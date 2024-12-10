package negocio;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OfertaTest {

    private Oferta oferta;

    @Before
    public void iniciar() {
        oferta = new Oferta("Edu", "Gara", "36039472", 100.0, 10, 14);
    }

    @Test
    public void CalcularHorasOfertadasTest() {
        oferta.calcularHorasOfertadas();
        assertEquals(4, oferta.obtenerCantidadHorasOfertadas()); // 14 - 10 = 4
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerificarHorarioInvalido() {
        Oferta ofertaInvalida = new Oferta("Edu", "Gara", "36039472", 100.0, 14, 10);
        ofertaInvalida.verificarHorario(14, 10);
    }
    
    @Test
    public void asignarYVerificarReservaBateriaTest() {
        oferta.asignarReservaBateria(true);
        assertTrue(oferta.esBateriaReservada());
    }

    @Test
    public void asignarYVerificarReservaAmplificadorTest() {
        oferta.asignarReservaAmplificador(true);
        assertTrue(oferta.esAmplificadorReservado());
    }

    @Test
    public void asignarYVerificarReservaMicrofonoTest() {
        oferta.asignarReservaMicrofono(true);
        assertTrue(oferta.esMicrofonoReservado());
    }

    @Test
    public void asignarYVerificarReservaPianoTest() {
        oferta.asignarReservaPiano(true);
        assertTrue(oferta.esPianoReservado());
    }

    @Test
    public void asignarYVerificarReservaConsolaTest() {
        oferta.asignarReservaConsola(true);
        assertTrue(oferta.esConsolaReservada());
    }

    @Test
    public void asignarYVerificarReservaParlanteTest() {
        oferta.asignarReservaParlante(true);
        assertTrue(oferta.esParlanteReservado());
    }
    

    @Test
    public void CompareToTest() {
        Oferta oferta2 = new Oferta("Ana", "Gómez", "87654321", 200.0, 10, 12);
        Oferta oferta3 = new Oferta("Carlos", "Díaz", "11223344", 50.0, 10, 15);

        assertTrue(oferta.compareTo(oferta2) > 0);

        assertTrue(oferta.compareTo(oferta3) < 0);
    }
}