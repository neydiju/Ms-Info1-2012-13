/**
 *  Uebungsgruppe G06-E
 *  Henner Niehaus, Jonas Stadler, Eva Pöll
 *
 *  Loesung zu Aufgabe 43 / Blatt 11 / Wintersemester 2012/2013.
 *
 *  Repraesentiert eine nxm Matrix im mathematischen Sinne.
 *  Enthaelt Eintraege vom Typ long.
 */
 
 public class Matrix {
 	//Attribute
 	long[][] matrix;

 	
 	//Konstruktoren
 	/**
 	 * Loesung zu 43 a
 	 *
 	 * Erzeugt eine nxm Matrix vom Typ long
 	 * Aus dem übergebenen Feld in der Groesse der uebergebenen Werten.
 	 * Nicht besetzte Stellen werden mit 0 gefuellt,
 	 * ueberschuessige Uebergaben werden ignoriert.
 	 *
 	 *@param field Zweidimensionales Array, dass die einzutragenden
 	 *			Zahlen der Eingabe enthaelt
 	 *@param n Groesse der Matrix in x-Richtung/Anzahl Spalten
 	 *@param m Groesse der Matrix in y-Richtung/Anzahl Zeilen
 	 */
 	public Matrix(long[][] field, int n, int m) {
 		 
 		 //Matrix-Feld erzeugen
 		 matrix = new long[n][m];
 		 
 		 //Matrix mit 0 vorbelegen:
 		 setallTo0(matrix);
 		 
 		 //field durchlaufen um matrix mit Nutzereingaben zu belegen
 		 initialiseMatrix(field, matrix, n, m);
 		 
 	} 
 	 	
 	/**
 	 * Loesung zu 43 b
 	 *
 	 * Erzeugt eine Matrix vom Typ long aus dem übergebenen Feld.
 	 * Die Groesse der Matrix wird passend bestimmt.
 	 * Nicht besetzte Stellen werden mit 0 gefuellt.
 	 *
 	 *@param field Zweidimensionales Array, dass die einzutragenden
 	 *			Zahlen der Eingabe enthaelt
 	 */
 	public Matrix(long[][] field) {
 		
 		//Groesse bestimmen:
		int m = field.length;
 		//n ist von Zeile zu Zeile verschieden -> Maximum suchen
 		int n = 0;
		for (int y=0; y<m; y++) {
			if 	(n < field[y].length) {
				n = field[y].length;
			}
		}
		
		//Rest ist gleich wie beim Konstruktor a
		//Matrix-Feld erzeugen
 		 matrix = new long[n][m];
 		 
 		 //vorbelegen entfaellt, da field schon mit 0 vorbelegt ist und es keine
 		 //weiteren Zellen gibt
 		 
 		 //field durchlaufen um matrix mit Nutzereingaben zu belegen
 		 initialiseMatrix(field, matrix, n, m);
	}
	
	/**
	 * Hilfskonstruktor fuer 43 d
	 *
	 * Erzeugt eine beispielhafte obere Dreiecks-Matrix vom Typ long,
	 * in der uebergebenen Groesse.
 	 * Eine obere Dreiecksmatrix ist eine nxn-Matrix, bei der alle Eintraege
 	 * unterhalb der Hauptdiagonalen den Wert 0 haben
 	 * und hier oberhalb den Wert 1 hat.
 	 *
 	 *@param n Die Groesse der Matrix in beiden Richtungen
 	 */
 	public Matrix(int n) {
 		
 		//Matrix-Feld erzeugen
 		matrix = new long[n][n];
 		
 		//Matrix durchlaufen und  ab der Spalte Nr.. y (inklusive) 1 setzen
 		for (int y=0; y<n; y++) {
 			for (int x=y; x<n; x++) {
 			
				matrix[y][x] = 1;
 				
 			} //for x
 		} //for y
 		
 	}
	
	
 	//Methoden
 	
 	/**
 	 * Setzt alle Felder der uebergebenen Matrix auf 0 (<> null!)
 	 *
 	 *@param matrix Matrix, die auf 0 gesetzt werden soll.
 	 */
 	private void setallTo0 (long[][] matrix) {
 	
 		for (int y=0; y < matrix.length; y++) {
 			for (int x=0; x < matrix[y].length; x++) {
 				matrix[y][x] = 0;
 			} //for x
 		} //for y
 	
 	}
 	
 	/**
 	 * Durchlaeuft ein Datenfeld um die Matrix mit Nutzereingaben zu belegen
 	 *
 	 *@param field Zweidimensionales Array, dass die einzutragenden
 	 *			Zahlen der Eingabe enthaelt
 	 *@param matrix Zweidimensionales Array, dass die Zahlen aufnimmt
 	 */
 	 private void initialiseMatrix(long[][] field, long[][] matrix, int n, int m) {
 		 
 		 for (int y=0; y<field.length && y<m; y++) {
 			for (int x=0; x<field[y].length && x<n; x++) {
 			
 				//nicht besetzte Felder im Array sind mit 0 per default initialisiert,
 				//also bleibt die gesetzte 0 quasi
 				matrix[y][x] = field[y][x];
 			} //for x
 		} //for y
 	
 	}
 	
 	/**
 	 * Ueberprueft die Gueltigkeit einer x,y-Position
 	 * und gibt ggf. eine Fehlermeldung auf der Konsole aus.
 	 * Erwartet ein symmetrisches Array! Eine Matrix hat ja auch immer
	 * gleich viele Spalten.
 	 *
 	 *@param x Spaltennummer / x-Position (von 0 an)
 	 *@param y Zeilennummer / y-Position (von 0 an)
 	 *
 	 *@return false, wenn x,y-Position außerhalb des Indexbereichs, sonst true
 	 */
 	private boolean checkPosValidity(int x, int y) {
 		boolean valid = true;
 		
 		//x-Position ueberpruefen
 		if (x<0 || x>matrix.length) {
 			System.out.println("Spaltennummer/x-Position, "+x+", liegt außerhalb des erlaubten "
 					+"Bereichs: [0, "+matrix[0].length+"]");
 			valid = false;
 		}
 		//y-Position ueberpruefen
 		if (y<0 || y>matrix.length) {
 			System.out.println("Zeilennummer/y-Position, "+y+", liegt außerhalb des erlaubten "
 					+"Bereichs: [0, "+matrix.length+"]");
 			valid = false;
 		}
 		
 		//ist true geblieben, wenn keine der Abfragen zutraf
 		// -> x,y-Position ist gueltig
 		return valid;
 	}
 	
 	/**
 	 * Gibt ein Array erst in x-, dann in y-Richtung aus / Zeilenweise.
 	 *
 	 *@param matrix Die auszugebende Matrix
 	 */
 	public void showMatrix() {
 		for (long[] line : matrix) {
 			for (long cell : line) {
 				System.out.print("  " + cell);
 			}//for cell
 			System.out.println();
 		}//for line
 	}
 	
 	/**
 	 * Loesung zur Aufgabe 43 c, Teil 1
 	 * 
 	 * Schreibt einen einzelnen Eintrag an die uebergebene Position
 	 *
 	 *@param entry Die einzutragende Zahl
 	 *@param x Spaltennummer / x-Position (von 0 an)
 	 *@param y Zeilennummer / y-Position (von 0 an)
 	 */
 	public void setEntry(long entry, int x, int y) {
 		
 		//Wenn x,y-Position gueltig ist, den Eintrag setzen, sonst Fehler melden
 		if (checkPosValidity(x, y)) { 		
 			matrix[y][x] = entry;
 		} else {
 			System.out.println("Ihr Eintrag: "+entry+" konnte nicht gesetzt werden!");
 		}
 		
 	}
 	
 	/**
 	 * Loesung zur Aufgabe 43 c, Teil 2
 	 * 
 	 * Gibt einen einzelnen Eintrag an der uebergebene Position zurueck
 	 *
 	 *@param x Spaltennummer / x-Position (von 0 an)
 	 *@param y Zeilennummer / y-Position (von 0 an)
 	 *
 	 *@return Der Matrizenwert an der gefragten Stelle, bei Fehler: -1
 	 */
 	public long getEntry(int x, int y) {
 		
 		//Wenn x,y-Position gueltig ist, den Eintrag lesen, sonst Fehler melden
 		if (checkPosValidity(x, y)) { 		
 			return matrix[y][x];
 		} else {
 			System.out.println("Der Eintrag konnte nicht gelesen werden!");
 			return -1;
 		}
 		
 	} 
 	
 	/**
 	 * Loesung zu Aufgabe 43 d
 	 *
 	 * Ueberprueft ob das Matrixobjekt eine obere Dreiecksmatrix repraesentiert.
 	 * Eine obere Dreiecksmatrix ist eine nxn-Matrix, bei der alle Eintraege
 	 * unterhalb der Hauptdiagonalen den Wert 0 haben.
 	 *
 	 *@return true, wenn es eine obere Dreiecksmatrix ist
 	 */
 	public boolean isUpperTriangular() {
 		
 		//Matrix durchlaufen und pruefen, ob ab (inklusive) der Spalte Nr. y Einsen stehen
 		for (int y=0; y<matrix.length; y++) {
 			for (int x=0; x<matrix[y].length; x++) {
 				
 				if (x<y && matrix[y][x]!=0) {
 					return false;
 				}
 				
 			} //for x
 		} //for y
 		
 		//Wenn es bis hier hin kommt,
 		//dann spricht nichts dagegen, dass es eine obere Dreiecksmatrix ist.
 		return true;
 		
 	}
 	
 	
 	
 	//main 	
 	public static void main(String[] args) {
 	}
 }
