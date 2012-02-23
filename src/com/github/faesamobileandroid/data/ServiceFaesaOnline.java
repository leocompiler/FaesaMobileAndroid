package com.github.faesamobileandroid.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.webkit.WebView;

import com.github.faesamobileandroid.R;
import com.github.faesamobileandroid.RequestServer;


public class ServiceFaesaOnline {
	
	private String capturarString(String buffer ,String inicio , String fim ){
		int start = buffer.indexOf(inicio);
		String  tmp = buffer.substring(start+inicio.length());
		int end = tmp.indexOf(fim); 
		return tmp.substring(0,end);
		
	}
	 
	public Sessao  sessionFaesaOnline() throws Exception{
		String url = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2fDefault.aspx";
		String stringCookie = RequestServer.requistarSessao(url);
		String url2 = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2flogoff.aspx";
		String buffer = RequestServer.requisitarDadosHttpGet(url2, stringCookie);
		
		Sessao sessao = new Sessao();
 
		sessao.set__EVENTVALIDATION(capturarString(buffer, "EVENTVALIDATION\" value=\"", "\" />"));
		sessao.set__VIEWSTATE(capturarString(buffer, "id=\"__VIEWSTATE\" value=\"", "\" />"));
		sessao.setCookie(stringCookie);
		return sessao ;
		
	}
	public RespostaAutenticacao autenticarFaesaOnline(Estudante estudante ){
		
		
					  
		String url = "http://aluno.faesa.br/Login.aspx?ReturnUrl=%2fDefault.aspx";
		
		
        List<NameValuePair> listaAtributos = new ArrayList<NameValuePair>();
        listaAtributos.add(new BasicNameValuePair("__LASTFOCUS", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTTARGET", ""));
        listaAtributos.add(new BasicNameValuePair("__EVENTARGUMENT", ""));
        listaAtributos.add(new BasicNameValuePair("__VIEWSTATE", estudante.getSessao().get__VIEWSTATE()));
        listaAtributos.add(new BasicNameValuePair("__EVENTVALIDATION", estudante.getSessao().get__EVENTVALIDATION()));        
        listaAtributos.add(new BasicNameValuePair("Login1$UserName", estudante.getMatricula()));
        listaAtributos.add(new BasicNameValuePair("Login1$LoginButton", "ENTRAR"));
        listaAtributos.add(new BasicNameValuePair("Login1$Password", estudante.getSenha()));
      
		String retorno = RequestServer.requisitarDadosHttpPost(url, listaAtributos , estudante.getSessao().getCookie());
		
		//int iComp = retorno.compareTo("<h2>Object moved to <a href=\"%2fSistema%2fDefault.aspx\">here</a>.</h2>\r\n");
		
		
		return null ;
		
	}
	
	public RespostaMateriasNotasFaltas materiasNotasFaltasFaesaOnline(Estudante estudante ) throws Exception{
//        String url = "http://aluno.faesa.br/sistema/NotasFaltas/Default.aspx";
//        String buffer;
//		try {
//			buffer = RequestServer.requisitarDadosHttpGet(url);
//		} catch (Exception e) {
//			buffer = e.toString();
//		}
//		
//		int start = buffer.indexOf(" <div id=\"ctl00_ContentPlaceHolder1_UpdatePanel1\">"); 
//		int end = buffer.indexOf("<!-- FIM - MIOLO-->");
//		
//		
//		String resp = "<html>"+buffer.substring(start, end)+"</html>";
//		//resp = resp.replace("#", "%23");
//		resp = resp.replace("%", "%25");
//		resp = resp.replace("\\", "%27");
//		resp = resp.replace("?", "%3f");
		
		//TODO : SERVICE TESTE AINDA ...
        
        List<Materia> listMateria = new ArrayList<Materia>();
        listMateria.add(new Materia());
        listMateria.add(new Materia());
        listMateria.add(new Materia());
        listMateria.add(new Materia());
        
        listMateria.get(0).setNome("Fisica 2");
        listMateria.get(1).setNome("Engenharia Software");
        listMateria.get(2).setNome("Sistema Distribuidos");
        listMateria.get(3).setNome("Organização Métodos Sistemas");
        
        List<String> notas = new ArrayList<String>();
        
        notas.add("5.4");
        notas.add("6");
        notas.add("3");
        notas.add("10");
        
        listMateria.get(0).setNota(notas);
        listMateria.get(1).setNota(notas);
        listMateria.get(2).setNota(notas);
        listMateria.get(3).setNota(notas);
        
        listMateria.get(0).setQuantFaltas(18);
        listMateria.get(1).setQuantFaltas(18);
        listMateria.get(2).setQuantFaltas(18);
        listMateria.get(3).setQuantFaltas(7);
        
        listMateria.get(0).setQuantFaltasOcorridas(2);
        listMateria.get(1).setQuantFaltasOcorridas(6);
        listMateria.get(2).setQuantFaltasOcorridas(8);
        listMateria.get(3).setQuantFaltasOcorridas(2);
        
        RespostaMateriasNotasFaltas resposta = new RespostaMateriasNotasFaltas();
        
        resposta.setMsg("OK");
        resposta.setListMateria(listMateria);
        
        return resposta;
	}
	
	public void historicoEscolarFaesaOnline(Estudante estudante ){
		
	}
	
	public void boletosBancariosCursoFaesa(Estudante estudante){
		
	}
}
