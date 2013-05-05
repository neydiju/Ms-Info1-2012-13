/**
 *  Uebungsgruppe G04-C
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  Auswertung eines Binomialkoeffizienten ohne Rekursion.
 *  Blatt 4, Aufgabe 13(b), Sommersemester 2013
 */
public class RecursionlessBinomialCoefficient {

    /**
     *  Berechne den Wert eines Binomialkoeffizienten mit Hilfe
     *  eines iterativen Verfahrens unter Verwendung eines Stapels.
     *  Gib zusaetzliche Informationen aus, wenn ein entsprechender
     *  Parameter gesetzt ist. Es erfolgt keine zusaetzliche 
     *  Ueberpruefung der Parameter, da dies bereits im Konstruktor
     *  der Klasse <code>BinomialCoefficient</code> abgefangen wird.
     *  @param n Parameter n fuer den Binomialkoeffizienten
     *  @param k Parameter k fuer den Binomialkoeffizienten
     *  @param print Zusaetzliche Informationen werden genau dann
     *         ausgegeben, wenn dieser Parameter den Wert <code>true</code> hat.
     *  @return berechneter Wert des Binomialkoeffizienten
     */
    public int eval(int n, int k, boolean print) {

		int z = 0;
	
		//1. Stapel mit Anfangsproblem initialisieren
		Stapel stapel = new Stapel();
		stapel.push(n);
		stapel.push(k); //k ist oben
	
		if (print) System.out.println("--- Berechne: ("+n+" "+k+")");

	
		//2.Solange Stapel nicht leer, folgende Schritte
		while ( !stapel.isEmpty() ) {
//System.out.println("!stapel.isEmpty() = "+!stapel.isEmpty());
			//n und k speichern
			int actK = (Integer) stapel.top();	//k
			stapel.pop();					//n zugäglich machen
			int actN = (Integer) stapel.top();	//n
			stapel.push(actK);				//Stapel wiederherstellen
//System.out.println("actN = "+actN);
//System.out.println("actK = "+actK);
		
			//2.a Oberstes Problem von S bearbeiten
			if (actK == 0 || actN == actK) {	//wenn k = 0 ist oder n = k ist,
				z++;							//ist der Binomialkoeffizienten laut Def.  1
//System.out.println("z = "+z);
				if (print) {printStack(stapel);}	//Stapel ausgeben, wenn gefordert
				stapel.pop(); 			//dieses k entfernen
				stapel.pop();			//zugehoeriges n entfernen, da Problem geloest
//System.out.println("nach pop");
//printStack(stapel);
			}
		
			//2.b Teilprobleme auf S ablegen
			else {
//System.out.println("in 2b");
				stapel.pop();
				stapel.pop();
				stapel.push(actN-1);
				stapel.push(actK);
				stapel.push(actN-1);
				stapel.push(actK-1);
//printStack(stapel);
			}
		}

		return z;


    }

    /**
     *  Ueberpruefe, ob die Methode eval das gleiche Ergebnis
     *  liefert wie <code>BinomialCoefficient.eval</code>.
     *  Gib zusaetzliche Informationen aus, wenn ein entsprechender
     *  Parameter gesetzt ist. Es erfolgt keine zusaetzliche 
     *  Ueberpruefung der Parameter, da dies bereits im Konstruktor
     *  der Klasse <code>BinomialCoefficient</code> abgefangen wird.
     *  @param n Parameter n fuer den Binomialkoeffizienten
     *  @param k Parameter k fuer den Binomialkoeffizienten
     *  @param print Zusaetzliche Informationen werden genau dann
     *         ausgegeben, wenn dieser Parameter den Wert <code>true</code> hat.
     *  @return <code>true</code>, falls die Ergebnisse uebereinstimmen,
     *          <code>false</code> sonst.
     */
    public boolean testEval(int n, int k, boolean print) {

		boolean passed = true;
		BinomialCoefficient bnc = new BinomialCoefficient(n, k);

		int vergleichswert = bnc.eval();
		int wert           = eval(n, k, print);

		if (wert != vergleichswert) {
			System.out.println("testEval(" + n + "," + k + "," + print + ") "
					   + "ergab " + wert + " an Stelle von " 
					   + vergleichswert + "."); 
			passed = false;
		}

		return passed;

    }

    //Hilfsmethoden
    /**
     *  Gibt den Inhalt des Stapels in Pärchen aus
     *
     *  @param stack Der Stapel der ausgegeben werden soll
     */
    public void printStack(Stapel stack) {
		//Stapel fuer umgekehrte Reihenfolge
		Stapel copyN = new Stapel();
    	Stapel copyK = new Stapel();    
    	//copy in umgekehrter Reihenfolge füllen
    	while (!stack.isEmpty()) {
    		copyK.push(stack.top());
    		stack.pop();
    		copyN.push(stack.top());
    		stack.pop();		
    	}
    
    	//Inhalt ausgeben und stack wieder auffüllen
    	while(!copyK.isEmpty() || !copyN.isEmpty()) {
    		System.out.print("("+copyN.top()+" "+copyK.top()+") ");
    		stack.push(copyN.top());
    		stack.push(copyK.top());
    		copyN.pop();
    		copyK.pop();
    	}
    	
    	System.out.println();    	
    }
    

    /**
     *  Ueberprueft verschiedene Grenzfaelle der Implementierung.
     */
    public void run() {

		//eval(3,1,true);

		boolean passed = true;
		boolean passedAll = true;

		passed = passed && testEval(10,5,true);
		passedAll = passedAll && passed;

		passed = passed && testEval(9,9,true);
		passedAll = passedAll && passed;

		passed = passed && testEval(5,3,true);
		passedAll = passedAll && passed;

		if (passedAll) {
			System.out.println("*** Alle Tests bestanden: " + passedAll);
		}
		else {
			System.out.println("*** Nicht alle Tests bestanden: " + passedAll);
		}
    }


    public static void main(String[] args) {
	RecursionlessBinomialCoefficient rbc = new RecursionlessBinomialCoefficient();
	rbc.run();	
    }
}
