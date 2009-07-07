package teste;

import mem.exception.InvalidDateException;
import util.Date;
import facade.Facade;


public class Testes {

	public static void main(String[] args) {
		try {
			Date data = new Date(6,2,1977);
			
			
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
