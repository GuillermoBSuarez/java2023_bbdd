package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Usuario;
import service.UsuarioService;

public class JLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	
	UsuarioService us = new UsuarioService();

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	/** Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 211);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(64, 39, 66, 14);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(45, 70, 80, 14);
		contentPane.add(lblPass);
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(140, 38, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setColumns(10);
		txtPass.setBounds(140, 69, 86, 20);
		contentPane.add(txtPass);
		
		JButton bEntrar = new JButton("Entrar");
		bEntrar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (us.comprobarUsuario( new Usuario( txtUser.getText(), txtPass.getText() ) ) ) {
							JOptionPane.showMessageDialog( JLogin.this, "Usuario correcto" );
						} else {
							JOptionPane.showMessageDialog( JLogin.this, "Usuario INcorrecto" );
						}
					}
				}
		);
		bEntrar.setBounds(93, 122, 89, 23);
		contentPane.add(bEntrar);
	}
}
