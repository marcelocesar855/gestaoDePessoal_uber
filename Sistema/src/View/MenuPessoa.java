package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.PessoaDAO;
import Model.Pessoa;

public class MenuPessoa {

	private JFrame frmDas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPessoa window = new MenuPessoa();
					window.frmDas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPessoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDas = new JFrame();
		frmDas.setTitle("Menu");
		frmDas.setBounds(100, 100, 456, 196);
		frmDas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Criar nova conta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frmDas.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnAlterarCadastro = new JButton("Alterar cadastro");
		btnAlterarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Novo nome: ");
				String cpf = JOptionPane.showInputDialog("Novo CPF: ");
				long cpfLong = Long.parseLong(cpf);
				String telefone = JOptionPane.showInputDialog("Novo telefone: ");
				long telefoneLong = Long.parseLong(telefone);
				Pessoa p1 = new Pessoa (cpfLong, nome, null, null, telefoneLong);
				try {
					PessoaDAO.alterarPessoa(p1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		frmDas.getContentPane().add(btnAlterarCadastro, BorderLayout.WEST);
		
		JButton btnExcluirCadastro = new JButton("Excluir cadastro");
		btnExcluirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String email = JOptionPane.showInputDialog("Email do cadastro que deseja excluir: ");
			Pessoa p1 = new Pessoa();
			p1 = PessoaDAO.resgataDados(email);
			try {
				PessoaDAO.excluirPessoa(p1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		frmDas.getContentPane().add(btnExcluirCadastro, BorderLayout.EAST);
		
		JButton btnConsultarDados = new JButton("Consultar dados");
		btnConsultarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = JOptionPane.showInputDialog("Email do cadastro que deseja consultar: ");
				Pessoa p1 = new Pessoa();
				p1 = PessoaDAO.resgataDados(email);
				PessoaDAO.lePessoa(p1.getIdPessoa());
				 JOptionPane.showMessageDialog(null,"Nome: " + p1.getNome()+ "\n"
				    + "CPF: " + p1.getCpf() + "\n"
				    + "Telefone: " + p1.getTelefone() + "\n"
				    + "Email: " + p1.getEmail());
			}
		});
		frmDas.getContentPane().add(btnConsultarDados, BorderLayout.SOUTH);
		
		JButton btnSolicitarCorrida = new JButton("Solicitar Corrida");
		btnSolicitarCorrida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui seria chamado o metodo para criacao de um objeto do tipo corrida
			}
		});
		frmDas.getContentPane().add(btnSolicitarCorrida, BorderLayout.CENTER);
	}

}
