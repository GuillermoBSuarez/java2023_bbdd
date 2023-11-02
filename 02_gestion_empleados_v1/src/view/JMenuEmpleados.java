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

public class JMenuEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuEmpleados frame = new JMenuEmpleados();
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
	public JMenuEmpleados() {
		setTitle("Menú de empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 219);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuAcciones = new JMenu("Acciones");
		menuBar.add(menuAcciones);
		
		JMenuItem itemAlta = new JMenuItem("Alta usuarios");
		itemAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JAltas();
			}
		});
		menuAcciones.add(itemAlta);
		
		JMenuItem itemEliminar = new JMenuItem("Eliminar");
		itemEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JBajas();
			}
		});
		menuAcciones.add(itemEliminar);
		
		JMenuItem itemModificarSalario = new JMenuItem("Modificar salario");
		itemModificarSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JModificaciones();
			}
		});
		menuAcciones.add(itemModificarSalario);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
