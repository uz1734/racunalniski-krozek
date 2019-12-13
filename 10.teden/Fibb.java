class Fibb {
	
	public static int fibb(int steveilo) {
		
		System.out.println("-------------------------");
		System.out.println("stKLic: " + steveilo);
		
		if (steveilo <= 1) {
			System.out.println("return: " + steveilo);
			return steveilo;
		}
		
		
		int prvi = fibb(steveilo - 1);
		
		System.out.println("prvi: " + prvi);
		
		int drugi = fibb(steveilo - 2);
		
		System.out.println("drugi: " + drugi);
		
		
		int st = prvi + drugi;
		
		System.out.println("st: " + prvi);
		
		return st;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("dela");
		
		int rs = fibb(5);
		
		System.out.println(rs);
	}
	
}