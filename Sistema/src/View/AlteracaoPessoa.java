package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AlteracaoPessoa {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * @wbp.nonvisual location=57,7
	 */
	private final JLabel lblAlterarCadastro = new JLabel("Alterar cadastro");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteracaoPessoa window = new AlteracaoPessoa();
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
	public AlteracaoPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 186);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo nome:");
		lblNewLabel.setBounds(10, 11, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNovoCpf = new JLabel("Novo CPF:");
		lblNovoCpf.setBounds(10, 36, 71, 14);
		frame.getContentPane().add(lblNovoCpf);
		
		JLabel lblNovoTelefone = new JLabel("Novo telefone:");
		lblNovoTelefone.setBounds(10, 61, 89, 14);
		frame.getContentPane().add(lblNovoTelefone);
		
		textField = new JTextField();
		textField.setBounds(91, 8, 215, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 33, 215, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 61, 115, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 113, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(239, 113, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(127, 113, 89, 23);
		frame.getContentPane().add(btnLimpar);
	}

}
