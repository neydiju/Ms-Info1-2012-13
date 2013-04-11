/**
 *  Uebungsgruppe 
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  4./5 Klassen zur Loesung zu Aufgabe 1 / Blatt 1 / Sommersemester 2013.
 *
 *  Implementiert ein Rechteck
 */
 
public class Rectangle extends Shape {
	
	//Attribut
	/** Hoehe des Rechtecks */
	int height;
	
	//Konstruktoren
	//-------------
	/**
	 *  Setzt die Attribute einfach auf default-Werte
	 */
	public Rectangle() {
		super();
		this.height = 10;
	}
	
	/**
	 *  Setzt die Attribute auf die uebergebenen Werte
	 *
	 *  @param x x-Position der oberen linken Ecke
	 *  @param y y-Position der oberen linken Ecke
	 *  @param width Breite des Rechtecks
	 *  @param height Hoehe des Rechtecks
	 */
	public Rectangle(int x, int y, int width, int height) {
		this.pointX = x;
		this.pointY = y;
		this.width  = width;
		this.height = height;
	}
	
	//Methoden:
	//---------
	/**
	 *  Berechnet den Umfang des Rechtecks
	 */
	public int circumference() {
		return (int) Math.round((2*width)+(2*height));
	}
}
