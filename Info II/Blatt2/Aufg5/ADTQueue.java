package G04C_A5; //Zum Kompilieren hinzugefuegt, sonst wurde nichts geaendert

/**
 *  Schnittstelle fuer Realisierungen des ADT Queue.
 */
public interface ADTQueue<T> {

    /**
     *  Ueberprueft, ob die Warteschlange leer ist.
     */
    public boolean isEmpty();

    /**
     *  Ein Element wird hinten an die Warteschlagen angefuegt.
     *  @param element Die anzufuegende Objektreferenz.
     */
    public void enqueue(T element);

    /**
     *  Liefert das vorderste Element - so vorhanden - zurueck.
     *  @return Vorderstes Element
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public T front() throws IllegalStateException;

    /**
     *  Das erste Element der Warteschlange - so vorhanden - wird entfernt.
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public void dequeue() throws IllegalStateException;

}
