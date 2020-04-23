package ca.uqam.inf2120;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class NGramList extends LinkedList<NGram> {
    public final int n;

    public NGramList(int n) {
        super();
        this.n = n;
    }

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

    public double recall(NGramList fromGenerated) {
        if (size() == 0) return 0;
        return (double) compareWith(fromGenerated) / size();
    }

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
