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

import service.FormacionService;
import service.FormacionServiceFactory;

public class JBorrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JBorrar() {
		setTitle("Borrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(111, 77, 82, 14);
		contentPane.add(lblDNI);
		
		JTextArea txtDNI = new JTextArea();
		txtDNI.setBounds(203, 72, 134, 22);
		contentPane.add(txtDNI);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FormacionService fs = new FormacionService();
				var service = FormacionServiceFactory.getFormacionService();
				if (service.borrarAlumno(txtDNI.getText())) {
					JOptionPane.showMessageDialog(JBorrar.this, "Kaput");
					txtDNI.setText("");
				} else {
					JOptionPane.showMessageDialog(JBorrar.this, "Nasti de plasti");
				};	
			}
		});
		btnBorrar.setBounds(171, 202, 89, 23);
		contentPane.add(btnBorrar);
		
		this.setVisible(true);
	}
}