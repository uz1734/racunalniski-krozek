
interface ImeInterfaca {
	public void izpisi();
}

interface DrugInterface extends ImeInterfaca {
	public void povej();
}

class Prvi implements ImeInterfaca {
	
	public void izpisi() {
		System.out.println("IP1");
	}
}


class Drugi implements DrugInterface {
	public void izpisi() {
		System.out.println("IP2");
	}
	
	public void povej() {
		System.out.println("Govori");
	}
}


public class InterfaceDemo {
	
	public static void lastnosti(ImeInterfaca ime) {
		ime.izpisi();
	}
	
	public static void lastnosti2(DrugInterface drugiI) {
		drugiI.povej();
	}
	
	public static void main(String[] args) {
		
		Prvi prvi = new Prvi();
		// prvi.izpisi();
		
		Drugi drugi = new Drugi();
		// drugi.izpisi();
		
		lastnosti(prvi);
		lastnosti(drugi);
		
		
		lastnosti2(drugi);
	}
	
}