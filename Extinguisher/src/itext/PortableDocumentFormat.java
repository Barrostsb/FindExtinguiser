package itext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Extintor;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class PortableDocumentFormat {
	private JFileChooser filechooser;
	private Extintor extintor;
	private ResultSet result;
	private LookAndFeel lnf;

	public PortableDocumentFormat(Extintor extintor, ResultSet result) {
		this.extintor = extintor;
		this.result = result;
		this.lnf = UIManager.getLookAndFeel();

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// erro de look and feel
		}
	}

	/**
	 * M�todo respons�vel por verificar e validar o SAVE do arquivo
	 */
	public void salvar() {
		filechooser = new JFileChooser();
		filechooser.setSelectedFile(new File("findEXT - " + extintor.getCodigo() + ".pdf"));
		filechooser.setFileFilter(new FileNameExtensionFilter("Arquivos pdf (*.pdf)", "pdf"));

		// abre Dialog para salvar arquivo
		if (filechooser.showSaveDialog(filechooser) == JFileChooser.APPROVE_OPTION) {
			File arquivo = filechooser.getSelectedFile();

			if (arquivo == null) {
				JOptionPane.showMessageDialog(null, "Insira um nome para o relat�rio.");
				return;
			}

			if(!arquivo.getName().toLowerCase().endsWith(".pdf")) {
				JOptionPane.showMessageDialog(null, "Extens�o inv�lida. Utilize o formato *.pdf");
				return;
			}

			if (arquivo.exists()) {
				int opcao = JOptionPane.showConfirmDialog(null,
						"Um arquivo com o mesmo nome j� existe. Deseja realmente sobrescrever?", 
						"Relat�rio", 
						JOptionPane.YES_NO_OPTION); 
				if (opcao == JOptionPane.NO_OPTION) {
					return;
				}
			}

			formatar(arquivo);
		}
	}

	/**
	 * M�todo para preparar PDF
	 */
	private void formatar(File arquivo) {
		try {
			Document document = new Document(PageSize.A4, 20, 20, 20, 20);
			PdfWriter.getInstance(document, new FileOutputStream(arquivo));

			document.addTitle("Relat�rio de Manuten��o de Extintor");
			document.addSubject("findEXT");
			document.addKeywords("Extintor, Manuten��o, Inspe��o, findEXT");
			document.addAuthor("findEXT");
			document.addCreator("findEXT");

			document.open();

			document.add(new Paragraph("Gerenciador de Extintores"));
			document.add(new Paragraph("C�digo do extintor: " + extintor.getCodigo()));

			String tipo = null;
			switch (extintor.getTipo()) {
			case 'a' : tipo = "�gua"; break;
			case 'c' : tipo = "CO2"; break;
			case 'e' : tipo = "Espuma Mec�nica"; break;
			case 'p' : tipo = "P� Qu�mico"; break;
			}

			document.add(new Paragraph("Tipo: " + tipo));
			document.add(new Paragraph("Capacidade: " + extintor.getCapacidade()));

			PdfPTable table = new PdfPTable(3);

			populate(table);

			document.add(table);

			document.close();			

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo para popular tabela no PDF
	 */
	private void populate(PdfPTable table) {
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Data"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Tipo"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Local"));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		table.setHeaderRows(1);

		try {
			while (result.next()) {
				table.addCell(result.getString(1));

				String tipo = "";
				switch (result.getString(2)) {
				case "m" : tipo = "Manuten��o"; break;
				case "i" : tipo = "Inspe��o"; break;
				}

				table.addCell(tipo);
				table.addCell(result.getString(3));
			}
		} catch (SQLException e) {}
	}
	
	/**
	 * Destruidor 
	 */
	@Override
	public void finalize() {
		try {
			UIManager.setLookAndFeel(this.lnf);
		} catch (UnsupportedLookAndFeelException e) {
			// erro de look and feel
		}
	}

}
