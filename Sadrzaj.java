package raspored;

public abstract class Sadrzaj 
{
	protected Vreme pocetak=new Vreme();
	protected Vreme trajanje;
	private String naziv;
	protected Vreme kraj;
	private char vrsta;
	public Sadrzaj(Vreme trajanje, String naziv) {
		super();
		this.trajanje = trajanje;
		this.naziv = naziv;
	}
	
	public void postaviPocVreme(Vreme poc)
	{
		pocetak=poc;
	}
	
	
	public String dohvIme()
	{
		return naziv;
	}
	
	public Vreme dohvTrajanje()
	{
		return trajanje;
	}
	
	public Vreme dohvKraj()throws GVreme
	{
		return kraj = Vreme.saberi(pocetak, trajanje);
	}
	
	public abstract Vreme preklapaSe(Sadrzaj s);
	
	public char vrsta() {
		return vrsta;
	}
	
	public void pomeri(Vreme p)throws GVreme
	{
		this.pocetak=Vreme.saberi(this.pocetak, p);
	}
	
	
	public Vreme dohvPocetak()
	{
		return pocetak;
	}
	
	public String toString() {
		return vrsta + ","+naziv+"|"+pocetak+"-"+kraj;
	}
}
