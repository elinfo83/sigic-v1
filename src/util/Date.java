package util;

import java.util.StringTokenizer;

import mem.exception.InvalidDateException;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date() {
		setDay(1);
		setMonth(1);
		setYear(1900);
	}
	
	public Date(String date) throws InvalidDateException{
		this.setDate(date);
	}
	
	public Date(int day, int month, int year) throws InvalidDateException {
		super();
		this.setDate(day,month,year);
	}

	public int getDay() {
		return day;
	}

	private void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	private void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	private void setYear(int year) {
		this.year = year;
	}
	
	public void setDate(String date) throws InvalidDateException{
		int dates[] = new int[3];
		
		StringTokenizer token = new StringTokenizer(date," /");
		
		for (int i = 0; i < dates.length && token.hasMoreTokens(); i++) {
			dates[i] = Integer.parseInt(token.nextToken());
			
		}
		
		this.setDate(dates[0], dates[1], dates[2]);
	}
	
	private void setDate(int day, int month, int year) throws InvalidDateException{

		if(day<1)throw new InvalidDateException("Dia tem que ser maior que zero!");

		if(month<1 || month>12)throw new InvalidDateException("Mês não existe!");

		if(year < 1800)throw new InvalidDateException("Ano Invalido!" + day + month + year);

		/*Trata o mes de fevereiro em ano bisexto ou não*/
		if(month == 2){
			if((year%4 == 0) && (day <= 29)){
				this.setDay(day);
			}else if(day <= 28){
				this.setDay(day);
			}else{
				throw new InvalidDateException("Dia inválido para o mes de Fevereiro!");
			}/*meses com 30 dias: abril, junho, setembro, novembro */
		}else if ( ( (month == 4) || (month == 6) || (month == 9) || (month == 11) ) && day <= 30) {
			
			this.setDay(day);
		} else if ( ( (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) 
				|| (month == 10) || (month == 12)) && day <= 31) {
			
			this.setDay(day);
		} else {
			
			throw new InvalidDateException("Mes com dia Errado!");
		}

		this.setMonth(month);
		this.setYear(year);
	} 

	public String toString(){
		String day = "";
		String month = "";

		if(this.day <= 9){
			day = "0" + this.day;
		}else day = String.valueOf(this.day);

		if(this.month <= 9){
			month = "0" + this.month;
		}else month = String.valueOf(this.month);

		return day + "/" + month + "/" + this.year;

	}
}
