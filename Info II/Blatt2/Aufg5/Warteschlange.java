/**
 *  Uebungsgruppe G04-C
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  1./2 Klassen zur Loesung zu Aufgabe 5 / Blatt 2 / Sommersemester 2013.
 *
 *  Realisierung des ADT Queue
 *  Die Implementierung greift auf die Klasse
 *  <code>Stapel<T></code> zurueck.
 */
 
 public class Warteschlange<T> implements ADTQueue<T> {
 	
 	//Attribute
 	//---------
 	private Stapel stapelEnqueue;	//Letztes Element der Warteschlange/tail ist oben 
 	private Stapel stapelDequeue;	//Erstes  Element der Warteschlange/head ist oben
 							//									-> umgekehrte Reihenfolge
 	//es gibt intern kein richtiges Warteschlangen-Objekt,
 	  // sondern es wird durch die 2 Stapel realisiert
 	
 	
 	//Konstruktoren
 	//-------------
 	/**
     *  Default-Konstruktor.
     *  Das <code>stapelEnqueue</code>-Attribut und das <code>stapelDequeue</code>-Attribut
     *  werden als leere Stapel initialisiert.
     */
    public Warteschlange() {
		//Erzeuge einen leeren Stapel in der Reihenfolge des Anfügens   der Elemente
		stapelEnqueue = new Stapel();
		//Erzeuge einen leeren Stapel in der Reihenfolge des Entfernens der Elemente
		stapelDequeue = new Stapel();
    }
    
    /**
     *  Copy-Konstruktor.
     *  Erzeugt aus einer uebergebenen Warteshclange eine neue
     *  Ist von der SIgnatur jedoch nicht vorgesehen!! Sollte aber keine Probleme als zusätzliche
     *  Schnittstelle geben.
     *  
     *  @param queue Die Warteschlange die kopiert werden soll
     */
    public Warteschlange(Warteschlange queue) {
    	//Erzeuge einen Stapel in der Reihenfolge des Anfügens   der Elemente aus der Uebergabe
		stapelEnqueue = queue.getStapelEnqueue();
		//Erzeuge einen Stapel in der Reihenfolge des Entfernens der Elemente aus der Uebergabe
		stapelDequeue = queue.getStapelDequeue();
    }
 	
 	
 	//Methoden
 	//--------
 	
 	//Getter:
 	//Setter sind nicht noetig, da, bis auf den Copy-Konstruktor, nicht über getter oder setter auf
 	  // die Attribute zugegriffen wird. Denn auch die Signatur sieht solches nicht vor.
 	/**
 	 *  Uebergibt den Stapel mit dem letzten Element der Warteschlange/tail oben
 	 */
 	public Stapel getStapelEnqueue() {
 		return stapelEnqueue;
 	} 	
 	/**
 	 *  Uebergibt den Stapel mit dem ersten Element der Warteschlange/head oben
 	 */
 	public Stapel getStapelDequeue() {
 		return stapelDequeue;
 	}
 	
 	
 	//Aus dem Template: 	
 	/**
 	 *  Realisierung der ADT-Methode <code>isEmpty</code>.
     *  Ueberprueft, ob die Warteschlange leer ist.
     */
    public boolean isEmpty() {
    	//es reicht, einen der beiden Stapel zu pruefen,
    	  // denn sie werden immer gleichzeitig veraendert.
    	return stapelEnqueue.isEmpty();
    }

    /**
 	 *  Realisierung der ADT-Methode <code>enqueue</code>.
     *  Ein Element wird hinten an die Warteschlagen angefuegt.
     *
     *  @param element Die anzufuegende Objektreferenz.
     */
    public void enqueue(T element){
    	//Element an den Stapel mit dem letzten Element der Warteschlange/tail oben anfuegen
    	stapelEnqueue.push(element);
    	//Aus diesem Stapel den anderen generieren:
    	reverseStapel(true);
    }

    /**
 	 *  Realisierung der ADT-Methode <code>front</code>.
     *  Liefert das vorderste Element - so vorhanden - zurueck.
     *
     *  @return Vorderstes Element
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public T front() throws IllegalStateException {
    	if (stapelEnqueue.isEmpty()) {	//es reicht, einen der beiden Stapel zu pruefen,
    									 // denn sie werden immer gleichzeitig veraendert.
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else {
    		return stapelDequeue.top();
    	}
    }

    /**
 	 *  Realisierung der ADT-Methode <code>dequeue</code>.
     *  Das erste Element der Warteschlange - so vorhanden - wird entfernt.
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public void dequeue() throws IllegalStateException {
    	if (stapelEnqueue.isEmpty()) {	//es reicht, einen der beiden Stapel zu pruefen,
    									 // denn sie werden immer gleichzeitig veraendert.
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else {
    		//Element von dem Stapel mit dem ersten Element der Warteschlange/head oben entfernen
    		stapelDequeue.pop();
    		//Aus diesem Stapel den anderen generieren:
    		reverseStapel(false);
    	}
    }
    
    
    //Hilfsmethoden:
    /**
     *  Erzeugt aus dem uebergebenen Stapel den umgekehrten Stapel
     *
     *  @param way In welche Richtung umgedreht werden soll: 
     *             <code>true</code>,  wenn von stapelEnqueue aus stapelDequeue gebildet wird, 
     *             <code>false</code>, wenn von stapelDequeue aus stapelEnqueue gebildet wird
     *  @throws IllegalStateException falls die Warteschlange leer ist. 
     */
    protected Stapel reverseStapel(boolean way) throws IllegalStateException {
    	//Fehler abfangen, falls die Schlange leer ist.
    	if (stapelEnqueue.isEmpty()) {	//es reicht, einen der beiden Stapel zu pruefen,
    									 // denn sie werden immer gleichzeitig veraendert.
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else {
    		//eigentliches Umdrehen
    		if (way) {	//von stapelEnqueue aus stapelDequeue bilden
    			stapelDequeue = reverseInternal(stapelEnqueue);
    		}
    		else {		//von stapelDequeue aus stapelEnqueue bilden
    			stapelEnqueue = reverseInternal(stapelDequeue);
    		}
    		
    	}
    }
    
    /**
     *  Hilfsfunktion fuer die Funktion <code>reverseStapel</code>
     *  Enthaelt die Schleifenstruktur davon. Und braucht sich dafuer nicht mit Exceptions befassen.
     *
     *  @param stapel Der Stapel von dem ausgehend der andere gebildet werden soll
     *  @return Den umgekehrten Stapel
     */
    protected Stapel reverseInternal(Stapel stapel) { //list-of-numbers actual max step
    	//Variablen:
    	Stapel stapelSource;
    	Stapel stapelOutput;
    	T      element;
    	
    	//Uebergebenen Stapel zum Bearbeiten kopieren
    	stapelSource = stapel.clone();
    	
    	//Ausgabe Stapel als leeren Stapel erzeugen
    	stapelOutput = new Stapel();
    	
    	//Stapel umschichten
    	while (!stapelSource.isEmpty()) {	//solange der Stapel noch nicht leer ist
    		element = stapelSource.top();	//oberstes Element von Source waehlen
    		stapelOutput.push(element);		//dieses Element in Output kopieren (kan man auch zusammenfassen, ist aber weniger uebersichtlich)
    		stapelSource.pop();				//oberstes Element von Source löschen
    	}
    	
    	return stapelOutput;
 	}
 	
 }