package itext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.itextpdf.text.DocumentException;
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
public class ExtensibleMarkupLanguage {

	private String codigo;
	private JFileChooser filechooser;
	private LookAndFeel lnf;
	private org.w3c.dom.Document doc;
	private com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4, 20, 20, 20, 20);
	private File arquivo;

	public ExtensibleMarkupLanguage() {
		this.lnf = UIManager.getLookAndFeel();

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// erro de look and feel
		}
	}

	/**
	 * M�todo respons�vel por abrir arquivo XML
	 */
	public void abrir() {
		filechooser = new JFileChooser();
		filechooser.setMultiSelectionEnabled(false);
		filechooser.setFileFilter(new FileNameExtensionFilter("Arquivos xml (*.xml)", "xml"));

		// abre Dialog para salvar arquivo
		if (filechooser.showOpenDialog(filechooser) == JFileChooser.APPROVE_OPTION) {
			arquivo = filechooser.getSelectedFile();

			// Converter XML para Document
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				doc = db.parse(arquivo);
				doc.getDocumentElement().normalize();

				salvar();
				formatar(arquivo);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu algum erro interno. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

	/**
	 * M�todo respons�vel por verificar e validar o SAVE do arquivo
	 */
	private void salvar() throws FileNotFoundException, DocumentException {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setSelectedFile(new File("findEXT.pdf"));
		filechooser.setFileFilter(new FileNameExtensionFilter("Arquivos pdf (*.pdf)", "pdf"));

		if (filechooser.showSaveDialog(filechooser) == JFileChooser.APPROVE_OPTION) {
			File output = filechooser.getSelectedFile();

			PdfWriter.getInstance(document, new FileOutputStream(output));

			if (output == null) {
				JOptionPane.showMessageDialog(null, "Insira um nome para o relat�rio.");
				return;
			}

			if(!output.getName().toLowerCase().endsWith(".pdf")) {
				JOptionPane.showMessageDialog(null, "Extens�o inv�lida. Utilize o formato *.pdf");
				return;
			}

			if (output.exists()) {
				int opcao = JOptionPane.showConfirmDialog(null,
						"Um arquivo com o mesmo nome j� existe. Deseja realmente sobrescrever?", 
						"Relat�rio", 
						JOptionPane.YES_NO_OPTION); 
				if (opcao == JOptionPane.NO_OPTION) {
					return;
				}
			}
		}
	}

	/**
	 * M�todo para preparar PDF
	 */
	private void formatar(File input) throws DocumentException {
		document.addTitle("Relat�rio de Manuten��o de Extintor");
		document.addSubject("findEXT");
		document.addKeywords("Extintor, Manuten��o, Inspe��o, findEXT");
		document.addAuthor("findEXT");
		document.addCreator("findEXT");

		document.open();

		NodeList infos = doc.getElementsByTagName("info");
		for (int i = 0; i < infos.getLength(); i++) {
			Node info = infos.item(i);

			if (info.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) info;
				document.add(new Paragraph("Gerenciador de Extintores"));
				document.add(new Paragraph("C�digo do extintor: " + getValue("codigo", element)));
				document.add(new Paragraph("Tipo: " + getValue("tipo", element)));
				document.add(new Paragraph("Capacidade: " + getValue("capacidade", element)));

				codigo = getValue("codigo", element);
			}
		}

		PdfPTable table = new PdfPTable(3);

		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Data"));
		cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Tipo"));
		cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Local"));
		cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		table.addCell(cell);

		table.setHeaderRows(1);

		NodeList manutencoes = doc.getElementsByTagName("manutencao");

		for (int i = 0; i < manutencoes.getLength(); i++) {
			Node manutencao = manutencoes.item(i);

			if (manutencao.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) manutencao;
				table.addCell(getValue("data", element));
				table.addCell(getValue("tipo", element));
				table.addCell(getValue("local", element));
			}
		}

		document.add(table);

		document.close();

		JOptionPane.showMessageDialog(null, "O relat�rio foi gerado com sucesso.");
	}

	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodes.item(0);
		return node.getNodeValue();
	}

	/**
	 * Destruidor 
	 */
	@Override
	public void finalize() {
		try {
			UIManager.setLookAndFeel(this.lnf);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
