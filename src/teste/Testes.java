package teste;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exception.InvalidDateException;
import mem.model.integrantesIg.IntegranteIgreja;
import facade.Facade;


public class Testes {

	public static void main(String[] args) {
		Facade facade = new Facade();
		try {
			IntegranteIgreja[] members = facade.getIntegranteIgreja();
			for (IntegranteIgreja integranteIgreja : members) {
				integranteIgreja.getNome();
			}
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
		}
	}
}
