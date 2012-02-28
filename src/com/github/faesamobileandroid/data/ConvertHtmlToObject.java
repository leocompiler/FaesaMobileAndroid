package com.github.faesamobileandroid.data;

import java.util.ArrayList;
import java.util.List;

public class ConvertHtmlToObject {
	
	private static String capturarString(String buffer ,String inicio , String fim ){
		int start = buffer.indexOf(inicio);
		if(start == -1 ){ 
			return null ;
		}
		String  tmp = buffer.substring(start+inicio.length());
		int end = tmp.indexOf(fim); 
		return tmp.substring(0,end);
		
	}
	
	public static String convertHistoricoEscolar(String buffer){
		
		String tagInit = "<div id=\"ctl00_ContentPlaceHolder1_painelHistorico\">" ;
		String tagEnd = "<!-- FIM - MIOLO-->" ;
		 
		String bufferTmp = capturarString(buffer,tagInit,tagEnd);
		
		return bufferTmp ;
	}
	
	public static List<Materia> convertMaterias(String buffer){
		String tagInit ;
		String tagEnd ;
		List<String> listMat = new ArrayList<String>();
		
		tagInit = "<table cellspacing=\"1\"" ;
		tagEnd = "</table>" ;
		 
		String bufferTmp = capturarString(buffer,tagInit,tagEnd);
		String bufferTableNotas = capturarString(buffer,tagInit,tagEnd);
		
		tagInit = "<td align=\"left\" valign=\"middle\"><font face=\"Arial,Helvetica,sans-serif;\">" ;
		tagEnd = "</font></td>";
		
		while(bufferTableNotas != null){
			String dado = capturarString(bufferTableNotas,tagInit,tagEnd);
			if(dado != null)
			{
				listMat.add(dado);
				bufferTableNotas = bufferTableNotas.replace(tagInit+dado+tagEnd, "");
				bufferTableNotas = bufferTableNotas.substring(bufferTableNotas.indexOf(tagEnd)+tagEnd.length());
 
			}
			else{
				bufferTableNotas = null;
			}
		}
		
		return convertMateriasNotas(bufferTmp , listMat);
	}
	
	public static List<Materia> convertMateriasNotas(String buffer ,List<String> listMaterias){
		
		String tagInit ;
		String tagEnd ;
		List<Materia> listMat = new ArrayList<Materia>();
		
		

		
		for(int i = 0;i<listMaterias.size();i++)
		{
			Materia materia = new Materia();
			materia.setNome(listMaterias.get(i).trim());
			
			tagInit = "<td align=\"center\" valign=\"middle\"><font face=\"Arial,Helvetica,sans-serif;\">" ;
			tagEnd = "</font></td>";			
			String bufferTableNotas = buffer.substring(buffer.indexOf(listMaterias.get(i))+listMaterias.get(i).length());
			
			List<String>notas = new ArrayList<String>();
			
			for(int j=0;j<12;j++)
			{
				String dado = capturarString(bufferTableNotas,tagInit,tagEnd);
				
				if(dado != null)
				{
					notas.add(dado);
					String tag = tagInit+dado+tagEnd ;
					bufferTableNotas = bufferTableNotas.substring(bufferTableNotas.indexOf(tag)+tag.length(), bufferTableNotas.length()-1);
				}
				else{
					bufferTableNotas = null;
				}
			}
			
			materia.setQuantFaltas(new Integer(notas.get(9)));
			materia.setQuantFaltasOcorridas(new Integer(notas.get(10)));
			materia.setSituacao(notas.get(11));
			
			notas.remove(11);
			notas.remove(10);
			notas.remove(9);
			
			
			
			materia.setNota(notas);
			listMat.add(materia);
			
		}
		
		return listMat ;
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
