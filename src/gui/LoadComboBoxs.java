package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exception.InvalidDateException;
import mem.model.cargo.Cargo;
import mem.model.departamento.Department;
import mem.model.querys.Querys;
import facade.Facade;

public class LoadComboBoxs{
	
	private Facade facade;
	
	
	public LoadComboBoxs(Facade facade) {
		
		this.facade = facade;
	}

	public Cargo[] preencheComboCargos() throws ClassNotFoundException, SQLException, FileNotFoundException, InvalidDateException, IOException {	
		return this.facade.getCargos();
	}
	
	public Department[] preencheComboDep() throws SQLException, InvalidDateException, ClassNotFoundException{
		Querys querys = new Querys();
		return querys.getDepsWithoutIntIg();	
	}
	
	public static  String[] preencheComboEstados(){
		String []estados = {"","Acre","Alagoas","Amapá","Amazonas","Bahia","Ceará","Distrito Federal","Espírito Santo",
				"Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul",
				"Minas Gerais","Pará ","Paraná ","Paraíba","Pernambuco","Piauí","Rio Grande do Norte","Rio Grande do Sul",
				"Rio de Janeiro","Rondônia","Roraima","Santa Catarina","Sergipe","São Paulo","Tocantins"};
		return estados;
	}
	
	public static String[] loadEstCivil(){
		String []estCivil = {"","Solteiro(a)","Casado(a)","Viúvo(a)","Divorciado(a)"};
		return estCivil;
	}
	
	public static String[] preencheComboMeses(){
		String []meses = {"","Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		return meses;
	}
	
	public static String[] preencheComboTitulo(){
		String[] titulos = {"","PASTOR","PRESBÍTERO","DIÁCONO", "EVANGELISTA","MISSIONÁRIO"};
		return titulos;
	}
	
}
