package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Curso;
import view.adapters.ComboCursosModel;
import view.adapters.TablaAlumnosModel;

public class JConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbAlumnos;

	public JConsulta() {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCursos = new JLabel("Cursos:");
		lblCursos.setBounds(121, 33, 54, 14);
		contentPane.add(lblCursos);
		
		JComboBox<Curso> cbCursos = new JComboBox<Curso>();
		cbCursos.setBounds(200, 29, 131, 22);
		cbCursos.setModel( new ComboCursosModel() );
		cbCursos.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Curso curso = (Curso) cbCursos.getSelectedItem();
				tbAlumnos.setModel( new TablaAlumnosModel( curso.getIdCurso() ) );
			}
		});
		contentPane.add(cbCursos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 248, -318, -176);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(63, 90, 314, 160);
		contentPane.add(scrollPane_1);
		
		tbAlumnos = new JTable();
		scrollPane_1.setViewportView(tbAlumnos);
		
		this.setVisible(true);
	}
}
