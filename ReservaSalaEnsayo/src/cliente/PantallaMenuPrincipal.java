package cliente;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import aplicacion.Aplicacion;
import negocio.AlgoritmoGoloso;
import negocio.ListaDeOfertas;
import persistencia.GestorDeOfertasJSON;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaMenuPrincipal {

	private PantallaOfertar reservarSala;
	private PantallaReservasAsignada reservasAsignadas;
	private GestorDeOfertasJSON gestorDeOfertas;
	private ListaDeOfertas lista;
	public JFrame frame;
	private LocalDate fechaActual;

	public PantallaMenuPrincipal(Aplicacion app, PantallaOfertar reserva, PantallaReservasAsignada resAsig,
			GestorDeOfertasJSON gestor) {
		this.gestorDeOfertas = gestor;
		this.reservarSala = reserva;
		this.reservasAsignadas = resAsig;
		fechaActual = LocalDate.now().plusDays(1);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(600, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Menu reservas sala");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(202, 0, 176, 54);
		frame.getContentPane().add(lblTitulo);

		JButton btnGenOferta = new JButton("Ingresar Oferta");
		btnGenOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!gestorDeOfertas.estaReservada(fechaActual.toString())) {
					reservarSala.frame.setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Ya esta Reservada. ", "Error", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnGenOferta.setBounds(24, 65, 206, 64);
		frame.getContentPane().add(btnGenOferta);

		JButton btnVerOferta = new JButton("Ver Ofertas");
		btnVerOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				reservasAsignadas.frame.setVisible(true);
				frame.setVisible(false);
				actualizarComboFecha();
			}
		});
		btnVerOferta.setBounds(349, 65, 206, 65);
		frame.getContentPane().add(btnVerOferta);

		JButton btnFinOfertas = new JButton("Finalizar Ofertas del Dia");
		btnFinOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!gestorDeOfertas.estaReservada(fechaActual.toString())) {
					finalizarOfertasDelDia();

				} else {
					JOptionPane.showMessageDialog(null, "Ofertas finalizadas. ", "Error", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnFinOfertas.setBounds(24, 199, 531, 54);
		frame.getContentPane().add(btnFinOfertas);
	}

	private void actualizarComboFecha() {
		this.reservasAsignadas.actualizarComboFecha();

	}

	private void finalizarOfertasDelDia() {
		String fechaString = fechaActual.toString();
		lista = gestorDeOfertas.obtenerOfertasDeFecha(fechaString);
		ListaDeOfertas listaReservada = AlgoritmoGoloso.generarAlgGol(lista);
		gestorDeOfertas.guardarListaReservadaJSON(fechaString, listaReservada);
	}
}
