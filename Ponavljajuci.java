package raspored;

public class Ponavljajuci extends Sadrzaj{
	private Vreme ponavljanje;
	int jedandan = 24 * 60;

	public Ponavljajuci(String naziv, Vreme trajanje, Vreme ponavljanje){
		super(trajanje, naziv);
		this.ponavljanje = ponavljanje;
		
	}

	public String toString() {
		return super.toString()+ " T" +  ponavljanje;
	}
	
	public char vrsta() {
		return 'P';
	}
	
	public Vreme getPonavljanje()
	{
		return ponavljanje;
	}
	

public Vreme preklapaSe(Sadrzaj p) {

	int p1 = this.dohvPocetak().minuti();
	int p2 = p.dohvPocetak().minuti();
	
	int k1 = p1 + this.dohvTrajanje().minuti();
	int k2 = p2 + p.dohvTrajanje().minuti();
	
	int pr1 = this.getPonavljanje().minuti();
	int pr2 = ((Ponavljajuci)p).getPonavljanje().minuti();
	


	try {
		while (k1<=jedandan && k2<=jedandan) {
			if (p1 < p2) {
				if (p2 < k1) 
					return new Vreme(p2/60, p2%60);
				else 
					p1 = p1+pr1;
					k1 = k1+pr1;
				
			} else if (p1 > p2) {
				if (p1 < k2)
					return new Vreme(p1/60, p1%60);
			  else 
					p2 = p2+pr2;
					k2 = k2+pr2;
			} else 
				return new Vreme(p1/60, p1%60);
		}
	} catch (GVreme e) {}
	return null;
}



}
