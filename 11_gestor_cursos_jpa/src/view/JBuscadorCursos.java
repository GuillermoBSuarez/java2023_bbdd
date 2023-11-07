package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FormacionServiceFactory;
import view.adapters.TablaCursosFechaModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class JBuscadorCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTable tbCursos;

	public JBuscadorCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setBounds(118, 11, 70, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha de fin");
		lblFechaFin.setBounds(246, 11, 70, 14);
		contentPane.add(lblFechaFin);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(118, 36, 86, 20);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(246, 36, 86, 20);
		contentPane.add(txtFechaFin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 414, 121);
		contentPane.add(scrollPane);
		
		tbCursos = new JTable();
		scrollPane.setViewportView(tbCursos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					var service = FormacionServiceFactory.getFormacionService();
					var f1 = LocalDate.parse(txtFechaInicio.getText());
					var f2 = LocalDate.parse(txtFechaFin.getText());
					tbCursos.setModel(new TablaCursosFechaModel(f1, f2));
				} catch (DateTimeParseException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(JBuscadorCursos.this, "Error en las fechas");
				}
			}
		});
		btnBuscar.setBounds(181, 95, 89, 23);
		contentPane.add(btnBuscar);
		
		this.setVisible(true);
	}
}
