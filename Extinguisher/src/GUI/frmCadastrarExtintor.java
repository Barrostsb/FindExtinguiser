package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import model.Extintor;
import model.Manutencao;
import model.Usuario;

import DAO.ExtintorDAO;
import DAO.ManutencaoDAO;
import DAO.Session;
import DAO.UsuarioDAO;






/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmCadastrarExtintor extends javax.swing.JFrame {

	private javax.swing.JButton btnCadastrar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JComboBox cboxCapacidadeExtintor;
	private javax.swing.JComboBox cboxTipoExtintor;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jpDadosExtintor;
	private javax.swing.JLabel lblCadExtintor;
	private javax.swing.JLabel lblCapacidade;
	private javax.swing.JLabel lblCodigo;
	private javax.swing.JLabel lblTipo;
	private javax.swing.JTextField txtCodigo;
	private JFormattedTextField txtDataManut;
	private javax.swing.JTextField txtLocal;
	private Extintor extintor;

	/**
	 * Creates new form frmCadastrarExtintor
	 */
	public frmCadastrarExtintor() {
		super("Extintor");
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
	public frmCadastrarExtintor(Extintor extintor)  {
		super("Extintor");
		this.extintor = extintor;
		initComponents();
		
		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnCadastrar);
		this.setLocationRelativeTo(null);

		lblCadExtintor.setText("ATUALIZA��O DE EXTINTORES");
		btnCadastrar.setText("Atualizar");

		txtLocal.setFocusable(false);
		txtLocal.setEditable(false);
		txtLocal.setBackground(new Color(235, 235, 228));
		txtDataManut.setFocusable(false);
		txtDataManut.setEditable(false);
		txtDataManut.setBackground(new Color(235, 235, 228));

		populate();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		jpDadosExtintor = new javax.swing.JPanel();
		lblCodigo = new javax.swing.JLabel();
		lblTipo = new javax.swing.JLabel();
		lblCapacidade = new javax.swing.JLabel();
		cboxTipoExtintor = new javax.swing.JComboBox();
		txtCodigo = new javax.swing.JTextField();
		cboxCapacidadeExtintor = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtDataManut = new javax.swing.JFormattedTextField();
		txtLocal = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		lblCadExtintor = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JButton();
		btnCadastrar = new javax.swing.JButton();
		btnLimpar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jpDadosExtintor.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Extintor"));

		lblCodigo.setText("C�digo");

		lblTipo.setText("Tipo");

		lblCapacidade.setText("Capacidade");

		cboxTipoExtintor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "�gua", "CO2", "P� Qu�mico", "Espuma Mec�nica" }));

		cboxCapacidadeExtintor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 kg", "2 kg", "4 kg", "6 kg","10 kg","12 kg","20 kg","50 kg","9 L","10 L","50 L" }));

		jLabel1.setText("Local");

		jLabel2.setText("�ltima Manuten��o");

		javax.swing.GroupLayout jpDadosExtintorLayout = new javax.swing.GroupLayout(jpDadosExtintor);
		jpDadosExtintor.setLayout(jpDadosExtintorLayout);
		jpDadosExtintorLayout.setHorizontalGroup(
				jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosExtintorLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jpDadosExtintorLayout.createSequentialGroup()
										.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblTipo)
												.addComponent(lblCodigo))
												.addGap(34, 34, 34)
												.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jpDadosExtintorLayout.createSequentialGroup()
																.addComponent(cboxTipoExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(119, 119, 119)
																.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel2)
																		.addComponent(jLabel1)))
																		.addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGroup(jpDadosExtintorLayout.createSequentialGroup()
																				.addComponent(lblCapacidade)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(cboxCapacidadeExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
																				.addGap(22, 22, 22)
																				.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(txtDataManut)
																						.addComponent(txtLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
																						.addContainerGap(36, Short.MAX_VALUE))
				);
		jpDadosExtintorLayout.setVerticalGroup(
				jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosExtintorLayout.createSequentialGroup()
						.addGap(17, 17, 17)
						.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblCodigo)
								.addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jpDadosExtintorLayout.createSequentialGroup()
												.addGap(18, 18, 18)
												.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lblTipo)
														.addComponent(cboxTipoExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(25, 25, 25)
														.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lblCapacidade)
																.addComponent(cboxCapacidadeExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGroup(jpDadosExtintorLayout.createSequentialGroup()
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel1)
																				.addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGap(18, 18, 18)
																				.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabel2)
																						.addComponent(txtDataManut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
																						.addContainerGap(26, Short.MAX_VALUE))
				);

		lblCadExtintor.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblCadExtintor.setText("CADASTRO DE EXTINTOR");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCadExtintor)
						.addGap(137, 137, 137))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(16, Short.MAX_VALUE)
						.addComponent(lblCadExtintor)
						.addContainerGap())
				);

		btnCancelar.setText("Cancelar");

		btnCadastrar.setText("Cadastrar");

		btnLimpar.setText("Limpar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnCancelar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnLimpar)
										.addGap(18, 18, 18)
										.addComponent(btnCadastrar))
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jpDadosExtintor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jpDadosExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnLimpar)
								.addComponent(btnCadastrar))
								.addGap(19, 19, 19))
				);

		pack();

		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("####-##-##");
			maskData.install(txtDataManut);
		} catch (ParseException e) {}

		//adicionando ouvintes aos botoes
		btnCadastrar.addActionListener(new btnCadastrarHandler());
		btnLimpar.addActionListener(new btnLimparHandler());
		btnCancelar.addActionListener(new btnCancelarHandler());
	}

	/**
	 * M�todo para limpar campos de cadastro
	 */
	private void clear(){
		txtCodigo.setText("");
		cboxTipoExtintor.setSelectedIndex(0);
		cboxCapacidadeExtintor.setSelectedIndex(0);
		txtLocal.setText("");
		txtDataManut.setText("");
	}

	/**
	 * M�todo para popular campos j� preenchidos
	 */
	private void populate() {
		txtCodigo.setText(extintor.getCodigo());

		switch (extintor.getTipo()) {
		case 'a' : cboxTipoExtintor.setSelectedItem("�gua"); break;
		case 'c' : cboxTipoExtintor.setSelectedItem("CO2"); break;
		case 'e' : cboxTipoExtintor.setSelectedItem("Espuma Mec�nica"); break;
		case 'p' : cboxTipoExtintor.setSelectedItem("P� Qu�mico"); break;
		}

		cboxCapacidadeExtintor.setSelectedItem(extintor.getCapacidade());

		ManutencaoDAO business;
		try {
			business = new ManutencaoDAO(new Manutencao());
			Manutencao manutencao = (Manutencao) business.find("Manutencao", extintor.getId_manutencao());

			txtDataManut.setText(manutencao.getData());
			txtLocal.setText(manutencao.getLocal());
		} catch (SQLException e) {
			txtDataManut.setText("");
			txtLocal.setText("");
		}
	}

	/**
	 * Controller btnCadastrarHandler respons�vel 
	 * pela a��o de cadastrar extintor
	 */
	private class btnCadastrarHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Extintor ext = new Extintor();
			Manutencao manutencao = new Manutencao();

			try {
				// atribui valores
				request(ext, manutencao);

				// se existir extintor (caso de atualiza��o)
				if (extintor != null) {
					// atribuir valores
					ext = merge(extintor, ext);
				}

				// valida valores
				ext.validate();
				manutencao.validate();

				// Data Access Object - salva extintor
				ExtintorDAO businessExtintor = new ExtintorDAO(ext);

				//businessExtintor.beginTransaction();

				if (ext.getId() == 0) {
					int idExtintor = businessExtintor.create(ext);

					manutencao.setId_extintor(idExtintor);
					ManutencaoDAO businessManutencao = new ManutencaoDAO(manutencao);
					int idManutencao = businessManutencao.create(manutencao);

					ext.setId(idExtintor);
					ext.setId_manutencao(idManutencao);
					businessExtintor.update(ext);

					JOptionPane.showMessageDialog(null, "Extintor salvo com sucesso!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
					clear();
				} else {
					businessExtintor.update(ext);

					JOptionPane.showMessageDialog(null, "Extintor atualizado com sucesso!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
					new frmGerenciarExtintor().setVisible(true);
					dispose();
				}

				//businessExtintor.commit(true);

			} catch (SQLException e) {
				// erro de banco de dados
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				// mensagens de valida��o
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}

		/**
		 * M�todo para atribuir os valores das requisi��es ao Extintor  
		 * @param pessoa
		 * @throws ParseException 
		 */
		private void request(Extintor ext, Manutencao manutencao) throws ParseException {
			ext.setCodigo(txtCodigo.getText());

			Character tipo = null;
			switch (String.valueOf(cboxTipoExtintor.getSelectedItem())) {
				case "�gua" : tipo = 'a'; break;
				case "CO2" : tipo = 'c'; break;
				case "Espuma Mec�nica" : tipo = 'e'; break;
				case "P� Qu�mico" : tipo = 'p'; break;
			}
			ext.setTipo(tipo);

			ext.setCapacidade(String.valueOf(cboxCapacidadeExtintor.getSelectedItem()));
			ext.setId_usuario(Session.getId());

			manutencao.setData(txtDataManut.getText());
			manutencao.setLocal(txtLocal.getText());
			manutencao.setId_usuario(Session.getId());
			manutencao.setTipo('m');
		}

		/**
		 * M�todo para atribuir valores selecionados ao extintor antigo
		 * @param antigo
		 * @param novo
		 * @return antigo
		 */
		private Extintor merge(Extintor antigo, Extintor novo) {
			antigo.setCodigo(novo.getCodigo());
			antigo.setCapacidade(novo.getCapacidade());
			antigo.setTipo(novo.getTipo());

			// atualizar usu�rio caso o que cadastrou esteja inativo
			UsuarioDAO business;
			try {
				business = new UsuarioDAO(new Usuario());
				Usuario usuario = (Usuario) business.find("Usuario", antigo.getId_usuario());
				if (usuario.getStatus() == 'i') {
					antigo.setId_usuario(Session.getId());
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
			}

			return antigo;
		}
	}

	/**
	 * Controller btnLimparHandler respons�vel pela 
	 * a��o de limpar os campos de cadastro de extintor
	 */
	private class btnLimparHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// se existir usu�rio (caso de atualiza��o)
			if (extintor != null) {
				// limpa os dados escritos por cima dos originais
				populate();
			} else {
				// limpa os campos
				clear();
			}
		}

	}

	/**
	 * Controller btnCancelarHandler respons�vel 
	 * por fechar a tela de cadastro de usu�rio 
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

