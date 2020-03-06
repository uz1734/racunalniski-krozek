
abstract class Clovek {
	
	String priimek;
	String ime;
	
	public void izpisi() {
		System.out.println("INSIDE abstrct");
		System.out.println(this.priimek + " " + this.ime);
	}
	
	abstract public void nastaviPriimek(String p);
}

class Dijak extends Clovek {
	int vpisnaStevilka;
	
	public Dijak(String priimek, String ime, int vpisnaStevilka) {
		this.priimek = priimek;
		this.ime = ime;
		this.vpisnaStevilka = vpisnaStevilka;
	}
	
	public void nastaviPriimek(String p) {
		this.priimek = p;
		System.out.println("DIJAK");
	}
	
}

class Student extends Clovek {
	int vpisnaStevilka;
	
	public Student(String priimek, String ime, int vpisnaStevilka) {
		this.priimek = priimek;
		this.ime = ime;
		this.vpisnaStevilka = vpisnaStevilka;
	}
	
	public void nastaviPriimek(String p) {
		this.priimek = p;
	}
	
	public void nastaviIme(String p) {
		this.ime = p;
	}
	
	public void nastavVpisnoSt(int vpisna) {
		this.vpisnaStevilka = vpisna;
	}
	
	public void izpisi() {
		System.out.println("INSIDE");
		System.out.println(this.priimek + " " + this.ime + " " + this.vpisnaStevilka);
	}
}

class IzredniStudent extends Student {
	int vpisnina;
	
	public IzredniStudent(String priimek, String ime, int vpisnaStevilka, int vpisnina) {
		super(priimek, ime, vpisnaStevilka);
		this.vpisnina = vpisnina;
	}
	
	public void nastaviVpisnino(int vp) {
		this.vpisnina = vp;
	}
	
	@Override
	public void izpisi() {
		super.izpisi();
		System.out.println("podrazred");
		System.out.println(this.vpisnina);
	}
	
}



public class DemoStudent {
	
	public static void povejLastnosti(Clovek clovek) {
		clovek.izpisi();
	}
	
	public static void main(String[] args) {
		
		Clovek clovek;
		
		Student student = new Student("Zoretic", "Uros", 123);
		/*student.nastavVpisnoSt(1234);
		student.nastaviPriimek("Uros");
		student.nastaviIme("Zoretic");*/
		
		// student.izpisi();
		
		IzredniStudent izredniStudent = new IzredniStudent("Zoretic", "Uros", 123, 10);
		//izredniStudent.nastavVpisnoSt(1234);
		/*izredniStudent.nastaviPriimek("Uros");
		izredniStudent.nastaviIme("Zoretic");
		izredniStudent.nastaviVpisnino(10);*/
		System.out.println();
		// izredniStudent.izpisi();
		
		
		Dijak dijak = new Dijak("dijak 1", "2", 212122);
		// dijak.izpisi();
		
		povejLastnosti(student);
		povejLastnosti(dijak);
		povejLastnosti(izredniStudent);
		
		/*clovek = student;
		clovek.izpisi();
		clovek = izredniStudent;
		clovek.izpisi();
		clovek = dijak;
		clovek.izpisi();*/
		
	}
	
}