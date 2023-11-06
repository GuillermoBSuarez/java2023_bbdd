package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FormacionService;
import service.FormacionServiceFactory;

public class JOperacionesCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOperacionesCursos frame = new JOperacionesCursos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JOperacionesCursos() {
		setTitle("Gestor de cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);
		
		JMenuItem itActualizar = new JMenuItem("Actualizar datos");
		itActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// var fs = new FormacionService();
				var service = FormacionServiceFactory.getFormacionService();
				service.actualizarDatos();
			}
		});
		mnAcciones.add(itActualizar);
		
		JMenuItem itConsulta = new JMenuItem("Consulta");
		itConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JConsulta();
			}
		});
		mnAcciones.add(itConsulta);
		
		JMenuItem itBorrar = new JMenuItem("\"Eliminar\" alumnos");
		itBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JBorrar();
			}
		});
		mnAcciones.add(itBorrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
