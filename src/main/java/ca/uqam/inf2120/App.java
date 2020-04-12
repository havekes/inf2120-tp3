package ca.uqam.inf2120;

import java.util.Scanner;

public class App 
{
    static String sentence1;
    static String sentence2;

    public static void main(String[] args)
    {
        readInput();
        System.out.println(sentence1);
        System.out.println(sentence2);
        
        var sen1gram1 = new NGram(sentence1, 1);
        var sen1gram2 = new NGram(sentence1, 2);
        var sen1gram3 = new NGram(sentence1, 3);
        var sen1gram4 = new NGram(sentence1, 4);

        var sen2gram1 = new NGram(sentence2, 1);
        var sen2gram2 = new NGram(sentence2, 2);
        var sen2gram3 = new NGram(sentence2, 3);
        var sen2gram4 = new NGram(sentence2, 4);

        System.out.println(String.format("1-grammes de la phrase 1 = %s", sen1gram1));
        System.out.println(String.format("2-grammes de la phrase 1 = %s", sen1gram2));
        System.out.println(String.format("3-grammes de la phrase 1 = %s", sen1gram3));
        System.out.println(String.format("4-grammes de la phrase 1 = %s", sen1gram4));
    }

    private static void readInput() {
        var sc = new Scanner(System.in);

        System.out.print("Entrez la phrase générée : ");
        sentence1 = sc.nextLine();
        System.out.print("Entrez la phrase cible : ");
        sentence2 = sc.nextLine();
        sc.close();
    }
}
