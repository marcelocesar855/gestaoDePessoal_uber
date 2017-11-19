package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuMotorista {

	private JFrame frmMenu;

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
				
			}
		});
		btnNovoCadastro.setBounds(0, 0, 434, 23);
		frmMenu.getContentPane().add(btnNovoCadastro);
		
		JButton btnConsultarDados = new JButton("Consultar Dados");
		btnConsultarDados.setBounds(0, 238, 434, 23);
		frmMenu.getContentPane().add(btnConsultarDados);
		
		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.setBounds(0, 23, 113, 215);
		frmMenu.getContentPane().add(btnAlterarCadastro);
		
		JButton btnExcluirCadastro = new JButton("Excluir Cadastro");
		btnExcluirCadastro.setBounds(323, 23, 111, 215);
		frmMenu.getContentPane().add(btnExcluirCadastro);
		
		JButton btnCadastrar = new JButton("Cadastrar Carro");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(159, 34, 113, 23);
		frmMenu.getContentPane().add(btnCadastrar);
		
		JButton btnExcluirCarro = new JButton("Excluir Carro");
		btnExcluirCarro.setBounds(159, 68, 113, 23);
		frmMenu.getContentPane().add(btnExcluirCarro);
		
		JButton btnAlterarCor = new JButton("Alterar cor");
		btnAlterarCor.setBounds(159, 102, 113, 23);
		frmMenu.getContentPane().add(btnAlterarCor);
		
		JButton btnConsultarInformaes = new JButton("Consultar Carro");
		btnConsultarInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultarInformaes.setBounds(146, 204, 139, 23);
		frmMenu.getContentPane().add(btnConsultarInformaes);
		
		JLabel lblUber = new JLabel("UBER");
		lblUber.setBounds(198, 160, 46, 14);
		frmMenu.getContentPane().add(lblUber);
	}

}
