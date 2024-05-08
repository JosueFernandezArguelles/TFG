package graph;

public class Node {
    private int valor;

    public Node(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "Node{" +
                "valor=" + valor +
                '}';
    }
}
