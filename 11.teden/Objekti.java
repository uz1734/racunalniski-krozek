public class Objekti {
	private static class PrivatenObjektRazreda {
		public static void izpisi() {
			System.out.println("Izpis iz privatnega razreda ");
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("objekti...");
		
		Delavec d=new Delavec();
		
		// vpis vrednosti atributov
		d.vpisiMatSt(234);
		d.vpisiPriimek("Novak");
		d.vpisiIme("Janez");
		d.vpisiStUr(182);
		
		//izpis vsebine objekta s pomočjo posameznih metod
		System.out.println("Matična številka: "+d.vrniMatSt());
		System.out.println("Priimek in ime: "+d.vrniPriimek()+" "+d.vrniIme());
		System.out.println("Število ur: "+d.vrniStUr());
		
		System.out.println("----------------------");
		
		d.izpisiVse();
		
		System.out.println("Bruto OD: "+d.izracunajBrutoOD(1500));
		
		
		System.out.println("----------------------");
		Delavec d2 =new Delavec(236, "Uros", "Zoretic");
		d2.izpisiVse();
		
		System.out.println("PRIVATNO");
		PrivatenObjektRazreda.izpisi();
		
	}
}
