/*Exercice 2.5 : Jeu du 0 - 2 
A tour de rôle, l'ordinateur et le joueur choisissent un nombre qui ne peut prendre que 3 valeurs: 0, 1 ou 2.
Le choix du nombre par l'ordinateur sera simulé par génération d'un nombre aléatoire : N <-- RANDOM
Si la différence entre les nombres choisi vaut :
▪ 2 : le joueur qui a proposé le plus grand nombre gagne un point.
▪ 1 : le joueur qui a proposé le plus petit nombre gagne un point.
▪ 0 : aucun point n'est marqué. 
Le jeu se termine quand un des deux joueurs (l'ordinateur ou le joueur humain) totalise 10 points ou quand l'être 
humain introduit un nombre négatif qui indique sa volonté d'arrêter de jouer.
 */
/*Math.abs(nbMachine)*/

import java.util.*;
import java.util.Scanner;
public class E_2_5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		Scanner sc2 = new Scanner (System.in);
		Random aléa = new Random ();

		int score;
		int score2;
		score=0;
		score2=0;
		String rép="";

		do {

			System.out.println("Jeu de pierre feuille ciseau");
			System.out.println(" " );

			int nbUser;

			String choix = null;
			String choix2 = null;


			System.out.println("Veuillez choisir un chiffre entier en 0 et 2");	
			nbUser = sc.nextInt();
			if (nbUser <=2) {
				if (nbUser == 0 )
				{ choix="Pierre"; }

				if (nbUser == 1 )
				{ choix="Papier"; }

				if (nbUser == 2 )
				{ choix="Ciseau"; }

				System.out.println(" " );
				System.out.println("joueur1: " + choix);



				int nbMachine = aléa.nextInt(3);

				if ( nbMachine == 0 )
				{ choix2="Pierre"; }

				if ( nbMachine == 1 )
				{ choix2="Papier"; }

				if ( nbMachine == 2 )
				{ choix2="Ciseau"; }

				System.out.println("ordinateur: " +choix2 );

				//Détermination des gagnants
				System.out.println(" " );
				if (nbUser == 0 && nbMachine == 0)
				{
					System.out.println("Partie Nulle." );
				}
				else
				{
					if (nbUser == 0 && nbMachine == 1)
					{
						System.out.println("Le papier recouvre la pierre." );
						score2++;
					}
					else
					{
						if (nbUser == 0 && nbMachine == 2)
						{
							System.out.println("La pierre casse les ciseaux." );
							score++;
						}
					}
				}

				if (nbUser == 1 && nbMachine == 0)
				{
					System.out.println("Le papier enveloppe la pierre." );
					score++;
				}
				else
				{
					if (nbUser == 1 && nbMachine == 1)
					{
						System.out.println("Partie Nulle." );
					}
					else
					{
						if (nbUser == 1 && nbMachine == 2)
						{
							System.out.println("Le ciseau coupe le papier." );
							score2++;
						}
					}
				}

				if (nbUser == 2 && nbMachine == 0)
				{
					System.out.println("La pierre casse le ciseau." );
					score2++;
				}
				else
				{
					if (nbUser == 2 && nbMachine == 1)
					{
						System.out.println("Le ciseau coupe le papier." );
						score++;
					}
					else
					{
						if (nbUser == 2 && nbMachine == 2)
						{
							System.out.println("Partie Nulle." );
						}
					}
				}

				//Affichage des résultats  
				System.out.println(" " );
				System.out.println("Les scores sont :" );
				System.out.println("Joueur1 : " + score);
				System.out.println("Ordinateur : " + score2);
				System.out.println(" " );
				System.out.println ("Encore une partie?(O/N)" ); 
				rép = sc2.nextLine();

			}

			else System.out.println ("Perdue" ); 
			{

				//Fin de la boucle 
			}	

		}
		while(rép.equalsIgnoreCase("o")) ;
		System.out.println("Fin " );
		sc.close();
		sc2.close();
	}

}


