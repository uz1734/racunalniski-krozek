class Tabele1 {
	public static void main(String[] args) {
		
		int[] tabela = new int[3];
		tabela[0] = 4;
		
		
		// System.out.println(tabela.length);
		
		/*for (int i = 0; i < tabela.length; i++) {
			System.out.println(tabela[i]);
		}*/
		izpisTabele(tabela);
		
		tabela[1] = tabela[0];
		
		tabela[3 - 1]
		
		izpisTabele(tabela);
		
		/*for (int i = 0; i < tabela.length; i++) {
			System.out.println(tabela[i]);
		}*/
	}
	
	public static void izpisTabele(int[] tabelaIzpis) {
		for (int i = 0; i < tabelaIzpis.length; i++) {
			System.out.println(tabelaIzpis[i]);
		}
	}
}