package ca.uqam.inf2120;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Representation d'un n-gramme
 */
public class NGram implements Comparable<NGram> {

    public final int n;
    public final String[] values;

    /**
     * Cree un n-gramme a partir de la liste des arguments en prametre
     * Le nombre d'arguments sera l'ordre `n` du n-gramme
     * @param args
     */
    public NGram(final String ... args) {
        n = args.length;
        values = args;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof NGram)) return false;

        return compareTo((NGram) obj) == 0 ? true : false;
    }

    @Override
    public int compareTo(NGram other) {
        if (n == other.n) {
            var i = 0;
            var comparaison = values[i].compareToIgnoreCase(other.values[i]);
            while (comparaison == 0 && i < n - 1) {
                i++;
                comparaison = values[i].compareToIgnoreCase(other.values[i]);
            }
            return comparaison;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (n == 1) return String.format("\"%s\"", values[0]);
        return "(" + Arrays.stream(values).map((s) -> "\"" + s + "\"").collect(Collectors.joining(", "))+ ")";
    }
}
