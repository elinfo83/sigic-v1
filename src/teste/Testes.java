package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JFileChooser;

import mem.exception.InvalidDateException;
import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.relatorio.RelatorioIntegrantesIgreja;

import com.lowagie.text.DocumentException;

import facade.Facade;



public class Testes {

	public static void main(String[] args) {
		
		Facade facade = new Facade();
		
		try {
			Iterator<IntegranteIgreja>iterator = facade.getIntegranteIgreja();
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
			
			fileChooser.setDialogTitle("Selecionar Pasta");
			fileChooser.showSaveDialog(null);
			File file = fileChooser.getSelectedFile();
			
			
			
			if (file.isDirectory()) {
				
				System.out.println(file.getAbsolutePath());
			}
			
			
			
			RelatorioIntegrantesIgreja relatorioIntegrantesIgreja = new RelatorioIntegrantesIgreja(
					"Relatório de Membros e Congregados da ICB em São Lourenço da Mata/PE","D:/pdfteste/teste.pdf");
			relatorioIntegrantesIgreja.preencheTabela(iterator);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
