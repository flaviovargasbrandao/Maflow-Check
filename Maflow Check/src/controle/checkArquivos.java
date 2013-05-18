package controle;

import java.io.File;

import javax.swing.JTable;

import model.modeloTabela;

public class checkArquivos {
	prodLoad prodCheck;
	/*
	 * Autor: Flavio Brandão
	 */
	
	public void buscaArquivo(JTable tabela, modeloTabela modelo ){
		
		try {
			
			String diretorio = "maflowFiles";
			String nomeArq = null;
//			String [] arquivosLidos = null;
			File dir = new File(diretorio);
			File[] lista = dir.listFiles();
//			boolean igual = false;
			
			prodCheck = new prodLoad();
			
			
			for (int i = 0; i < lista.length; i++){
				Thread.sleep(45);
				nomeArq = lista[i].getName();
			//	arquivosLidos[i] = lista[i].getName();
					
				
//				for (int j = 0; j <= lista.length; j++){
//					
//							if (arquivosLidos[i].equals(nomeArq)){
//								
//								igual = true;
//								
//							}
//						
//					}
				
				prodCheck.novaProducao(tabela, modelo,diretorio, nomeArq);
			
			
				nomeArq = null;
			
			}
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("checkArquivos " + e.getMessage());
		}
		

	
		
		
		
		
	}
	


}
