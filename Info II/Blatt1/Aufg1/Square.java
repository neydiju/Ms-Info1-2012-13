/**
 *  Uebungsgruppe 
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  3./5 Klassen zur Loesung zu Aufgabe 1 / Blatt 1 / Sommersemester 2013.
 *
 *  Implementiert ein Quadrat
 */
 
public class Square extends Shape {
	
	//Konstruktoren
	//-------------
	/**
	 *  Setzt die Attribute einfach auf default-Werte
	 */
	public Square() {
		super();
	}
	
	/**
	 *  Setzt die Attribute auf die uebergebenen Werte
	 *
	 *  @param x x-Position der oberen linken Ecke
	 *  @param y y-Position der oberen linken Ecke
	 *  @param length Seitenlänge des Quadrats
	 */
	public Square(int x, int y, int length) {
		this.pointX = x;
		this.pointY = y;
		this.width  = length;
	}
	
	//Methoden:
	//---------
	/**
	 *  Berechnet den Umfang des Quadrats
	 */
	public int circumference() {
		return (int) Math.round((4*width));
	}
}
