package vista;

public class ImagenView {

	private String direccion;
	private String tipo;
	
	public ImagenView() {}

	public ImagenView(String direccion, String tipo) {
		this.direccion = direccion;
		this.tipo = tipo;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
