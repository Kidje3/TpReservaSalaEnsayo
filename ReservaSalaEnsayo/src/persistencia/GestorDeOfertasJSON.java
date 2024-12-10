package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import negocio.ListaDeOfertas;
import negocio.Oferta;
import persistencia.GestorDeOfertasJSON;

public class GestorDeOfertasJSON {

	private HashMap<String, ListaDeOfertas> calendarioDeOfertas;
	private HashMap<String, ListaDeOfertas> calendarioDeOfertasReservadas;


	public GestorDeOfertasJSON() {
		this.calendarioDeOfertas = new HashMap<>();
		this.calendarioDeOfertasReservadas = new HashMap<>();
	}	
	
	public void guardarOfertaJSON(String fecha, Oferta oferta, int horarioInicial, int horarioFinal) {		
		oferta.verificarHorario(horarioInicial, horarioFinal);	
		agregaOferta(fecha, oferta);
		guardarEnJason();
	}

	private void agregaOferta(String fecha, Oferta oferta) {
		if (calendarioContieneFecha(fecha)) {
			agregarEnListaExistente(fecha, oferta);
		} else {
			agregarEnListaNueva(fecha, oferta);
		}
	}
	
	private void agregarEnListaNueva(String fecha, Oferta oferta) {
		ListaDeOfertas listaOfertas = new ListaDeOfertas();
		listaOfertas.agregarOferta(oferta);
		calendarioDeOfertas.put(fecha, listaOfertas);
	}

	private void agregarEnListaExistente(String fecha, Oferta oferta) {
		ListaDeOfertas lista = obtenerOfertasDeFecha(fecha);
		lista.agregarOferta(oferta);
	}
	
	public void guardarListaReservadaJSON (String fecha, ListaDeOfertas lista) {
		calendarioDeOfertasReservadas.put(fecha, lista);
		guardarEnJason();
	}
	
	public boolean estaReservada (String fecha) {
		return calendarioDeOfertasReservadas.containsKey(fecha);			
		}
	

	private void guardarEnJason() {
		String jsonPretty = generarJSONPretty();
		guardarJSON(jsonPretty, "GestorDeOfertasPretty.JSON");
	}

	private boolean calendarioContieneFecha(String fecha) {
		return calendarioDeOfertas.containsKey(fecha);
	}

	public ListaDeOfertas obtenerOfertasDeFecha(String fecha) {
		return calendarioDeOfertas.get(fecha);
	}
	
	public ListaDeOfertas obtenerReservasDeFecha(String fecha) {
		return calendarioDeOfertasReservadas.get(fecha);
	}
	
	public Set<String> verFechasOfertas() {
		return this.calendarioDeOfertas.keySet();
	}
	
	public Set<String> verFechasReservas() {
		return this.calendarioDeOfertasReservadas.keySet();
	}

	
	public String generarJSONPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);

		return json;
	}

	public void guardarJSON(String jsonParaGuardar, String archivoDestino) {
		try {
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static GestorDeOfertasJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		GestorDeOfertasJSON ret = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, GestorDeOfertasJSON.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	

}

