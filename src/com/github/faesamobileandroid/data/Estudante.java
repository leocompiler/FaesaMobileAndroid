package com.github.faesamobileandroid.data;

public class Estudante {

	private String matricula ="";
	private String senha ="";
	private String nome ="";
	private DadosCadastro cadastro ;
	private String cursoAtual ="";
	private Sessao sessao  ;
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCursoAtual() {
		return cursoAtual;
	}

	public void setCursoAtual(String cursoAtual) {
		this.cursoAtual = cursoAtual;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public DadosCadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(DadosCadastro cadastro) {
		this.cadastro = cadastro;
	}
	
}
