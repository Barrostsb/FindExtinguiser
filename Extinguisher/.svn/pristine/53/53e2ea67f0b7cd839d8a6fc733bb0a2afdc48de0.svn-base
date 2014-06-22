package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import model.Usuario;

import DAO.UsuarioDAO;






/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmCadastrarUsuario extends javax.swing.JFrame {

	private javax.swing.JButton btnCadastrar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JComboBox cboxTipoUsuario;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jpDadosAcesso;
	private javax.swing.JPanel jpDadosUsuario;
	private javax.swing.JPanel jpPrincipal;
	private javax.swing.JLabel lblCPF;
	private javax.swing.JLabel lblCadUsuario;
	private javax.swing.JLabel lblUsuário;
	private javax.swing.JFormattedTextField txtCPF;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtLoginUsuario;
	private javax.swing.JTextField txtNome;
	private javax.swing.JPasswordField txtPasswdUsuario;
	private Usuario usuario;

	/**
	 * Creates new form frmUsuario
	 * @throws ParseException 
	 */
	public frmCadastrarUsuario()  {
		super("Usuário");
		initComponents();
		
		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnCadastrar);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Creates new form frmUsuario
	 * @throws ParseException 
	 */
	public frmCadastrarUsuario(Usuario usuario)  {
		super("Usuário");
		this.usuario = usuario;
		initComponents();
		
		lblCadUsuario.setText("ATUALIZAÇÃO DE USUÁRIO");
		btnCadastrar.setText("Atualizar");
		
		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnCadastrar);
		this.setLocationRelativeTo(null);
		populate();
	}


	@SuppressWarnings("unchecked")
	private void initComponents() {

		jpPrincipal = new javax.swing.JPanel();
		lblCadUsuario = new javax.swing.JLabel();
		jpDadosUsuario = new javax.swing.JPanel();
		lblCPF = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		cboxTipoUsuario = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		txtEmail = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtNome = new javax.swing.JTextField();
		txtCPF = new javax.swing.JFormattedTextField();
		jpDadosAcesso = new javax.swing.JPanel();
		lblUsuário = new javax.swing.JLabel();
		txtLoginUsuario = new javax.swing.JTextField();
		txtPasswdUsuario = new javax.swing.JPasswordField();
		jLabel4 = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JButton();
		btnLimpar = new javax.swing.JButton();
		btnCadastrar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblCadUsuario.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblCadUsuario.setText("CADASTRO DE USUÁRIO");

		javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
		jpPrincipal.setLayout(jpPrincipalLayout);
		jpPrincipalLayout.setHorizontalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup()
						.addGap(129, 129, 129)
						.addComponent(lblCadUsuario)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jpPrincipalLayout.setVerticalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCadUsuario)
						.addContainerGap(16, Short.MAX_VALUE))
				);

		jpDadosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do usuário"));

		lblCPF.setText("CPF");

		jLabel2.setText("Tipo de usuário");

		cboxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auxiliar", "Encarregado" }));

		jLabel1.setText("E-Mail");

		jLabel3.setText("Nome");

		javax.swing.GroupLayout jpDadosUsuarioLayout = new javax.swing.GroupLayout(jpDadosUsuario);
		jpDadosUsuario.setLayout(jpDadosUsuarioLayout);
		jpDadosUsuarioLayout.setHorizontalGroup(
				jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosUsuarioLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3)
								.addComponent(lblCPF))
								.addGap(18, 18, 18)
								.addGroup(jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
										.addComponent(txtCPF))
										.addGap(52, 52, 52)
										.addGroup(jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel2)
												.addComponent(jLabel1))
												.addGap(18, 18, 18)
												.addGroup(jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(txtEmail)
														.addComponent(cboxTipoUsuario, 0, 137, Short.MAX_VALUE))
														.addContainerGap(20, Short.MAX_VALUE))
				);
		jpDadosUsuarioLayout.setVerticalGroup(
				jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosUsuarioLayout.createSequentialGroup()
						.addGap(23, 23, 23)
						.addGroup(jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cboxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
								.addGap(27, 27, 27)
								.addGroup(jpDadosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblCPF)
										.addComponent(jLabel1)
										.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(26, Short.MAX_VALUE))
				);

		jpDadosAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Acesso"));

		lblUsuário.setText("Usuário");

		jLabel4.setText("Senha");

		javax.swing.GroupLayout jpDadosAcessoLayout = new javax.swing.GroupLayout(jpDadosAcesso);
		jpDadosAcesso.setLayout(jpDadosAcessoLayout);
		jpDadosAcessoLayout.setHorizontalGroup(
				jpDadosAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosAcessoLayout.createSequentialGroup()
						.addGap(43, 43, 43)
						.addComponent(lblUsuário)
						.addGap(18, 18, 18)
						.addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(61, 61, 61)
						.addComponent(jLabel4)
						.addGap(18, 18, 18)
						.addComponent(txtPasswdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jpDadosAcessoLayout.setVerticalGroup(
				jpDadosAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosAcessoLayout.createSequentialGroup()
						.addGap(32, 32, 32)
						.addGroup(jpDadosAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblUsuário)
								.addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPasswdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
								.addGap(0, 23, Short.MAX_VALUE))
				);

		btnCancelar.setText("Cancelar");

		btnLimpar.setText("Limpar");

		btnCadastrar.setText("Cadastrar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jpDadosAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jpDadosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGap(0, 2, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(btnCancelar)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnLimpar)
														.addGap(48, 48, 48)
														.addComponent(btnCadastrar)))
														.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpDadosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jpDadosAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnLimpar)
								.addComponent(btnCadastrar))
								.addContainerGap(20, Short.MAX_VALUE))
				);

		pack();

		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("###.###.###-##");
			maskData.install(txtCPF);
		} catch (ParseException e) {}

		btnCadastrar.addActionListener(new btnCadastrarHandler());
		btnLimpar.addActionListener(new btnLimparHandler());
		btnCancelar.addActionListener(new btnCancelarHandler());
	}
	
	/**
	 * Método para limpar campos de cadastro
	 */
	private void clear(){
		txtNome.setText("");
		txtCPF.setText("");
		cboxTipoUsuario.setSelectedIndex(0);
		txtEmail.setText("");
		txtLoginUsuario.setText("");
		txtPasswdUsuario.setText("");
	}

	/**
	 * Método para popular campos já preenchidos
	 */
	private void populate() {
		txtCPF.setText(usuario.getCpf());
		txtNome.setText(usuario.getNome());
		cboxTipoUsuario.setSelectedItem((usuario.getTipo() == 'a') ? "Auxiliar" : "Encarregado");
		txtEmail.setText(usuario.getEmail());
		txtLoginUsuario.setText(usuario.getUsuario());
		txtPasswdUsuario.setText(usuario.getSenha());
	}

	/**
	 * Controller btnCadastrarHandler responsável 
	 * pela ação de cadastrar usuário
	 */
	private class btnCadastrarHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Usuario pessoa = new Usuario();

			// atribui valores
			request(pessoa);

			try {
				// se existir usuário (caso de atualização)
				if (usuario != null) {
					// atribuir valores
					pessoa = merge(usuario, pessoa);
				}

				// valida valores
				pessoa.validate();

				// TODO - Senha

				// Data Access Object - salva usuário
				UsuarioDAO business = new UsuarioDAO(pessoa);
				business.save();

				if (usuario != null) {
					JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
					new frmGerenciarUsuario().setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
					clear();        			
				}

			} catch (SQLException e) {
				// erro de banco de dados
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				// mensagens de validação
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}

		/**
		 * Método para atribuir os valores das requisições ao Usuario  
		 * @param pessoa
		 */
		private void request(Usuario pessoa) {
			pessoa.setNome(txtNome.getText());
			pessoa.setCpf(txtCPF.getText());
			Character tipo = (cboxTipoUsuario.getSelectedItem() == "Auxiliar") ? 'a' : 'e';
			pessoa.setTipo(tipo);
			pessoa.setEmail(txtEmail.getText());
			pessoa.setUsuario(txtLoginUsuario.getText());
			pessoa.setSenha(new String(txtPasswdUsuario.getPassword()));
		}

		/**
		 * Método para atribuir valores selecionados ao usuário antigo
		 * @param antigo
		 * @param novo
		 * @return antigo
		 */
		private Usuario merge(Usuario antigo, Usuario novo) {
			antigo.setCpf(novo.getCpf());
			antigo.setNome(novo.getNome());
			antigo.setTipo(novo.getTipo());
			antigo.setEmail(novo.getEmail());
			antigo.setUsuario(novo.getUsuario());
			antigo.setSenha(novo.getSenha());

			return antigo;
		}
	}

	/**
	 * Controller btnLimparHandler responsável pela 
	 * ação de limpar os campos de cadastro de usuário
	 */
	private class btnLimparHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// se existir usuário (caso de atualização)
			if (usuario != null) {
				// limpa os dados escritos por cima dos originais
				populate();
			} else {
				// limpa os campos
				clear();
			}
		}

	}

	/**
	 * Controller btnCancelarHandler responsável 
	 * por fechar a tela de cadastro de usuário 
	 * e retornar ao Form Principal
	 */
	private class btnCancelarHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new frmPrincipal().setVisible(true);
			dispose();
		}

	}

}