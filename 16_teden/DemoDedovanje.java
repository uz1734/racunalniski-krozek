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
}

class IzredniStudent extends Student {  //beseda extends se nanasa na to, da razsiri razred student na nekaj vec.
  private int solnina;
  
  public void vpisiSolnina(int solnina) {
    this.solnina=solnina;
  }
  public int vrniSolnina() {
    return solnina;
  }
}

class DemoDedovanje {
  public static void main(String[] args) {
    Student s = new Student();
    s.vpisiVpisnaSt(63150999);
    s.vpisiPriimek("Novak");
    s.vpisiIme("Janez");
    System.out.println(s.vrniVpisnaSt()+" "+s.vrniPriimek()+" "+s.vrniIme());
	
    IzredniStudent is = new IzredniStudent();
    is.vpisiVpisnaSt(63150888);
    is.vpisiPriimek("Petek");
    is.vpisiIme("Peter");
    is.vpisiSolnina(1200);
    System.out.println(is.vrniVpisnaSt()+" "+is.vrniPriimek()+" "+is.vrniIme()+" "+is.vrniSolnina());
  }
}