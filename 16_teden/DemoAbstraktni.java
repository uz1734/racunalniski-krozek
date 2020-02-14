//Ne morem kreirat novega objekta tipa zival, saj imam notri abstraktno metodo, ki nam to preprecuje.
//Lahko pa kreiram tip zival v nekem aplikacijskem razredu.

abstract class Zival {
  private String ime;
  
  public Zival(String imeZivali) {  //Osnovni konstruktor za ime zivali...
    ime=imeZivali;
  }
  
  public String vrniIme() {   //metoda za izpis zivali.
    return ime;
  }
  public abstract void oglasanje();  //abstraktna globalna metoda, ki mora biti uporabljena v seh ostalih podrazredih.
}

class Pes extends Zival {

  public Pes(String imePsa) {
    super(imePsa);
  }
  @Override
  public void oglasanje() {
    System.out.println("hov, hov");
  }
}

class Macka extends Zival {

  public Macka(String imeMacke) {
    super(imeMacke);
  }
  @Override
  public void oglasanje() {
    System.out.println("mjav, mjav");
  }
}

class Krava extends Zival {

  public Krava(String imeKrave) {
    super(imeKrave);
  }
  public void oglasanje() {
    System.out.println("Muuuu");
  }
}

class DemoAbstraktni {
  public static void main(String[] args) {
	  Zival z;  //Staticni tip, ki se navede na zacetku ob deklaraciji.
	  
	  //Kreiranje novih objekotv v aplikacijskem razredu
	  Pes p = new Pes ("Fifi");  
	  Macka m = new Macka ("Miki");
	  Krava k = new Krava ("Lisa");
	  
	  //Dinamicni tipi, ki so doloceni ob izvajanju. 
	  //Imajo sposobnost da se izvede tista metoda, ki ustreza trenutnemu dinamicnemu tipu.
	  z = p;
	  z.oglasanje();
	  z = m;
	  z.oglasanje();
	  z = k;
	  z.oglasanje();
	  
	  
	  
	  Zival[] tabelaZival=new Zival [3];
	  tabelaZival[0] = p;
	  tabelaZival[1] = m;
	  tabelaZival[2] = k;
	  
	  System.out.println();
	  System.out.println("DINAMICNE TABELE");
	  for (Zival z1 : tabelaZival) {
		  System.out.println(z1.vrniIme());
		  z1.oglasanje();
		  System.out.println("--------");
	  }
	  
	  
	  
   /* Pes p=new Pes("Fifi");
    Macka m=new Macka("Miki");
    Krava k=new Krava("Liska");
	
    System.out.print(p.vrniIme()+" se oglasa ");
    p.oglasanje();
	
    System.out.print(m.vrniIme()+" se oglasa ");
    m.oglasanje();
	
    System.out.print(k.vrniIme()+" se oglasa ");
    k.oglasanje();*/
  }
}