package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

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
public class frmCadastrarManutInsp extends javax.swing.JFrame {
	
	private javax.swing.JTable JtblExtintoresCadastrados;
	private javax.swing.JLabel LBLData;
	private javax.swing.JButton btnCadastrar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JButton btnPesquisar;
	private javax.swing.JComboBox cBoxManutInsp;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel jpDadosExtintor;
	private javax.swing.JLabel lblCadExtintor;
	private javax.swing.JLabel lblCodigoExtintor;
	private javax.swing.JLabel lblLocal;
	private javax.swing.JLabel lblServico;
	private javax.swing.JTextField txtCodigoExtintor;
	private JFormattedTextField txtData;
	private javax.swing.JTextField txtLocal;
	private javax.swing.JTextField txtPesquisaCodigoExt;
	private Extintor extintor;
	private Manutencao manutencao;
	private ManutencaoDAO business;
	
	/**
	 * Creates new form frmCadastrarManutInsp
	 */
	public frmCadastrarManutInsp() {
		super("Manuten��o-Inspe��o");

		try {
			business = new ManutencaoDAO(new Manutencao());
		} catch (SQLException e) {
			// erro de banco de dados
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		initComponents();

		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnCadastrar);
		this.setLocationRelativeTo(null);
		clear();
	}

	/**
	 * Creates new form frmCadastrarManutInsp
	 */
	public frmCadastrarManutInsp(Manutencao manutencao)  {
		super("Manuten��o-Inspe��o");

		try {
			business = new ManutencaoDAO(new Manutencao());
			this.manutencao = manutencao;
		} catch (SQLException e) {
			// erro de banco de dados
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		initComponents();
		
		lblCadExtintor.setText("ATUALIZA��O DE MANUTEN��ES E INSPE��ES");
		btnCadastrar.setText("Atualizar");
		
		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnCadastrar);
		this.setLocationRelativeTo(null);

		populate();
	}

	private void populate() {
		extintor = (Extintor) business.find("Extintor", manutencao.getId_extintor());

		txtCodigoExtintor.setText(extintor.getCodigo());
		txtCodigoExtintor.setFocusable(false);
		txtCodigoExtintor.setEditable(false);
		txtCodigoExtintor.setBackground(new Color(235, 235, 228));

		txtLocal.setText(manutencao.getLocal());
		txtData.setText(manutencao.getData());

		switch (manutencao.getTipo()) {
			case 'i' : cBoxManutInsp.setSelectedIndex(0); break;
			case 'm' : cBoxManutInsp.setSelectedIndex(1); break;
		}

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		JtblExtintoresCadastrados = new javax.swing.JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {                
				return false;  
			};
		};
		JtblExtintoresCadastrados.getTableHeader().setReorderingAllowed(false);


		jpDadosExtintor = new javax.swing.JPanel();
		lblCodigoExtintor = new javax.swing.JLabel();
		txtCodigoExtintor = new javax.swing.JTextField();
		lblLocal = new javax.swing.JLabel();
		lblServico = new javax.swing.JLabel();
		txtLocal = new javax.swing.JTextField();
		cBoxManutInsp = new javax.swing.JComboBox();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jLabel1 = new javax.swing.JLabel();
		txtPesquisaCodigoExt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		btnPesquisar = new javax.swing.JButton();
		txtData = new javax.swing.JFormattedTextField();
		LBLData = new javax.swing.JLabel();
		btnCancelar = new javax.swing.JButton();
		btnLimpar = new javax.swing.JButton();
		btnCadastrar = new javax.swing.JButton();
		lblCadExtintor = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jpDadosExtintor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		lblCodigoExtintor.setText("C�digo do Extintor");

		lblLocal.setText("Local");

		lblServico.setText("Tipo de Servico");

		cBoxManutInsp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inspe��o", "Manuten��o" }));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Extintores Cadastrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

		jScrollPane1.setViewportView(JtblExtintoresCadastrados);

		jLabel1.setText("Pesquisar");

		jLabel3.setText("Pesquisa por tipo");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os tipos", "�gua", "CO2", "P� Qu�mico", "Espuma Mec�nica" }));

		btnPesquisar.setText("Pesquisar");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(121, 121, 121)
										.addComponent(jLabel1)
										.addGap(18, 18, 18)
										.addComponent(txtPesquisaCodigoExt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnPesquisar)
										.addGap(59, 59, 59)
										.addComponent(jLabel3)
										.addGap(18, 18, 18)
										.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
										.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(17, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(txtPesquisaCodigoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3)
								.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPesquisar))
								.addGap(35, 35, 35)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
				);

		LBLData.setText("Data");

		javax.swing.GroupLayout jpDadosExtintorLayout = new javax.swing.GroupLayout(jpDadosExtintor);
		jpDadosExtintor.setLayout(jpDadosExtintorLayout);
		jpDadosExtintorLayout.setHorizontalGroup(
				jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosExtintorLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jpDadosExtintorLayout.createSequentialGroup()
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosExtintorLayout.createSequentialGroup()
												.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(lblCodigoExtintor)
														.addComponent(lblLocal)
														.addComponent(lblServico)
														.addComponent(LBLData))
														.addGap(18, 18, 18)
														.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(txtCodigoExtintor, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
																		.addComponent(txtLocal)
																		.addComponent(txtData))
																		.addComponent(cBoxManutInsp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(352, 352, 352))))
				);
		jpDadosExtintorLayout.setVerticalGroup(
				jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpDadosExtintorLayout.createSequentialGroup()
						.addGap(17, 17, 17)
						.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblCodigoExtintor)
								.addComponent(txtCodigoExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLocal))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(LBLData))
												.addGap(14, 14, 14)
												.addGroup(jpDadosExtintorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(cBoxManutInsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lblServico))
														.addGap(18, 21, Short.MAX_VALUE)
														.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
				);

		btnCancelar.setText("Cancelar");

		btnLimpar.setText("Limpar");

		btnCadastrar.setText("Cadastrar");

		lblCadExtintor.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblCadExtintor.setText("CADASTRO DE MANUTEN��ES E INSPE��ES");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jpDadosExtintor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnCancelar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnLimpar)
										.addGap(26, 26, 26)
										.addComponent(btnCadastrar)))
										.addContainerGap())
										.addGroup(layout.createSequentialGroup()
												.addGap(194, 194, 194)
												.addComponent(lblCadExtintor)
												.addContainerGap(195, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addComponent(lblCadExtintor)
						.addGap(18, 18, 18)
						.addComponent(jpDadosExtintor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(24, 24, 24)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnLimpar)
								.addComponent(btnCadastrar))
								.addGap(22, 22, 22))
				);

		pack();

		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("####-##-##");
			maskData.install(txtData);
		} catch (ParseException e) {}

		populateJTable(null,null);
		
		JtblExtintoresCadastrados.addMouseListener(new DoubleClickAdapter(JtblExtintoresCadastrados)); 
		btnCancelar.addActionListener(new CancelarHandler());
		btnPesquisar.addActionListener(new PesquisarHandler());
		btnLimpar.addActionListener(new LimparHandler());
		btnCadastrar.addActionListener(new CadastrarHandler());
	}

	/**
	 * Controller para duplo clique no JTable
	 */
	private class DoubleClickAdapter extends MouseAdapter { 
		javax.swing.JTable table; 

		public DoubleClickAdapter(javax.swing.JTable table){ 
			this.table = table; 
		} 
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) { 
			if ( e.getClickCount() == 2 ) { 
				int id = Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 0));
				populate(id);
			} 
		} 

		/**
		 * M�todo para popular campos j� preenchidos
		 */
		private void populate(int id) {
			ManutencaoDAO business;
			try {
				business = new ManutencaoDAO(new Manutencao());
				Manutencao manutencao = (Manutencao) business.find("Manutencao", id);
				extintor = (Extintor) business.find("Extintor", manutencao.getId_extintor());

				txtCodigoExtintor.setText(extintor.getCodigo());    			
				txtCodigoExtintor.setFocusable(false);
				txtCodigoExtintor.setEditable(false);
				txtCodigoExtintor.setBackground(new Color(235, 235, 228));

				txtLocal.setFocusable(true);
				txtLocal.setEditable(true);
				txtLocal.setBackground(new Color(255, 255, 255));

				txtData.setFocusable(true);
				txtData.setEditable(true);
				txtData.setBackground(new Color(255, 255, 255));


			} catch (SQLException e) {
				txtCodigoExtintor.setText("");
				txtLocal.setText("");
			}    	
		}
	}

	/**
	 * M�todo para popular JTable com usu�rios
	 * @param search pesquisa livre
	 * @param column combobox
	 */
	private void populateJTable(String search, String column) {
		try {
			ExtintorDAO business = new ExtintorDAO(new Extintor());

			// vetor de string
			Vector<Vector<String>> results;

			if (search == null && column == null) {
				// resultados sem pesquisa livre e combobox
				results = business.read();
			} else {
				if (column == null) {
					// resultados da pesquisa livre
					results = business.read(search);   
				} else {
					// resultados da pesquisa livre e combobox
					results = business.read(search, column);
				}
			}

			// vetor de string para receber o cabe�alho do JTable 
			Vector<String> header = new Vector<String>();
			header.add("ID");
			header.add("C�DIGO");
			header.add("TIPO");
			header.add("CAPACIDADE");
			header.add("�LTIMA MANUTEN��O");

			// popula JTable com resultados e cabe�alho
			JtblExtintoresCadastrados.setModel(new javax.swing.table.DefaultTableModel(results, header));

			// esconder a coluna ID
			JtblExtintoresCadastrados.getColumnModel().getColumn(0).setMaxWidth(0);
			JtblExtintoresCadastrados.getColumnModel().getColumn(0).setMinWidth(0);
			JtblExtintoresCadastrados.getColumnModel().getColumn(0).setPreferredWidth(0);

		} catch (SQLException e) {
			JtblExtintoresCadastrados.setModel(new javax.swing.table.DefaultTableModel());
		}
	}

	/**
	 * Controller PesquisarHandler respons�vel pela 
	 * a��o de pesquisar extintores do banco de dados
	 */
	private class PesquisarHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// sem usuario espec�fico marcado na combobox
			if (jComboBox1.getSelectedIndex() == 0) {
				// pesquisa livre 
				populateJTable(txtPesquisaCodigoExt.getText(), null);
			} else {
				// pesquisa combobox
				String tipo = "";
				switch ((String)jComboBox1.getSelectedItem()) {
					case "�gua" : tipo = "a"; break;
					case "CO2" : tipo = "c"; break;
					case "Espuma Mec�nica" : tipo = "e"; break;
					case "P� Qu�mico" : tipo = "p"; break;
				}

				populateJTable(tipo, "tipo");
			}
		}
	}

	/**
	 * Controller
	 */
	private class LimparHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			clear();	
		}
	}

	private void clear() {
		if (this.manutencao == null) {
			txtCodigoExtintor.setText("");
			txtCodigoExtintor.setFocusable(false);
			txtCodigoExtintor.setEditable(false);
			txtCodigoExtintor.setBackground(new Color(235, 235, 228));

			txtLocal.setText("");
			txtLocal.setFocusable(false);
			txtLocal.setEditable(false);
			txtLocal.setBackground(new Color(235, 235, 228));

			txtData.setText("");
			txtData.setFocusable(false);
			txtData.setEditable(false);
			txtData.setBackground(new Color(235, 235, 228));		   
		} else {
			populate();
		}
	}

	/**
	 * Controller
	 */
	private class CancelarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new frmPrincipal().setVisible(true);
			dispose();
		}

	}

	/**
	 * Controller
	 */
	private class CadastrarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Manutencao manu = new Manutencao();

			try {
				// atribui valores
				request(manu);

				// se existir manuten��o (caso de atualiza��o)
				if (manutencao != null) {
					// atribuir valores
					manu = merge(manutencao, manu);
				}

				// valida valores
				manu.validate();

				// Data Access Object - salva extintor
				ManutencaoDAO businessManutencao = new ManutencaoDAO(manu);

				if (manu.getId() == 0) {
					int idManutencao = businessManutencao.create(manu);

					extintor.setId_manutencao(idManutencao);
					ExtintorDAO businessExtintor = new ExtintorDAO(extintor);
					businessExtintor.update(extintor);


					JOptionPane.showMessageDialog(null, cBoxManutInsp.getSelectedItem() + " salva com sucesso!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
					clear();
					populateJTable(null, null);
				} else {
					businessManutencao.update(manu);

					JOptionPane.showMessageDialog(null, cBoxManutInsp.getSelectedItem() + " atualizada com sucesso!", "Confirma��o", JOptionPane.INFORMATION_MESSAGE);
					new frmGerenciarManutInsp().setVisible(true);
					dispose();
				}


			} catch (SQLException e) {
				// erro de banco de dados
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
		private void request(Manutencao manutencao) throws ParseException {
			manutencao.setData(txtData.getText());

			Character tipo = null;
			switch (String.valueOf(cBoxManutInsp.getSelectedItem())) {
				case "Inspe��o" : tipo = 'i'; break;
				case "Manuten��o" : tipo = 'm'; break;
			}
			manutencao.setTipo(tipo);

			manutencao.setLocal(txtLocal.getText());
			manutencao.setId_extintor(extintor.getId());
			manutencao.setId_usuario(Session.getId());
		}

		/**
		 * M�todo para atribuir valores selecionados a manutencao antiga
		 * @param antigo
		 * @param novo
		 * @return antigo
		 */
		private Manutencao merge(Manutencao antigo, Manutencao novo) {
			antigo.setData(novo.getData());
			antigo.setTipo(novo.getTipo());
			antigo.setLocal(novo.getLocal());
			antigo.setId_extintor(extintor.getId());

			// atualizar usu�rio caso o que cadastrou esteja inativo
			UsuarioDAO business;
			try {
				business = new UsuarioDAO(new Usuario());
				Usuario usuario = (Usuario) business.find("Usuario", antigo.getId_usuario());
				if (usuario.getStatus() == 'i') {
					antigo.setId_usuario(Session.getId());
				}
			} catch (SQLException e) {
				// erro banco de dados
			}

			return antigo;
		}
	}
}