package com.github.faesamobileandroid.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.webkit.WebView;

import com.github.faesamobileandroid.R;
import com.github.faesamobileandroid.RequestServer;


public class ServiceFaesaOnline {
	
	 
	public String  sessionFaesaOnline() throws Exception{
		String url = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2fDefault.aspx";
		String buffer = RequestServer.requistarSessao(url);
		String url2 = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2flogoff.aspx";
		RequestServer.requisitarDadosHttpGet(url2, buffer);
		return buffer ;
		
	}
	public RespostaAutenticacao autenticarFaesaOnline(Estudante estudante ){
		
		
					  
		String url = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2fDefault.aspx";
		
		
        List<NameValuePair> listaAtributos = new ArrayList<NameValuePair>();
        listaAtributos.add(new BasicNameValuePair("__LASTFOCUS", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTTARGET", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWBQKSjZ3jBQKUvNa1DwKnz4ybCAL666vYDALM9PumD6ZjBaEYN4tpSzLinGUYzbrtbzWK"));
        listaAtributos.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwUKMTgwNDgxNzMwNA9kFgICAQ8WAh4MYXV0b2NvbXBsZXRlBQNvZmYWBAIBD2QWAmYPZBYEAgcPD2QWAh4Jb25LZXlEb3duBRVyZXR1cm4gTnVtZXJvKGV2ZW50KTtkAg0PD2QWAh8BBR5yZXR1cm4gTnVtZXJvTWF0cmljdWxhKGV2ZW50KTtkAgcPFgIeB1Zpc2libGVoZGTOgjAitWTj95AGnZgoPJpkF/5C4w=="));
        
        listaAtributos.add(new BasicNameValuePair("Login1$UserName", estudante.getMatricula()));
        listaAtributos.add(new BasicNameValuePair("Login1$LoginButton", "ENTRAR"));
        listaAtributos.add(new BasicNameValuePair("Login1$Password", estudante.getSenha()));
      
		String retorno = RequestServer.requisitarDadosHttpPost(url, listaAtributos , estudante.getCookie());
		
		int iComp = retorno.compareTo("<h2>Object moved to <a href=\"%2fSistema%2fDefault.aspx\">here</a>.</h2>\r\n");
		
		
		return null ;
		
	}
	
	public void notasFaltasFaesaOnline(Estudante estudante ){
        String url = "http://aluno.faesa.br/sistema/NotasFaltas/Default.aspx";
        String buffer;
		try {
			buffer = RequestServer.requisitarDadosHttpGet(url);
		} catch (Exception e) {
			buffer = e.toString();
		}
		
		int start = buffer.indexOf(" <div id=\"ctl00_ContentPlaceHolder1_UpdatePanel1\">"); 
		int end = buffer.indexOf("<!-- FIM - MIOLO-->");
		
		
		String resp = "<html>"+buffer.substring(start, end)+"</html>";
		//resp = resp.replace("#", "%23");
		resp = resp.replace("%", "%25");
		resp = resp.replace("\\", "%27");
		resp = resp.replace("?", "%3f");
		
        
        
	}
	
	public void historicoEscolarFaesaOnline(Estudante estudante ){
		
	}
	

}
