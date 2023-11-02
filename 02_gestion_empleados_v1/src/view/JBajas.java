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

import service.EmpleadoService;

public class JBajas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	EmpleadoService es = new EmpleadoService();

	public JBajas() {
		setTitle("Eliminar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(111, 77, 82, 14);
		contentPane.add(lblEmail);
		
		JTextArea txtEmail = new JTextArea();
		txtEmail.setBounds(203, 72, 134, 22);
		contentPane.add(txtEmail);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (es.borrarEmpleado(txtEmail.getText())) {
					JOptionPane.showMessageDialog(JBajas.this, "RIP");
					txtEmail.setText("");
				} else {
					JOptionPane.showMessageDialog(JBajas.this, "Pos no ha podío ser");
				};	
			}
		});
		btnEliminar.setBounds(171, 202, 89, 23);
		contentPane.add(btnEliminar);
		
		this.setVisible(true);
	}

}
