package controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class mouseEvento extends MouseAdapter{	
	
	private	JButton btnPlay;
	private	boolean playPause;

	
	public mouseEvento(JButton btnPlay, boolean playPause) {
		// TODO Auto-generated constructor stub
		
		this.btnPlay=btnPlay;
		
		this.playPause=playPause;	
	
	}

	


	@Override
	public void mouseClicked(MouseEvent e) {
			
		if(playPause){
			
			btnPlay.setIcon(new ImageIcon("imagem/btnPause.png"));
			
			
			}else{	
				
				
				btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
				btnPlay.revalidate();
			
			}
			
	}

	@Override
	public void mouseEntered(MouseEvent e) {

			
		if (playPause){
			
			btnPlay.setIcon(new ImageIcon("imagem/btnPause.png"));
			btnPlay.setToolTipText("Parar o monitoramento");
			
		}else{
			
			btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

			if (playPause){
				
				btnPlay.setIcon(new ImageIcon("imagem/loading.gif"));
				
				}else{
					
					btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
					
				}
				

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
			btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		
		
			btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
		
	}
	



}
