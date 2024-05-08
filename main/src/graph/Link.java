package graph;

import java.util.Objects;

public class Link {
    private Node start;
    private Node end;
    private int value;

    public Link(Node start, Node end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public boolean equals(Node start, Node end) {
        return this.start == start && this.end == end;
    }

    @Override
    public String toString() {
        return "Link{" +
                "start=" + start +
                ", end=" + end +
                ", value=" + value +
                '}';
    }
}
