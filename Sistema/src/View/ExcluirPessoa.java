package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ExcluirPessoa {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=57,7
	 */
	private final JLabel lblExcluirCadastro = new JLabel("Excluir cadastro");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirPessoa window = new ExcluirPessoa();
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
	public ExcluirPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 309, 188);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 266, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblEscolhaAConta = new JLabel("Escolha a conta que deseja apagar:");
		lblEscolhaAConta.setBounds(53, 11, 196, 14);
		frame.getContentPane().add(lblEscolhaAConta);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(10, 99, 89, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(187, 99, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
