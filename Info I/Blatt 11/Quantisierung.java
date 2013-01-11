/**
 *  Uebungsgruppe _____
 *  (Namen der Teilnehmer)
 *
 */

public class Quantisierung {

    private Picture input;

    public Quantisierung() {

	//  Erstelle Dialog zur Auswahl einer Bilddatei und lade das
	//  ausgewaehlte Bild.
	input = new Picture(FileChooser.pickAFile());

    }

    /**
     * Wandele ein Graustufenbild mittels Quantisierung  in ein
     * Graustufenbild mit 2^l Graustufen um
     * @param l Anzahl der zu verwendenden Bits (0...8)
     * @return Picture Referenz auf das skalierte Bild
     */
    public Picture quantize(int l) {
	
	//  Referenzvariable, die auf das zu erstellende Bild verweisen soll.
	Picture output = null;
	
	//  Falls keine Datei ausgewaehlt wurde, ist nichts zu tun.
	if (input != null) {

	    //  Zeige das Bild zur Kontrolle an.
	    input.show();	    
	    
	    /*
	      Hier ist die Loesung zu Aufgabe 44 einzutragen.
	    */

	    //  Zeige das Bild zur Kontrolle an.
	    output.show();	    
	
	}

	return output;
    }

    /**
     * Loesung der Aufgabe 44 / Blatt 11 / Wintersemester 2012/2013.
     */
    public void run() {

	Picture output;

	String directory = "";   //  Hier muss ein gueltiger Verzeichnisname 
	                         //  eingesetzt werden,
                               	 //  z.B. "C:\" oder "/Users/Shared/" oder ...
	
	//  Erster Test
	output = quantize(8);
	output.write(directory + "gray256.png");

	//  Zweiter Test
	output = quantize(4);
	output.write(directory + "gray16.png");

	//  Dritter Test
	output = quantize(3);
	output.write(directory + "gray8.png");

	//  Vierter Test
	output = quantize(1);
	output.write(directory + "gray2.png");

	System.exit(0);
    }

    public static void main(String[] args) {

	Quantisierung q = new Quantisierung();	
	q.run();

    }

}
