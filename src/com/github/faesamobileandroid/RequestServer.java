package com.github.faesamobileandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

 



public class RequestServer {

	public static String requisitarDadosHttpPost(String url, List<NameValuePair> _Atributos){
		 try{
		        HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost(url);
		
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
		  BufferedReader in = null;
		  String cookie = "ASP.NET_SessionId=nkojx0vumgge4kv0po1zvju5; aluno.faesa.br=A0FB16367681180615B145C9D29B1AE8C7E5C16DFB60AD0898A95851726C0FCD44C5190FFFA20C91D3BAC88F53E7FFD8B8250DC0FF10F4C4E4EBCB67069032AFBE01E893C65AD4352C6D3CBADEFFA4DCCA8A9AF3C6EF4998C053B4259B092684B6616D9950C6DC025A4AA607DE19693E192D07F3F059642FB4F7CEC1B74BBECA3E2AE591D12BFF27D4C4643239691B60882A81138525484925B4100A24B4860A4A1B358FBA80C70EA6381D3EDC7511AD51B751C7121BEEF6539AC0D5F3EB2C55649F736B; __utma=178220986.767419523.1329441172.1329441172.1329444379.2; __utmb=178220986.11.10.1329444379; __utmc=178220986; __utmz=178220986.1329441172.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)";
		  
	        try {
	            HttpClient client = new DefaultHttpClient();
	            
	            HttpGet request = new HttpGet();
	            request.setHeader("User-Agent", "Geocontrol Android");
	            request.setHeader("Cookie", cookie);
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
	
	
}
