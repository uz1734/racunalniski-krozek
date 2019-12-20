import java.util.*;
public class Delavec {
  // atributi
	private int matStev;
	private String priimek;
	private String ime;
	private int stUr;
	
	public Delavec (int ms, String p, String i) {
		matStev = ms;
		priimek = p;
		ime = i;
	}
	
	public Delavec(){
	}
	
	// metode
	public void vpisiMatSt(int st)	{
		matStev=st;
	}
	public void vpisiPriimek(String p)	{
		priimek=p;
	}
	public void vpisiIme(String i){
		ime=i;
	}		
	public void vpisiStUr(int u) {
		stUr=u;
	}
	public int vrniMatSt() {
		return matStev;
	}
	public String vrniPriimek() {
		return priimek;
	}
	public String vrniIme() {
		return ime;
	}
	public int vrniStUr() {
		return stUr;
	}
	public int izracunajBrutoOD(int cenaUre) {
		return stUr*cenaUre;
	}
	public void izpisiVse(){
		System.out.println("Maticna stevilka: "+matStev);
		System.out.println("Priimek in ime: "+priimek+' '+ime);
		System.out.println("Stevilo ur: "+stUr);
	}
}