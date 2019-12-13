
public class VsotaElementov {
	//static int vs = 0;
	static int nivo = 0;
	public static int vsota(int[] array, int index, int v) {
		
		//System.out.println("Trenutno vsota: "+vs);
		//ali smo pregledali celoten seznam
		if (index >= array.length){
			System.out.println("Konec: "+v);
			return v;
			//System.out.println(vs);
			// return 0;
		}
		
		else
			/*vs += array[index];
			return vsota(array, index+1); */
			
			v += array[index];
			System.out.println("Pred klicem: "+v);
			// nivo++;
			int n = vsota(array, index + 1, v);
			System.out.println(n);
			// nivo--;
			
			//return v;
			//return v;
			// return array[index] + vsota(array, index + 1, v);
			return n;
	}
		
	public static void main(String[] args) {
		int[] data = {11, 7, 10, 10, 11, 6, 3, 4, 12, 3, 7, 8, 4};

		System.out.print("Vsota stevil ");
		/*for (int i = 0;  i< data.length; i++)
			System.out.print(data[i] + " ");*/
		
		System.out.println("je " + vsota(data, 0, 0));
	}

}
