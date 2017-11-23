package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.CarroDAO;
import Controller.MotoristaDAO;
import Model.Carro;
import Model.Motorista;

public class MenuMotorista {

	private JFrame frmMenu;

	/**
	 * @return the frmMenu
	 */
	public JFrame getFrmMenu() {
		return frmMenu;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMotorista window = new MenuMotorista();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuMotorista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JButton btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MotoristaDAO.cadastrarMotorista();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNovoCadastro.setBounds(0, 0, 434, 23);
		frmMenu.getContentPane().add(btnNovoCadastro);
		
		JButton btnConsultarDados = new JButton("Consultar Dados");
		btnConsultarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroCnh = JOptionPane.showInputDialog("Numero da CNH do motorista que deseja visualizar: ");
				long numeroCnhLong = Long.parseLong(numeroCnh);
				Motorista m1 = MotoristaDAO.resgataDados(numeroCnhLong);
				JOptionPane.showMessageDialog(null,"Nome: " + m1.getNome()+ "\n"
					    + "CPF: " + m1.getCpf() + "\n"
					    + "Telefone: " + m1.getTelefone() + "\n"
					    + "Email: " + m1.getEmail() + "\n"
					    + "Numero CNH: " + m1.getNumeroCNH() + "\n"
					    + "Categoria CNH: " + m1.getCategoriaCNH() + "\n"
					    + "Classificacao: " + m1.getClassificacao());
			}
		});
		btnConsultarDados.setBounds(0, 238, 434, 23);
		frmMenu.getContentPane().add(btnConsultarDados);
		
		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MotoristaDAO.alterarMotorista();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlterarCadastro.setBounds(0, 23, 113, 215);
		frmMenu.getContentPane().add(btnAlterarCadastro);
		
		JButton btnExcluirCadastro = new JButton("Excluir Cadastro");
		btnExcluirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MotoristaDAO.excluirMotorista();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluirCadastro.setBounds(323, 23, 111, 215);
		frmMenu.getContentPane().add(btnExcluirCadastro);
		
		JButton btnCadastrar = new JButton("Cadastrar Carro");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CarroDAO.cadastrarCarro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(159, 34, 113, 23);
		frmMenu.getContentPane().add(btnCadastrar);
		
		JButton btnExcluirCarro = new JButton("Excluir Carro");
		btnExcluirCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placa = JOptionPane.showInputDialog("Placa do carro que deseja excluir");
					Carro c1 = CarroDAO.resgataDados(placa);
					CarroDAO.excluirCarro(c1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluirCarro.setBounds(159, 68, 113, 23);
		frmMenu.getContentPane().add(btnExcluirCarro);
		
		JButton btnAlterarCor = new JButton("Alterar cor");
		btnAlterarCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CarroDAO.alterarCarro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlterarCor.setBounds(159, 102, 113, 23);
		frmMenu.getContentPane().add(btnAlterarCor);
		
		JButton btnConsultarInformaes = new JButton("Consultar Carro");
		btnConsultarInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = JOptionPane.showInputDialog("Placa do carro que deseja consultar: ");
				Carro c1 = CarroDAO.resgataDados(placa);
				JOptionPane.showMessageDialog(null,"Placa: " + c1.getPlaca()+ "\n"
					    + "Cor: " + c1.getCor() + "\n"
					    + "Modelo: " + c1.getModelo() + "\n"
					    + "Marca: " + c1.getMarca());
			}
		});
		btnConsultarInformaes.setBounds(146, 204, 139, 23);
		frmMenu.getContentPane().add(btnConsultarInformaes);
		
		JLabel lblUber = new JLabel("UBER");
		lblUber.setBounds(198, 160, 46, 14);
		frmMenu.getContentPane().add(lblUber);
	}

}
