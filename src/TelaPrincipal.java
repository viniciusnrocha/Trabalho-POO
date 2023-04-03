import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Reserva de Laboratorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("RESERVA");
		btnNewButton.setBounds(457, 363, 107, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao para ir par a tela de criar reserva
				CriaReserva cr = new CriaReserva();
				cr.setVisible(true); //seta como visivel a tela laboratorio
				dispose();// remove a tela atual
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("C\n LABORATORIO");
		btnNewButton_1.setBounds(10, 363, 150, 40);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao voltar
				CadastraLaboratorio cl = new CadastraLaboratorio();
				cl.setVisible(true); //seta como visivel a tela laboratorio
				dispose();// remove a tela atual
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C PROFESSOR");
		btnNewButton_2.setBounds(168, 363, 136, 40);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao voltar
				CadastraProfessor cp = new CadastraProfessor();
				cp.setVisible(true); //seta como visivel a tela professor
				dispose();// remove a tela atual
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("C CAMPUS");
		btnNewButton_4.setBounds(319, 363, 128, 40);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir para tela de cadastro de novo campus
				CadastrarCampus cc = new CadastrarCampus();
				cc.setVisible(true); //seta como visivel a tela cadastrar campus
				dispose();// remove a tela atual	
			}
		});
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(109, 10, 382, 289);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vinic\\Pictures\\img\\logo.png"));
		contentPane.add(lblNewLabel_1);
	}
}
