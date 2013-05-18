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
	//String [] aux;
	List<String> aux = new ArrayList<String>();
	int i = 0;
	static Date horaMax = new Date();
	
	public void pegaFeedback(File arquivo){
		

		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
		Date horaProd = new Date();
	//	Date dataProd = new Date();
	
		//System.out.println(arquivo.getName());
		
		try {
				
			BufferedReader in = new BufferedReader (new FileReader(arquivo));
		//	System.out.println(in.readLine());
			
				while ((linha = in.readLine()) != null){
					
					aux.add(linha.substring(1,24));
					
					
					
				//	System.out.println(horaProd);
					
						if (linha.contains("ProcessNewFiles(): Found") ){
							 
							int novaProducao = Integer.parseInt(linha.substring(66, 67));
							
							data = linha.substring(1, 24).replace(".", "/");				
							horaProd = sdf.parse(data + horario);
							horaMax = horaProd;
							 
							
								if (novaProducao > 0 && horaProd.getTime() >= horaMax.getTime() ){
									
									
									System.out.println("Nova produção encontrada: " + novaProducao);
									horaMax = horaProd;
									System.out.println(horaMax);
								//	System.out.println(aux.get(i));
									
									
								}else{
									System.out.println("nenhuma produção carregada");
								}
						}
						
//					System.out.println(arquivo.getName());
//					System.out.println(aux[i]); 
//					System.out.println(i);
					i++;
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("MaflowGetFeedback: " + e.getMessage());
		}
		
	}

}
