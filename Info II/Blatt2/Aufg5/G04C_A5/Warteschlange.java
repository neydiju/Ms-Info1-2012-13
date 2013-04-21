package G04C_A5;

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
 	private Stapel<T> stapelEnqueue;	//Letztes Element der Warteschlange/tail ist oben 
 	private Stapel<T> stapelDequeue;	//Erstes  Element der Warteschlange/head ist oben
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
		stapelEnqueue = new Stapel<T>();
		//Erzeuge einen leeren Stapel in der Reihenfolge des Entfernens der Elemente
		stapelDequeue = new Stapel<T>();
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
    	try {
			//Erzeuge einen Stapel in der Reihenfolge des Anfügens   der Elemente aus der Uebergabe
			stapelEnqueue = queue.getStapelEnqueue();
			//Erzeuge einen Stapel in der Reihenfolge des Entfernens der Elemente aus der Uebergabe
			stapelDequeue = queue.getStapelDequeue();
		}
		catch (Exception e) {
			System.out.println("Ein Fehler ist aufgetreten");
		}
    }
 	
 	
 	//Methoden
 	//--------
 	
 	//Getter:
 	//Setter sind nicht noetig, da, bis auf den Copy-Konstruktor, nicht über getter oder setter auf
 	  // die Attribute zugegriffen wird. Denn auch die Signatur sieht solches nicht vor.
 	/**
 	 *  Uebergibt den Stapel mit dem letzten Element der Warteschlange/tail oben
 	 *
     *  @throws IllegalStateException falls die Warteschlange leer ist.
 	 */
 	public Stapel getStapelEnqueue() throws IllegalStateException {
 		if (stapelEnqueue.isEmpty()) {	//es reicht, einen der beiden Stapel zu pruefen,
    									 // denn sie werden immer gleichzeitig veraendert.
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else return stapelEnqueue;
 	} 	
 	/**
 	 *  Uebergibt den Stapel mit dem ersten Element der Warteschlange/head oben
 	 *
     *  @throws IllegalStateException falls die Warteschlange leer ist.
 	 */
 	public Stapel getStapelDequeue() throws IllegalStateException {
 		if (stapelEnqueue.isEmpty()) {	//es reicht, einen der beiden Stapel zu pruefen,
    									 // denn sie werden immer gleichzeitig veraendert.
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else return stapelDequeue;
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
     *  Erzeugt aus dem angegebenen Stapel den anderen in umgekehrter Reihenfolge
     *
     *  @param way In welche Richtung umgedreht werden soll: 
     *             <code>true</code>,  wenn von stapelEnqueue aus stapelDequeue gebildet wird, 
     *             <code>false</code>, wenn von stapelDequeue aus stapelEnqueue gebildet wird
     *  @throws IllegalStateException falls die Warteschlange leer ist. 
     */
    protected void reverseStapel(boolean way) throws IllegalStateException {
    	//Fehler abfangen, falls die Schlange leer ist.
    	if (stapelEnqueue.isEmpty()) {	//es reicht, einen der beiden Stapel zu pruefen,
    									 // denn sie werden immer gleichzeitig veraendert.
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else {
    		//Zwischenspeicher als leeren Stapel erzeugen
    		Stapel<T> memory = new Stapel<T>();
    		T      element;
    	
    		//eigentliches Umdrehen
    		//(muss einmal hin und einmal her gedreht werden, weil man Stapel selbst nicht kopieren kann)
    		
    		if (way) {	//von stapelEnqueue aus: stapelDequeue bilden
    			//stapelEnqueue umschichten
				while (!stapelEnqueue.isEmpty()) {	//solange der Stapel noch nicht leer ist
					
					element = stapelEnqueue.top();	//oberstes Element von Source waehlen
					
					stapelDequeue.push(element);	//dieses Element in Output kopieren
					memory.push(element);			//dieses Element in den Zwischenspeicherstapel kopieren
													//(kann man auch zusammenfassen, ist aber weniger uebersichtlich) 
					stapelEnqueue.pop();			//oberstes Element von Source löschen
				}//=> stapelDequeue fertig erzeugt
				
				//aus memory wieder stapelEnqueue erzeugen:
				while (!memory.isEmpty()) {			//solange der Stapel noch nicht leer ist
					
					element = memory.top();			//oberstes Element von Source waehlen
					
					stapelEnqueue.push(element);	//dieses Element in Output kopieren
													//(kann man auch zusammenfassen, ist aber weniger uebersichtlich) 
					memory.pop();					//oberstes Element von Source löschen
				}
    		}
    		
    		else {		//von stapelDequeue aus: stapelEnqueue bilden
    			//stapelDequeue umschichten
				while (!stapelDequeue.isEmpty()) {	//solange der Stapel noch nicht leer ist
					
					element = stapelDequeue.top();	//oberstes Element von Source waehlen
					
					stapelEnqueue.push(element);	//dieses Element in Output kopieren
					memory.push(element);			//dieses Element in den Zwischenspeicherstapel kopieren
													//(kann man auch zusammenfassen, ist aber weniger uebersichtlich) 
					stapelDequeue.pop();			//oberstes Element von Source löschen
				}//=> stapelEnqueue fertig erzeugt
				
				//aus memory wieder stapelDequeue erzeugen:
				while (!memory.isEmpty()) {			//solange der Stapel noch nicht leer ist
					
					element = memory.top();			//oberstes Element von Source waehlen
					
					stapelDequeue.push(element);	//dieses Element in Output kopieren
													//(kann man auch zusammenfassen, ist aber weniger uebersichtlich) 
					memory.pop();					//oberstes Element von Source löschen
				}
    		}
    		
    	} //else Exception
    } //reverseStapel()
 	
 } //class
