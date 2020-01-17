public class Ulomek{
	
	private int stevec;
	private int imenovalec;
	
	
	public Ulomek(int a, int b){
		if (b < 0){
			a = -a;
			b = -b;
		}
		
		int gcd = gcd(Math.abs(a),Math.abs(b));
		this.stevec = a/gcd;
		this.imenovalec = b/gcd;
	}
	
	public String toString(){
		return String.format("%d/%d", this.stevec, this.imenovalec);
	}
	
	public boolean jeEnakKot(Ulomek u){
		if (this.stevec == u.imenovalec && this.imenovalec == u.imenovalec){
			return true;
		}
		return false;
	}
	
	public Ulomek negacija(){
		Ulomek nov = new Ulomek(-this.stevec, this.imenovalec);
		return nov;
	}
	
	public Ulomek obrat(){
		Ulomek nov = new Ulomek(this.imenovalec, this.stevec);
		return nov;
	}
	
	public Ulomek vsota(Ulomek u){
		Ulomek nov = new Ulomek(this.stevec * u.imenovalec + this.imenovalec * u.stevec, this.imenovalec * u.imenovalec);
		return nov;
	}
	
	public Ulomek razlika(Ulomek u){
		return this.vsota(u.negacija());
	}
	
	public Ulomek zmnozek(Ulomek u){
		Ulomek nov = new Ulomek(this.stevec * u.stevec, this.imenovalec * u.imenovalec);
		return nov;
	}
	
	public Ulomek kolicnik(Ulomek u){
		//return this.zmnozek(u.obrat());
		Ulomek nov = new Ulomek(this.stevec * u.imenovalec, this.imenovalec * u.stevec);
		return nov;
	}
	
	public Ulomek potenca(int eksponent){
		if (eksponent < 0){
			return this.obrat().potenca(-eksponent);
		}
		
		Ulomek rezultat = new Ulomek(1, 1);
		for(int i = 1; i <= eksponent; i++){
			rezultat = rezultat.zmnozek(this);
		}
		
		return rezultat;
	}
	
	public boolean jeManjsiOd(Ulomek u){
		return (this.razlika(u).stevec < 0);
	}
	
	private static int gcd (int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}