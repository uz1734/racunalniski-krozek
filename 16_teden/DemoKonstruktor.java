class Student {
  private int vpisnaSt;
  private String priimek;
  private String ime;
  
  //dodamo svoj nov konstruktor v razred Student.
  public Student(int vpisnaSt, String priimek, String ime) {
    this.vpisnaSt=vpisnaSt;
    this.priimek=priimek;
    this.ime=ime;
  }
  //
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
  
  public IzredniStudent(int vpisnaSt, String priimek, String ime, int solnina) {
    super(vpisnaSt,priimek,ime);  //S tem klicem poklicemo vse paramtre, ki jim ima nadrazred Student.
    this.solnina=solnina;  //Dodamo svoj parameter v konstruktorju v podrazredu.
  }
  
  @Override
  public void izpisiVse() {
    /*
    System.out.println("Vpisna stevilka: "+vrniVpisnaSt());
    System.out.println("Priimek in ime: "+vrniPriimek()+" "+vrniIme());
    */
    super.izpisiVse();
    System.out.println("Solnina: "+solnina);
  }
  
  public void vpisiSolnina(int solnina) {
    this.solnina=solnina;
  }
  public int vrniSolnina() {
    return solnina;
  }
}

class DemoKonstruktor {
  public static void main(String[] args) {
    Student s=new Student(63150999,"Novak","Janez");
    s.izpisiVse();
	
	System.out.println("--------------------");
	
    IzredniStudent is=new IzredniStudent(63150888,"Petek","Peter",1200);
    is.izpisiVse();
  }
  
}