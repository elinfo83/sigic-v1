package mem.model.relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

public class Relatorio {
	
	private String nome;
	private String path;
	private Document document;
	private boolean isOpen;
	
	public Relatorio(String nome, String path) {
		this.nome = nome;
		this.path = path;
		document = new Document(PageSize.A4.rotate());
		this.isOpen = false;
		
	}
	
	void abrirDocumento() throws FileNotFoundException, DocumentException{
		PdfWriter.getInstance(document,	new FileOutputStream(this.path));
		this.document.open();
		this.isOpen = true;
	}
	
	void addContent(Element element) throws DocumentException{
		if(isOpen){
		this.document.add(element);
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void fecharDocumento(){
		this.document.close();
		this.isOpen = false;
	}
	
}
