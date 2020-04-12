package ca.uqam.inf2120.utils;

public class Tuple<T> {
    public final T value1;
    public final T value2;
    public final T value3;
    public final T value4;

    public Tuple(T arg1) {
        value1 = arg1;
        value2 = null;
        value3 = null;
        value4 = null;
    }

    public Tuple(T arg1, T arg2) {
        value1 = arg1;
        value2 = arg2;
        value3 = null;
        value4 = null;
    }

    public Tuple(T arg1, T arg2, T arg3) {
        value1 = arg1;
        value2 = arg2;
        value3 = arg3;
        value4 = null;
    }

    public Tuple(T arg1, T arg2, T arg3, T arg4) {
        value1 = arg1;
        value2 = arg2;
        value3 = arg3;
        value4 = arg4;
    }

    @Override
    public String toString() {
        if (value2 == null) {
            return String.format("\"%s\"", value1);
        }
        if (value3 == null) {
            return String.format("(\"%s\", \"%s\")", value1, value2);
        }
        if (value4 == null) {
            return String.format("(\"%s\", \"%s\", \"%s\")", value1, value2, value3);
        }
        return String.format("(\"%s\", \"%s\", \"%s\", \"%s\")", value1, value2, value3, value4);
    }
}