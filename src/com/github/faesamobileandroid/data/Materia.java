package com.github.faesamobileandroid.data;

import java.util.List;

public class Materia {

	private String nome;
	private String codigo;
	private int  quantFaltas ;
	private int  quantFaltasOcorridas ;
	private List<String> nota ;
	private String situacao ;
		public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getQuantFaltas() {
		return quantFaltas;
	}
	public void setQuantFaltas(int quantFaltas) {
		this.quantFaltas = quantFaltas;
	}
	public int getQuantFaltasOcorridas() {
		return quantFaltasOcorridas;
	}
	public void setQuantFaltasOcorridas(int quantFaltasOcorridas) {
		this.quantFaltasOcorridas = quantFaltasOcorridas;
	}
	public List<String> getNota() {
		return nota;
	}
	public void setNota(List<String> nota) {
		this.nota = nota;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
