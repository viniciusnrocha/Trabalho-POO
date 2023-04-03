import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class CriaReserva extends JFrame {

	private JPanel contentPane;
	private JTextField textData;
	private JTextField textFieldHoraInicio;
	private JTextField textFieldHoraFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaReserva frame = new CriaReserva();
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
	public CriaReserva() {
		Professor p1 = new Professor();
		Reserva r = new Reserva();
		
		setTitle("Criar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Criar e editar reserva");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(39, 10, 321, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Predio ou Campus");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 70, 183, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Laboratorio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(13, 124, 121, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Professor");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(13, 163, 82, 21);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Data");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(13, 211, 102, 21);
		contentPane.add(lblNewLabel_4);

		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao voltar
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true); //seta como visivel a tela principal
				dispose();// remove a tela atual
			}
		});
		btnVoltarButton.setBounds(591, 364, 85, 21);
		contentPane.add(btnVoltarButton);

		JLabel lblNewLabel_5 = new JLabel("Hora de inicio");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(13, 283, 121, 24);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Hora termino");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(13, 317, 121, 21);
		contentPane.add(lblNewLabel_6);

		Campus c = new Campus();
		JComboBox comboBoxCampus = new JComboBox(c.listarCampus());
		comboBoxCampus.setBounds(156, 70, 121, 20);
		comboBoxCampus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// açao de clicar no comboBox
//				System.out.println(comboBoxCampus.getSelectedItem());// imprime o item que eu selecionei
//				String rs = (String) comboBoxCampus.getSelectedItem();// converte de objeto para string e salva em uam variavel
//				r.setCampus(rs); 
			}
		});
		contentPane.add(comboBoxCampus);

		Laboratorio l = new Laboratorio();
		JComboBox comboBoxLaboratorio = new JComboBox(l.listarLaboratorio());// lista a lista de laboratorio
		comboBoxLaboratorio.setBounds(110, 124, 167, 21);
		comboBoxLaboratorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// açao de clicar no comboBox
				System.out.print("O Laboratorio é : ");
				System.out.println(comboBoxLaboratorio.getSelectedItem());//imprime o item selecionado
				String cbl = (String) comboBoxLaboratorio.getSelectedItem();
				String[]ls = cbl.split(",");				
				r.setLaboratorio(ls[0]);
				r.setCampus(ls[1]);				
			}
		});
		contentPane.add(comboBoxLaboratorio);

		JComboBox comboBoxProfessor = new JComboBox(p1.listarProfessor());
		comboBoxProfessor.setBounds(156, 167, 121, 21);
		comboBoxProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// açao de clicar no comboBox
				String cbp = (String) comboBoxProfessor.getSelectedItem();
				r.setProfessor(cbp);
			}
		});
		contentPane.add(comboBoxProfessor);
		
		JList list = new JList(r.listarReserva());
		list.setBounds(287, 71, 389, 267);
		contentPane.add(list);

		textData = new JTextField();
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		DataEHora dt = new DataEHora();
		textData.setText(dt.DataFinal());
		textData.setBounds(156, 216, 121, 19);
		contentPane.add(textData);
		textData.getText();
		textData.setColumns(10);

		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
		DataEHora hi = new DataEHora();
		textFieldHoraInicio.setText(hi.HoraAtual());
		textFieldHoraInicio.setBounds(156, 290, 121, 19);
		contentPane.add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);

		textFieldHoraFinal = new JTextField();// como ler o testo inserido 
		DataEHora hf = new DataEHora();
		textFieldHoraFinal.setText(hf.HoraFinal());// como 
		textFieldHoraFinal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldHoraFinal.setBounds(156, 322, 121, 19);
		contentPane.add(textFieldHoraFinal);
		textFieldHoraFinal.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo para cadastrar reserva 
				String hInicial = textFieldHoraInicio.getText();
				r.setHoraInicio(hInicial);
				String hFinal = textFieldHoraFinal.getText();
				r.setHoraFinal(hFinal);
				String dData = textData.getText();
				r.setData(dData);
				r.gravarReserva(r.getData(), r.getHoraInicio(), r.getHoraFinal(), r.getLaboratorio(), r.getCampus(), r.getProfessor());
				list.setListData(r.listarReserva());// atualiza a lista				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(39, 364, 121, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// açao de deletar reserva na lista
				String d = (String) list.getSelectedValue();				
				r.deletarReserva(d);
				list.setListData(r.listarReserva());// atualiza a lista
			}
		});
		btnNewButton_2.setBounds(485, 364, 85, 21);
		contentPane.add(btnNewButton_2);
	}
}
