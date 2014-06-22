package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmPrincipal extends javax.swing.JFrame {

	private javax.swing.JButton btnCadastrarExtintor;
	private javax.swing.JButton btnCadastrarManutInsp;
	private javax.swing.JButton btnCadastrarPessoa;
	private javax.swing.JButton btnExit;
	private javax.swing.JButton btnGerenciar;
	private javax.swing.JButton btnGerenciarExtintor;
	private javax.swing.JButton btnGerenciarPessoa;
	private javax.swing.JButton btnLogout;
	private javax.swing.JButton btnRelatorio;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jpExtintor;
	private javax.swing.JPanel jpPessoa;
	private javax.swing.JPanel jpRelatorio;
	private javax.swing.JMenuBar mbBarra;
	private javax.swing.JMenu menuCadastrar;
	private javax.swing.JMenu menuGerenciar;
	private javax.swing.JMenu menuRelatorio;
	private javax.swing.JMenuItem smCadastrarManutInsp;
	private javax.swing.JMenuItem smCadastrarPessoas;
	private javax.swing.JMenuItem smCadatrarExtintor;
	private javax.swing.JMenuItem smGerenciarExtintor;
	private javax.swing.JMenuItem smGerenciarManutInsp;
	private javax.swing.JMenuItem smGerenciarPessoa;
	private javax.swing.JMenuItem smRelatorioEmitir;

	/**
	 * Creates new form frmPrincipal
	 */
	public frmPrincipal() {
		super("Gerenciador de Extintores");
		initComponents();

		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}


	private void initComponents() {
		jFrame1 = new javax.swing.JFrame();
		jpPessoa = new javax.swing.JPanel();
		btnCadastrarPessoa = new javax.swing.JButton();
		btnGerenciarPessoa = new javax.swing.JButton();
		jpExtintor = new javax.swing.JPanel();
		btnCadastrarExtintor = new javax.swing.JButton();
		btnGerenciarExtintor = new javax.swing.JButton();
		jpRelatorio = new javax.swing.JPanel();
		btnRelatorio = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		btnCadastrarManutInsp = new javax.swing.JButton();
		btnGerenciar = new javax.swing.JButton();
		btnLogout = new javax.swing.JButton();
		btnExit = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		mbBarra = new javax.swing.JMenuBar();
		menuCadastrar = new javax.swing.JMenu();
		smCadastrarPessoas = new javax.swing.JMenuItem();
		smCadatrarExtintor = new javax.swing.JMenuItem();
		smCadastrarManutInsp = new javax.swing.JMenuItem();
		menuGerenciar = new javax.swing.JMenu();
		smGerenciarPessoa = new javax.swing.JMenuItem();
		smGerenciarExtintor = new javax.swing.JMenuItem();
		smGerenciarManutInsp = new javax.swing.JMenuItem();
		menuRelatorio = new javax.swing.JMenu();
		smRelatorioEmitir = new javax.swing.JMenuItem();

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(
				jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				);
		jFrame1Layout.setVerticalGroup(
				jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
				);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jpPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa"));

		btnCadastrarPessoa.setText("Cadastrar");

		btnGerenciarPessoa.setText("Gerenciar");

		javax.swing.GroupLayout jpPessoaLayout = new javax.swing.GroupLayout(jpPessoa);
		jpPessoa.setLayout(jpPessoaLayout);
		jpPessoaLayout.setHorizontalGroup(
				jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPessoaLayout.createSequentialGroup()
						.addGap(79, 79, 79)
						.addComponent(btnCadastrarPessoa)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGerenciarPessoa)
						.addGap(94, 94, 94))
				);
		jpPessoaLayout.setVerticalGroup(
				jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPessoaLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCadastrarPessoa)
								.addComponent(btnGerenciarPessoa))
								.addGap(20, 20, 20))
				);

		jpExtintor.setBorder(javax.swing.BorderFactory.createTitledBorder("Extintor"));

		btnCadastrarExtintor.setText("Cadastrar");

		btnGerenciarExtintor.setText("Gerenciar");

		javax.swing.GroupLayout jpExtintorLayout = new javax.swing.GroupLayout(jpExtintor);
		jpExtintor.setLayout(jpExtintorLayout);
		jpExtintorLayout.setHorizontalGroup(
				jpExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpExtintorLayout.createSequentialGroup()
						.addGap(78, 78, 78)
						.addComponent(btnCadastrarExtintor)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGerenciarExtintor)
						.addGap(94, 94, 94))
				);
		jpExtintorLayout.setVerticalGroup(
				jpExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpExtintorLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCadastrarExtintor)
								.addComponent(btnGerenciarExtintor))
								.addGap(0, 11, Short.MAX_VALUE))
				);

		jpRelatorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Relat�rio"));

		btnRelatorio.setText("Emitir Relat�rio");

		javax.swing.GroupLayout jpRelatorioLayout = new javax.swing.GroupLayout(jpRelatorio);
		jpRelatorio.setLayout(jpRelatorioLayout);
		jpRelatorioLayout.setHorizontalGroup(
				jpRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpRelatorioLayout.createSequentialGroup()
						.addGap(165, 165, 165)
						.addComponent(btnRelatorio)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jpRelatorioLayout.setVerticalGroup(
				jpRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpRelatorioLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnRelatorio)
						.addContainerGap(13, Short.MAX_VALUE))
				);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Manuten��o/Inspe��o"));

		btnCadastrarManutInsp.setText("Cadastrar");

		btnGerenciar.setText("Gerenciar");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(77, 77, 77)
						.addComponent(btnCadastrarManutInsp)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
						.addComponent(btnGerenciar)
						.addGap(95, 95, 95))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCadastrarManutInsp)
								.addComponent(btnGerenciar))
								.addGap(36, 36, 36))
				);

		btnLogout.setText("Logout");

		btnExit.setText("Sair");

		jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(153, 0, 0));
		jLabel1.setText("FindEXT 07.2013");

		menuCadastrar.setText("Cadastrar");

		smCadastrarPessoas.setText("Pessoa");
		menuCadastrar.add(smCadastrarPessoas);

		smCadatrarExtintor.setText("Extintor");
		menuCadastrar.add(smCadatrarExtintor);

		smCadastrarManutInsp.setText("Manuten��es/Inspe��es");
		menuCadastrar.add(smCadastrarManutInsp);

		mbBarra.add(menuCadastrar);

		menuGerenciar.setText("Gerenciar");

		smGerenciarPessoa.setText("Pessoa");		
		menuGerenciar.add(smGerenciarPessoa);

		smGerenciarExtintor.setText("Extintor");
		menuGerenciar.add(smGerenciarExtintor);

		smGerenciarManutInsp.setText("Manuten��es/Inspe��es");
		menuGerenciar.add(smGerenciarManutInsp);

		mbBarra.add(menuGerenciar);

		menuRelatorio.setText("Relat�rio");

		smRelatorioEmitir.setText("Emitir Relat�rio");
		menuRelatorio.add(smRelatorioEmitir);

		mbBarra.add(menuRelatorio);

		setJMenuBar(mbBarra);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(layout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnLogout)
												.addGap(18, 18, 18)
												.addComponent(btnExit))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addGap(31, 31, 31)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jpExtintor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jpPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jpRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																.addGroup(layout.createSequentialGroup()
																		.addGap(176, 176, 176)
																		.addComponent(jLabel1)))
																		.addContainerGap(29, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(23, 23, 23)
						.addComponent(jLabel1)
						.addGap(36, 36, 36)
						.addComponent(jpPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jpExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jpRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnLogout)
								.addComponent(btnExit))
								.addContainerGap(34, Short.MAX_VALUE))
				);

		pack();

		/**
		 * Inicio do trecho desenvolvido no Eclipse
		 */
		//Cadastrar extintor
		btnCadastrarExtintor.addActionListener(new CadastrarExtHandler());
		smCadatrarExtintor.addActionListener(new CadastrarExtHandler());

		//Gerenciar extintor
		btnGerenciarExtintor.addActionListener(new GerenciarExtintorHandler());
		smGerenciarExtintor.addActionListener(new GerenciarExtintorHandler());

		//Cadastrar pessoa
		btnCadastrarPessoa.addActionListener(new CadastrarUserHandler());
		smCadastrarPessoas.addActionListener(new CadastrarUserHandler());

		//Gerenciar pessoa
		btnGerenciarPessoa.addActionListener(new GerenciarPessoaHandler());
		smGerenciarPessoa.addActionListener(new GerenciarPessoaHandler());

		//Cadastrar manuten��es e inspe��es
		btnCadastrarManutInsp.addActionListener(new CadastrarManutInsp());
		smCadastrarManutInsp.addActionListener(new CadastrarManutInsp());

		//Gerenciar manuten��es e inspe��es
		btnGerenciar.addActionListener(new GerenciarManutInspHandler());
		smGerenciarManutInsp.addActionListener(new GerenciarManutInspHandler());

		//Relatorio
		btnRelatorio.addActionListener(new EmitirRelatorioHandler());
		smRelatorioEmitir.addActionListener(new EmitirRelatorioHandler());

		//Bot�es
		btnLogout.addActionListener(new Logout());
		btnExit.addActionListener(new ExitFindExt());
	}

	/**
	 * Controller
	 */
	private class CadastrarExtHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new frmCadastrarExtintor().setVisible(true);
			dispose();
		}
	}

	/**
	 * Controller
	 */
	private class GerenciarExtintorHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new frmGerenciarExtintor().setVisible(true);			
			dispose();
		}

	}

	/**
	 * Controller
	 */
	private class CadastrarUserHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new frmCadastrarUsuario().setVisible(true);												
			dispose();
		}	 	
	} 

	/**
	 * Controller
	 */
	private class GerenciarPessoaHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new frmGerenciarUsuario().setVisible(true);			
			dispose();
		}

	}

	/**
	 * Controller
	 */
	private class CadastrarManutInsp implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new frmCadastrarManutInsp().setVisible(true);	
			dispose();
		}
	}

	/**
	 * Controller
	 */
	private class GerenciarManutInspHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new frmGerenciarManutInsp().setVisible(true);
			dispose();
		}

	}

	/**
	 * Controller
	 */
	private class EmitirRelatorioHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new frmRelatorio().setVisible(true);
			dispose();
		}	
	}

	/**
	 * Controller
	 */
	private class ExitFindExt implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja realmente sair?", 
					"Sair", 
					JOptionPane.YES_NO_OPTION); 
			if (opcao == JOptionPane.YES_OPTION) {
				System.exit(0);	
			}
			return;					
		}
	}

	/**
	 * Controller
	 */
	private class Logout implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja realmente trocar de usu�rio?", 
					"Logout", 
					JOptionPane.YES_NO_OPTION); 
			if (opcao == JOptionPane.YES_OPTION) {
				new frmLogin().setVisible(true);
				dispose();
			} else {
				return;
			}
		}

	}
}