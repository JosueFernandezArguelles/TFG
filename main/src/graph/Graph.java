package graph;

import util.Checker;

import java.util.*;

public class Graph {

    private final int MIN_NODES = 7;
    private final int MAX_NODES = 8;
    private final int MIN_LINK_VALUE = 5;
    private final int MAX_LINK_VALUE = 10;
    private final int MIN_NEIGHBOURS = 5;
    private final int MAX_NEIGHBOURS = 6;


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

    public List<Node> getNodes(){
        List<Node> nodes = new ArrayList<>();
        graph.forEach((n,l) -> nodes.add(n));
        return nodes;
    }

    public Map<Node, List<Link>> getGraph(){
        return this.graph;
    }

    /**
     * Genera un grafo de manera totalemente aleatoria, con un número de nodos aleatorio
     * entre MIN_NODES y MAX_NODES, y unos enlacen aleatorios teniendo cada nodo entre
     * MIN_NEIGHBOURS y MAX_NEIGHBOURS vecinos, cada uno con un enlace de valor entre
     * MIN_LINK_VALUE y MAX_LINK_VALUE.
     * @return
     */
    public void generateRandomGraph(){
        int nodes = random.nextInt(MIN_NODES,MAX_NODES);
        List<Node> list = new ArrayList<>();

        //Generación aleatoria de nodos
        for (int i = 0; i < nodes; i++ ){
            Node n = new Node(i);
            addNode(n);
            list.add(n);
        }

        //Generación aleatoria de enlaces
        for (int i = 0; i < nodes; i++ ){
            generateRandomLinks(random.nextInt(MIN_NEIGHBOURS, MAX_NEIGHBOURS), list.get(i), list );
        }
    }

    /**
     * Genera tantos enlaces como neighbours se pasen como parámetro al nodo n.
     * @param neighbours
     * @param n
     * @param list
     */
    private void generateRandomLinks(int neighbours, Node n, List<Node> list) {
        for (int i = 0; i < neighbours; i++ ){
            Node possibleNeighbour = list.get(random.nextInt(list.size()));
            if( !Checker.existsLink(possibleNeighbour, n, graph) ){
                addLink(n, possibleNeighbour, random.nextInt(MIN_LINK_VALUE, MAX_LINK_VALUE));
            }
        }
    }

    /**
     * Escribe en pantalla los nodos y enlaces del grafo.
     */
    public void printGraph(){
        graph.forEach( (n, l) -> {System.out.println(n + "\n"); System.out.println(l+ "\n");} );
    }
}