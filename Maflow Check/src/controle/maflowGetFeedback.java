package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class maflowGetFeedback {
	
	
	String linha = "";
	String data,horario = null;	
	List<String> aux = new ArrayList<String>();
	int i = 0;
	static Date horaMax = new Date();
	
	public void pegaFeedback(File arquivo){
		

		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
		Date horaProd = new Date();

		
		try {
				
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader (new FileReader(arquivo));
	
			
				while ((linha = in.readLine()) != null){
					
					aux.add(linha.substring(1,24));				
					
						if (linha.contains("ProcessNewFiles(): Found") ){
							 
							int novaProducao = Integer.parseInt(linha.substring(66, 67));
							
							data = linha.substring(1, 24).replace(".", "/");				
							horaProd = sdf.parse(data + horario);
							horaMax = horaProd;
							 
							
								if (novaProducao > 0 && horaProd.getTime() >= horaMax.getTime() ){
									
									
									System.out.println("Nova produ��o encontrada: " + novaProducao);
									horaMax = horaProd;
									System.out.println(horaMax);
								
									
									
								}else{
									System.out.println("nenhuma produ��o carregada");
								}
						}
						

					i++;
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("MaflowGetFeedback: " + e.getMessage());
		}
		
	}

}
