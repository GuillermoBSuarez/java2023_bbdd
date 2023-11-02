package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.EmpleadoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JModificaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	EmpleadoService es = new EmpleadoService();

	public JModificaciones() {
		setTitle("Modificaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("Id");
		lbId.setBounds(110, 54, 82, 14);
		contentPane.add(lbId);
		
		JTextArea txtId = new JTextArea();
		txtId.setBounds(202, 49, 134, 22);
		contentPane.add(txtId);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(110, 109, 82, 14);
		contentPane.add(lblSalario);
		
		JTextArea txtSalario = new JTextArea();
		txtSalario.setBounds(202, 104, 134, 22);
		contentPane.add(txtSalario);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (es.actualizarSalario(Integer.valueOf(txtId.getText()), Double.valueOf(txtSalario.getText()))) {
					JOptionPane.showMessageDialog(JModificaciones.this, "Tocada la cartera");
				} else {
					JOptionPane.showMessageDialog(JModificaciones.this, "Pos no ha podío ser");
				};
			}
		});
		btnGrabar.setBounds(190, 201, 89, 23);
		contentPane.add(btnGrabar);
		
		this.setVisible(true);
	}

}
