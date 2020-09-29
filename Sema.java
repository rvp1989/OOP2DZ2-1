package raspored;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Sema {
	
	private String naziv;
	private Vreme pocetak;
	private Vreme kraj;

	private ArrayList<Sadrzaj> progSad;
	
	public Sema(String n,Vreme p,Vreme k){
		naziv = n;
		pocetak=p;
		kraj=k;
		progSad = new ArrayList<Sadrzaj>();
	}
	
	public Sema(String n)
	{
		naziv=n;
			try {
				this.pocetak=new Vreme(8,0);
			} catch (GVreme e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				this.kraj=new Vreme(22,0);
			} catch (GVreme e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public double zauzetost()
	{
		double sum=0;
		return sum;
	}
	
	
	public void dodaj(Sadrzaj s1) throws GDodaj {
		Vreme start0 = s1.dohvPocetak();
		Vreme start = start0;
		
		Vreme trajanjee = s1.dohvTrajanje();
		
		Vreme kra = Vreme.saberi(start,  trajanjee);
		
		if (kra.minuti() >= kraj.minuti()) { 
			throw new GDodaj();
		}
		int indeks = 0;
		while (s1.dohvPocetak().minuti()>=progSad.get(indeks).dohvPocetak().minuti())
			indeks++;
		progSad.add(indeks, s1);
		
	}
	
	
	public int brSadrzaja() {
		int k;
		k=progSad.size();
		return k;
	}
	
	public Sadrzaj getSema(int index) throws GIndeks{
		int brSema = brSadrzaja();
		if(index > brSema || index < 0 || progSad.size()<index) {
			throw new GIndeks();
		}
		else {
			return progSad.get(index);
		}
	}
	
	public Vreme getKraj() {
		return kraj;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public Vreme getPocetak() {
		return pocetak;
	}
	
	public String toString() {
		String vrati = "";
		
		vrati += this.getNaziv() +  " : " + this.getPocetak() + " - " + this.getKraj() + "\n";
		for (Sadrzaj s : progSad) {
			vrati += s+"\n";
		}
		return vrati;
	}
	
}