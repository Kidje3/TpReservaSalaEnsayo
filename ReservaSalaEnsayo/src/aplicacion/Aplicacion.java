package aplicacion;

import cliente.PantallaMenuPrincipal;
import cliente.PantallaOfertar;
import cliente.PantallaReservasAsignada;
import persistencia.GestorDeOfertasJSON;

public class Aplicacion {
	private PantallaMenuPrincipal menuPrincipal;
	PantallaOfertar reservarSala;
	PantallaReservasAsignada reservasAsignadas;
	GestorDeOfertasJSON ofertasJSON;

	public Aplicacion() {
		preparar();
		mostrarMenu();
	}

	private void mostrarMenu() {
		this.menuPrincipal.frame.setVisible(true);
	}

	private void preparar() {
		this.ofertasJSON = GestorDeOfertasJSON.leerJSON("GestorDeOfertasPretty.JSON");
		this.reservarSala = new PantallaOfertar(this, this.ofertasJSON);
		this.reservasAsignadas = new PantallaReservasAsignada(this, this.ofertasJSON);
		this.menuPrincipal = new PantallaMenuPrincipal(this, this.reservarSala, this.reservasAsignadas,
				this.ofertasJSON);

	}

	public PantallaMenuPrincipal verMenuPricipal() {
		return this.getMenuPricipal();
	}

	private PantallaMenuPrincipal getMenuPricipal() {
		return this.menuPrincipal;
	}
}
