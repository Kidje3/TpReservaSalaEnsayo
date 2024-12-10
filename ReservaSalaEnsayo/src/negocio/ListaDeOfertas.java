package negocio;

import java.util.ArrayList;
import java.util.Collections;

public class ListaDeOfertas {

	private ArrayList<Oferta> ofertas;

	public ListaDeOfertas() {
		ofertas = new ArrayList<Oferta>();
	}

	public void agregarOferta(Oferta oferta) {		
		ofertas.add(oferta);
	}	
	
	public Oferta obtenerOferta(int indice) {
		return ofertas.get(indice);
	}		

	public int obtenerTamaño() {
		return ofertas.size();
	}

	public void ordenarLista() {
		Collections.sort(ofertas);		
	}

}
