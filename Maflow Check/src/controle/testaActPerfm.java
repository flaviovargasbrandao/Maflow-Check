package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class testaActPerfm implements ActionListener{
	JButton btnPlay;
	boolean playPause;
	//ActionEvent arg0
	public void actionPerformed(final JButton btnPlay,final boolean playPause) {
		
		this.btnPlay=btnPlay;
		
		this.playPause=playPause;

		//btnPlay.addMouseListener(this);
		
		// TODO Auto-generated method stub
		try {
			
		
		btnPlay.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (playPause == true){
					btnPlay.setIcon(new ImageIcon("imagem/loading.gif"));
					}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (playPause == true){
					
					btnPlay.setIcon(new ImageIcon("imagem/loading.gif"));
					
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (playPause == true){
					
					btnPlay.setIcon(new ImageIcon("imagem/btnPause.png"));
					
					btnPlay.setToolTipText("Parar o monitoramento");
					
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(playPause == true){
					btnPlay.setIcon(new ImageIcon("imagem/btnPause.png"));
					}else{
						btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
					}
			}
		});
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	}

	
	
//}
