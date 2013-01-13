/**
 *  Uebungsgruppe G06-E
 *  Henner Niehaus, Jonas Stadler, Eva Poell
 *
 *  Testklasse zur Loesung zu Aufgabe 41 / Blatt 11 / Wintersemester 2012/2013.
 *
 *  Es wird in einem 400 Jahre-Interval ermittelt ob der 13. oefter auf einen
 *  Freitag als auf andere Tage faellt.
 */
 
public class DateProbabilityCalculator2 {

	/**
	 * Ermittelt, ob der 13. eines Monats oefter aus einen Freitag als auf andere
	 * Tage faellt.
	 *
	 *@return true, wenn dem so ist
	 */	
	public boolean isMoreOftenFriday() {
		
		boolean itIs = false;
	
		//1. Tag ist Samstag, der 1.1.1600
		int dayOfTheFirst = 5;
	
		//Zeigen, dass die Tage in 400 Jahren ohne Rest durch 7 teilbar sind:
		int daysIn400y = 400*365;
			//plus die Tage für Schaltjahre
			//"What years are leap years?
			//The Gregorian calendar has 97 leap years every 400 years:"
			//von http://www.tondering.dk/claus/cal/gregorian.php
			//Aufruf 13.01.13
			daysIn400y += 97;
		if (daysIn400y%7 == 0) {
		
			//Feld fuer die 7 Wochentage (0=Montag, ..., 6=Sonntag)
			//in dem gespeichert wird, wie oft der Tag auf einen 13. fiel
			int[] amountOf13s = new int[7];
		
		
			//Ueber 400 Jahre iterieren
			//1. Tag ist Samstag, der 1.1.1600
			for (int year=1600; year<=2000; year+=1) {
				for (int month=1; month<=12; month++) {
					
					//Wochentag des 13. bestimmen
					int dayOfWeek13 = whichDayOfWeekIs13(dayOfTheFirst);
					
					//Wochentagzaehler erhohen
					amountOf13s[dayOfWeek13] ++;
					
					//Wochentag des 1. im naechsten Monat setzen
					dayOfTheFirst = whichIsLastDayOfWeek(dayOfTheFirst, howManyDays(month,year));
					dayOfTheFirst = (dayOfTheFirst+1) % 7;
					
				}//for month
			}//for year
		
			//Pruefen ob der 13. an einem anderen Tag als Freitag oefter vorkam
			//(koennte man auch in eine if-Abfrage packen, aber so ist uebrsichtlicher.)
			if      (amountOf13s[0] > amountOf13s[4]) { itIs = false; }
			else if (amountOf13s[1] > amountOf13s[4]) { itIs = false; }
			else if (amountOf13s[2] > amountOf13s[4]) { itIs = false; }
			else if (amountOf13s[3] > amountOf13s[4]) { itIs = false; }
			else if (amountOf13s[5] > amountOf13s[4]) { itIs = false; }
			else if (amountOf13s[6] > amountOf13s[4]) { itIs = false; }
			else									  { itIs = true;  }
		
		}//if %7
	
		return itIs;
	
	}
	
	/**
	 * Prueft ob das uebergeben jahr ein Schaltjahr ist
	 *
	 *@param year Jahreszahl/jahr das geprueft wreden soll
	 *
	 *@return true, wenn es kein Schaltjahr ist
	 */
	private boolean isLeapyear(int year) {
	
		//Schaltjahr, wenn
		//1. das Jahr       durch 4 ganzzahlig teilbar ist
		//2. das Jahr nicht durch 100 ganzzahlig teilbar ist
		//3. das Jahr aber  durch 400 ganzzahlig teilbar ist
	
		if ( 		  (year %   4 == 0)	//1. true, wenn Jahr ganzzahlig durch 4 teilbar ist
			 &&  (   !(year % 100 == 0)	//2. true, wenn Jahr nicht auch ganzzahlig durch 100 teilbar ist
				   || (year % 400 == 0)	//3. true, wenn Jahr      dafür ganzzahlig durch 400 teilbar ist
				 )
		   ) {
			return true;		
		}
		else {
			return false;
		}
	}
	
	/**
	 * Ermittelt die Tageszahl entsprechend dem Monat
	 *
	 *@param month Monat zu dem die tageszahl ermittelt wird
	 *@param year Das Jahr in dem der Monat liegt, die richige Zahl im Februar zu bestimmen
	 *
	 *@return Anzahl Tage des Monats
	 */
	private int howManyDays(int month, int year) {
		
		switch (month) {
			case  1:
			case  3:
			case  5:
			case  7:
			case  8:
			case 10:
			case 12: return 31;
			
			case  4:
			case  6:
			case  9:
			case 11: return 30;
			
			case  2: if ( isLeapyear(year) ) { return 29; }
					 else 					 { return 28; }
			
			default: return -1;
		}
			
	}
	
	/**
	 * Ermittelt den Wochentag des 13. eines Monats
	 *
	 *@param dayToBegin Der Wochentag des 1. im Monat
	 *
	 *@return Den Wochentag des 13 von 0=Monatg bis 6=Sonntag
	 */
	private int whichDayOfWeekIs13(int dayToBegin) {
		
		return ( (dayToBegin+12) % 7 );
		
	}
	
	/**
	 * Ermittelt den Wochentag des letzten Tages eines Monats
	 *
	 *@param month Monat in dem der letzte Wochentag ermittelt werden soll
	 *@param days Anzahl der tage dieses Monats
	 *
	 *@return Den Wochentag des letzten Tages von 0=Monatg bis 6=Sonntag
	 */
	private int whichIsLastDayOfWeek(int dayToBegin, int days) {
		
		return ( (dayToBegin + (days-1)) % 7 );
		
	}
	
	
	public void run() {
		
		System.out.println("Der 13. fällt zwischen 1600 und 2000 öfter auf einen Freitag als auf andere Tage: das ist "+isMoreOftenFriday());
	
	}
	 
	public static void main(String[] args) {
	
		DateProbabilityCalculator2 calculator = new DateProbabilityCalculator2();
		calculator.run();
		
	}
}
