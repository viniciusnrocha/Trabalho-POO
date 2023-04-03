import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastraProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNovoProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraProfessor frame = new CadastraProfessor();
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
	public CadastraProfessor() {
		Professor p1 = new Professor();

		setTitle("Cadastrar Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao voltar
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true); //seta como visivel a tela laboratorio
				dispose();// remove a tela atual
			}
		});
		btnNewButton.setBounds(491, 382, 85, 21);
		contentPane.add(btnNewButton);

		//		list do professor 	
		JList list = new JList(p1.listarProfessor());
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// açao								
				String s = (String) list.getSelectedValue();				
				p1.setProfessor(s);// armazena em uma variavel dentro da classe caso queira deletar
				//System.out.println(s);
			}
		});	
		list.setBounds(34, 40, 175, 294);
		contentPane.add(list);

		JLabel lblNewLabel = new JLabel("Novo Professor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(219, 59, 123, 13);
		contentPane.add(lblNewLabel);

		textFieldNovoProfessor = new JTextField();
		textFieldNovoProfessor.setBounds(352, 58, 190, 19);
		contentPane.add(textFieldNovoProfessor);
		textFieldNovoProfessor.setColumns(10);

		JButton btnCadastrarButton = new JButton("Cadastrar");
		btnCadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//açao
				p1.gravarProfessor(textFieldNovoProfessor.getText());//grava o que foi escrito				
				list.setListData(p1.listarProfessor());// atualiza a lista
			}
		});
		btnCadastrarButton.setBounds(34, 382, 83, 21);
		contentPane.add(btnCadastrarButton);

		JButton btnRemoverButton = new JButton("Remover");
		btnRemoverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Você quer realmente deletar?","Deletar",JOptionPane.YES_NO_OPTION);				
				if(action==0) {// se confirmar sim deleta
					String s = (String) list.getSelectedValue();
					p1.deletarProfessor(s);//deleta o dado
					list.setListData(p1.listarProfessor());// atualiza a lista					
				}
			}
		});
		btnRemoverButton.setBounds(219, 382, 83, 21);
		contentPane.add(btnRemoverButton);


	}
}
