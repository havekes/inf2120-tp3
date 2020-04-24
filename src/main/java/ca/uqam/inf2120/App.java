package ca.uqam.inf2120;

import java.util.Scanner;

/**
 * Classe principale, demande les deux phrases a l'utilisateur
 */
public class App
{
    static Sentence sentence1;
    static Sentence sentence2;

    /**
     * Affiche le n-grammes ainsi que les valeurs de
     */
    public static void main(String[] args)
    {
        readInput();

        System.out.println("1-grammes de la phrase 1 = " + sentence1.nGrams[1]);
        System.out.println("2-grammes de la phrase 1 = " + sentence1.nGrams[2]);
        System.out.println("3-grammes de la phrase 1 = " + sentence1.nGrams[3]);
        System.out.println("4-grammes de la phrase 1 = " + sentence1.nGrams[4]);

        System.out.println("1-grammes de la phrase 2 = " + sentence2.nGrams[1]);
        System.out.println("2-grammes de la phrase 2 = " + sentence2.nGrams[2]);
        System.out.println("3-grammes de la phrase 2 = " + sentence2.nGrams[3]);
        System.out.println("4-grammes de la phrase 2 = " + sentence2.nGrams[4]);

        System.out.println(Sentence.showCardinality(sentence1, sentence2));
        System.out.println(Sentence.showRecall(sentence1, sentence2));
        System.out.println(Sentence.showPrecision(sentence1, sentence2));
        System.out.println(Sentence.showFmeasure(sentence1, sentence2));
    }

    /**
     * Demande les deux phrases a l'utilisateur et "parse" les phrases en n-grammes
     */
    private static void readInput() {
        var sc = new Scanner(System.in);

        System.out.print("Entrez la phrase générée : ");
        sentence1 = new Sentence(sc.nextLine(), 4);
        System.out.print("Entrez la phrase cible : ");
        sentence2 = new Sentence(sc.nextLine(), 4);
        sc.close();
    }
}
