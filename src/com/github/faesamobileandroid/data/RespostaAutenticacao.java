package com.github.faesamobileandroid.data;

public class RespostaAutenticacao {
	
	public Estudante estudante ;
	private boolean autenticado ;
	public String log ;
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

}
