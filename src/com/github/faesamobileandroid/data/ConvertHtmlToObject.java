package com.github.faesamobileandroid.data;

import java.util.List;

public class ConvertHtmlToObject {
	
	public static List<Materia> convertMaterias(String buffer){
		return null;
	}
	
	
	public static DadosCadastro DadosCadastro(final String buffertmp) throws Exception{
		
		String tagInit ;
		String tagEnd ;
		String buffertmp2 = buffertmp.replace("</b>", "");
		String buffertmp3 = buffertmp2.replace("<font face=\"Arial\" color=\"Black\">","");
		final String buffer = buffertmp3.replace("</font>", "");
		 tagInit = "cula:</td><td>";
		 tagEnd = "</td>" ;
		 int indexInit = buffer.indexOf(tagInit);
		 int indexEnd = buffer.indexOf(tagEnd);
		String matricula = buffer.substring(indexInit,indexEnd);
		
		 tagInit = "Nome:</td><td>";
		 tagEnd = "</td>" ;
		String nome = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));

		 tagInit = "Endere&#231;o:</td><td>";
		 tagEnd = "</td>" ;
		String endereco = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));
		
		 tagInit = "Complemento:</td><td>";
		 tagEnd = "</td>" ;
		String complemento = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));
		
		 tagInit = "Bairro:</td><td>";
		 tagEnd = "</td>" ;
		String bairro = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));

		 tagInit = "Cidade:</td><td>";
		 tagEnd = "</td>" ;
		String cidade = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));
		
		 tagInit = "Estado:</td><td>";
		 tagEnd = "</td>" ;
		String estado = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));
		
		 tagInit = "CEP:</td><td>";
		 tagEnd = "</td>" ;
		String cep = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));
		
		DadosCadastro dadosCadastro = new DadosCadastro();
		dadosCadastro.setBairro(bairro);
		dadosCadastro.setCep(cep);
		dadosCadastro.setCidade(cidade);
		dadosCadastro.setComplemento(complemento);
		dadosCadastro.setEndereco(endereco);
		dadosCadastro.setEstado(estado);
		
		return dadosCadastro ;
	}
	

}
