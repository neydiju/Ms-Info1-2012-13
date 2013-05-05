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
    */
    public BinomialCoefficient() {
    	this(0, 0);
    }
    
    /**    
     *  Konstruktor erzeugt ein Objekt zur Repraesentation eines Binomialkoeffizienten aus den
     *  uebergeben Werten
     *
     *  @param n Wert fuer n (über k)
     *  @param k Wert fuer k
     */
    public BinomialCoefficient(int n, int k) {
    	##gültig?
    	this.n = n;
    	this.k = k;
    }
    
    /**
     *  Copy-Konstruktor.
     *  Erzeugt aus einem uebergebenen Binomialkoeffizienten einen Neuen
     *  
     *  @param koeffizient Der Binomialkoeffizient der kopiert werden soll
     */
    public BinomialCoefficient(BinomialCoefficient koeffizient) {
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
     */
    public int setN(int n) {
    	##gültig
    	this.n = n;
    }
    
    /**
     *  Setzt den Wert von k
     *
     *  @param n neuer Wert für k
     */
    public int setK(int k) {
    	##gültig
    	this.k = k;
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
    		n!/(k! * (n-k)! oder pi von 1 bis k ( n+1-i / i )
    	}
    }
     
    //Hilfsmethoden
    /**
     *  Prueft ob der Parameter gueltig, d.h. aus den natuerlichen Zahlen ist und n <= k
     *
     *  @param num die zu pruefende Zahl
     */
    public isLegal(Number num){
    	if is
    }
    
    /**
     *  Berechnet die Fakultät einer Funktion
     *
     *  @param number Zahl zu der die Fakultät gebildet werden soll
     */
    public 
    
}
