package com.github.faesamobileandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

 



public class RequestServer {

	public static String requisitarDadosHttpPost(String url, List<NameValuePair> _Atributos , String cookie){

		
		
			try{
		        HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost(url);
		        httppost.setHeader("Cookie",cookie);
		        httppost.setHeader("User-Agent", "Geocontrol Android");
		        httppost.setEntity(new UrlEncodedFormEntity(_Atributos));
		        HttpResponse webResposta = httpclient.execute(httppost);
		        
		        BufferedReader in = new BufferedReader(new InputStreamReader(webResposta.getEntity().getContent()));
		        StringBuilder sb = new StringBuilder("");
		        String line = "";
		        String NL = System.getProperty("line.separator");
		        while ((line = in.readLine()) != null) {
		            sb.append(line);
		            sb.append(NL);
		        }
		        in.close();
		        String result = sb.toString();
		        return result;
		        
		    }catch(Exception e)     
		    {
		        return null ;
		    }
	}
	
	public static String requisitarDadosHttpGet(String url) throws Exception{
		return RequestServer.requisitarDadosHttpGet(url,null);
	}
	public static String requisitarDadosHttpGet(String url ,String cookie) throws Exception{
		  BufferedReader in = null;
		  
		  
	        try {
	            HttpClient client = new DefaultHttpClient();
	            
	            HttpGet request = new HttpGet();
	            request.setHeader("User-Agent", "Geocontrol Android");
	            if(cookie != null )request.setHeader("Cookie", cookie);
	            request.setURI(new URI(url));
	            HttpResponse response = client.execute(request);
	            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer sb = new StringBuffer("");
	            String line = "";
	            String NL = System.getProperty("line.separator");
	            while ((line = in.readLine()) != null) {
	                sb.append(line + NL);
	            }
	            in.close();
	            String page = sb.toString();
	            return page ;
	            } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                    } catch (IOException e) {
	                    return e.toString();
	                }
	            }
	        }
	}
	
	
	public static String requistarSessao(String url) throws URISyntaxException, ClientProtocolException, IOException{
		 BufferedReader in = null;
		  
		  
	        try {
	            HttpClient client = new DefaultHttpClient();
	            
	            HttpGet request = new HttpGet();
	            request.setHeader("User-Agent", "Geocontrol Android");
	            request.setURI(new URI(url));
	            HttpResponse response = client.execute(request);
	            Header  header = response.getHeaders("Set-Cookie")[0];
	            String stringCookie = header.getValue().replace(" path=/; HttpOnly", "");
	            return stringCookie;
	            
	            
	            } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                    } catch (IOException e) {
	                    return e.toString();
	                }
	            }
	        }
	}
	
}
