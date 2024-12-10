package cliente;

import negocio.FiltroNumeros;
import negocio.Oferta;
import persistencia.GestorDeOfertasJSON;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import aplicacion.Aplicacion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class PantallaOfertar {

	public JFrame frame;
	private Aplicacion aplicacion;
	private JTextField nombre;
	private JTextField dni;
	private JTextField oferta;
	private JTextField apellido;
	private GestorDeOfertasJSON gestorDeOfertas;
	private LocalDate fechaActual;
	private JCheckBox chckBateria;
	private JCheckBox chckAmplificador;
	private JCheckBox chckPiano;
	private JCheckBox chckConsola;
	private JCheckBox chckMicrofono;
	private JCheckBox chckParlante;
	private JComboBox<Integer> horarioDesde;
	private JComboBox<Integer> horarioHasta;
	private JButton btnVolverMenu;

	public PantallaOfertar(Aplicacion app, GestorDeOfertasJSON gestor) {
		this.aplicacion = app;
		fechaActual = LocalDate.now().plusDays(1);
		this.gestorDeOfertas = gestor;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ingresa Oferta");
		frame.setSize(600, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		horarioDesde = new JComboBox<Integer>();
		horarioDesde.setBounds(153, 304, 89, 22);
		frame.getContentPane().add(horarioDesde);

		horarioHasta = new JComboBox<Integer>();
		horarioHasta.setBounds(304, 304, 89, 22);
		frame.getContentPane().add(horarioHasta);

		setComboHorario(horarioDesde, horarioHasta);

		JLabel lblNewLabel = new JLabel("desde");
		lblNewLabel.setBounds(153, 290, 80, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("hasta");
		lblNewLabel_1.setBounds(304, 290, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		nombre = new JTextField();
		nombre.setBounds(90, 53, 160, 20);
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(19, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		dni = new JTextField();
		dni.setBounds(90, 82, 160, 20);
		((AbstractDocument) dni.getDocument()).setDocumentFilter(new FiltroNumeros());
		frame.getContentPane().add(dni);
		dni.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Dni");
		lblNewLabel_3.setBounds(19, 85, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);

		oferta = new JTextField();
		oferta.setBounds(363, 84, 160, 20);
		((AbstractDocument) oferta.getDocument()).setDocumentFilter(new FiltroNumeros());
		frame.getContentPane().add(oferta);
		oferta.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Oferta         $");
		lblNewLabel_4.setBounds(285, 87, 80, 14);
		frame.getContentPane().add(lblNewLabel_4);

		apellido = new JTextField();
		apellido.setBounds(363, 53, 160, 20);
		frame.getContentPane().add(apellido);
		apellido.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Apellido");
		lblNewLabel_6.setBounds(282, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);

		chckBateria = new JCheckBox("Bateria");
		chckBateria.setBounds(153, 164, 97, 23);
		frame.getContentPane().add(chckBateria);

		chckAmplificador = new JCheckBox("Amplificador");
		chckAmplificador.setBounds(153, 187, 97, 23);
		frame.getContentPane().add(chckAmplificador);

		chckPiano = new JCheckBox("Piano");
		chckPiano.setBounds(342, 164, 97, 23);
		frame.getContentPane().add(chckPiano);

		chckConsola = new JCheckBox("Consola");
		chckConsola.setBounds(342, 187, 97, 23);
		frame.getContentPane().add(chckConsola);

		chckMicrofono = new JCheckBox("Microfono");
		chckMicrofono.setBounds(153, 213, 97, 23);
		frame.getContentPane().add(chckMicrofono);

		chckParlante = new JCheckBox("Parlante");
		chckParlante.setBounds(342, 213, 97, 23);
		frame.getContentPane().add(chckParlante);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 137, 564, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 262, 564, 2);
		frame.getContentPane().add(separator_1);

		JButton btnRegistrarOferta = new JButton("Registrar Oferta");
		btnRegistrarOferta.setBounds(207, 359, 129, 23);
		frame.getContentPane().add(btnRegistrarOferta);

		btnRegistrarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarOferta();
			}
		});

		JLabel lblNewLabel_5 = new JLabel("Horario");
		lblNewLabel_5.setBounds(19, 275, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Equipamiento");
		lblNewLabel_7.setBounds(19, 147, 97, 14);
		frame.getContentPane().add(lblNewLabel_7);

		btnVolverMenu = new JButton("Volver");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				aplicacion.verMenuPricipal().frame.setVisible(true);
			}
		});
		btnVolverMenu.setBounds(473, 377, 89, 23);
		frame.getContentPane().add(btnVolverMenu);
	}

	private void registrarOferta() {
		String fechaString = fechaActual.toString();
		String nombreUsuario = nombre.getText();
		String dniUsuario = dni.getText();
		String apellidoUsuario = apellido.getText();
		double ofertaUsuario = Double.parseDouble(oferta.getText());
		int valorSeleccionadoDesde = (Integer) horarioDesde.getSelectedItem();
		int valorSeleccionadoHasta = (Integer) horarioHasta.getSelectedItem();
		
		

		Oferta nuevaOferta = new Oferta(nombreUsuario, apellidoUsuario, dniUsuario, ofertaUsuario,
				valorSeleccionadoDesde, valorSeleccionadoHasta);
		
		equipamientoSeleccionado(nuevaOferta);
		agregaOferta(fechaString, valorSeleccionadoDesde, valorSeleccionadoHasta, nuevaOferta);

		limpiarPantalla();
	}

	private void agregaOferta(String fechaString, int valorSeleccionadoDesde, int valorSeleccionadoHasta,
			Oferta nuevaOferta) {

		try {
			gestorDeOfertas.guardarOfertaJSON(fechaString, nuevaOferta, valorSeleccionadoDesde, valorSeleccionadoHasta);
			JOptionPane.showMessageDialog(null, "Oferta agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Error: Debe ingresar bien los datos. " + e.getMessage(),
					"Error en los datos", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void equipamientoSeleccionado(Oferta nuevaOferta) {
		nuevaOferta.asignarReservaBateria(chckBateria.isSelected());
		nuevaOferta.asignarReservaAmplificador(chckAmplificador.isSelected());
		nuevaOferta.asignarReservaPiano(chckPiano.isSelected());
		nuevaOferta.asignarReservaConsola(chckConsola.isSelected());
		nuevaOferta.asignarReservaMicrofono(chckMicrofono.isSelected());
		nuevaOferta.asignarReservaParlante(chckParlante.isSelected());
	}

	private void setComboHorario(JComboBox<Integer> horarioDesde, JComboBox<Integer> horarioHasta) {
		for (int i = 0; i <= 23; i++) {
			horarioDesde.addItem(i);
			horarioHasta.addItem(i);
		}
	}

	private void limpiarPantalla() {
		limpiarFiltro(dni);
		limpiarFiltro(oferta);
		limpiarOferta();
	}

	private void limpiarOferta() {
		nombre.setText("");
		apellido.setText("");
		dni.setText("");
		oferta.setText("");
		horarioDesde.setSelectedIndex(0);
		horarioHasta.setSelectedIndex(0);
		chckBateria.setSelected(false);
		chckAmplificador.setSelected(false);
		chckPiano.setSelected(false);
		chckConsola.setSelected(false);
		chckMicrofono.setSelected(false);
		chckParlante.setSelected(false);
	}

	private void limpiarFiltro(JTextField campo) {
		((AbstractDocument) campo.getDocument()).setDocumentFilter(null);
		campo.setText("");
		((AbstractDocument) campo.getDocument()).setDocumentFilter(new FiltroNumeros());
	}
}
