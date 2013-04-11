/**
 *  Uebungsgruppe 
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  1./5 Klassen zur Loesung zu Aufgabe 1 / Blatt 1 / Sommersemester 2013.
 *
 *  Für eine allgemeine geometrische Figur
 */
 
public abstract class Shape {
	
	//Attribute:
	//----------
	/** X-Position des Startpunktes der Figur */
	int pointX;
	/** Y-Position des Startpunktes der Figur */
	int pointY;
	/** Breite/Seitenlänge/Radius der Figur */
	int width;
	
	
	//Konstruktor
	//-----------
	/**
	 *  Setzt die Attribute einfach auf default-Werte
	 */
	public Shape() {
		this.pointX = 50;
		this.pointY = 50;
		this.width  = 20;
	}
	
	//Methoden:
	//---------
	/**
	 *  Berechnet den Umfang der Figur
	 */
	public abstract int circumference();
	//in Unterklassen deklariertes Vorgehen
}
