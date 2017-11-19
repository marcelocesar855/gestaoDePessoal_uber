package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class ConsultarPessoa {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=57,7
	 */
	private final JLabel lblDadosPessoais = new JLabel("Dados Pessoais");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarPessoa window = new ConsultarPessoa();
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
	public ConsultarPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 341, 191);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblTelefone);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(66, 11, 253, 20);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnTeste = new JTextPane();
		txtpnTeste.setBounds(66, 36, 157, 20);
		frame.getContentPane().add(txtpnTeste);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(66, 61, 233, 20);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(66, 86, 135, 20);
		frame.getContentPane().add(textPane_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(226, 122, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
