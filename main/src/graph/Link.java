package graph;

public class Link {
    private Node start;
    private Node end;
    private int value;

    public Link(Node start, Node end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
