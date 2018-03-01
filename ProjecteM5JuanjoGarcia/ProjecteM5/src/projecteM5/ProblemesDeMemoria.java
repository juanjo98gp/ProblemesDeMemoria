package projecteM5;
	
	/**
	 * @author Juanjo Garcia Pagan (juanjogp)
	 * 
	 * @version 01/03/2018/V2
	 * 
	 */

import java.util.Scanner;

public class ProblemesDeMemoria {
	/**
	 * @param JOC Indica la quantitat de jocs que tindrem que introduit (longitud vector)
	 */
	public static final int JOC = 9;
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		/**
		 * @param total Total de espai ocupat per els jocs
		 * @param torn Variable per a poder comptar el numero de accions que es fan
		 * @param escollir Numero de joc que escollim despres de decidir si instalem o desinstalem (posicio del vector jocs)
		 * @param accions Indica la quantitat de accions que farem durant el problema (es compta amb la variable torn)
		 * @param accio Indica si Instalem (I/i) o Desinstalem (D/d) el joc
		 * @param hdd Volum total de el disc dur (on estran instalats els jocs)
		 */
		
		int total=0;
		int torn=0;
		int escollir;
		int accions;
		char accio;
		int hdd; 
		
		/**
		 * @param jocs[] Vector on enmagatzemen els jocs
		 * @param instalat[] Vector per saber quins jocs tenim instalats i quins no 
		 */
			
		int jocs[] = new int[JOC];
		boolean instalat[] = new boolean[JOC];
			
			for(int x = 0;x<JOC;x++) {
				instalat[x]=false;
			}
			
			/**
			 * @return Inicialitza el vector instalat a False
			 */
			
			for(int x= 0;x<JOC;x++) {
				jocs[x]=0;
			}
			
			/**
			 * @return Inicialitza el vector jocs a 0
			 */
			
			total=0; hdd = 0;
			
			/**
			 * @return Inicialitza les variables total i hdd a 0, per iniciar el problema
			 */
			
			System.out.println("Accions");
			accions = input.nextInt();
			System.out.println("Espai disc dur");
			hdd = input.nextInt();
			System.out.println("Jocs");
			for (int j = 0; j < JOC; j++) {
				jocs[j] = input.nextInt();
			}
			
			/**
			 * @return Introduim de forma manual el numero d'accions que tenim que fer, el volum del disc dur i cadascun dels joc que tenim
			 */
			
			System.out.println("Inici");
			while ( torn < accions) {
				accio = input.next().charAt(0);
				if(accio=='I'||accio=='i') {
					escollir= input.nextInt();
					if(instalat[escollir-1]==false) {
						total=total+jocs[escollir-1];
						instalat[escollir-1]=true;
						torn++;
						
						/**
						 * @return al indicar l'accio I/i i escollir N joc sumara aquest joc al total i el posara en true en el vector instalat, tambe sumara una accio
						 */
						
					} else {
						System.out.println("No pots tornar a instalar el mateix joc");
						
						/**
						 * @return si el joc ja esta instalat no fara res
						 */
						
					}
				} 
				if(accio=='D'||accio=='d') {
					escollir= input.nextInt();
					if(instalat[escollir-1]==true) {
						total=total-jocs[escollir-1];
						instalat[escollir-1]=false;
						torn++;
						
						/**
						 * @return al indicar la accio D/d i escollir N joc restara aquest joc al total i el posara en false en el vector instalat, tambe sumara una accio
						 */
						
					} else {
						System.out.println("No pots desinstalar un joc que no tens");
						
						/**
						 * @return si el joc ja esta desinstalat no fara res
						 */
					}
				}
			}
			
			if(total>hdd) {
				System.out.println("Espai en disc insuficient");
				System.out.println("Espai en disc: "+total);
				
				/**
				 * @return Si total > hdd llavors indicara que no hi ha espai diferent i donara el espai en disc
				 */
				
			} else {
				System.out.println("Pots jugar");
				System.out.println("Espai en disc: "+total);
				
				/**
				 * @return Si total <= hdd llavors indicara que pots jugar i donara el espai en disc
				 */
				
			}
	}
	
}
