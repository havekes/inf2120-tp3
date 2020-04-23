package ca.uqam.inf2120;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence {

    public final int maxN;
    public final NGramList[] nGrams;

    Sentence(String input, int maxN) {
        this.maxN = maxN;
        this.nGrams = new NGramList[maxN + 1];

        var words = input.trim().split("\\W|\\d|_");

        for (var n = 1; n <= maxN; n++) {
            this.nGrams[n] = generateNGramList(n, Arrays.stream(words)
                .filter(w -> w != null && !w.equals(""))
                .collect(Collectors.toList()));
        }
    }

    public static NGramList generateNGramList(int n, List<String> words) {
        var list = new NGramList(n);
        for (var i = 0; (i + n) <= words.size(); i++) {
            list.add(new NGram(words.subList(i, i + n).toArray(new String[0])));
        }
        return list;
    }

    public static String showCardinality(Sentence s1, Sentence s2) {
        if (s1.maxN != s2.maxN) return null;

        var sb = new StringBuilder();
        for (var n = 1; n <= s1.maxN; n++) {
            var c = s1.nGrams[n].compareWith(s2.nGrams[n]);
            sb.append("c" + n + " = " + c);
            if (n != s1.maxN) sb.append(", ");
        }
        return sb.toString();
    }

    public static String showRecall(Sentence generated, Sentence target) {
        if (generated.maxN != target.maxN) return null;

        var sb = new StringBuilder();
        for (var n = 1; n <= target.maxN; n++) {
            var r = target.nGrams[n].recall(generated.nGrams[n]);
            sb.append("r" + n + " = " + r);
            if (n != target.maxN) sb.append(", ");
        }
        return sb.toString();
    }

    public static String showPrecision(Sentence generated, Sentence target) {
        if (generated.maxN != target.maxN) return null;

        var sb = new StringBuilder();
        for (var n = 1; n <= target.maxN; n++) {
            var q = generated.nGrams[n].precision(target.nGrams[n]);
            sb.append("q" + n + " = " + q);
            if (n != target.maxN) sb.append(", ");
        }
        return sb.toString();
    }

    public static String showFmeasure(Sentence generated, Sentence target) {
        if (generated.maxN != target.maxN) return null;

        var sb = new StringBuilder();
        for (var n = 1; n <= target.maxN; n++) {
            var r = target.nGrams[n].recall(generated.nGrams[n]);
            var q = generated.nGrams[n].precision(target.nGrams[n]);
            var f = (r + q == 0) ? 0 : (double) 2 * r * q / (r + q);
            sb.append("F" + n + " = " + f);
            if (n != target.maxN) sb.append(", ");
        }
        return sb.toString();
    }
}
