package com.github.faesamobileandroid.data;

import java.util.List;

public class ConvertHtmlToObject {
	
	private static String capturarString(String buffer ,String inicio , String fim ){
		int start = buffer.indexOf(inicio);
		String  tmp = buffer.substring(start+inicio.length());
		int end = tmp.indexOf(fim); 
		return tmp.substring(0,end);
		
	}
	
	public static List<Materia> convertMaterias(String buffer){
		String tagInit ;
		String tagEnd ;
		
		
		tagInit = "<table cellspacing=\"1\"" ;
		tagEnd = "</table>" ;
		 
		String bufferTableNotas = capturarString(buffer,tagInit,tagEnd);
		
		tagInit = "<td align=\"left\" valign=\"middle\" style=\"border-style:None;font-family:Arial,Helvetica,sans-serif;;font-size:12px;\">" ;
		tagEnd = "</td>" ;
		 
		String materia = capturarString(buffer,tagInit,tagEnd);
		
		
		return null;
	}
	
	
	public static DadosCadastro DadosCadastro(final String buffertmp) throws Exception{
		
		String tagInit ;
		String tagEnd ;
		String buffertmp2 = buffertmp.replace("</b>", "");
		String buffertmp3 = buffertmp2.replace("<font face=\"Arial\" color=\"Black\">","");
		final String buffer = buffertmp3.replace("</font>", "");
		 tagInit = "cula:</td><td>";
		 tagEnd = "</td>\n" ;
 		String matricula = buffer.substring(buffer.indexOf(tagInit)+tagInit.length(),buffer.indexOf(tagEnd));
		
		 tagInit = "Nome:</td><td>";
		 tagEnd = "</td>\n" ;
		 
		String nome = capturarString(buffer,tagInit,tagEnd);

		 tagInit = "Endere&#231;o:</td><td>";
		 tagEnd = "</td>\n" ;
		String endereco = capturarString(buffer,tagInit,tagEnd);
		
		 tagInit = "Complemento:</td><td>";
		 tagEnd = "</td>\n" ;
		String complemento = capturarString(buffer,tagInit,tagEnd);
		
		 tagInit = "Bairro:</td><td>";
		 tagEnd = "</td>\n" ;
		String bairro = capturarString(buffer,tagInit,tagEnd);

		 tagInit = "Cidade:</td><td>";
		 tagEnd = "</td>\n" ;
		String cidade = capturarString(buffer,tagInit,tagEnd);
		
		 tagInit = "Estado:</td><td>";
		 tagEnd = "</td>\n" ;
		String estado = capturarString(buffer,tagInit,tagEnd);
		
		 tagInit = "CEP:</td><td>";
		 tagEnd = "</td>\n" ;
		String cep = capturarString(buffer,tagInit,tagEnd);
		
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
