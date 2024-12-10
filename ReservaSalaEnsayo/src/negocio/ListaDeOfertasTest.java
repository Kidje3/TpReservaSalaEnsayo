package negocio;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ListaDeOfertasTest {

	private ListaDeOfertas listaDeOfertas;
	private Oferta oferta1;
	private Oferta oferta2;
	private Oferta oferta3;

	@Before
	public void iniciar() {
		listaDeOfertas = new ListaDeOfertas();
		oferta1 = new Oferta("Edu", "Gara", "36039472", 150.0, 10, 14);
		oferta2 = new Oferta("Julian", "Kidjekouchian", "111111111", 200.0, 10, 12);
		oferta3 = new Oferta("Seba", "Prieto", "22222222", 100.0, 10, 15);
	}

	@Test
	public void agregarOfertaTest() {
		listaDeOfertas.agregarOferta(oferta1);
		listaDeOfertas.agregarOferta(oferta2);

		assertEquals(oferta1, listaDeOfertas.obtenerOferta(0));
		assertEquals(oferta2, listaDeOfertas.obtenerOferta(1));
	}

	@Test
	public void obtenerOfertaTest() {
		listaDeOfertas.agregarOferta(oferta1);
		listaDeOfertas.agregarOferta(oferta2);
		listaDeOfertas.agregarOferta(oferta3);

		assertEquals(oferta1, listaDeOfertas.obtenerOferta(0));
		assertEquals(oferta2, listaDeOfertas.obtenerOferta(1));
		assertEquals(oferta3, listaDeOfertas.obtenerOferta(2));
	}

	@Test
	public void obtenerTamañoTest() {

		listaDeOfertas.agregarOferta(oferta1);
		listaDeOfertas.agregarOferta(oferta2);
		listaDeOfertas.agregarOferta(oferta3);

		assertEquals(3, listaDeOfertas.obtenerTamaño());
	}

	@Test
	public void ordenarListaTest() {
		listaDeOfertas.agregarOferta(oferta1);
		listaDeOfertas.agregarOferta(oferta2);
		listaDeOfertas.agregarOferta(oferta3);

		listaDeOfertas.ordenarLista();

		assertEquals(oferta2, listaDeOfertas.obtenerOferta(0));
		assertEquals(oferta1, listaDeOfertas.obtenerOferta(1));
		assertEquals(oferta3, listaDeOfertas.obtenerOferta(2));
	}
}