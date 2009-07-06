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
		String []estados = {"","Acre","Alagoas","Amap�","Amazonas","Bahia","Cear�","Distrito Federal","Esp�rito Santo",
				"Goi�s","Maranh�o","Mato Grosso","Mato Grosso do Sul",
				"Minas Gerais","Par� ","Paran� ","Para�ba","Pernambuco","Piau�","Rio Grande do Norte","Rio Grande do Sul",
				"Rio de Janeiro","Rond�nia","Roraima","Santa Catarina","Sergipe","S�o Paulo","Tocantins"};
		return estados;
	}
	
	public static String[] loadEstCivil(){
		String []estCivil = {"","Solteiro(a)","Casado(a)","Vi�vo(a)","Divorciado(a)"};
		return estCivil;
	}
	
	public static String[] preencheComboMeses(){
		String []meses = {"","Janeiro","Fevereiro","Mar�o","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		return meses;
	}
	
	public static String[] preencheComboTitulo(){
		String[] titulos = {"","PASTOR","PRESB�TERO","DI�CONO", "EVANGELISTA","MISSION�RIO"};
		return titulos;
	}
	
}
