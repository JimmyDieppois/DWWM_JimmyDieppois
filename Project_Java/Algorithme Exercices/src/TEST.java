import java.util.Scanner;
public class TEST
{
  public static void main(String args[])
  {
    int nbr, r = 0;
    System.out.print("Entrez un nombre à inverser : ");
    Scanner sc = new Scanner(System.in);
    nbr = sc.nextInt();
   while(nbr != 0)
    {
     r = r * 10;
      r = r + nbr%10;
      nbr = nbr/10;
      System.out.print(r);
    }
    System.out.println("L'inverse du nombre est " + r);
    sc.close();
  }
}