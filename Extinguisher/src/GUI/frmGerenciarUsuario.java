package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Usuario;

import DAO.UsuarioDAO;






/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
@SuppressWarnings("serial")
public class frmGerenciarUsuario extends javax.swing.JFrame {

	private javax.swing.JButton btnAtualizar;
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnDeletar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JComboBox cboxLoginPesquisa;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel jpBotoes;
	private javax.swing.JPanel jpPesquisa;
	private javax.swing.JPanel jpPrincipal;
	private javax.swing.JPanel jpTable;
	private javax.swing.JTable jtblUsuarios;
	private javax.swing.JLabel lblGerenciarUsuario;
	private javax.swing.JLabel lblLoginPesquisa;
	private javax.swing.JLabel lblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	private javax.swing.JButton btnPesquisar;
	private UsuarioDAO business;
	
	/**
	 * Creates new form frmGerenciarUsuario
	 */
	public frmGerenciarUsuario() {
		super("Usu�rio");
		
		try {
			// Data Access Object
			business = new UsuarioDAO(new Usuario());
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
		lblGerenciarUsuario = new javax.swing.JLabel();
		jpPesquisa = new javax.swing.JPanel();
		lblLoginPesquisa = new javax.swing.JLabel();
		cboxLoginPesquisa = new javax.swing.JComboBox();
		btnLimpar = new javax.swing.JButton();
		lblPesquisa = new javax.swing.JLabel();
		txtPesquisa = new javax.swing.JTextField();
		btnPesquisar = new javax.swing.JButton();
		jpTable = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtblUsuarios = new javax.swing.JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {                
				return false;  
			};
		};
		jtblUsuarios.getTableHeader().setReorderingAllowed(false);
		btnCancelar = new javax.swing.JButton();
		btnDeletar = new javax.swing.JButton();
		btnAtualizar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblGerenciarUsuario.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
		lblGerenciarUsuario.setText("GERENCIAR  USU�RIO");

		javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
		jpPrincipal.setLayout(jpPrincipalLayout);
		jpPrincipalLayout.setHorizontalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup()
						.addGap(192, 192, 192)
						.addComponent(lblGerenciarUsuario)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jpPrincipalLayout.setVerticalGroup(
				jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblGerenciarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jpPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		lblLoginPesquisa.setText("Pesquisar por login");

		cboxLoginPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		btnLimpar.setText("Limpar");

		lblPesquisa.setText("Pesquisa");

		btnPesquisar.setText("Pesquisar");

		javax.swing.GroupLayout jpPesquisaLayout = new javax.swing.GroupLayout(jpPesquisa);
		jpPesquisa.setLayout(jpPesquisaLayout);
		jpPesquisaLayout.setHorizontalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPesquisaLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLimpar)
						.addGap(18, 18, 18)
						.addComponent(btnPesquisar)
						.addContainerGap())
						.addGroup(jpPesquisaLayout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addComponent(lblPesquisa)
								.addGap(27, 27, 27)
								.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(41, 41, 41)
								.addComponent(lblLoginPesquisa)
								.addGap(18, 18, 18)
								.addComponent(cboxLoginPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(137, Short.MAX_VALUE))
				);
		jpPesquisaLayout.setVerticalGroup(
				jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPesquisaLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblLoginPesquisa)
								.addComponent(cboxLoginPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesquisa)
								.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnLimpar)
										.addComponent(btnPesquisar))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jScrollPane1.setViewportView(jtblUsuarios);

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
										.addGap(34, 34, 34)
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
								.addComponent(btnCancelar)
								.addComponent(btnDeletar)
								.addComponent(btnAtualizar))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();

		btnLimpar.addActionListener(new LimparHandler());
		btnPesquisar.addActionListener(new PesquisarHandler());
		btnCancelar.addActionListener(new CancelarHandler());
		btnDeletar.addActionListener(new DeletarHandler());
		btnAtualizar.addActionListener(new AtualizarHandler());
		cboxLoginPesquisa.addActionListener(new ChangeHandler());

		populateJComboBox();
		populateJTable(null, null);
	}

	/**
	 * M�todo para popular JComboBox com usu�rios
	 */
	@SuppressWarnings("unchecked")
	private void populateJComboBox() {
		try {
			// vetor de string
			Vector<String> usuarios = new Vector<String>();
			usuarios.add("Todos os usu�rios");

			// armazena e executa query
			business.storage("SELECT usuario FROM usuario WHERE status = 'a'");
			ResultSet result = business.execute();

			// enquanto tiver resultados
			while (result.next()) {
				// adiciona ao vetor o usuario
				usuarios.add(result.getString(1));
			}

			// popula JComboBox com vetor
			cboxLoginPesquisa.setModel(new javax.swing.DefaultComboBoxModel(usuarios));
		} catch (SQLException e) {
			cboxLoginPesquisa.setModel(new javax.swing.DefaultComboBoxModel());
		}
	}

	/**
	 * M�todo para popular JTable com usu�rios
	 * @param search pesquisa livre
	 * @param column combobox
	 */
	private void populateJTable(String search, String column) {
		try {
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
			header.add("CPF");
			header.add("NOME");
			header.add("USU�RIO");
			header.add("EMAIL");

			// popula JTable com resultados e cabe�alho
			jtblUsuarios.setModel(new javax.swing.table.DefaultTableModel(results, header));

			// esconder a coluna ID
			jtblUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
			jtblUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
			jtblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);

		} catch (SQLException e) {
			jtblUsuarios.setModel(new javax.swing.table.DefaultTableModel());
		}
	}

	/**
	 * Controller PesquisarHandler respons�vel pela 
	 * a��o de pesquisar usu�rios do banco de dados
	 */
	private class PesquisarHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// sem usuario espec�fico marcado na combobox
			if (cboxLoginPesquisa.getSelectedIndex() == 0) {
				// pesquisa livre 
				populateJTable(txtPesquisa.getText(), null);
			} else {
				// pesquisa combobox
				populateJTable((String)cboxLoginPesquisa.getSelectedItem(), "usuario");
			}
		}
	}

	/**
	 * Controller AtualizarHandler respons�vel pela 
	 * a��o de abrir tela de atualiza��o de usu�rios do banco de dados
	 */
	private class AtualizarHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int id;

			try {
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) jtblUsuarios.getValueAt(jtblUsuarios.getSelectedRow(), 0));

				// popula usuario com os dados
				Usuario usuario = (Usuario) business.find("Usuario", id);

				// abre tela para atualizar usuario
				new frmCadastrarUsuario(usuario).setVisible(true);
				dispose();
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhum usu�rio selecionado!");
				return;
			}
		}
	}

	/**
	 * Controller DeletarHandler respons�vel pela 
	 * a��o de remover usu�rios do banco de dados
	 */
	private class DeletarHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int id;

			try {
				// retorna o valor da primeira coluna da linha selecionada
				id = Integer.valueOf((String) jtblUsuarios.getValueAt(jtblUsuarios.getSelectedRow(), 0));
			} catch (Exception e1) {
				javax.swing.JOptionPane.showMessageDialog(null, "Nenhum usu�rio selecionado!");
				return;
			}

			int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja realmente remover este usu�rio?", 
					"Usu�rio", 
					JOptionPane.YES_NO_OPTION); 

			if (opcao == JOptionPane.YES_OPTION) { // SIM
				try {
					// popula usuario com os dados
					Usuario usuario = (Usuario) business.find("Usuario", id);

					// remove usuario
					business.delete(usuario);

					// popula a JTable - Refresh
					populateJTable(null, null);

					javax.swing.JOptionPane.showMessageDialog(null, "Usu�rio removido com sucesso!");
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
			cboxLoginPesquisa.setSelectedIndex(0);
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

	private class ChangeHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (cboxLoginPesquisa.getSelectedIndex() != 0) {
				txtPesquisa.setFocusable(false);
				txtPesquisa.setEditable(false);
				txtPesquisa.setBackground(new Color(235, 235, 228));
			} else {
				txtPesquisa.setFocusable(true);
				txtPesquisa.setEditable(true);
				txtPesquisa.setBackground(new Color(255, 255, 255));
			}
		}
	}
}
