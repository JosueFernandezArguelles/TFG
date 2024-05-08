package graph;

import util.Checker;

import java.util.*;

public class Graph {

    private Map<Node, List<Link>> graph;
    private Random random = new Random();

    public Graph(){
        this.graph = new HashMap<>();
    }

    /**
     * Añade un nodo al grafo y crea una lista vacía para sus futuros enlaces.
     * @param node
     */
    public void addNode(Node node){
        graph.put(node, new ArrayList<>());
    }

    /**
     * Añade un enlace en base al nodo de comienzo, fin y al valor del mismo.
     * @param start
     * @param end
     * @param value
     */
    public void addLink(Node start, Node end, int value){
        Checker.checkIsInGraph(start, this.graph);
        Checker.checkIsInGraph(end, this.graph);
        graph.get(start).add(new Link(start, end, value));
        //Añadir enlace en la otra dirección al ser un grafo no dirigido
        graph.get(end).add(new Link(end, start, value));
    }

    /**
     * Devuelve la lista de enlaces de un nodo si este está en el grafo
     * @param node
     * @return
     */
    public List<Link> getLinks(Node node){
        Checker.checkIsInGraph(node, graph);
        return graph.get(node);
    }

    /**
     * Genera un grafo de manera totalemente aleatoria, con un número de nodos aleatorio
     * entre 10 y 30, y unos enlacen aleatorios teniendo cada nodo entre 1 y 4 vecinos,
     * cada uno con un enlace de valor entre 1 y 4.
     * @return
     */
    public Graph generateRandomGraph(){
        int nodes = random.nextInt(10,31);
        List<Node> list = new ArrayList<>();

        //Generación aleatoria de nodos
        for (int i = 0; i < nodes; i++ ){
            Node n = new Node(i);
            addNode(n);
            list.add(n);
        }

        //Generación aleatoria de enlaces
        for (int i = 0; i < nodes; i++ ){
            generateRandomLinks(random.nextInt(1, 5), list.get(i), list );
        }
        return this;
    }

    /**
     * Genera un enlace
     * @param neighbours
     * @param n
     * @param list
     */
    private void generateRandomLinks(int neighbours, Node n, List<Node> list) {
        for (int i = 0; i < neighbours; i++ ){
            Node possibleNeighbour = list.get(random.nextInt(list.size()));
            if( !Checker.existsLink(possibleNeighbour, n, graph) ){
                addLink(n, possibleNeighbour, random.nextInt(1, 5));
            }
        }
    }

    /**
     * Prints the nodes and the links of the graph
     */
    public void printGraph(){
        graph.forEach( (n, l) -> {System.out.println(n + "\n"); System.out.println(l+ "\n");} );
    }

}