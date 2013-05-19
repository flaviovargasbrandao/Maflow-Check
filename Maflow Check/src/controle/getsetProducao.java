package controle;

import javax.swing.Icon;

public class getsetProducao {
	
	private Icon Status;
	private String printID;
	private String type;
	private String prodName;
	private String tiragem;
	private String dobradeira;
	private String tipo_bobina;

	
	
	public getsetProducao(){
		printID = null;
		type = null;
		prodName = null;
		tiragem = null;
		tipo_bobina=null;
		
	}
			public String getPrintID() {
				return printID;
			}
			public void setPrintID(String string) {
				this.printID = string;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public String getProdName() {
				return prodName;
			}
			public void setProdName(String prodName) {
				this.prodName = prodName;
			}
			public String getTiragem() {
				return tiragem;
			}
			public void setTiragem(String string) {
				this.tiragem = string;
			}
			public Icon getStatus() {
				return Status;
			}
			public void setStatus(Icon icon) {
				Status = icon;
			}
			public String getTipo_bobina() {
				return tipo_bobina;
			}
			public void setTipo_bobina(String tipo_bobina) {
				this.tipo_bobina = tipo_bobina;
			}
			public String getDobradeira() {
				return dobradeira;
			}
			public void setDobradeira(String dobradeira) {
				this.dobradeira = dobradeira;
			}

			
			
	
}
