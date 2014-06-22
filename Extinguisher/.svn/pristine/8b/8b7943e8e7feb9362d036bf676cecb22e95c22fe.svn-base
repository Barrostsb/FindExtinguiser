package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Manutencao;

import DAO.ManutencaoDAO;






/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmGerenciarManutInsp extends javax.swing.JFrame {

	private javax.swing.JButton btnAtualizar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnDeletar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JComboBox cboxLocalPesquisa;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JPanel jpBotoes;
	private javax.swing.JPanel jpPesquisa;
	private javax.swing.JPanel jpPrincipal;
	private javax.swing.JPanel jpTable;
	private javax.swing.JLabel lblGerenciarManutInsp;
	private javax.swing.JLabel lblLoginPesquisa;
	private javax.swing.JLabel lblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	private javax.swing.JButton btnPesquisar;
	private ManutencaoDAO business;

	/**
	 * Creates new form frmGerenciarManutInsp
	 */
	public frmGerenciarManutInsp() {
		super("Manutenção-Inspeção");

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
		this.getRootPane().setDefaultButton(btnAtualizar);
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jpPrincipal = new javax.swing.JPanel();
		lblGerenciarManutInsp = new javax.swing.JLabel();
		jpPesquisa = new javax.swing.JPanel();
		lblLoginPesquisa = new javax.swing.JLabel();
		cboxLocalPesquisa = new javax.swing.JComboBox();
		btnLimpar = new javax.swing.JButton();
		lblPesquisa = new javax.swing.JLabel();
		txtPesquisa = new javax.swing.JTextField();
		btnPesquisar = new javax.swing.JButton();
		jpTable = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jTable1 = new javax.swing.JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {                
				return false;  
			};
		};
		jTable1.getTableHeader().setReorderingAllowed(false);
		jPanel2 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {                
				return false;  
			};
		};
		jTable2.getTableHeader().setReorderingAllowed(false);
		btnCancelar = new javax.swing.JButton();
		btnDeletar = new javax.swing.JButton();
		btnAtualizar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblGerenciarManutInsp.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblGerenciarManutInsp.setText("GERENCIAR  MANUTENÇÕES/INSPEÇÕES");

		javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
		jpPrincipal.setLayout(jpPrincipalLayout);
		jpPrincipalLayout.setHorizontalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGerenciarManutInsp)
						.addGap(99, 99, 99))
				);
		jpPrincipalLayout.setVerticalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGerenciarManutInsp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		jpPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		lblLoginPesquisa.setText("Pesquisar por Tipo");

		cboxLocalPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os tipos", "Água", "CO2", "Pó Químico", "Espuma Mecânica" }));

		btnLimpar.setText("Limpar");

		lblPesquisa.setText("Pesquisa");

		btnPesquisar.setText("Pesquisar");

		javax.swing.GroupLayout jpPesquisaLayout = new javax.swing.GroupLayout(jpPesquisa);
		jpPesquisa.setLayout(jpPesquisaLayout);
		jpPesquisaLayout.setHorizontalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPesquisaLayout.createSequentialGroup()
						.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jpPesquisaLayout.createSequentialGroup()
										.addGap(55, 55, 55)
										.addComponent(lblPesquisa)
										.addGap(27, 27, 27)
										.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblLoginPesquisa)
										.addGap(18, 18, 18)
										.addComponent(cboxLocalPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jpPesquisaLayout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnLimpar)
												.addGap(18, 18, 18)
												.addComponent(btnPesquisar)))
												.addContainerGap())
				);
		jpPesquisaLayout.setVerticalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPesquisaLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblLoginPesquisa)
								.addComponent(cboxLocalPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesquisa)
								.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnLimpar)
										.addComponent(btnPesquisar))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jScrollPane2.setViewportView(jTable1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addContainerGap())
				);

		jTabbedPane1.addTab("Inspeções", jPanel1);

		jScrollPane3.setViewportView(jTable2);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
						.addContainerGap())
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addContainerGap())
				);

		jTabbedPane1.addTab("Manutenções", jPanel2);

		javax.swing.GroupLayout jpTableLayout = new javax.swing.GroupLayout(jpTable);
		jpTable.setLayout(jpTableLayout);
		jpTableLayout.setHorizontalGroup(
				jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpTableLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTabbedPane1)
						.addContainerGap())
				);
		jpTableLayout.setVerticalGroup(
				jpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpTableLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		btnCancelar.setText("Cancelar");

		btnDeletar.setText("Remover");

		btnAtualizar.setText("Atualizar");

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
										.addComponent(btnDeletar)
										.addGap(57, 57, 57)
										.addComponent(btnAtualizar)))
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnDeletar)
								.addComponent(btnAtualizar))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();

		btnLimpar.addActionListener(new LimparHandler());
		btnCancelar.addActionListener(new CancelarHandler());
		btnDeletar.addActionListener(new DeletarHandler());
		btnAtualizar.addActionListener(new AtualizarHandler());
		btnPesquisar.addActionListener(new PesquisarHandler());

		populateJTable(jTable1, 'i', null, null);
		populateJTable(jTable2, 'm', null, null);
	}

	/**
	 * Método para popular JTable com usuários
	 * @param search pesquisa livre
	 * @param column combobox
	 */
	private void populateJTable(JTable table, Character type, String search, String column) {
		try {
			// vetor de string
			Vector<Vector<String>> results;

			// resultados da pesquisa
			if (column == null) {
				results = business.read(search, type);    		   
			} else {
				results = business.read(search, type, column);
			}

			// vetor de string para receber o cabeçalho do JTable 
			Vector<String> header = new Vector<String>();
			header.add("ID");
			header.add("EXTINTOR");
			header.add("TIPO");
			header.add("DATA");
			header.add("LOCAL");

			// popula JTable com resultados e cabeçalho
			table.setModel(new javax.swing.table.DefaultTableModel(results, header));

			// esconder a coluna ID
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(0);

		} catch (SQLException e) {
			table.setModel(new javax.swing.table.DefaultTableModel());
		}
	}

	/**
	 * Controller PesquisarHandler responsável pela 
	 * ação de pesquisar manutenções do banco de dados
	 */
	private class PesquisarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (cboxLocalPesquisa.getSelectedIndex() == 0) {
				populateJTable(jTable1, 'i', txtPesquisa.getText(), null);
				populateJTable(jTable2, 'm', txtPesquisa.getText(), null);

			} else {

				// pesquisa combobox
				String tipo = "";
				switch ((String)cboxLocalPesquisa.getSelectedItem()) {
				case "Água" : tipo = "a"; break;
				case "CO2" : tipo = "c"; break;
				case "Espuma Mecânica" : tipo = "e"; break;
				case "Pó Químico" : tipo = "p"; break;
				}

				populateJTable(jTable1, 'i', txtPesquisa.getText(), tipo);
				populateJTable(jTable2, 'm', txtPesquisa.getText(), tipo);
			}

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
	private class DeletarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// verifica qual aba está selecionada para procurar a linha selecionada dentro dela
			int aba = jTabbedPane1.getSelectedIndex();
			JTable table = (aba == 0) ? jTable1 : jTable2;

			String retorno = (aba == 0) ? "inspeção" : "manutenção";

			int id;

			try {
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 0));
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhuma " + retorno + "selecionada!");
				return;
			}
			int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja realmente remover esta " + retorno + "?", 
					"Manutenção-Inspeção", 
					JOptionPane.YES_NO_OPTION); 
			if (opcao == JOptionPane.YES_OPTION) {
				try {
					// popula manutencao com os dados
					Manutencao manutencao = (Manutencao) business.find("Manutencao", id);

					// remove usuario
					business.delete(manutencao);

					// popula a JTable - Refresh
					populateJTable(jTable1, 'i', null, null);
					populateJTable(jTable2, 'm', null, null);

					javax.swing.JOptionPane.showMessageDialog(null, Character.toUpperCase(retorno.charAt(0)) + retorno.substring(1) + " removida com sucesso!");
				} catch (SQLException e1) {
					// erro de banco de dados
					JOptionPane.showMessageDialog(null, "Essa é a última manutenção cadastrada de um extintor, não podendo então ser apagada", Character.toUpperCase(retorno.charAt(0)) + retorno.substring(1), JOptionPane.ERROR_MESSAGE);
				}
			} else {
				return;
			}

		}

	}

	/**
	 * Controller
	 */
	private class AtualizarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// verifica qual aba está selecionada para procurar a linha selecionada dentro dela
			int aba = jTabbedPane1.getSelectedIndex();
			JTable table = (aba == 0) ? jTable1 : jTable2;

			String retorno = (aba == 0) ? "inspeção" : "manutenção";

			int id;

			try {
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 0));

				// popula manutencao com os dados
				Manutencao manutencao = (Manutencao) business.find("Manutencao", id);

				// abre tela para atualizar extintor
				new frmCadastrarManutInsp(manutencao).setVisible(true);
				dispose();
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhuma " + retorno + "selecionada!");
				return;
			}
		}		   
	}

	/**
	 * Controller
	 */
	private class LimparHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			txtPesquisa.setText("");			
		}
	}
	
}
