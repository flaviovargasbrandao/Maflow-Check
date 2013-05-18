package controle;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import visao.telaPrincipal;
  
   
  
public class minimizaJanela {  
	
	/*
	 * Por Flavio Brandão
	 */
	
static telaPrincipal telaPrincipal;
  
   
  
	public minimizaJanela() {
		// TODO Auto-generated constructor stub
		super();
		trayIcone();
	}
    @SuppressWarnings("unused")
	static void trayIcone() {  
          
      final TrayIcon trayIcon;   
  

	

  
      if (SystemTray.isSupported()) {  
    	 
    	  SystemTray tray = SystemTray.getSystemTray();  
    	  Image image = Toolkit.getDefaultToolkit().getImage("imagem/small1.png");  
    	 
    	  

    	  
    	  
    	  MouseListener mouseListener = new MouseListener() {   
                 
  
			        public void mouseClicked(MouseEvent e) {		
			        	
			        	try {
			        		if(e.getClickCount() >=2){
			        			telaPrincipal = new telaPrincipal();
			        			telaPrincipal.setVisible(true);
			        			System.out.println(e.getClickCount());
			        			
			        		}
			        		
			        		
							
						} catch (Exception e2) {
							// TODO: handle exception
							System.out.println(e2.getMessage());
						}
			        	
			        	
			  
			        }		  
			   
			  
			        public void mouseEntered(MouseEvent e) {           
			  
			        }  
			  
			   
			  
			        public void mouseExited(MouseEvent e) { 		             
			  
			        }  
			  
			   
			  
			        public void mousePressed(MouseEvent e) {         
			  
			             						  
			        }  
  
   
  
				    public void mouseReleased(MouseEvent e) {  		  
				             
				  
				        }  
  
    	  	};  
    	  	
  
    	  	
    	  
    	  		
    	  	
    	  		
			
       
      
    ActionListener exitListener = new ActionListener() {  
  
        public void actionPerformed(ActionEvent e) {  
  
  
  
            JOptionPane.showMessageDialog(null,"As alterações foram salvas com sucesso!");  
  
            System.exit(0);  
  
        }  
  
    };  
  
   
     
	//    PopupMenu popup = new PopupMenu("Menu de Opções");  
	   
	  
	  //  MenuItem defaultItem = new MenuItem("Exit");  
	    
	  
	 //   defaultItem.addActionListener(exitListener);  
	     
	  
	 //   popup.addSeparator();  
	  
	//    PopupMenu popup2 = new PopupMenu("Options");  
	  
//	    MenuItem mostraFrame = new MenuItem("Abrir tela");  
//	  
//	    MenuItem fechaFrame = new MenuItem("Sair");  
//
//
//	    mostraFrame.addActionListener(new ActionListener() {
//			
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					telaPrincipal = new telaPrincipal();
//						
//					telaPrincipal.setVisible(true);
//					
//				}
//			});
//		  
	  
	     
	  
	//    popup2.add(mostramsg2);  
	  
	//    popup2.add(mostramsg3);  
	  
	//    popup.add(popup2);  
//	    popup.add(mostraFrame);
	  
//	    popup.addSeparator();  
	  
//	    popup.add(defaultItem);
//	    popup.add(fechaFrame);
	    
	

     
//	    	trayIcon = new TrayIcon(image, "Execução em Andamento", popup);
		    trayIcon = new TrayIcon(image, "Execução em Andamento");
		    ActionListener actionListener = new ActionListener() {  
		  
		        public void actionPerformed(ActionEvent e) {  
		  
		            trayIcon.displayMessage("Novas Produções Carregadas",  
		  
		                null,  
		  
		                TrayIcon.MessageType.INFO);  
		            	
		            	
		  
		        }  
		  
		    };  
  
      
  
    trayIcon.setImageAutoSize(true);  
    
  
    trayIcon.addActionListener(actionListener);  
    trayIcon.addMouseListener(mouseListener);  
    
    	
  
    
									  
									    try {  
									  
									        tray.add(trayIcon);  
									  
									    } catch (AWTException e) {  
									  
									        System.err.println("Erro, TrayIcon não sera adicionado.");  
									  
									    }  
									  
   
									    
      		} else {  
  
  
  
      			JOptionPane.showMessageDialog(null,"recurso ainda não esta disponível pra o seu sistema");  
  
      	} // fim do   if (SystemTray.isSupported()) 
      
      
   
   
   
    }  //fim metodo
  
}// END.  