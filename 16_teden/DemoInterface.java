import java.io.*;

interface ZivalInterface {
	
	int a = 2;
	
	public void pojej();
	public void premakniSe();
}


class Mamut implements ZivalInterface {
	
	Mamut() {
			
		System.out.println("staticna spremenljivka: " 
		+  Integer.toString(this.a));
	}
	
	@Override
	public void pojej() {
		System.out.println("Mamut zeli hrano");
	}
	
	@Override
	public void premakniSe() {
		System.out.println("Mamut se premika");
	}
}

class Pes implements ZivalInterface {
	
	Pes() {	
	}
	@Override
	public void pojej() {
		System.out.println("Pes zeli hrano");
	}
	
	@Override
	public void premakniSe() {
		System.out.println("Pes se premika");
	}
}


public class DemoInterface {
	
	public static void prehranjujZival(ZivalInterface zival) {
		zival.pojej();
	}
	
	public static void premikajZival(ZivalInterface zival) {
		zival.premakniSe();
	}
	
	
	public static void main(String[] args) {
		Mamut mamut = new Mamut();
		
		// mamut.pojej();
		// mamut.premakniSe();
		
		Pes pes = new Pes();
		// pes.pojej();
		// pes.premakniSe();
		
		prehranjujZival(mamut);
		prehranjujZival(pes);
		System.out.println();
		
		premikajZival(pes);
		premikajZival(mamut);
		
	}
}