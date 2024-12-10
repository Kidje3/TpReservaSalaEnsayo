package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import aplicacion.Aplicacion;
import negocio.ListaDeOfertas;
import persistencia.GestorDeOfertasJSON;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PantallaReservasAsignada{

	public JFrame frame;
	private Aplicacion aplicacion;
	private JTable table;
	private GestorDeOfertasJSON gestorDeOfertas;
	private ListaDeOfertas listaOfertas;
	private JButton btnVolverMenu;
	private JComboBox<String> comboBoxFechasOfertas;
	private JComboBox<String> comboBoxFechasReservas;

	private JTable table_1;

	public PantallaReservasAsignada(Aplicacion app, GestorDeOfertasJSON gestor) {
		this.aplicacion = app;
		this.gestorDeOfertas = gestor;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(600, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane_ofertas = new JScrollPane();
		scrollPane_ofertas.setBounds(10, 47, 564, 125);
		frame.getContentPane().add(scrollPane_ofertas);

		table = new JTable();
		scrollPane_ofertas.setViewportView(table);

		btnVolverMenu = new JButton("Volver");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				aplicacion.verMenuPricipal().frame.setVisible(true);
			}
		});
		btnVolverMenu.setBounds(485, 377, 89, 23);
		frame.getContentPane().add(btnVolverMenu);

		DefaultTableModel model = new DefaultTableModel();
		setearModelo(model);
		table.setModel(model);

		comboBoxFechasOfertas = new JComboBox<String>();
		comboBoxFechasOfertas.setBounds(166, 11, 144, 22);
		frame.getContentPane().add(comboBoxFechasOfertas);
		JLabel lblNewLabel = new JLabel("Ofertadas para fecha");
		lblNewLabel.setBounds(28, 15, 128, 14);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane_reservas = new JScrollPane();
		scrollPane_reservas.setBounds(10, 241, 564, 125);
		frame.getContentPane().add(scrollPane_reservas);

		table_1 = new JTable();
		scrollPane_reservas.setViewportView(table_1);

		DefaultTableModel model2 = new DefaultTableModel();
		setearModelo(model2);
		table_1.setModel(model2);

		comboBoxFechasReservas = new JComboBox<String>();
		comboBoxFechasReservas.setBounds(166, 208, 144, 22);
		frame.getContentPane().add(comboBoxFechasReservas);

		JLabel lblReservadasEnLa = new JLabel("Reservadas en fecha");
		lblReservadasEnLa.setBounds(28, 212, 139, 14);
		frame.getContentPane().add(lblReservadasEnLa);

		JButton btnOfertas = new JButton("Ver Ofertas");
		btnOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (String) comboBoxFechasOfertas.getSelectedItem();
				model.setRowCount(0);
				cargarOfertasEnTabla(model, a);

			}
		});
		btnOfertas.setBounds(341, 11, 128, 23);
		frame.getContentPane().add(btnOfertas);

		JButton btnReservas = new JButton("Ver Reservas");
		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (String) comboBoxFechasReservas.getSelectedItem();
				model2.setRowCount(0);
				cargarReservasEnTabla(model2, a);
			}
		});
		btnReservas.setBounds(341, 207, 128, 23);
		frame.getContentPane().add(btnReservas);
	}

	private void setearModelo(DefaultTableModel model) {
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("desde");
		model.addColumn("hasta");
		model.addColumn("Oferta");
		model.addColumn("Bateria");
		model.addColumn("Amplificador");
		model.addColumn("Piano");
		model.addColumn("Microfono");
		model.addColumn("Consola");
		model.addColumn("Parlante");
	}

	private void cargarOfertasEnTabla(DefaultTableModel model, String fecha) {
		listaOfertas = gestorDeOfertas.obtenerOfertasDeFecha(fecha);
		for (int i = 0; i < listaOfertas.obtenerTamaño(); i++) {
			model.addRow(new String[] { listaOfertas.obtenerOferta(i).obtenerNombre(),
					listaOfertas.obtenerOferta(i).obtenerApellido(), listaOfertas.obtenerOferta(i).obtenerDni(),
					listaOfertas.obtenerOferta(i).obtenerHorarioInicial() + "",
					listaOfertas.obtenerOferta(i).obtenerHorarioFinal() + "",
					listaOfertas.obtenerOferta(i).obtenerMontoOferta() + "",
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esBateriaReservada()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esAmplificadorReservado()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esPianoReservado()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esMicrofonoReservado()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esConsolaReservada()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esParlanteReservado()) });
		}
	}

	private void cargarReservasEnTabla(DefaultTableModel model, String fecha) {
		listaOfertas = gestorDeOfertas.obtenerReservasDeFecha(fecha);
		for (int i = 0; i < listaOfertas.obtenerTamaño(); i++) {
			model.addRow(new String[] { listaOfertas.obtenerOferta(i).obtenerNombre(),
					listaOfertas.obtenerOferta(i).obtenerApellido(), listaOfertas.obtenerOferta(i).obtenerDni(),
					listaOfertas.obtenerOferta(i).obtenerHorarioInicial() + "",
					listaOfertas.obtenerOferta(i).obtenerHorarioFinal() + "",
					listaOfertas.obtenerOferta(i).obtenerMontoOferta() + "",
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esBateriaReservada()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esAmplificadorReservado()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esPianoReservado()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esMicrofonoReservado()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esConsolaReservada()),
					ponerSimboloEnLugarDeBoolean(listaOfertas.obtenerOferta(i).esParlanteReservado()) });
		}
	}

	private String ponerSimboloEnLugarDeBoolean(Boolean logico) {
		if (logico == true)
			return "✓";
		return "x";
	}

	public void actualizarComboFecha() {
		this.comboBoxFechasOfertas.removeAllItems();
		this.comboBoxFechasReservas.removeAllItems();

		for (String fecha : gestorDeOfertas.verFechasOfertas()) {
			this.comboBoxFechasOfertas.addItem(fecha);

		}

		for (String fecha : gestorDeOfertas.verFechasReservas()) {

			this.comboBoxFechasReservas.addItem(fecha);

		}
	}
}
