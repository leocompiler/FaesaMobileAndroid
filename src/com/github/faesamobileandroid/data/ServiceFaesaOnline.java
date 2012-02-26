package com.github.faesamobileandroid.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.ls.LSInput;

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
	public RespostaAutenticacao autenticarFaesaOnline(Estudante estudante ) throws Exception{
		
		
					  
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
      
		RespostaRequestPost retorno = RequestServer.requisitarDadosHttpPost(url, listaAtributos , estudante.getSessao().getCookie());
		
		String novoCookie = estudante.getSessao().getCookie()+retorno.getRetornoCookie();
		
		String url2 = "http://aluno.faesa.br/Default.aspx";
		String retorno2 = RequestServer.requisitarDadosHttpGet(url2,novoCookie);
		
		
		String tagInit = "<span id=\"ctl00_lblNomeUsuario\">";
		
		String nome = retorno2.substring(retorno2.indexOf(tagInit)+tagInit.length(),retorno2.indexOf("</span>"));
		estudante.setNome(nome);
		estudante.getSessao().setCookie(novoCookie);
		RespostaAutenticacao respostaAutenticacao = new RespostaAutenticacao();
		respostaAutenticacao.setEstudante(estudante);
		
		int comparar = retorno2.indexOf("FAESA - Central do Aluno");
		if(comparar > 0)
		{
			respostaAutenticacao.setAutenticado(true);
			return respostaAutenticacao ;
		}
		else{
			return null ;
		}
		
		
		
	}
	
	public RespostaMateriasNotasFaltas materiasNotasFaltasFaesaOnline(Estudante estudante ) throws Exception{
        
		String url = "http://aluno.faesa.br/sistema/NotasFaltas/Default.aspx";
     	String buffer = RequestServer.requisitarDadosHttpGet(url,estudante.getSessao().getCookie());
     	List<Materia> listMateria = ConvertHtmlToObject.convertMaterias(buffer);
     	RespostaMateriasNotasFaltas resposta = new RespostaMateriasNotasFaltas();
     	resposta.setListMateria(listMateria);
     	resposta.setMsg(buffer);
     	return resposta;
     	
	}
	
	public RespostaDadosCadastro dadosCadastroFaesaOnline(Estudante estudante) throws Exception{
		
		String url = "http://aluno.faesa.br/sistema/Cadastro/Default.aspx";
		String buffer = RequestServer.requisitarDadosHttpGet(url, estudante.getSessao().getCookie());
		DadosCadastro cadastro = ConvertHtmlToObject.DadosCadastro(buffer);
		RespostaDadosCadastro resposta = new  RespostaDadosCadastro();
		resposta.setDadosCadastro(cadastro);
		return resposta;
	}
	
	public void historicoEscolarFaesaOnline(Estudante estudante ){
		
	}
	
	public void boletosBancariosCursoFaesa(Estudante estudante){
		
	}
}
