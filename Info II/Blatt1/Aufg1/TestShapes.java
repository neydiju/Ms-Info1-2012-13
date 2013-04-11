/**
 *  Uebungsgruppe 
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  5./5 Klassen zur Loesung zu Aufgabe 1 / Blatt 1 / Sommersemester 2013.
 *
 *  Testes die Sachen
 */
 
public class TestShapes {
	
	public static void main (String[] args) {
		
			TestShapes test = new TestShapes();
			test.run();
		
	}
	
	public void run() {
		
		//Kreis
		Circle kreis1 = new Circle();
		Circle kreis2 = new Circle(10, 10, 10);
		System.out.println("Der 1. Kreis sollte einen Umfang von 126 haben: "+kreis1.circumference());
		System.out.println("Der 2. Kreis sollte einen Umfang von  63 haben: "+kreis2.circumference());
		System.out.println();
		
		//Quadrat
		Square quadrat1 = new Square();
		Square quadrat2 = new Square(10,10,10);
		System.out.println("Das 1. Quadrat sollte einen Umfang von 80 haben: "+quadrat1.circumference());
		System.out.println("Das 2. Quadrat sollte einen Umfang von 40 haben: "+quadrat2.circumference());
		System.out.println();
		
		//Rechteck
		Rectangle rechteck1 = new Rectangle();
		Rectangle rechteck3 = new Rectangle(10, 10, 50, 25);
		System.out.println("Das 1. Rechteck sollte einen Umfang von  60 haben: "+rechteck1.circumference());
		System.out.println("Das 2. Rechteck sollte einen Umfang von 150 haben: "+rechteck3.circumference());
		System.out.println();
		
		//Figur
		//Shape s = new Shape(); geht nicht ist abstract
	}
}
