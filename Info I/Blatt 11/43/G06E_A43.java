/**
 *  Uebungsgruppe G06-E
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  Testklasse zur Loesung zu Aufgabe 41 / Blatt 11 / Wintersemester 2012/2013.
 */
 
public class G06E_A43 {

	private void run() {
	
		long[][] eingabe  = {{1,2}, {3,4,5}, {6}};
		long[][] eingabe2 = {{1,2,3}, {0,4,5}, {0,0,6}};
		
		System.out.println("***********************************************************");
		
		//Test Konstruktor a
		System.out.println("Test Konstruktor a");
		System.out.println();
 		
 		Matrix m1 = new Matrix(eingabe, 4, 5);
 		System.out.println("long[][] eingabe = {{1,2}, {3,4,5}, {6}} mit m = 5 und n = 4 ergibt:");
 		m1.showMatrix();
 			System.out.println();
 		Matrix m2 = new Matrix(eingabe, 2, 2);
 		System.out.println("long[][] eingabe = {{1,2}, {3,4,5}, {6}} mit m = 2 und n = 2 ergibt:");
 		m2.showMatrix();
 			System.out.println();
 		
 		System.out.println("***********************************************************");
 		
 		//Test Konstruktor b
 		System.out.println("Test Konstruktor b");
		System.out.println();
		 		
 		Matrix m3 = new Matrix(eingabe);
 		System.out.println("long[][] eingabe = {{1,2}, {3,4,5}, {6}} mit n, m automatisch ergibt:");
 		m3.showMatrix();
 			System.out.println();
 		
 		System.out.println("***********************************************************");
 		
 		//Test get-/setEntry c
 		System.out.println("Test setEntry(long entry, int x, int y)");
		System.out.println();
		
		m3.showMatrix();
 			System.out.println("--- Neu: ---");
		m3.setEntry(42, 2, 2);
		m3.showMatrix();
			System.out.println();
			
		System.out.println("Test getEntry(int x, int y)");
		System.out.println();
		
		System.out.print("Der Wert an der Stelle 0, 0 ist: "+m3.getEntry(0,0));
		System.out.print(" Der Wert an der Stelle 1, 0 ist: "+m3.getEntry(1,0));
		System.out.print(" Der Wert an der Stelle 2, 0 ist: "+m3.getEntry(2,0));
			System.out.println();
		System.out.print("Der Wert an der Stelle 0, 1 ist: "+m3.getEntry(0,1));
		System.out.print(" Der Wert an der Stelle 1, 1 ist: "+m3.getEntry(1,1));
		System.out.print(" Der Wert an der Stelle 2, 1 ist: "+m3.getEntry(2,1));
			System.out.println();
		System.out.print("Der Wert an der Stelle 0, 2 ist: "+m3.getEntry(0,2));
		System.out.print(" Der Wert an der Stelle 1, 2 ist: "+m3.getEntry(1,2));
		System.out.print(" Der Wert an der Stelle 2, 2 ist: "+m3.getEntry(2,2));
			System.out.println();
			System.out.println();
		System.out.println("Der Wert an der Stelle 5, 2 ist: "+m3.getEntry(5,2)+" und damit fehlerhaft.");
			System.out.println();
		System.out.println("Der Wert an der Stelle 1, 5 ist: "+m3.getEntry(1,5)+" und damit fehlerhaft.");
			System.out.println();
 		
 		System.out.println("***********************************************************");
 		
 		//Test isUpperTriangular d
 		System.out.println("Test isUpperTriangular()");
		System.out.println();
				
		Matrix m4 = new Matrix(5);
		Matrix m5 = new Matrix(eingabe2);
		
		m4.showMatrix();
		System.out.println("Diese Matrix hat eine obere Dreiecksform: "+m4.isUpperTriangular());
			System.out.println();
		m5.showMatrix();
		System.out.println("Diese Matrix hat eine obere Dreiecksform: "+m5.isUpperTriangular());
			System.out.println();
		m3.showMatrix();
		System.out.println("Diese Matrix hat eine obere Dreiecksform: "+m3.isUpperTriangular());
			System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		G06E_A43 unsereLoesung = new G06E_A43();
		unsereLoesung.run();
	}
}
