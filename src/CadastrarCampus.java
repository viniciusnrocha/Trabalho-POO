import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

public class CadastrarCampus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCampus frame = new CadastrarCampus();
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
	public CadastrarCampus() {
		setTitle("Cadastro Campus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Campus c = new Campus();// inicia campus c
		Campus d= new Campus();
		String predioCadastro;// verificar
		
		// lista os campus
		JList listCampus = new JList(c.listarCampus());
		listCampus.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// açao								
				String s = (String) listCampus.getSelectedValue();				
				c.setCampus(s);// armazena em uma variavel dentro da classe caso queira deletar
				//System.out.println(s);
			}
		});		
		listCampus.setBounds(25, 41, 183, 316);
		contentPane.add(listCampus);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//codigo do boltao voltar
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true); //seta como visivel a tela principal
				dispose();// remove a tela atual
			}
		});
		btnNewButton.setBounds(493, 382, 83, 21);
		contentPane.add(btnNewButton);

		textField = new JTextField();
//		d.setCampus(textField.getText());
		textField.setBounds(380, 66, 183, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//açao
				d.gravarCampus(textField.getText());
				listCampus.setListData(c.listarCampus());// atualiza a lista
			}
		});
		btnNewButton_1.setBounds(493, 135, 83, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//açao
				int action = JOptionPane.showConfirmDialog(null,"Você quer realmente deletar?","Deletar",JOptionPane.YES_NO_OPTION);				
				if(action==0) {// se confirmar sim deleta
					c.deletarCampus(c.getCampus());//deleta o dado
					listCampus.setListData(c.listarCampus());// atualiza a lista					
				}			 	
			}
		});
		btnNewButton_2.setBounds(493, 166, 83, 21);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Nome do Campus");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(231, 69, 139, 16);
		contentPane.add(lblNewLabel);


		
		
	}
}
