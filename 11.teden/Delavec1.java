import java.util.*;
public class Delavec1 {
	private String ime;
	private String priimek;
	private String naslov;
	private int stUr;
	private int urnaPostavka = 10;
	
	public Delavec1(String ime123, String priimek123, String naslov123) {
		System.out.println("LOL");
		this.ime = ime123;
		this.priimek = priimek123;
		this.naslov = naslov123; 
	}
	
	public String getIme() {
		return this.ime;
	}
	
	public void setStUr(int ure) {
		this.stUr = ure;
	}
	
	public int getStUr() {
		return this.stUr;
	}
	
	public int izracunajPlaco() {
		// 
		return this.urnaPostavka * this.stUr;
	}
	
}