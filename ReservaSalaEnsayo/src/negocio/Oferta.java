package negocio;

import java.util.Objects;

public class Oferta implements Comparable<Oferta> {

	private String nombre;
	private String apellido;
	private String dni;
	private double montoOferta;
	private int horarioInicial;
	private int horarioFinal;

	private int cantidadHorasOfertadas;
	private boolean bateria;
	private boolean amplificador;
	private boolean microfono;
	private boolean piano;
	private boolean consola;
	private boolean parlante;
	

	public Oferta(String nombre, String apellido, String dni, double montoOferta, int horarioInicial,
			int horarioFinal) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.montoOferta = montoOferta;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		calcularHorasOfertadas();

	}
	
	public void calcularHorasOfertadas() {
		this.cantidadHorasOfertadas = horarioFinal - horarioInicial;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public String obtenerApellido() {
		return apellido;
	}

	public String obtenerDni() {
		return dni;
	}

	public double obtenerMontoOferta() {
		return montoOferta;
	}

	public int obtenerHorarioInicial() {
		return horarioInicial;
	}

	public int obtenerHorarioFinal() {
		return horarioFinal;
	}
	
	public int obtenerCantidadHorasOfertadas() {
		return cantidadHorasOfertadas;
	}

	public boolean esBateriaReservada() {
		return bateria;
	}

	public void asignarReservaBateria(boolean bateria) {
		this.bateria = bateria;
	}

	public boolean esAmplificadorReservado() {
		return amplificador;
	}

	public void asignarReservaAmplificador(boolean amplificador) {
		this.amplificador = amplificador;
	}

	public boolean esMicrofonoReservado() {
		return microfono;
	}

	public void asignarReservaMicrofono(boolean microfono) {
		this.microfono = microfono;
	}

	public boolean esPianoReservado() {
		return piano;
	}

	public void asignarReservaPiano(boolean piano) {
		this.piano = piano;
	}

	public boolean esConsolaReservada() {
		return consola;
	}

	public void asignarReservaConsola(boolean consola) {
		this.consola = consola;
	}

	public boolean esParlanteReservado() {
		return parlante;
	}

	public void asignarReservaParlante(boolean parlante) {
		this.parlante = parlante;
	}
	
	public void verificarHorario (int horarIni, int horarioFinal) {
		if (this.horarioFinal<=this.horarioInicial) {
			throw new IllegalArgumentException("El horario inicial debe ser inferior al horario final");
		}		
	}

	@Override
	public int compareTo(Oferta otra) {

		double valor1 = this.montoOferta / this.cantidadHorasOfertadas;
		double valor2 = otra.montoOferta / otra.cantidadHorasOfertadas;

		if (valor1 < valor2) {
			return 1;
		} else if (valor1 > valor2) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		return amplificador == other.amplificador && Objects.equals(apellido, other.apellido)
				&& bateria == other.bateria && cantidadHorasOfertadas == other.cantidadHorasOfertadas
				&& consola == other.consola && Objects.equals(dni, other.dni) && horarioFinal == other.horarioFinal
				&& horarioInicial == other.horarioInicial && microfono == other.microfono
				&& Double.doubleToLongBits(montoOferta) == Double.doubleToLongBits(other.montoOferta)
				&& Objects.equals(nombre, other.nombre) && parlante == other.parlante && piano == other.piano;
	}
	
	
}
