package com.github.faesamobileandroid.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.webkit.WebView;

import com.github.faesamobileandroid.R;
import com.github.faesamobileandroid.RequestServer;


public class ServiceFaesaOnline {
	
	 
	public Sessao  sessionFaesaOnline() throws Exception{
		String url = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2fDefault.aspx";
		String stringCookie = RequestServer.requistarSessao(url);
		String url2 = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2flogoff.aspx";
		String buffer = RequestServer.requisitarDadosHttpGet(url2, stringCookie);
		
		Sessao sessao = new Sessao();
        
		String stringVarsSessao;
 
		
		int start = buffer.indexOf("EVENTVALIDATION\" value=\"");
		String  tmp = buffer.substring(start+24);
		int end = tmp.indexOf("\" />"); 
		sessao.set__EVENTVALIDATION(tmp.substring(0,end));
		
		String eventValidation = buffer.substring(start, end);
		
		
		//int start = buffer.indexOf("id=\"__VIEWSTATE\" value=\""); 
		//int end = buffer.indexOf("\" />\r\n")
		
		String resp = "<html>"+buffer.substring(start, end)+"</html>";
		
		return sessao ;
		
	}
	public RespostaAutenticacao autenticarFaesaOnline(Estudante estudante ){
		
		
					  
		String url = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2fDefault.aspx";
		
		
        List<NameValuePair> listaAtributos = new ArrayList<NameValuePair>();
        listaAtributos.add(new BasicNameValuePair("__LASTFOCUS", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTTARGET", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
        listaAtributos.add(new BasicNameValuePair("__VIEWSTATE", "%2FwEPDwUKMTgwNDgxNzMwNA9kFgICAQ8WAh4MYXV0b2NvbXBsZXRlBQNvZmYWBAIBDzwrAAoBAA8WAh4IVXNlck5hbWUFBzA3MTE4MDhkFgJmD2QWBAIHDw8WAh4EVGV4dAUHMDcxMTgwOBYCHglvbktleURvd24FFXJldHVybiBOdW1lcm8oZXZlbnQpO2QCDQ8PZBYCHwMFHnJldHVybiBOdW1lcm9NYXRyaWN1bGEoZXZlbnQpO2QCBw8WAh4HVmlzaWJsZWhkZDn%2BU6DoCgLnZS6tifnfjth84nQT"));
        listaAtributos.add(new BasicNameValuePair("__EVENTVALIDATION", "%2FwEWBQKmjbmdCwKUvNa1DwKnz4ybCAL666vYDALM9PumD1dbWeA1zvxK40zQVTq%2FT3lR9P%2FX"));        
        listaAtributos.add(new BasicNameValuePair("Login1$UserName", estudante.getMatricula()));
        listaAtributos.add(new BasicNameValuePair("Login1$LoginButton", "ENTRAR"));
        listaAtributos.add(new BasicNameValuePair("Login1$Password", estudante.getSenha()));
      
		String retorno = RequestServer.requisitarDadosHttpPost(url, listaAtributos , estudante.getSessao().getCookie());
		
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
