package controle;

import java.io.File;
import java.util.Date;



public class copiaArquivos {


		String nomeArq = null;
		String dir = "/tmp";
		Long lastModified;
		
		public void ultimoModificado(){
	    
	        // Create an instance of file object.
	    	File diretorio = new File(dir);
	        File arquivo = new File(dir,nomeArq);
	        File [] lista = diretorio.listFiles();
	        
			        for (int i = 0; i < lista.length; i++ ){
			        	
			        	// Get the last modification information.
				        lastModified  = diretorio.lastModified();
			        }
	        
	 
	        
	        // Create a new date object and pass last modified information
	        // to the date object.
	        Date date = new Date(lastModified);
	 
	        // We know when the last time the file was modified.
	        System.out.println(date);
	    	
		}
}
