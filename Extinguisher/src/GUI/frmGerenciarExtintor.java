package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class frmGerenciarExtintor extends javax.swing.JFrame {

	private javax.swing.JButton btnAtualizar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnDeletar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JComboBox cboxLocalPesquisa;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel jpBotoes;
	private javax.swing.JPanel jpPesquisa;
	private javax.swing.JPanel jpPrincipal;
	private javax.swing.JPanel jpTable;
	private javax.swing.JTable jtblExtintores;
	private javax.swing.JLabel lblGerenciarExtintores;
	private javax.swing.JLabel lblLocalPesquisa;
	private javax.swing.JLabel lblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	private javax.swing.JButton btnPesquisar;
	private ExtintorDAO business;

	/**
	 * Creates new form frmGerenciarExtintor
	 */
	public frmGerenciarExtintor() {
		super("Extintor");
		
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
		this.getRootPane().setDefaultButton(btnAtualizar);
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jpPrincipal = new javax.swing.JPanel();
		lblGerenciarExtintores = new javax.swing.JLabel();
		jpPesquisa = new javax.swing.JPanel();
		lblLocalPesquisa = new javax.swing.JLabel();
		cboxLocalPesquisa = new javax.swing.JComboBox();
		btnLimpar = new javax.swing.JButton();
		lblPesquisa = new javax.swing.JLabel();
		txtPesquisa = new javax.swing.JTextField();
		btnPesquisar = new javax.swing.JButton();
		jpTable = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtblExtintores = new javax.swing.JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {                
				return false;  
			};
		};
		jtblExtintores.getTableHeader().setReorderingAllowed(false);
		btnAtualizar = new javax.swing.JButton();
		btnDeletar = new javax.swing.JButton();
		btnCancelar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblGerenciarExtintores.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblGerenciarExtintores.setText("GERENCIAR  EXTINTORES");

		javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
		jpPrincipal.setLayout(jpPrincipalLayout);
		jpPrincipalLayout.setHorizontalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGerenciarExtintores)
						.addGap(143, 143, 143))
				);
		jpPrincipalLayout.setVerticalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblGerenciarExtintores, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jpPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		lblLocalPesquisa.setText("Pesquisar por tipo");

		cboxLocalPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os tipos", "�gua", "CO2", "P� Qu�mico", "Espuma Mec�nica" }));

		btnLimpar.setText("Limpar");

		lblPesquisa.setText("Pesquisa");

		btnPesquisar.setText("Pesquisar");

		javax.swing.GroupLayout jpPesquisaLayout = new javax.swing.GroupLayout(jpPesquisa);
		jpPesquisa.setLayout(jpPesquisaLayout);
		jpPesquisaLayout.setHorizontalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPesquisaLayout.createSequentialGroup()
						.addGap(32, 32, 32)
						.addComponent(lblPesquisa)
						.addGap(18, 18, 18)
						.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
						.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPesquisaLayout.createSequentialGroup()
										.addComponent(lblLocalPesquisa)
										.addGap(18, 18, 18)
										.addComponent(cboxLocalPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPesquisaLayout.createSequentialGroup()
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
								.addComponent(lblLocalPesquisa)
								.addComponent(cboxLocalPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesquisa)
								.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnLimpar)
										.addComponent(btnPesquisar))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jtblExtintores.setCellSelectionEnabled(true);
		jtblExtintores.setEditingColumn(0);
		jtblExtintores.setEditingRow(0);
		jScrollPane1.setViewportView(jtblExtintores);

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

		btnAtualizar.setText("Atualizar");

		btnDeletar.setText("Remover");

		btnCancelar.setText("Cancelar");

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
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addComponent(btnCancelar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDeletar)
										.addGap(18, 18, 18)
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnAtualizar)
								.addComponent(btnDeletar)
								.addComponent(btnCancelar))
								.addContainerGap(20, Short.MAX_VALUE))
				);

		pack();

		btnPesquisar.addActionListener(new PesquisarHandler());
		btnDeletar.addActionListener(new DeletarHandler());
		btnAtualizar.addActionListener(new AtualizarHandler());
		btnLimpar.addActionListener(new LimparHandler());
		btnCancelar.addActionListener(new CancelarHandler());

		populateJTable(null, null);
	}

	/**
	 * M�todo para popular JTable com extintores
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

			// vetor de string para receber o cabe�alho do JTable 
			Vector<String> header = new Vector<String>();
			header.add("ID");
			header.add("C�DIGO");
			header.add("TIPO");
			header.add("CAPACIDADE");
			header.add("�LTIMA MANUTEN��O");

			// popula JTable com resultados e cabe�alho
			jtblExtintores.setModel(new javax.swing.table.DefaultTableModel(results, header));

			// esconder a coluna ID
			jtblExtintores.getColumnModel().getColumn(0).setMaxWidth(0);
			jtblExtintores.getColumnModel().getColumn(0).setMinWidth(0);
			jtblExtintores.getColumnModel().getColumn(0).setPreferredWidth(0);

		} catch (SQLException e) {
			jtblExtintores.setModel(new javax.swing.table.DefaultTableModel());
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
			if (cboxLocalPesquisa.getSelectedIndex() == 0) {
				// pesquisa livre 
				populateJTable(txtPesquisa.getText(), null);
			} else {
				// pesquisa combobox
				String tipo = "";
				switch ((String)cboxLocalPesquisa.getSelectedItem()) {
				case "�gua" : tipo = "a"; break;
				case "CO2" : tipo = "c"; break;
				case "Espuma Mec�nica" : tipo = "e"; break;
				case "P� Qu�mico" : tipo = "p"; break;
				}

				populateJTable(txtPesquisa.getText(), tipo);
			}
		}
	}

	/**
	 * Controller AtualizarHandler respons�vel pela 
	 * a��o de abrir tela de atualiza��o de extintores do banco de dados
	 */
	private class AtualizarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int id;

			try { 
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) jtblExtintores.getValueAt(jtblExtintores.getSelectedRow(), 0));

				// popula usuario com os dados
				Extintor extintor = (Extintor) business.find("Extintor", id);

				// abre tela para atualizar extintor
				new frmCadastrarExtintor(extintor).setVisible(true);
				dispose();
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhum extintor selecionado!");
				return;
			}
		}
	}

	/**
	 * Controller DeletarHandler respons�vel pela 
	 * a��o de remover extintores do banco de dados
	 */
	private class DeletarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int id;

			try {
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) jtblExtintores.getValueAt(jtblExtintores.getSelectedRow(), 0));
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhum extintor selecionado!");
				return;
			}

			int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja realmente remover este extintor?", 
					"Extintor", 
					JOptionPane.YES_NO_OPTION); 

			if (opcao == JOptionPane.YES_OPTION) { // SIM
				try {
					// popula usuario com os dados
					Extintor extintor = (Extintor) business.find("Extintor", id);

					// remove usuario
					business.delete(extintor);

					// popula a JTable - Refresh
					populateJTable(null, null);

					javax.swing.JOptionPane.showMessageDialog(null, "Extintor removido com sucesso!");
				} catch (SQLException e1) {
					// erro de banco de dados
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
				}					
			} else { // NAO 
				return;
			}
		}
	}	   


	/**
	 * Controller LimparHandler respons�vel pela 
	 * a��o de limpar os campos de pesquisa
	 */
	private class LimparHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			txtPesquisa.setText("");
			cboxLocalPesquisa.setSelectedIndex(0);
		}
	}

	/**
	 * Controller CancelarHandler respons�vel pela 
	 * a��o de fechar a tela de gerenciamento de usu�rio
	 */
	private class CancelarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new frmPrincipal().setVisible(true);
			dispose();
		}
	}
}