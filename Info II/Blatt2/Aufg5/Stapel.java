package G04C_A5; //Zum Kompilieren hinzugefuegt, sonst wurde nichts geaendert

/**
 *  Beispielhafte Realisierung des ADT Stack.
 *  Die Implementierung greift auf die Klasse
 *  <code>java.util.LinkedList<T></code> zurueck.
 */
public class Stapel<T> implements ADTStack<T> {

    //  Assoziiertes Listen-Objekt zur Speicherung der Daten.
    private java.util.LinkedList<T> data;  //  An Stelle der Klasse Liste<T>

    /**
     *  Default-Konstruktor.
     *  Das <code>data</code>-Attribut wird als
     *  leere Liste initialisiert.
     */
    public Stapel() {
	//  Erzeuge eine leere Liste zur Speicherung der Elemente.
	data = new java.util.LinkedList<T>();
    }
    
    /**
     *  Realisierung der ADT-Methode <code>isEmpty</code>.
     *  Abfrage, ob der Stapel leer ist.
     *  @return <code>true</code>, falls der Stapel leer ist,
     *          <code>false</code> sonst.
     */
    public boolean isEmpty() {
	// Leite die Anfrage direkt an die Liste weiter.
	return data.isEmpty();
    }

    /**
     *  Realisierung der ADT-Methode <code>push</code>.
     *  Ein Element wird auf den Stapel gelegt.
     *  @param element Die auf den Stapel zu legende Objektreferenz.
     *                 Es wird nicht geprueft, ob diese Referenz die
     *                 <code>null</code>-Referenz ist.
     */
    public void push(T element) {
	//  Fuege das Element vorne an die Liste an.
	data.add(0, element);
    }

    /**
     *  Realisierung der ADT-Methode <code>top</code>.
     *  Das oberste Element des Stapels - so vorhanden -
     *  wird zurueckgeliefert.
     *  @return Objektreferenz, die oben auf dem Stapel gespeichert ist.
     *  @throws IllegalStateException falls der Stapel leer ist.
     */
    public T top() throws IllegalStateException {
	if (isEmpty()) {
	    throw new IllegalStateException("Stapel ist leer.");
	}

	//  Greife auf das erste Listenelement zu.
	return data.getFirst();
    }

    /**
     *  Realisierung der ADT-Methode <code>pop</code>.
     *  Das oberste Element des Stapels - so vorhanden -
     *  wird entfernt.
     *  @throws IllegalStateException falls der Stapel leer ist.
     */
    public void pop() throws IllegalStateException {
	if (isEmpty()) {
	    throw new IllegalStateException("Stapel ist leer.");
	}
	
	//  Entferne das erste Listenelement.
	data.remove(0);
    }
} 
