import java.util.*;

class Objekti1 {
	
	public static void main(String[] args) {
		System.out.println("dela");
		
		Delavec1 delavec = new Delavec1("Uros", "Zoretic", "naslov");
		Delavec1 delavec1 = new Delavec1("Uros123", "Zoretic123", "naslov123");
		Delavec1 delavec2 = new Delavec1("123", "123priimek", "LOLnaslov");
		
		System.out.println(delavec.getIme() );
		System.out.println(delavec1.getIme() );
		System.out.println(delavec2.getIme() );
		
		delavec.setStUr(78);
		System.out.println(delavec.getStUr() );
		System.out.println(delavec1.getStUr() );
		
		System.out.println("Placa Delavec: " + delavec.izracunajPlaco() );
		
		
		
		
		/*
		String ime1 = "Uros";
		String priimek1 = "Zoretic";
		String naslov1;
		int stUr1;
		
		
		String ime2 = "Uros12";
		String priimek2 = "Zoretic2121";
		String naslov2;
		int stUr2;
		
		*/
	}
	
}