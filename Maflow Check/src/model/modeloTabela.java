package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import controle.getsetProducao;




public class modeloTabela extends AbstractTableModel {
	
	
	

	/**
	 * fonte: http://www.guj.com.br/java/231928-morte-definitiva-ao-default-table-model
	 */
	private static final long serialVersionUID = 1L;
	
	/* representa as linhas a serem adicionadas */
	private List<getsetProducao> linhas;
	
	
	/* representa as colunas a adicionar */
	private String[] colunas = new String[] {"Status","PrintID", "Type", "Production Name", "Dobradeira", "Tiragem","Tipo Bobina"};
	
	
	
	/* criando um Table Model vazio*/
	
	public modeloTabela(){
		
		linhas = new ArrayList<getsetProducao>();
	}
	
	
	/* cria um modeloTabela preenchido com os dados de leProducao*/
	
	public modeloTabela(List<getsetProducao> linhasAdd){
		
		linhas = new ArrayList<getsetProducao>(linhasAdd);
	}
	
	

		public int getColumnCount() {
			// TODO Auto-generated method stub
			//retorna o numero de colunas pré-determinado no modelo
			return colunas.length;
		}
	
		public int getRowCount() {
			// TODO Auto-generated method stub
			//retorna o numero de linhas baseado no tamanho do Array
			return linhas.size();
		}
		
		public String getColumnName (int columnIndex){
			
			return colunas[columnIndex];
		}
		
		 public Class<?> getColumnClass(int columnIndex) {  
		        
			 switch (columnIndex){    
	            case 0:    
	                return Image.class;    
	            case 1:    
	                return String.class;    
	            case 2:    
	                return String.class;    
	            case 3:    
	                return String.class;    
	            case 4:    
	            	return String.class;  
	            case 5:    
	            	return String.class;  
	            case 6:
	            	return String.class;
	            default:    
	                throw new IndexOutOfBoundsException("ColumnIndex out of bounds"); 
			 }
			 
		    }  
		 
	
		 //modificando linha e coluna especificada.
		 
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			getsetProducao leprod = (getsetProducao) linhas.get(rowIndex);
			// TODO Auto-generated method stub
				
			
			/* Switch para retornar qual coluna será utilizada para escrever o conteudo da celula.*/
				switch (columnIndex) {
				
				case 0:
					return leprod.getStatus();
				case 1 :
					return leprod.getPrintID();
				case 2 :
					return leprod.getType();				
				case 3:					
					return leprod.getProdName();				
				case 4:
					return leprod.getDobradeira();					
				case 5:					
					return leprod.getTiragem();
				case 6:
					return leprod.getTipo_bobina();
				
					
				default:
					
					throw new IndexOutOfBoundsException("columnIndex out of bounds");
					
				}
			
		}
		
		//modifica na linha e coluna especificada.
		
		public void setValueAt(getsetProducao aValue, int rowIndex, int columnIndex){
				
			getsetProducao leprod = (getsetProducao) linhas.get(rowIndex); //carrega linha a ser modificada
			
			leprod.setPrintID(aValue.getPrintID());
			leprod.setProdName(aValue.getProdName());
			leprod.setTiragem(aValue.getTiragem());
			leprod.setType(aValue.getType());
			leprod.setDobradeira(aValue.getDobradeira());
			leprod.setStatus(aValue.getStatus());
			leprod.setTipo_bobina(aValue.getTipo_bobina());
			
			fireTableCellUpdated(rowIndex, 0);
			fireTableCellUpdated(rowIndex, 1);
			fireTableCellUpdated(rowIndex, 2);
			fireTableCellUpdated(rowIndex, 3);
			fireTableCellUpdated(rowIndex, 4);
			fireTableCellUpdated(rowIndex, 5);
			fireTableCellUpdated(rowIndex, 6);
			
		}
		
		
		public boolean isCellEditable (int rowIndex, int columnIndex){
			//decide se a celula é editavel ou não, foi setada para False pois não será editada manualmente
			return false;
		
		}
		
		public getsetProducao getProducao (int indiceLinha){
			
			return linhas.get(indiceLinha);
		}
		
		
		/* adiciona registro*/
		
		public void addProducao (getsetProducao m){
			linhas.add(m);
		}
		
		/* Remove linha especificada */
		
		public void removeProd(int indiceLinha){
			
			linhas.remove(indiceLinha);
			
			fireTableCellUpdated(indiceLinha, indiceLinha);
		}
		
		/* adiciona uma linha de producao no final do registro */
		
		public void addListaDeProducao (List<getsetProducao> leprod){
			
			//checa o tamanho anterior do Array
			int tamanhoAntigo = getRowCount();
			
			//adicionando registro
			linhas.addAll(leprod);
			
			fireTableRowsInserted(tamanhoAntigo, getRowCount() -1);
		}
		
		/*limpar registros*/
		
		public void limpar(){
			
			linhas.clear();
			
			fireTableDataChanged();
		}
		
		/* verifica se o Table Model está vazio*/
		
		public boolean isEmpty(){
			
			return linhas.isEmpty();
		}
		
		
		


		

}
