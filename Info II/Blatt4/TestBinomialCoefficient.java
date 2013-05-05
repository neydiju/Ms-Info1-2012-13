/**
 *  Testklasse fuer die Klasse BinomialCoefficient.
 *  Blatt 4, Aufgabe 13(a), Sommersemester 2013
 */
public class TestBinomialCoefficient {

    /**
     *  Ueberprueft, ob der Konstruktor bei der Erzeugung
     *  keine IllegalArgumentException ausloest.
     *  @param n Parameter n fuer den Konstruktor
     *  @param k Parameter k fuer den Konstruktor
     *  @param expect Erwartetes Verhalten (<code>true</code>: 
     *         es wird keine IllegalArgumentException ausgeloest.
     *  @return <code>true</true> wenn sich der Konstruktor wie
     *         erwartet verhaelt, <code>false</code> sonst.
     */
    public boolean testConstructor(int n, int k, boolean expect) {

	BinomialCoefficient aBinomialCoefficient;
	boolean passed = true;

	try {
	    //  Versuche, ein Objekt mit den gegebenen Parametern
	    //  zu erzeugen.
	    aBinomialCoefficient = new BinomialCoefficient(n, k);
	}
	catch(IllegalArgumentException e) {
	    passed = (expect == false); // Sollte dies passieren?
	}
	catch(Exception e) {
	    passed = false;  //  Jede andere Ausnahme zeugt von einem Problem.
	}

	if (passed == false) {
	    System.out.println("testConstructor(" + n + "," + k + "," 
			       + expect + ") ergab ein Problem."); 
	}

	return passed;
    }

    /**
     *  Ueberprueft, ob das Setzen der Parameter n und k keine
     *  Ausnahmen ausloest.
     *  @param bc Referenz auf gueltiges Objekt der Klasse 
     *         <code>BinomialCoefficient</code>
     *  @param n Parameter n
     *  @param k Parameter k
     *  @param expect Erwartetes Verhalten (<code>true</code>: 
     *         es wird keine IllegalArgumentException ausgeloest.
     *  @return <code>true</true> wenn sich die Selektoren wie
     *         erwartet verhalten, <code>false</code> sonst.
     */
    public boolean testSelector(BinomialCoefficient bc, int n, int k, boolean expect) {

	BinomialCoefficient aBinomialCoefficient;
	boolean passed = true;

	try {
	    //  Versuche, ein Objekt mit den gegebenen Parametern
	    //  zu erzeugen.
	    aBinomialCoefficient = new BinomialCoefficient(n, k);
	}
	catch(IllegalArgumentException e) {
	    passed = (expect == false); // Sollte dies passieren?
	}
	catch(Exception e) {
	    passed = false;  //  Jede andere Ausnahme zeugt von eine, Problem.
	}

	if (passed == false) {
	    System.out.println("testSelector(bc," + n + "," + k + "," 
			       + expect + ") ergab ein Problem."); 
	}

	return passed;
    }

    /**
     *  Ueberprueft, ob sich set- und get-Methoden konsistent verhalten.
     *  @param n Parameter n fuer den Konstruktor
     *  @param k Parameter k fuer den Konstruktor
     *  @return <code>true</true> wenn sich die Methoden wie
     *         erwartet verhalten, <code>false</code> sonst.
     *  @throws IllegalArgumentExeception falls nicht  <code>0<=k<=n</code> gilt.
     */
    public boolean testConsistency(int n, int k) {

	if ((n<0) || (k<0) || (n<k)) {
	    throw new IllegalArgumentException("testConsistency: 0<=k<=n erwartet.");
	}

	BinomialCoefficient aBinomialCoefficient;
	boolean passed = true;

	aBinomialCoefficient = new BinomialCoefficient(n, k);

	passed = passed && (aBinomialCoefficient.getN() == n);
	if (passed == false) {
	    System.out.println("testConsistency(" + n + "," + k + ") "
			       +"ergab ein Problem mit getN()."); 
	}

	passed = passed && (aBinomialCoefficient.getK() == k);
	if (passed == false) {
	    System.out.println("testConsistency(" + n + "," + k + ") "
			       +"ergab ein Problem mit getK()."); 
	}

	aBinomialCoefficient = new BinomialCoefficient(0, 0);
	aBinomialCoefficient.setN(n);
	passed = passed && (aBinomialCoefficient.getN() == n);
	if (passed == false) {
	    System.out.println("testConsistency(" + n + "," + k + ") "
			       +"ergab ein Problem mit setN()."); 
	}

	aBinomialCoefficient = new BinomialCoefficient(n, 0);
	aBinomialCoefficient.setK(k);
	passed = passed && (aBinomialCoefficient.getK() == k);
	if (passed == false) {
	    System.out.println("testConsistency(" + n + "," + k + ") "
			       +"ergab ein Problem mit setK()."); 
	}

	return passed;
    }

    /**
     *  Ueberprueft, ob sich set- und get-Methoden konsistent verhalten.
     *  @param n Parameter n fuer den Konstruktor
     *  @param k Parameter k fuer den Konstruktor
     *  @param expect erwarteter Wert.
     *  @return <code>true</true> wenn die Auswertung den erwarteten Wert
     *         ergibt, <code>false</code> sonst.
     *  @throws IllegalArgumentExeception falls nicht  <code>0<=k<=n</code> gilt.
     */
    public boolean testEval(int n, int k, int expect) {

	if ((n<0) || (k<0) || (n<k)) {
	    throw new IllegalArgumentException("testConsistency: 0<=k<=n erwartet.");
	}

	BinomialCoefficient aBinomialCoefficient = new BinomialCoefficient(n, k);
	boolean passed = true;

	passed = (aBinomialCoefficient.eval() == expect);

	if (passed == false) {
	    System.out.println("testEval(" + n + "," + k + "," + expect +") "
			       +"ergab " + aBinomialCoefficient.eval()); 
	}

	return passed;
    }


    /**
     *  Ueberprueft verschiedene Grenzfaelle der Implementierung.
     */
    public void run() {

	boolean passedAll = true;

	//  Teste Konstruktoren.
	boolean passed = true;
	passed = passed && testConstructor( 2,  1, true);
	passed = passed && testConstructor( 2,  0, true);
	passed = passed && testConstructor( 2, -1, false);
	passed = passed && testConstructor( 2,  3, false);
	passed = passed && testConstructor( -2,  -3, false);
	passed = passed && testConstructor( -2,  1, false);
	passed = passed && testConstructor( 0,  0, true);
	passed = passed && testConstructor( 5,  5, true);

	System.out.println("Tests fuer den Konstruktor bestanden: " + passed );
	passedAll = passedAll && passed;

	//  Teste Selektoren.
	BinomialCoefficient bc;
	passed = true;

	bc = new BinomialCoefficient(4,2);	
	passed = passed && testSelector(bc, 4, 3, true);

	bc = new BinomialCoefficient(4,2);
	passed = passed && testSelector(bc, 4, 4, true);

	bc = new BinomialCoefficient(4,2);
	passed = passed && testSelector(bc, 4, 5, false);
	
	bc = new BinomialCoefficient(4,2);
	passed = passed && testSelector(bc, 4, -2, false);

	bc = new BinomialCoefficient(4,2);
	passed = passed && testSelector(bc, -4, 2, false);

	bc = new BinomialCoefficient(4,2);
	passed = passed && testSelector(bc, 2, 2, true);

	System.out.println("Test 1 fuer die Selektoren bestanden: " + passed );
	passedAll = passedAll && passed;

	//  Teste Konsistenz der Selektoren.
	passed = testConsistency(5,4);
	System.out.println("Test 2 fuer die Selektoren bestanden: " + passed );
	passedAll = passedAll && passed;
	
	//  Teste Werte.
	passed = true;
	
	passed = passed && testEval(4,2,6);
	passed = passed && testEval(4,1,4);
	passed = passed && testEval(4,4,1);
	passed = passed && testEval(4,0,1);

	System.out.println("Test fuer die Auswertung bestanden: " + passed );
	passedAll = passedAll && passed;

	if (passedAll) {
	    System.out.println("*** Alle Tests bestanden: " + passedAll);
	}
	else {
	    System.out.println("*** Nicht alle Tests bestanden: " + passedAll);
	}

    }

    public static void main(String args[]) {
	TestBinomialCoefficient testBC = new TestBinomialCoefficient();
	testBC.run();
    }
}