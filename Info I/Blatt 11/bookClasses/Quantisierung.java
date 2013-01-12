/**
 *  Uebungsgruppe G06-E
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  Loesung zu Aufgabe 44 / Blatt 11 / Wintersemester 2012/2013.
 *
 *	Aendert die Farbtiefe eines Graustufenbildes
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
     *
     * @param l Anzahl der zu verwendenden Bits (0...8)
     *
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
			  
			  n := Anzahl Originalbits (hier 8)
			  l := Anzahl reduzierter Bits
			  
			  1. Ausgabebild erzeugen, das urspruenglich die gleichen Farbwerte hat, wie das Eingabebild
			  
			  2. Zeit sparen, wenn nicht komprimiert werden soll
			  
			  3. Intervallgrenze  und Mittelwert festlegen (eig nur fuer erstes Intervall)
			  	 -> 2⁸ = 256 Bits ausgehen
			  	 	und das in 2^l Teilintervalle teilen
			  	 	
			  4. Bild durchlaufen:
			  	 i)   Pruefen in welchem Interval der Farbkanal des aktuellen Pixels liegt
			  	 ii)  Farbkanal auf Mittelwert des Intervalls setzen
			  	 iii) Ausgabebild ueberschreiben
			*/
			
			//1. Ausgabebild erzeugen, das urspruenglich die gleichen Farbwerte hat, wie das Eingabebild
			output = new Picture(input);
			
			//2. Zeit sparen, wenn nicht komprimiert werden soll
			//   -> nichts ändert sich
			if (l != 8) {
			
				//3. Intervallgrenze  und Mittelwert festlegen (eig nur fuer erstes Intervall)
				int greyscale     = (int) java.lang.Math.floor( java.lang.Math.pow(2, l) );
				int intervalLimit = (int) java.lang.Math.ceil( 256 / greyscale );
				int middle        = (int) java.lang.Math.floor( intervalLimit/2 );
			
				//4. Bild durchlaufen:
				for (int x=0; x<output.getWidth(); x++) {
					for (int y=0; y<output.getHeight(); y++) {
						
						//Pixelobjekt erzeugen, um auf Farbwerte zuzugreifen
						Pixel p = new Pixel(output, x, y);
						
						//4.i)   Pruefen in welchem Interval der Farbkanal des aktuellen Pixels liegt
						//Ein Farbwert reicht, denn bei einem Graustufenbild sind die Kanalwerte
						//aller Farben gleich.
						int interval       = p.getRed() / intervalLimit;
						
						//4.ii)  Farbkanal auf Mittelwert des Intervalls setzen
						int valueQuantized = (2*interval + 1) * middle;
						
						//4.iii) Ausgabebild ueberschreiben
						p.updatePicture( p.getAlpha(),
										 valueQuantized,
										 valueQuantized,
										 valueQuantized
									   );				 

					}//for y
				}//for x
			}//if

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

		String directory = "/home/eva/Dokumente/gitHub/trunk/Info I/Blatt 11/44/";
						   //  Hier muss ein gueltiger Verzeichnisname 
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
