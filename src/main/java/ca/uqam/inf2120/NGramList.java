package ca.uqam.inf2120;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class NGramList extends LinkedList<NGram> {
    public final int n;

    public NGramList(int n) {
        super();
        this.n = n;
    }

    // Can return 0;
    public long compareWith(NGramList other) {
        if (other.n == n) {
            var intersection = new ArrayList<NGram>();
            for (var a : this) {
                for(var b : other) {
                    if (a.compareTo(b) == 0) {
                        intersection.add(a);
                    }
                }
            }

            return intersection.stream().distinct().count();
        }
        return -1;
    }

    public double recall(NGramList fromGenerated) {
        if (size() == 0) return 0;
        return (double) compareWith(fromGenerated) / size();
    }

    public double precision(NGramList fromTarget) {
        if (size() == 0) return 0;
        return (double) compareWith(fromTarget) / size();
    }

    @Override
    public boolean add(NGram e) {
        if (e.n != n) return false;
        return super.add(e);
    }

    @Override
    public String toString() {
        return "[" + this.stream().map(ngram -> ngram.toString()).collect(Collectors.joining(", ")) + "]";
    }
}
