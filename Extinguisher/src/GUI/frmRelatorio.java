package GUI;


import itext.ExtensibleMarkupLanguage;
import itext.PortableDocumentFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Extintor;

import DAO.ExtintorDAO;





/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmRelatorio extends javax.swing.JFrame {

	private javax.swing.JButton btnSalvar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnImportar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JButton btnPesquisar;
	private javax.swing.JComboBox cboxTipoPesquisa;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel jpPesquisa;
	private javax.swing.JPanel jpPrincipal;
	private javax.swing.JPanel jpTable;
	private javax.swing.JTable jtblExtintoresCadastrados;
	private javax.swing.JLabel lblGerenciarUsuario;
	private javax.swing.JLabel lblLoginPesquisa;
	private javax.swing.JLabel lblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	private ExtintorDAO business;

	/**
	 * Creates new form frmRelatorio
	 */
	public frmRelatorio() {
		super("Relatório");

		try {
			business = new ExtintorDAO(new Extintor());
		} catch (SQLException e) {
			// erro de banco de dados
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		initComponents();

		ImageIcon img = new ImageIcon("assets/icon.png");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btnSalvar);
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		btnSalvar = new javax.swing.JButton();
		btnImportar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();
		jpTable = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtblExtintoresCadastrados = new javax.swing.JTable();
		jtblExtintoresCadastrados = new javax.swing.JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {                
				return false;  
			};
		};
		jtblExtintoresCadastrados.getTableHeader().setReorderingAllowed(false);
		jpPrincipal = new javax.swing.JPanel();
		lblGerenciarUsuario = new javax.swing.JLabel();
		jpPesquisa = new javax.swing.JPanel();
		lblLoginPesquisa = new javax.swing.JLabel();
		cboxTipoPesquisa = new javax.swing.JComboBox();
		btnLimpar = new javax.swing.JButton();
		lblPesquisa = new javax.swing.JLabel();
		txtPesquisa = new javax.swing.JTextField();
		btnPesquisar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		btnSalvar.setText("Salvar");

		btnImportar.setText("Importar");

		btnCancelar.setText("Cancelar");

		jScrollPane1.setViewportView(jtblExtintoresCadastrados);

		javax.swing.GroupLayout jpTableLayout = new javax.swing.GroupLayout(jpTable);
		jpTable.setLayout(jpTableLayout);
		jpTableLayout.setHorizontalGroup(
				jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
				);
		jpTableLayout.setVerticalGroup(
				jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpTableLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		lblGerenciarUsuario.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblGerenciarUsuario.setText("RELATÓRIO DE EXTINTORES");

		javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
		jpPrincipal.setLayout(jpPrincipalLayout);
		jpPrincipalLayout.setHorizontalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGerenciarUsuario)
						.addGap(95, 95, 95))
				);
		jpPrincipalLayout.setVerticalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblGerenciarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jpPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		lblLoginPesquisa.setText("Pesquisar por tipo");

		cboxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os tipos", "Água", "CO2", "Pó Químico", "Espuma Mecânica" }));

		btnLimpar.setText("Limpar");

		lblPesquisa.setText("Pesquisa");

		btnPesquisar.setText("Pesquisar");

		javax.swing.GroupLayout jpPesquisaLayout = new javax.swing.GroupLayout(jpPesquisa);
		jpPesquisa.setLayout(jpPesquisaLayout);
		jpPesquisaLayout.setHorizontalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPesquisaLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jpPesquisaLayout.createSequentialGroup()
										.addComponent(lblPesquisa)
										.addGap(18, 18, 18)
										.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(76, 76, 76)
										.addComponent(lblLoginPesquisa))
										.addComponent(btnLimpar))
										.addGap(18, 18, 18)
										.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jpPesquisaLayout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addComponent(btnPesquisar))
														.addComponent(cboxTipoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addContainerGap())
				);
		jpPesquisaLayout.setVerticalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPesquisaLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblLoginPesquisa)
								.addComponent(cboxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesquisa)
								.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnLimpar)
										.addComponent(btnPesquisar))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jpPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jpTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnCancelar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnImportar)
										.addGap(18, 18, 18)
										.addComponent(btnSalvar)))
										.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnImportar)
								.addComponent(btnSalvar))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();

		btnCancelar.addActionListener(new CancelarHandler());
		btnSalvar.addActionListener(new SalvarHandler());
		btnImportar.addActionListener(new ImportarHandler());
		btnPesquisar.addActionListener(new PesquisarHandler());
		btnLimpar.addActionListener(new LimparHandler());
		
		populateJTable(null, null);
	}

	/**
	 * Método para popular JTable com extintores
	 * @param search pesquisa livre
	 * @param column combobox
	 */
	private void populateJTable(String search, String type) {
		try {
			// vetor de string
			Vector<Vector<String>> results;

			if (search == null && type == null) {
				// resultados sem pesquisa livre e combobox
				results = business.read();   
			} else {
				if (type == null) {
					// resultados da pesquisa livre
					results = business.read(search);
				} else {
					// resultados da pesquisa livre e combobox
					results = business.read(search, type);
				}
			}

			// vetor de string para receber o cabeçalho do JTable 
			Vector<String> header = new Vector<String>();
			header.add("ID");
			header.add("CÓDIGO");
			header.add("TIPO");
			header.add("CAPACIDADE");
			header.add("ÚLTIMA MANUTENÇÃO");

			// popula JTable com resultados e cabeçalho
			jtblExtintoresCadastrados.setModel(new javax.swing.table.DefaultTableModel(results, header));

			// esconder a coluna ID
			jtblExtintoresCadastrados.getColumnModel().getColumn(0).setMaxWidth(0);
			jtblExtintoresCadastrados.getColumnModel().getColumn(0).setMinWidth(0);
			jtblExtintoresCadastrados.getColumnModel().getColumn(0).setPreferredWidth(0);

		} catch (SQLException e) {
			jtblExtintoresCadastrados.setModel(new javax.swing.table.DefaultTableModel());
		}
	}

	/**
	 * Controller PesquisarHandler responsável pela 
	 * ação de pesquisar extintores do banco de dados
	 */
	private class PesquisarHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// sem usuario específico marcado na combobox
			if (cboxTipoPesquisa.getSelectedIndex() == 0) {
				// pesquisa livre 
				populateJTable(txtPesquisa.getText(), null);
			} else {
				// pesquisa combobox
				String tipo = "";
				switch ((String)cboxTipoPesquisa.getSelectedItem()) {
				case "Água" : tipo = "a"; break;
				case "CO2" : tipo = "c"; break;
				case "Espuma Mecânica" : tipo = "e"; break;
				case "Pó Químico" : tipo = "p"; break;
				}

				populateJTable(txtPesquisa.getText(), tipo);
			}
		}
	}

	/**
	 * Controller LimparHandler responsável pela 
	 * ação de limpar os campos de pesquisa
	 */
	private class LimparHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			txtPesquisa.setText("");
			cboxTipoPesquisa.setSelectedIndex(0);
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
	private class SalvarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int id;

			try {
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) jtblExtintoresCadastrados.getValueAt(jtblExtintoresCadastrados.getSelectedRow(), 0));
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhum extintor selecionado!");
				return;
			}

			// popula usuario com os dados
			Extintor extintor = (Extintor) business.find("Extintor", id);

			business.storage("SELECT data, tipo, local FROM manutencao WHERE id_extintor = " + extintor.getId());
			ResultSet result = business.execute();

			PortableDocumentFormat pdf = new PortableDocumentFormat(extintor, result);
			pdf.salvar();
			pdf.finalize();
		}
	}

	/**
	 * Controller
	 */
	private class ImportarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ExtensibleMarkupLanguage xml = new ExtensibleMarkupLanguage();
			xml.abrir();
			xml.finalize();
		}
	}  
}
