package G04C_A5;

/**
 *  Uebungsgruppe G04-C
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  2./2 Klassen zur Loesung zu Aufgabe 5 / Blatt 2 / Sommersemester 2013.
 *
 *  Testklasse zur Klasse <code>Warteschlange</code>
 */
 
public class WarteschlangenTest {
	
	public static void main (String[] args) {
		
			WarteschlangenTest test = new WarteschlangenTest();
			test.run();
		
	}
	
	public void run() {

		System.out.println();
		
		//Default-Konstruktor
		Warteschlange w1 = new Warteschlange();
		System.out.println("Warteschlange w1 wurde erzeugt");
		System.out.println();
		
		//isEmpty()
		System.out.println("Die Warteschlange sollte leer sein: "+w1.isEmpty());
		//front->Fehler
		try {
			System.out.println("Die Warteschlange sollte leer sein, also wirft front() einen Fehler: "
				+w1.front());
			System.out.println();
		}
		catch (Exception e) {
			System.out.println("Fehler gefangen");
			System.out.println();
		}
		
		//enqueue, front
		w1.enqueue("a");
		System.out.println("Ein neues Element wurde hinzugefügt. Das Vordeste ist: "+w1.front());
		w1.enqueue("b");
		System.out.println("Ein neues Element wurde hinzugefügt.");
		w1.enqueue("c");
		System.out.println("Ein neues Element wurde hinzugefügt.");
		System.out.println();
		
		//dequeue, front
		w1.dequeue();
		System.out.println("Ein Element wurde entfernt. Jetzt ist das Vorderste: "+w1.front());
		w1.dequeue();
		System.out.println("Ein Element wurde entfernt. Jetzt ist das Vorderste: "+w1.front());
		w1.dequeue();
		System.out.println("Das letzte Element wurde entfernt.");
		//Fehler werfen
		try {
			System.out.println("Der Stapel ist jetzt leer, bei nochmaliger Anwednung wird ein Fehler geworfen:");
			w1.dequeue();
			System.out.println();
		}
		catch (Exception e) {
			System.out.println("Fehler gefangen");
		}
		
		//nochmal enqueue, front
		w1.enqueue(1);
		System.out.println("Ein neues Element wurde hinzugefügt: "+w1.front());
		w1.enqueue(2);
		System.out.println("Ein neues Element wurde hinzugefügt.");
		System.out.println();
	}
	
}
