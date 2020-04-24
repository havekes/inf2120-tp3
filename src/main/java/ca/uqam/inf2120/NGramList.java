package ca.uqam.inf2120;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Representation des n-grammes d'un ordre partiuclier pour une phrase
 */
public class NGramList extends LinkedList<NGram> {
    public final int n;

    /**
     * Cree une nouvelle liste de n-gramms d'ordre n
     * @param n
     */
    public NGramList(int n) {
        super();
        this.n = n;
    }

    /**
     * Calcule la cardinalite de l'intersection entre deux listes de n-grammes
     * @param other Autre liste a comparer
     * @return Cardinalite de l'intersection
     */
    public long compareWith(NGramList other) {
        if (other.n == n) {
            if (this.size() < other.size()) {
                return this.stream().filter(other::contains).count();
            } else {
                return other.stream().filter(this::contains).count();
            }
        }
        return -1;
    }

    /**
     * Calcule le rappel entre une liste de n-grammes et `this`
     * `this` doit provenir de la phrase cible
     * @param fromGenerated liste de n-grammes de la phrase generee
     * @return Rappel
     */
    public double recall(NGramList fromGenerated) {
        if (size() == 0) return 0;
        return (double) compareWith(fromGenerated) / size();
    }

    /**
     * Calcule la precision entre une liste de n-grammes et `this`
     * `this` doit provenir de la phrase generee
     * @param fromTarget
     * @return
     */
    public double precision(NGramList fromTarget) {
        if (size() == 0) return 0;
        return (double) compareWith(fromTarget) / size();
    }

    @Override
    public boolean add(final NGram e) {
        if (e.n != n) return false;
        return super.add(e);
    }

    @Override
    public String toString() {
        return "[" + this.stream().map(ngram -> ngram.toString()).collect(Collectors.joining(", ")) + "]";
    }
}
