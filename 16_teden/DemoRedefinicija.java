class Student {
  private int vpisnaSt;
  private String priimek;
  private String ime;
  
  public void vpisiVpisnaSt(int vpisnaSt) {
    this.vpisnaSt=vpisnaSt;
  }
  public void vpisiPriimek(String priimek) {
    this.priimek=priimek;
  }
  public void vpisiIme(String ime) {
    this.ime=ime;
  }

  public int vrniVpisnaSt() {
    return vpisnaSt;
  }
  public String vrniPriimek() {
    return priimek;
  }
  public String vrniIme() {
    return ime;
  }
  
  public void izpisiVse() {
    System.out.println("Vpisna stevilka: "+vpisnaSt);
    System.out.println("Priimek in ime: "+priimek+" "+ime);
  }
}

class IzredniStudent extends Student {
  private int solnina;
  @Override
  public void izpisiVse() {
	  
    
    // System.out.println("Vpisna stevilka: "+this.vrniVpisnaSt());
    // System.out.println("Priimek in ime: "+vrniPriimek()+" "+vrniIme());
    
	// System.out.println("Hello world");
	
    super.izpisiVse();  // predpona super se nanasa na metode, ki so bile sprogramirane v nadrazredu. Ubistvo poklice vse iste.
    System.out.println("Solnina: "+solnina);
  }
  
  public void vpisiSolnina(int solnina) {
    this.solnina=solnina;
  }
  public int vrniSolnina() {
    return solnina;
  }
}

class DemoRedefinicija {
  public static void main(String[] args) {
    Student s=new Student();
    s.vpisiVpisnaSt(63150999);
    s.vpisiPriimek("Novak");
    s.vpisiIme("Janez");
    s.izpisiVse(); 
	
	System.out.println();

    IzredniStudent is=new IzredniStudent();
    is.vpisiVpisnaSt(63150888);
    is.vpisiPriimek("Petek");
    is.vpisiIme("Peter");
    is.vpisiSolnina(1200);
    is.izpisiVse();
  }
}