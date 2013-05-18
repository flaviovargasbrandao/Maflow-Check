package controle;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

public class iconeCheck extends DefaultTableCellRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void setValue (Object value){
		
		if (value instanceof ImageIcon){
			
			if (value !=null){
				ImageIcon imagem = (ImageIcon) value;
				setIcon(imagem);
			}else{
				setText("");
				setIcon(null);
			}
			
		}else{
			
			super.setValue(value);
		}
	}

}
