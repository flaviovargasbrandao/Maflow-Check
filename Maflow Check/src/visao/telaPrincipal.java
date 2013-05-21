package visao;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import model.modeloTabela;
import controle.checkArquivos;
import controle.getsetProducao;
import controle.iconeCheck;
import controle.maflowGetFeedback;
import controle.mouseEvento;
import controle.prodLoad;

public class telaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	private JPanel contentPane;
	modeloTabela modelo;
	private JTable tabela;
	getsetProducao prod = new getsetProducao();
	prodLoad prodCheck;
	prodLoad checkProd;
	checkArquivos checkArquivos;
	Timer timer;	
	static telaPrincipal telaPrincipal = null;	
	boolean playPause;	
	JButton btnRefresh = new JButton("");
	JButton btnPlay = new JButton("");
	
	
	
	
	/**
	 * Launch the application.
	 * Autor: Flavio Brand�o
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Construtor de cria��o do frame
	 * ainda n�o separei as instancias dos bot�es
	 */
	/**
	 * 
	 */
	public telaPrincipal() {
		
		
		
		 try {  
	 
	            
	            String OS = System.getProperty("os.name");
	            
	            if (OS.equals("Windows") ){
	            
	            		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	            	
	            	}else{
	            		
	            		UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
	            	}
	            	
	          
	        }catch(Exception e) {  
	            //Inseira qualuquer codigo, se necess�rio.  
	        	System.out.println(e.getMessage());
	        }  
		 
		setTitle("Aurosys ReportTool - Maflow Check  ----VERS\u00C3O PR\u00C9-ALPHA------");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		/*
		 * iniciar a modelagem da tabela no frame
		 */		
		
		modelo = new modeloTabela();
		
		tabela = new JTable();
		
		tabela.setModel(modelo);
		
		scrollPane.setViewportView(tabela);
		
		
		TableColumnModel colunaModel = tabela.getColumnModel();		
		
		iconeCheck iconecheck = new iconeCheck();
		
		colunaModel.getColumn(0).setCellRenderer(iconecheck);
		
		/*
		 * altera o tamanho das colunas
		 */
		
		colunaModel.getColumn(0).setPreferredWidth(12);
		colunaModel.getColumn(1).setPreferredWidth(12);
		colunaModel.getColumn(2).setPreferredWidth(10);
		colunaModel.getColumn(3).setPreferredWidth(200);
		colunaModel.getColumn(4).setPreferredWidth(20);
		colunaModel.getColumn(5).setPreferredWidth(10);
		colunaModel.getColumn(6).setPreferredWidth(70);

		
		/*
		 * iniciar botões e inserir imagens. 
		 */
		
		btnRefresh.setToolTipText("Atualiza\u00E7\u00E3o Manual");
		
		btnRefresh.setIcon(new ImageIcon ("imagem/btnRefresh.png"));	
						
		btnPlay.setIcon(new ImageIcon("imagem/btnPlay.png"));
		
		btnPlay.setToolTipText("Inicia o monitoramento");
		
		
		/*
		 * inicio action listener Timer para agendar tarefa de analise recorrente
		 */
		
			timer = new Timer(10000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						
						modelo.limpar();
						
						checkArquivos = new checkArquivos();

						checkArquivos.buscaArquivo(tabela, modelo);

						tabela.revalidate();
						
						Thread.sleep(1000);
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						
						e1.printStackTrace();
						
					}
				}
			});
			
			/*
			 * Executa refresh e recarrega a tabela
			 */
			
					btnRefresh.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
																
								File arquivo = new File("maflowFiles/Pr_EaeFi.log");
								
								modelo.limpar();
								
								checkArquivos = new checkArquivos();
								
								checkArquivos.buscaArquivo(tabela, modelo);
								
								maflowGetFeedback feedback = new maflowGetFeedback();
								
								feedback.pegaFeedback(arquivo);
								
							} catch (Exception e) {
								
								// TODO: handle exception
								
								System.out.println(e.getMessage());
								
								}
							}
						});	
			
			
			
			/*
			 * inicio da action listener - Botão Play
			 */
		
		
			btnPlay.addActionListener(new ActionListener() {
			

				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
										
						if (!playPause) {
							
							playPause = true;
																				
							btnPlay.addMouseListener(new mouseEvento(btnPlay, playPause));
								
							timer.start();																													
								
						} else {				
								
							playPause = false;
													
							btnPlay.addMouseListener(new mouseEvento(btnPlay, playPause));
								
							timer.stop();		
									
						}
												
					}
				});
			
		
		
		/*
		 * fim action listener
		 */
		
		/*
		 * Construção do layout
		 */
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(588, Short.MAX_VALUE)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRefresh))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12) 
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPlay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		contentPane.setLayout(gl_contentPane);
	}
	


}
