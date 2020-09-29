package raspored;


public class Vreme {
	private int h;
	private int min;
	
	public Vreme() 
	{
	}
	
	public Vreme(int h, int min) throws GVreme {
		if(h < 0 || h > 23 || min < 0 || min > 59 || (min % 15 != 0))
		{
			throw new GVreme();
		}
			this.h = h;
			this.min = min;
	}
	
	 public static Vreme saberi(Vreme t1,Vreme t2 ) 
		{
		int tt1=t1.h*60+t1.min;
		int tt2=t2.h*60+t2.min;
		
		int minuti = tt1+tt2;
		 
		 Vreme vreme = new Vreme();
		 
		 vreme.h=minuti/60;
		 vreme.min=minuti%60;
		 
		 return vreme;
		 
		}
	  
	 
	 public boolean equals(Object o)
	 {
		 if(o==this)
		 {
			 return true;
		 }
		 if(!(o instanceof Vreme))
			 return false;
		 Vreme v =(Vreme)o;
		 boolean u;
		 u=((h-v.h == 0)&&(min-v.min == 0));
		 return u;
		 
	 }
	 
	public int minuti()
	{
		return h*60+min;
	}
	 
	
	public int getH() {
		return h;
	}
	
	public String toString() {
		return "(" + h + ":" + min + ")";
	}
}


