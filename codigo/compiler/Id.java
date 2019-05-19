package compiler;

public class Id {

	String id;
	int value;
	boolean tem_valor;
	Id id_outro;
	
	public int getnext(Id item) {
		if (isTem_valor()) {
			return value;
		} else {
			return getnext(getId_outro());
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Id getId_outro() {
		return id_outro;
	}

	public void setId_outro(Id id_outro) {
		this.id_outro = id_outro;
	}

	public boolean isTem_valor() {
		return tem_valor;
	}

	public void setTem_valor(boolean tem_valor) {
		this.tem_valor = tem_valor;
	}
	
	

}
