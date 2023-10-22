package vista;

public class UnidadView {

	private int id;
	private String piso;
	private String numero;
	private boolean habitado;
	private EdificioView edificio;

	private PersonaView persona;
	
	public UnidadView() {}

	public UnidadView(int id, String piso, String numero, boolean habitado, EdificioView edificio) {
		this.id = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = habitado;
		this.edificio = edificio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getNumero() {
		return numero;
	}

	public PersonaView getPersona(){
		return persona;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isHabitado() {
		return habitado;
	}

	public void setHabitado(boolean habitado) {
		this.habitado = habitado;
	}

	public EdificioView getEdificio() {
		return edificio;
	}

	public void setEdificio(EdificioView edificio) {
		this.edificio = edificio;
	}

	public void setPersona(PersonaView persona){
		this.persona = persona;
	}
	
	public String toString() {
		return piso + " " + numero + " " + edificio.toString();
	}
}
