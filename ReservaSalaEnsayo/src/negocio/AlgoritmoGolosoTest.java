package negocio;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AlgoritmoGolosoTest {

    private ListaDeOfertas listaDeOfertas;
    private Oferta oferta1;
    private Oferta oferta2;
    private Oferta oferta3;
    private Oferta oferta4;

    @Before
    public void iniciar() {
        listaDeOfertas = new ListaDeOfertas();
        
        oferta1 = new Oferta("Edu", "Gara", "11111111", 150.0, 10, 12); 
        oferta2 = new Oferta("Julian", "Kidjekouchian", "22222222", 200.0, 13, 15);
        oferta3 = new Oferta("Seba", "Prieto", "33333333", 100.0, 12, 14);
        oferta4 = new Oferta("Thiago", "Lozano", "44444444", 250.0, 15, 17);
        
        listaDeOfertas.agregarOferta(oferta1);
        listaDeOfertas.agregarOferta(oferta2);
        listaDeOfertas.agregarOferta(oferta3);
        listaDeOfertas.agregarOferta(oferta4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verificarListaDeOfertasVaciaTest() {
        ListaDeOfertas listaVacia = new ListaDeOfertas();
        AlgoritmoGoloso.generarAlgGol(listaVacia);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verificarListaDeOfertasNulaTest() {
        AlgoritmoGoloso.generarAlgGol(null);
    }
   
    @Test
    public void generarAlgGolTest() {
        ListaDeOfertas listaGanadora = AlgoritmoGoloso.generarAlgGol(listaDeOfertas);

        assertTrue(oferta4.equals(listaGanadora.obtenerOferta(0)));
        assertTrue(oferta2.equals(listaGanadora.obtenerOferta(1)));
        assertTrue(oferta1.equals(listaGanadora.obtenerOferta(2)));
        
    }
}
