package negocio;

public class AlgoritmoGoloso {

	public static ListaDeOfertas generarAlgGol(ListaDeOfertas lista) {

		ListaDeOfertas listaGanadora = new ListaDeOfertas();

		verificarListaDeOfertas(lista);
		ListaDeOfertas nuevaListaOrdenada = crearListaOrdenada(lista);

		agregarLasMejoresOfertas(nuevaListaOrdenada, listaGanadora);
		
		return listaGanadora;

	}

	private static void verificarListaDeOfertas(ListaDeOfertas lista) {
		if (lista == null || lista.obtenerTamaño() == 0) {
			throw new IllegalArgumentException("La lista de ofertas no puede ser nula o vacía.");
		}
	}

	private static ListaDeOfertas crearListaOrdenada(ListaDeOfertas lista) {

		ListaDeOfertas listaOrdenada = new ListaDeOfertas();
		for (int i = 0; i < lista.obtenerTamaño(); i++) {
			listaOrdenada.agregarOferta(lista.obtenerOferta(i));
		}
		listaOrdenada.ordenarLista();
		return listaOrdenada;

	}

	private static void agregarLasMejoresOfertas(ListaDeOfertas nuevaListaOrdenada, ListaDeOfertas listaGanadora) {
		boolean[] casilleroDias = new boolean[23];

		for (int i = 0; i < nuevaListaOrdenada.obtenerTamaño(); i++) {

			if (!estaOcupado(casilleroDias, nuevaListaOrdenada.obtenerOferta(i).obtenerHorarioInicial(),
					nuevaListaOrdenada.obtenerOferta(i).obtenerHorarioFinal())) {

				listaGanadora.agregarOferta(nuevaListaOrdenada.obtenerOferta(i));
				reservarCasilleros(casilleroDias, nuevaListaOrdenada.obtenerOferta(i).obtenerHorarioInicial(),
						nuevaListaOrdenada.obtenerOferta(i).obtenerHorarioFinal());
			}
		}
	}

	private static boolean estaOcupado(boolean[] casilleros, int horaInicial, int horaFinal) {

		for (int i = horaInicial; i < horaFinal; i++) {
			if (casilleros[i] == true)
				return true;
		}
		return false;
	}

	private static void reservarCasilleros(boolean[] casilleros, int horaInicial, int horaFinal) {
		for (int i = horaInicial; i < horaFinal; i++) {
			casilleros[i] = true;
		}
	}
}
