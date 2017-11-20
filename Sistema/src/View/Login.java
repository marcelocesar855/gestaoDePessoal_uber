package View;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.MotoristaDAO;
import Controller.MotoristaRN;
import Controller.PessoaDAO;
import Controller.PessoaRN;
import Model.Motorista;
import Model.Pessoa;


public class Login {

	private JFrame frmLogin;
	private JTextField textEmail;
	
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	@SuppressWarnings({ "unlikely-arg-type", "deprecation" })
	public void validaLogin() {
		int c = 0;
		int sinal;
		Pessoa p1 = new Pessoa();
		Motorista m1 = new Motorista();
		List<Motorista> motoristas = null;
		List<Pessoa> pessoas = null;
		pessoas = PessoaRN.lePessoas();
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getEmail().equals(textEmail.getText()) && pessoas.get(i).getSenha().equals(passwordSenha.getText())) {
				JOptionPane.showMessageDialog(null, "Acesso permitido.");
				c = 1;
				p1 = pessoas.get(i);
				break;
			}
		}
		if (c > 0) {
				motoristas = MotoristaRN.leMotoristas();
				for (int i = 0; i < motoristas.size(); i++) {
					if (motoristas.get(i).getIdPessoa() == (p1.getIdPessoa())) {
//						executa interface de menu motorista
						new MenuMotorista().setVisible(true);
						break;
					}
				}
//				executa interface de menu pessoa
				ew MenuPessoa().setVisible(true);
			}
		
		else {
			JOptionPane.showMessageDialog(null, "Informacoes invalidas!");
		}
}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 457, 180);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setBounds(72, 27, 46, 14);
		frmLogin.getContentPane().add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(72, 52, 46, 14);
		frmLogin.getContentPane().add(lblSenha);
		
		textEmail = new JTextField();
		textEmail.setBounds(128, 24, 204, 20);
		frmLogin.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCancel = new JButton("Sair");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(342, 107, 89, 23);
		frmLogin.getContentPane().add(btnCancel);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					validaLogin();
					
			}
		});
		btnEnviar.setBounds(10, 107, 89, 23);
		frmLogin.getContentPane().add(btnEnviar);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setToolTipText("");
		passwordSenha.setBounds(128, 52, 126, 20);
		frmLogin.getContentPane().add(passwordSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Object[] opcoes = {"Passageiro","Motorista"};
					Object resposta;
					resposta = JOptionPane.showInputDialog(null,"Quem e voce?","Identificacao",
					JOptionPane.PLAIN_MESSAGE,null,opcoes,null);
					if (resposta == "Passageiro") {
						JOptionPane.showMessageDialog(null, "Ola passageiro!\n"
						+ "Vamos cadastra-lo ao sistema para com que voce possa solicitar seu motorista!");
						String nome = JOptionPane.showInputDialog("Qual seu nome?");
						String cpf = JOptionPane.showInputDialog("Qual seu CPF?");
						int cpfInt = Integer.parseInt(cpf);
						String telefone = JOptionPane.showInputDialog("Qual seu numero para contato?");
						int telefoneInt = Integer.parseInt(telefone);
						String email = JOptionPane.showInputDialog("Qual seu email?");
						String senha = JOptionPane.showInputDialog("Defina uma senha");
						Pessoa p1 = new Pessoa(cpfInt, nome, email, senha, telefoneInt);
						try {
							PessoaDAO.cadastrarPessoa(p1);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					if (resposta == "Motorista") {
						JOptionPane.showMessageDialog(null, "Ola motorista!\n"
						+ "Vamos cadastra-lo ao sistema para com que voce possa realizar suas corridas!");
						String nome = JOptionPane.showInputDialog("Qual seu nome?");
						String cpf = JOptionPane.showInputDialog("Qual seu CPF?");
						int cpfInt = Integer.parseInt(cpf);
						String telefone = JOptionPane.showInputDialog("Qual seu numero para contato?");
						int telefoneInt = Integer.parseInt(telefone);
						String email = JOptionPane.showInputDialog("Qual seu email?");
						String senha = JOptionPane.showInputDialog("Defina uma senha");
						String cnh = JOptionPane.showInputDialog("Qual a categoria da sua CNH?");
						String numeroCnh = JOptionPane.showInputDialog("Qual o numero de sua CNH?");
						int cnhInt = Integer.parseInt(numeroCnh);
						Motorista m1 = new Motorista(cpfInt, nome, email, senha, telefoneInt, cnh, cnhInt);
						try {
							MotoristaDAO.cadastrarMotorista();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		btnCadastrar.setBounds(208, 107, 124, 23);
		frmLogin.getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
				textEmail.setText(null);
				passwordSenha.setText(null);
			}
		});
		btnLimpar.setBounds(109, 107, 89, 23);
		frmLogin.getContentPane().add(btnLimpar);
	}
}
