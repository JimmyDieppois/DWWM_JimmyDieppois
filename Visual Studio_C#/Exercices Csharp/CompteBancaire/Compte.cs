﻿using System;

namespace CompteBancaire
{
    class Compte
    {
        // Attributs
        private long numero;
        private string nom;
        private double solde;
        private double decouvertAutorise;

        // Code
        static void Main(string[] args)
        {
            String answer;

            Compte compte1 = new Compte(4815162342, "Bellamy", 1505, -100);
            Compte compte2 = new Compte(4815162343, "Octavia", 2007, -50);
            Compte compte3 = new Compte(4815162344, "Finn", 1985, -500);
            Compte compte4 = new Compte(4815162345, "Clark", 1007, -103);

            // Donner une représentation textuel de toutes ses informations
            Console.Write("Voulez-vous consulter votre compte ? O/N : ");
            answer = Console.ReadLine();
            if (answer.ToLower().Equals("o"))
                Console.WriteLine(compte1.Afficher());

            Console.Write("\nVoulez-vous consulter les autres comptes ? O/N : ");
            answer = Console.ReadLine();
            if (answer.ToLower().Equals("o"))
            {
                Console.WriteLine(compte2.Afficher());
                Console.WriteLine(compte3.Afficher());
                Console.WriteLine(compte4.Afficher());
                Console.WriteLine("");
            }

            // Créditer d'un montant fourni 
            Console.Write("\nVoulez-vous déposer de l'argent ? O/N : ");
            answer = Console.ReadLine();
            if (answer.ToLower().Equals("o"))
            {
                Console.Write("Indiquez le montant a déposer : ");
                double num = Convert.ToDouble(Console.ReadLine());
                compte1.Crediter(num);
                Console.WriteLine("Crédit de " + num + " $ effectué.\nVotre solde : " + compte1.solde + "\n");
            }

            // Débiter le solde d'un montant fourni, mais attention un "drapeau" (booleen) indiquera si l'opération a pu se réaliser
            Console.Write("\nVoulez-vous retirer de l'argent ? O/N : ");
            answer = Console.ReadLine();
            if (answer.ToLower().Equals("o"))
            {
                Console.Write("Indiquez le montant a retirer : ");
                double num = Convert.ToDouble(Console.ReadLine());
                if (compte1.Debiter(num) == true)
                {
                    Console.WriteLine("Débit de : " + num + " $ effectué.\nVotre solde : " + compte1.solde + "\n");
                }
                else
                {
                    Console.WriteLine("Découvert autorisé dépassé, débit impossible.\nVotre solde : " + compte1.solde + "\n");
                }
            }

            // Transférer un montant, du compte courant vers un autre compte; même remarque que pour le paragraphe précédent.
            Console.Write("\nVoulez-vous transferer de l'argent vers un autre comptre ? O/N : ");
            answer = Console.ReadLine();
            if (answer.ToLower().Equals("o"))
            {
                bool flag;
                do
                {
                    flag = true;
                    Console.Write("Indiquez le numero du compte sujet au transfert : \"4815162343\" \"4815162344\" \"4815162345\" : ");
                    long numAnswer = Convert.ToInt64(Console.ReadLine());
                    Console.Write("\nIndiquez le montant a transferer (Solde actuel : " + compte1.solde + ". Decouvert autorisé : " + compte1.decouvertAutorise + " ) : ");
                    double num = Convert.ToDouble(Console.ReadLine());

                    if (compte2.numero == numAnswer && compte1.Transferer(num, compte2) == true)
                    {
                        Console.WriteLine("Transfert accepté : " + (compte1.solde + num) + " - " + num);
                        Console.WriteLine("Votre solde : " + compte1.solde + "\nSolde du compte crédité : " + compte2.solde);
                    }
                    else if (compte3.numero == numAnswer && compte1.Transferer(num, compte3) == true)
                    {
                        Console.WriteLine("Transfert accepté : " + (compte1.solde + num) + " - " + num);
                        Console.WriteLine("Votre solde : " + compte1.solde + "\nSolde du compte crédité : " + compte3.solde);
                    }
                    else if (compte4.numero == numAnswer && compte1.Transferer(num, compte4) == true)
                    {
                        Console.WriteLine("Transfert accepté : " + (compte1.solde + num) + " - " + num);
                        Console.WriteLine("Votre solde : " + compte1.solde + "\nSolde du compte crédité : " + compte4.solde);
                    }

                    if (compte2.numero != numAnswer && compte3.numero != numAnswer && compte4.numero != numAnswer)
                    {
                        Console.WriteLine("Mauvaise saisie, recommencez.\n");
                        flag = false;
                    }
                    else
                        Console.WriteLine("Découvert autorisé dépassé, transfert impossible.");
                    Console.WriteLine("");
                } while (flag == false);
            }

            // Comparer le solde de l'objet courant avec le solde d'un autre compte fourni, le résultat sera un booléen
            Console.Write("\nVoulez-vous comparer le solde de deux comptes ? O/N : ");
            answer = Console.ReadLine();
            if (answer.ToLower().Equals("o"))
            {
                bool flag = true;
                do
                {
                    Console.Write("Indiquez le nom du compte sujet à la comparaison : \"Octavia\" \"Finn\" \"Clark\" : ");
                    string Answer = Console.ReadLine();

                    if (compte2.nom == Answer)
                        if (compte1.Comparer(compte2) == true)
                            Console.WriteLine("Le solde de votre compte de " + compte1.solde + " est supérieur a celui du compte de " + compte2.nom + " et son solde de " + compte2.solde);
                        else Console.WriteLine("Le solde de votre compte de " + compte1.solde + " est inférieur a celui du compte de " + compte2.nom + " et son solde de " + compte2.solde);

                    else if (compte3.nom == Answer)
                        if (compte1.Comparer(compte3) == true)
                            Console.WriteLine("Le solde de votre compte de " + compte1.solde + " est supérieur a celui du compte de " + compte3.nom + " et son solde de " + compte3.solde);
                        else Console.WriteLine("Le solde de votre compte de " + compte1.solde + " est inférieur a celui du compte de " + compte3.nom + " et son solde de " + compte3.solde);

                    else if (compte4.nom == Answer)
                        if (compte1.Comparer(compte4) == true)
                            Console.WriteLine("Le solde de votre compte de " + compte1.solde + " est supérieur a celui du compte de " + compte4.nom + " et son solde de " + compte4.solde);
                        else Console.WriteLine("Le solde de votre compte de " + compte1.solde + " est inférieur a celui du compte de " + compte4.nom + " et son solde de " + compte4.solde);
                    else
                    {
                        Console.WriteLine("Mauvaise saisie, recommencez.\n");
                        flag = false;
                    }
                } while (flag == false);

            }


            Console.WriteLine("\n-------------------------------------------------------------------------------\n\n" +
                "Appuyez sur une touche pour quitte le programme !");
            Console.ReadLine();
        }

        // Constructeurs
        public Compte()
        {

        }
        public Compte(long _numero, string _nom, double _solde, double _decouvertAutorise)
        {
            this.numero = _numero;
            this.nom = _nom;
            this.solde = _solde;
            this.decouvertAutorise = _decouvertAutorise;
        }

        // Methodes
        public string Afficher()
        {
            string idc = "Numero : " + numero.ToString() + "\nNom : " + nom.ToString() + "\nSolde : " + solde.ToString() +
                "\nLimite decouvert autorisé : " + decouvertAutorise.ToString();
            return idc;
        }
        public void Crediter(double _montant)
        {
            solde = solde + _montant;
        }
        public bool Debiter(double _montant)
        {
            if (solde - decouvertAutorise >= _montant)
            {
                solde = solde - _montant;
                return true;
            }
            return false;
        }
        public bool Transferer(double _montant, Compte _compte)
        {
            if (solde - decouvertAutorise >= _montant)
            {
                solde = solde - _montant;
                _compte.solde = _compte.solde + _montant;
                return true;
            }
            return false;
        }
        public bool Comparer(Compte _compteY)
        {
            if (solde > _compteY.solde)
            {
                return true;
            }
            return false;
        }

    }
}
