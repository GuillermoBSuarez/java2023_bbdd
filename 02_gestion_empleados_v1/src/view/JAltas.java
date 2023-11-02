package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Empleado;
import service.EmpleadoService;

public class JAltas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	EmpleadoService es = new EmpleadoService();

	public JAltas() {
		setTitle("Altas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(107, 41, 82, 14);
		contentPane.add(lblNombre);
		
		JTextArea txtNombre = new JTextArea();
		txtNombre.setBounds(199, 36, 134, 22);
		contentPane.add(txtNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(107, 85, 82, 14);
		contentPane.add(lblEmail);
		
		JTextArea txtEmail = new JTextArea();
		txtEmail.setBounds(199, 80, 134, 22);
		contentPane.add(txtEmail);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(107, 131, 82, 14);
		contentPane.add(lblDepartamento);
		
		JTextArea txtDepartamento = new JTextArea();
		txtDepartamento.setBounds(199, 126, 134, 22);
		contentPane.add(txtDepartamento);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(107, 175, 82, 14);
		contentPane.add(lblSalario);
		
		JTextArea txtSalario = new JTextArea();
		txtSalario.setBounds(199, 170, 134, 22);
		contentPane.add(txtSalario);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (es.grabarEmpleado( new Empleado( txtNombre.getText(),
						 							 txtEmail.getText(),
						 							 txtDepartamento.getText(),
						 							 Double.valueOf(txtSalario.getText()) ) ) ) {
					JOptionPane.showMessageDialog(JAltas.this, "Grabado");
					txtNombre.setText("");
					txtEmail.setText("");
					txtDepartamento.setText("");
					txtSalario.setText("");
				} else {
					JOptionPane.showMessageDialog(JAltas.this, "Pos no ha podío ser");
				};	
			}
		});
		btnGrabar.setBounds(186, 214, 89, 23);
		contentPane.add(btnGrabar);
		
		this.setVisible(true);
	}
}
