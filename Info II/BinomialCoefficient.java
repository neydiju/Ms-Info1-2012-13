/**
 *  Uebungsgruppe G04-C
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  Klasse zur Repraesentation eines Binomialkoeffizienten.
 *  Blatt 4, Aufgabe 13(a), Sommersemester 2013
 */
public class BinomialCoefficient {
  
	//Attribute
 	//---------
 	private int n;
 	private int k;
 
 	
 	//Konstruktoren
 	//-------------
 	/**
     *  Default-Konstruktor.
     *  erzeugt ein Objekt zur Repraesentation eines Binomialkoeffizienten von 1 mit n = k = 0
     *
     *  @throws IllegalArgumentException falls n und/oder k falsch gewaehlt sind
    */
    public BinomialCoefficient() throws IllegalArgumentException {
    	this(0, 0);
    }
    
    /**    
     *  Konstruktor erzeugt ein Objekt zur Repraesentation eines Binomialkoeffizienten aus den
     *  uebergeben Werten
     *
     *  @param n Wert fuer n (über k)
     *  @param k Wert fuer k
     *  @throws IllegalArgumentException falls n und/oder k falsch gewaehlt sind
     */
    public BinomialCoefficient(int n, int k) throws IllegalArgumentException {
    	if (isLegal(n) && isLegal(k)) {
    		this.n = n;
    		this.k = k;
    	}
    	else {
    		throw new IllegalArgumentException("n und k müssen aus den natürlichen Zahlen sein und n<=k!");
    	}
    }
    
    /**
     *  Copy-Konstruktor.
     *  Erzeugt aus einem uebergebenen Binomialkoeffizienten einen Neuen
     *  
     *  @param koeffizient Der Binomialkoeffizient der kopiert werden soll
     *  @throws IllegalArgumentException falls n und/oder k falsch gewaehlt sind
     */
    public BinomialCoefficient(BinomialCoefficient koeffizient) throws IllegalArgumentException {
    	this(koeffizient.n, koeffizient.k);
    }
 	
 	//Methoden
 	//--------
    //Getter/Setter
    /**
     *  Liefert den Wert von n
     */
    public int getN() {
    	return this.n;
    }
    
    /**
     *  Liefert den Wert von k
     */
    public int getK() {
    	return this.k;
    }
    
    /**
     *  Setzt den Wert von n
     *
     *  @param n neuer Wert für n
     *  @throws IllegalArgumentException falls n und/oder k falsch gewaehlt sind
     */
    public void setN(int n) throws IllegalArgumentException {
    	if (isLegal(n) && isLegal(k)) {
    		this.n = n;
    	}
    	else {
    		throw new IllegalArgumentException("n und k müssen aus den natürlichen Zahlen sein und n<=k!");
    	}
    }
    
    /**
     *  Setzt den Wert von k
     *
     *  @param n neuer Wert für k
     *  @throws IllegalArgumentException falls n und/oder k falsch gewaehlt sind
     */
    public void setK(int k) throws IllegalArgumentException {
    	if (isLegal(n) && isLegal(k)) {
    		this.k = k;
    	}
    	else {
    		throw new IllegalArgumentException("n und k müssen aus den natürlichen Zahlen sein und n<=k!");
    	}
    }
 
 
    //sonstige Methoden
    /**
     *  bestimmt den Wert des repraesentierten Binomialkoeffizienten
     */
    public int eval() {
    	//Parameter sind gueltig, sonst waeren sie nicht gesetzt worden
    	if (n == k || k == 0) {
    		return 1;
    	}
    	else {
    		//(n-1 ueber k-1) + (n-1 ueber k)
    		//mit (n ueber k) = n!/(k! * (n-k)! für n aus N
    		return ( (fak(n-1) / (fak(k-1)*fak(n-k))) + (fak(n-1) / (fak(k)*fak((n-1)-k))) );
    	}
    }
     
    //Hilfsmethoden
    /**
     *  Prueft ob der Parameter gueltig, d.h. aus den natuerlichen Zahlen ist und n <= k
     *
     *  @param num die zu pruefende Zahl
     */
    private boolean isLegal(int num){
    	if (n<=k && n>=0 && k>=0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     *  Berechnet die Fakultät einer Funktion
     *
     *  @param number Zahl zu der die Fakultät gebildet werden soll
     */
    private int fak(int number) {
    	int product = 0;
    	for (int i=1; i<=number; i++) {
    		product *= number-i;
    	}
    	return product;
    }
    
    /**
     *  HIlfsfunktion zur Endrukirsiven Berchnung von fak
     *
     *  @
     */
   /* private fakInternal(int number, int product)
    	if (number <= 0) {
    		return product;
    	}
    	else {
    		fakInternal(number-1, product*number);
    		return product;
    	}
    } */
    
}
