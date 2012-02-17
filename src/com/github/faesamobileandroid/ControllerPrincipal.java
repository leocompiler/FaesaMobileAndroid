package com.github.faesamobileandroid;

import com.github.faesamobileandroid.data.Estudante;
import com.github.faesamobileandroid.data.ServiceFaesaOnline;

public class ControllerPrincipal {
	
	
	private static ServiceFaesaOnline service ;
	private static Estudante estudante  = new Estudante(); ;
	
	public ControllerPrincipal(){
		service = new ServiceFaesaOnline();
		
	}
	
	public void initSessao(){
		try {
			estudante.setCookie(service.sessionFaesaOnline());
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
