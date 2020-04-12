package ca.uqam.inf2120;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ca.uqam.inf2120.utils.Tuple;

public class NGram implements Iterable<Tuple<String>> {

    private final int n;
    private final List<String> words;

    NGram(String input, int n) {
        this.n = n;
        this.words = new ArrayList<String>();

        input = input.trim();

        var inputArray = input.toCharArray();
        var lastBreak = 0;

        for (var i = 0; i < inputArray.length; i++) {
            if (!Character.isLetter(inputArray[i])) {
                words.add(input.substring(lastBreak, i));
                lastBreak = i + 1;
            }
        }
        words.add(input.substring(lastBreak));
    }
    
    public int getN() {
      return n;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var it = this.iterator();
        
        sb.append("[ ");
        sb.append(it.next());

        while(it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }

        sb.append(" ]");

        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new IteratorNGram(this);
    }

    public class IteratorNGram implements Iterator<Tuple<String>> {
        private NGram nGram;
        private int i;

        IteratorNGram(NGram nGram) {
            this.nGram = nGram;
            this.i = 0;
        }

        @Override
        public boolean hasNext() {
            return (i + nGram.n + 1) <= nGram.words.size();
        }

        @Override
        public Tuple<String> next() {
            Tuple<String> ret;

            switch (nGram.n) {
                case 1:
                    ret = new Tuple<String>(nGram.words.get(i));
                    break;
                case 2:
                    ret = new Tuple<String>(nGram.words.get(i), nGram.words.get(i + 1));
                    break;
                case 3:
                    ret = new Tuple<String>(nGram.words.get(i), nGram.words.get(i + 1), nGram.words.get(i + 2));
                    break;
                case 4:
                    ret = new Tuple<String>(nGram.words.get(i), nGram.words.get(i + 1), nGram.words.get(i + 2), nGram.words.get(i + 3));
                    break;
                default:
                    ret = null;
            }
            i++;
            return ret;
        }
    }
}