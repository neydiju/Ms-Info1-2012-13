/**
 *  Uebungsgruppe 
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  2./5 Klassen zur Loesung zu Aufgabe 1 / Blatt 1 / Sommersemester 2013.
 *
 *  Implementiert einen Kreis
 */
 
public class Circle extends Shape {
	
	//Konstruktoren
	//-------------
	/**
	 *  Setzt die Attribute einfach auf default-Werte
	 */
	public Circle() {
		super();
	}
	
	/**
	 *  Setzt die Attribute auf die uebergebenen Werte
	 *
	 *  @param x x-Position des Mittelpunktes
	 *  @param y y-Position des Mittelpunktes
	 *  @param radius Radius des Kreises
	 */
	public Circle(int x, int y, int radius) {
		this.pointX = x;
		this.pointY = y;
		this.width  = radius;
	}
	
	//Methoden:
	//---------
	/**
	 *  Berechnet den Umfang des Kreises
	 */
	public int circumference() {
		return (int) Math.round(2*Math.PI*width);
	}
}
