package controle;

import java.io.File;

import javax.swing.JTable;

import model.modeloTabela;

public class checkArquivos {
	prodLoad prodCheck;
	/*
	 * Autor: Flavio Brand�o
	 */
	
	public void buscaArquivo(JTable tabela, modeloTabela modelo ){
		
		try {
			
			String diretorio = "maflowFiles";
			String nomeArq = null;
			File dir = new File(diretorio);
			File[] lista = dir.listFiles();

			
			prodCheck = new prodLoad();
			
			
			for (int i = 0; i < lista.length; i++){
				Thread.sleep(45);
				nomeArq = lista[i].getName();

				
				prodCheck.novaProducao(tabela, modelo,diretorio, nomeArq);
			
			
				nomeArq = null;
			
			}
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("checkArquivos " + e.getMessage());
		}
				
		
	}
	


}
