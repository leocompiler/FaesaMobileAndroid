package com.github.faesamobileandroid;

import com.github.faesamobileandroid.data.Estudante;
import com.github.faesamobileandroid.data.ServiceFaesaOnline;
import com.github.faesamobileandroid.data.Sessao;

public class ControllerPrincipal {
	
	
	private static ServiceFaesaOnline service ;
	private static Estudante estudante  = new Estudante(); ;
	private static Sessao sessaoEstudante  = new Sessao();
	public ControllerPrincipal(){
		service = new ServiceFaesaOnline();
		
	}
	
	public void initSessao(){
		try {
			sessaoEstudante = service.sessionFaesaOnline();
			estudante.setSessao(sessaoEstudante);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void autenticacao(String matricula , String senha ){
		estudante.setMatricula(matricula);
		estudante.setSenha(senha);
		service.autenticarFaesaOnline(estudante);
		
	}
	
	public void consultarNotasFaltas(Estudante estudante){
		
	}

}
