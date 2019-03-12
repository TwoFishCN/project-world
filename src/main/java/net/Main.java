package net;

public class Main {
    public static void main(String[] args) {
        /*Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7 */

        String data = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";

        Graph graph = Graph.build(data);

        System.out.println(graph.getRouteLength("A-B-C"));
        System.out.println(graph.getRouteLength("A-D"));
        System.out.println(graph.getRouteLength("A-D-C"));
        System.out.println(graph.getRouteLength("A-E-B-C-D"));
        System.out.println(graph.getRouteLength("A-E-D"));
    }
}
