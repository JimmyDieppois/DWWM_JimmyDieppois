/*Exercice 2.2 : Conversion Degrés Fahrenheit (°F) <--> Degrés Celsius (°C) 
Exercice 2.2.1 : 
Soit "X" la valeur à convertir.
Formule °F vers °C : °C = (X − 32) * 5/9
Formule °C vers °F : °F = (X * 9/5) + 32
L'utilisateur saisit une valeur numérique comprise entre -459.67 et 5 000 000 suivi de l'unité de température : 
▪ C pour Celsius
▪ F pour Fahrenheit
La valeur et l'unité de température sont séparés par un espace (exemple: 32 C pour 32 degrés Celsius). Si la valeur est 
hors limite, l’utilisateur recommence la saisie. 
Pour information, le zéro absolu correspond à -459.67 Degrés Fahrenheit ou -273.15 degrés Celsius. En physique, rien 
ne peut être plus froid que le zéro absolu !
La température de la plus basse jamais enregistrée sur Terre est de -95 degrés Celsius.
Le programme affiche le résultat de la conversion sous forme de nombre réel double précision.*/

import java.text.*;
import java.util.*;

public class E_2_2 {

	public static void main(String[] args) {


		System.out.println("CONVERTISSEUR DEGRÉ CELCIUS ET DEGRÉ FAHRENHEIT");
		System.out.println("----------------------------------------------------------");
		Scanner sc =new Scanner(System.in);
		char mode =' ';
		String test="";
		String rep;

		do {



			do {


				System.out.println("Choisissez le mode de conversion ! ");

				System.out.println(" 1 - Convertisseur Celcius --> Fahrenheit ");
				System.out.println(" 2 - Convertisseur Fahrenheit --> Celcius ");

				test= sc.nextLine();

				mode=test.charAt(0);

				System.out.println(test.length());

				if (mode!='1' &&  mode!='2' &&  test.length()>1)
				{ 

					System.out.println(" Mode inconnu !!! veuillez reitérer l'operation");

				}

			} while ((mode!='1'  &&  mode!='2') ||  test.length()>1); 

			DecimalFormat modele= new DecimalFormat("0.00");
			if (mode=='1') {

				System.out.println("veuillez entrer la temperature en celcius à convertir?");
				double a=sc.nextDouble();
				double s=(a*9)/5 +32;

				String  result=modele.format(s);
				System.out.println("Temperature equivalente en fahrenheit : "+result );



			}
			else 
			{
				System.out.println("veuillez entrer la temperature en Fahrenheit à convertir?");
				double f=sc.nextDouble();
				double c= (f-32 )*5/9;
				String result2 =modele.format(c);
				System.out.println("Temperature equivalente en Celcius : "+result2 );


			}
			sc.nextLine();
			System.out.println("Voulez-vous convertir une autre température ? O /N ");

			rep=sc.nextLine();

		} while ( rep.charAt(0)=='o' && rep.length()<2 );


		System.out.println("programme terminé!");
		sc.close();

	}

	public static double nombreArrondi( double nb, int chiffrevirgule)
	{

		double temp = nb*Math.pow(10, chiffrevirgule);
		double nbarrondis = Math.round(temp)/Math.pow(10, chiffrevirgule);

		return nbarrondis;

	}
}