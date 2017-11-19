package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CadastroPessoa {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=57,7
	 */
	private final JLabel lblCadastrarPessoa = new JLabel("Cadastrar pessoa");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoa window = new CadastroPessoa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 399, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(53, 31, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(53, 56, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(53, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(53, 106, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(53, 131, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(109, 28, 218, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 53, 126, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 78, 126, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 103, 218, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 128, 126, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 171, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(284, 171, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(139, 171, 89, 23);
		frame.getContentPane().add(btnLimpar);
	}
}
