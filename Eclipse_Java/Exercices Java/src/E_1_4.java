/*
Exercice 1.4 : Inversion de 2 valeurs 
Lire 2 nombres a et b. 
Mettre le contenu de a dans b et celui de b dans a
 */

import java.util.Scanner;
public class E_1_4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int [] myArray3 = { a, b };

		for (int i = 0; i < myArray3.length; i++) {

		}

		System.out.println( b +""+ a );
		sc.close();	
	}

}



/*int a = sc.nextInt();
int b = sc.nextInt();
/*int[] tableau = { a, b };
System.out.println( b +" "+ a ); */