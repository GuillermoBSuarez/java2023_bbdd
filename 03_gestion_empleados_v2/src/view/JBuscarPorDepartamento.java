package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import service.EmpleadoService;
import view.adapters.TablaEmpleadoModel;

public class JBuscarPorDepartamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	EmpleadoService es = new EmpleadoService();
	private JTable tblEmpleados;

	public JBuscarPorDepartamento() {
		setTitle("Empleados por departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(110, 16, 82, 14);
		contentPane.add(lblDepartamento);
		
		JTextArea txtDepartamento = new JTextArea();
		txtDepartamento.setBounds(202, 11, 134, 22);
		contentPane.add(txtDepartamento);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblEmpleados.setModel(new TablaEmpleadoModel(txtDepartamento.getText()));
			}
		});
		btnBuscar.setBounds(169, 64, 89, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 98, 335, 152);
		contentPane.add(scrollPane);
		
		tblEmpleados = new JTable();
		scrollPane.setViewportView(tblEmpleados);
		
		this.setVisible(true);
	}
}
