package mem.model.relatorio;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Iterator;

import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.integrantesIg.IntegrantesIgrejaTypes;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;


public class RelatorioIntegrantesIgreja extends Relatorio{

	public RelatorioIntegrantesIgreja(String nome, String path) {
		super(nome, path);
	}

	public void preencheTabela(Iterator<IntegranteIgreja> iterator) throws DocumentException, FileNotFoundException{
		
		int numCong = 0;
		int numMemb = 0;
		
		PdfPTable datatable = new PdfPTable(5);
		int headerwidths[] = {10, 30, 12, 12,12};
		datatable.setWidths(headerwidths);
		datatable.setWidthPercentage(100);
		datatable.getDefaultCell().setPadding(5);

		PdfPCell cell = new PdfPCell(new Phrase("Relatório de Membros e Congregados da ICB em São Lourenço da Mata/PE", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(2);
		cell.setColspan(10);
		cell.setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
		cell.setUseDescender(true);
		datatable.addCell(cell);
		datatable.getDefaultCell().setBorderWidth(2);
		datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

		// adiciona nomes colunas
		datatable.addCell("Nº de Registro");
		datatable.addCell("Nome");
		datatable.addCell("Tipo");
		datatable.addCell("Departamento");
		datatable.addCell("Data Nascimento");
		datatable.setHeaderRows(2);
		
		String type = "";
		// adiciona dados na tabela
		datatable.getDefaultCell().setBorderWidth(1);
		while (iterator.hasNext()) {
			IntegranteIgreja integranteIgreja = (IntegranteIgreja) iterator.next();
			type = integranteIgreja.getType().name();
			datatable.addCell(integranteIgreja.getRg());
			datatable.addCell(integranteIgreja.getNome());
			datatable.addCell(type);
			datatable.addCell(integranteIgreja.getCodDep());
			datatable.addCell(integranteIgreja.getDataNascimento().toString());
			if(type.intern().equals(IntegrantesIgrejaTypes.MEMBRO.name())){
				numMemb++;
			}else{
				numCong++;
			}

		}		

		datatable.setSplitLate(false);
		
		
		PdfPTable table = new PdfPTable(2);
		
		
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(2);
		
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.setTotalWidth(216f);
		table.setLockedWidth(true);
		
		
		table.addCell("Número de Membros");
		table.addCell(String.valueOf(numMemb));
		table.addCell("Número de Congregados");
		table.addCell(String.valueOf(numCong));
		table.setWidthPercentage(50);
		this.abrirDocumento();
		this.addContent(datatable);
		this.addContent(table);
		this.fecharDocumento();
	}

}
