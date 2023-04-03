import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class CadastraLaboratorio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraLaboratorio frame = new CadastraLaboratorio();
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


	public CadastraLaboratorio() {
		Campus c1 = new Campus();// 
		Laboratorio l1 = new Laboratorio();

		setTitle("Cadastrar Laboratorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
//		lista dos laboratorios
		JList listLaboratorio = new JList(l1.listarLaboratorio());
		listLaboratorio.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// açao								
				String s = (String) listLaboratorio.getSelectedValue();				
				l1.setLaboratorio(s);// armazena em uma variavel dentro da classe caso queira deletar
				System.out.println(s);				
			}
		});	
		listLaboratorio.setBounds(10, 51, 163, 317);
		contentPane.add(listLaboratorio);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(491, 382, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao voltar
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true); //seta como visivel a tela laboratorio
				dispose();// remove a tela atual
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);		

		textField = new JTextField();			
		textField.setBounds(383, 73, 193, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnDeletarButton = new JButton("Deletar");
		btnDeletarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int action = JOptionPane.showConfirmDialog(null,"Você quer realmente deletar?","Deletar",JOptionPane.YES_NO_OPTION);				
				if(action==0) {				
					// açao de deletar laboratorio
					String s = (String) listLaboratorio.getSelectedValue();				
					l1.deletarLaboratorio(s);
					listLaboratorio.setListData(l1.listarLaboratorio());// atualiza a lista		
				}
			}
		});
		btnDeletarButton.setBounds(270, 191, 83, 21);
		contentPane.add(btnDeletarButton);

		JLabel lblNewLabel = new JLabel("Nome do Laboratorio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(194, 75, 169, 13);
		contentPane.add(lblNewLabel);

		//comboBox para listar os campus
		JComboBox comboBoxCampus = new JComboBox(c1.listarCampus());		
		comboBoxCampus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// açao de clicar no comboBox
				if(comboBoxCampus.getSelectedIndex() >= 0 ) {
					String texto = (String) comboBoxCampus.getSelectedItem();					
					c1.setCampus(texto);
					System.out.println(c1.getCampus());
				}else {
					System.out.println("Selecione um campus");
				}
			}
		});
		comboBoxCampus.setBounds(383, 104, 193, 21);
		contentPane.add(comboBoxCampus);

		JLabel lblNewLabel_1 = new JLabel("Campus");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(192, 104, 161, 21);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("cadastrar novo campus");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ir para tela de cadastro de novo campus
				CadastrarCampus cc = new CadastrarCampus();
				cc.setVisible(true); //seta como visivel a tela cadastrar campus
				dispose();// remove a tela atual				
			}
		});
		btnNewButton_1.setBounds(383, 135, 193, 21);
		contentPane.add(btnNewButton_1);

		//		botao para salvar o laboratorio
		JButton btnSalvarButton = new JButton("Salvar");
		btnSalvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((comboBoxCampus.getSelectedIndex() >= 0 )||(listLaboratorio.getSelectedIndex() >= 0) ) {
					//salvar laboratorio
					Laboratorio l2 = new Laboratorio();
					l2.setLaboratorio(textField.getText());// salva o nome do laboratio em uma variavel
					l2.gravarLaboratorio(l2.getLaboratorio()+ ", "+ c1.getCampus());
				}
				System.out.println(textField.getText());// imprime no console
				listLaboratorio.setListData(l1.listarLaboratorio());// atualiza a lista							
			}
		});
		btnSalvarButton.setBounds(473, 191, 83, 21);
		contentPane.add(btnSalvarButton);
	}
}
