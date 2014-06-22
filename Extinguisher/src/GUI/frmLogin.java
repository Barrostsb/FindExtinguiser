package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Usuario;

import DAO.Session;
import DAO.UsuarioDAO;






/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmLogin extends javax.swing.JFrame {

	private javax.swing.JButton btnEnter;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private java.awt.Label lblPreencherCorretamente;
	private javax.swing.JPasswordField txtPasswd;
	private javax.swing.JTextField txtUser;


	public frmLogin() {
		super("Gerenciador de Extintores");
		initComponents();
		
		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnEnter);
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		btnEnter = new javax.swing.JButton();
		btnLimpar = new javax.swing.JButton();
		txtUser = new javax.swing.JTextField();
		txtPasswd = new javax.swing.JPasswordField();
		jLabel3 = new javax.swing.JLabel();
		lblPreencherCorretamente = new java.awt.Label();
		lblPreencherCorretamente.setVisible(false);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Usu�rio");

		jLabel2.setText("Senha");

		btnEnter.setText("Entrar");

		btnLimpar.setText("Limpar");

		jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(153, 0, 0));
		jLabel3.setText("FindEXT 07.2013");

		lblPreencherCorretamente.setForeground(new java.awt.Color(255, 0, 0));
		lblPreencherCorretamente.setText("Preencha Corretamente");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(64, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(btnLimpar)
										.addGap(81, 81, 81)
										.addComponent(btnEnter)
										.addGap(80, 80, 80))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(102, 102, 102))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1)
																.addComponent(jLabel2))
																.addGap(18, 18, 18)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																				.addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
																				.addComponent(txtPasswd))
																				.addComponent(lblPreencherCorretamente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGap(54, 54, 54))))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(32, 32, 32)
						.addComponent(jLabel3)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(25, 25, 25)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(txtPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
										.addComponent(lblPreencherCorretamente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnLimpar)
												.addComponent(btnEnter))
												.addGap(19, 19, 19))
				);

		pack();


		btnEnter.addActionListener(new btnEnterHandler());
		btnLimpar.addActionListener(new btnLimparHandler());
	}

	/**
	 * Controller btnEnterHandler respons�vel pela a��o de autentica��o
	 * @author Thiago Henrique Poiani
	 */
	private class btnEnterHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Usuario usuario = new Usuario();

			usuario.setUsuario(txtUser.getText());
			usuario.setSenha(new String(txtPasswd.getPassword()));

			try {
				UsuarioDAO business = new UsuarioDAO(usuario);
				Session.setId(business.auth());
				if (Session.getId() != 0) {
					Session.setUsuario(usuario.getUsuario());

					frmPrincipal formPrincipal= new frmPrincipal();
					formPrincipal.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorretos.", "Autentica��o", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Controller btnLimparHandler respons�vel pela a��o de autentica��o
	 * @author Thiago Henrique Poiani
	 */
	private class btnLimparHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtUser.setText("");
			txtPasswd.setText("");
		}		
	}
}
