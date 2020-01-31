public class Ulomek{
	
	public int stevec;
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
		return Integer.toString(this.stevec) + "/" + Integer.toString(this.imenovalec);
	}
	
	public boolean jeEnakKot(Ulomek u) {
		if (this.stevec == u.stevec && this.imenovalec == u.imenovalec) {
			return true;
		}
		
		return false;
		
	}
	
	public Ulomek negacija() {
		return new Ulomek(-this.stevec, this.imenovalec);
	}
	
	public Ulomek obrat() {
		return new Ulomek(this.imenovalec, this.stevec);
	}
	
	public Ulomek vsota(Ulomek u) {	
		return new Ulomek( this.stevec * u.imenovalec + this.imenovalec * u.stevec, this.imenovalec * u.imenovalec );
	}
	
	public Ulomek razlika(Ulomek u) {
		return this.vsota(u.negacija());
	}
	
	public Ulomek zmnozek(Ulomek u) {
		return new Ulomek(this.stevec * u.stevec, this.imenovalec * u.imenovalec);
	}
	
	public Ulomek kolicnik(Ulomek u) {
		return this.zmnozek(u.obrat());
	}
	
	public Ulomek potenca(int eksponent) {
		
		if (eksponent < 0) {
			return this.obrat().potenca(-eksponent);
		}
		
		Ulomek rs = new Ulomek(1, 1);
		for (int i = 1; i <= eksponent; i++ ) {
			rs = rs.zmnozek(this);
		}
		
		return rs;
	}
	
	public boolean jeManjsiOd(Ulomek u) {
		Ulomek razlika = this.razlika(u);
		
		if (razlika.stevec < 0) {
			return true;
		}	
		return false;
	}
	
	
	// great common devisor .... recursion function..
	private static int gcd (int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}