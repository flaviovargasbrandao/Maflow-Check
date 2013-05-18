package controle;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import model.modeloTabela;

public class prodLoad {

	/*
	 * autor Flavio Brandão
	 */
	
	private static  Properties config = new Properties();
	
	getsetProducao prod;
	String limpa,idprod,label,state,circulation,folder,papertype = null;
	
	



	public void novaProducao(JTable tabela, modeloTabela modelo,String dir, String file){
		Icon status = new ImageIcon("smallcelula.png");
		try {
			
			File arquivoMFF = new File(dir,file);
			FileInputStream fis = new FileInputStream(arquivoMFF);
			
			prod = new getsetProducao();
			

			if (arquivoMFF.getName().endsWith(".MFF")){
				System.out.println("arquivoMFF: =" + arquivoMFF);
			
			//config.load(new FileInputStream(arquivoMFF));
			config.load(fis);
			
			
			prod.setStatus(status);
			
			idprod = config.getProperty("ID_PRODUCTION");
			prod.setPrintID(idprod);
			System.out.println(idprod);
			
			label = config.getProperty("LABEL");
			prod.setProdName(label);
			System.out.println(label);
			
			state = config.getProperty("STATE");
			prod.setType(state);
			System.out.println(state);
			
			circulation = config.getProperty("CIRCULATION");
			prod.setTiragem(circulation);
			System.out.println(circulation);
			
			folder = config.getProperty("FOLDER");
			prod.setDobradeira(folder);
			System.out.println(folder);
			
			papertype = config.getProperty("PAPER_TYPE_DESCRIPTION");
			prod.setTipo_bobina(papertype);
			System.out.println(papertype);
			
			
			modelo.addProducao(prod);
			
			fis.close();
			}else{
				System.out.println("nenhum arquivo MFF encontrado");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("prodcheck " + e.getMessage());
		}
		
	}
}
