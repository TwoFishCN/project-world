package net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, List<Link>> graph = new HashMap<>();

    public static Graph build(String data) {
        Graph graph = new Graph();

        /*删除所有空格, 再按逗号分隔*/
        String[] links = data.replaceAll(" +", "").split(",");

        for (String link : links) {
            String from = link.substring(0, 1);
            String to = link.substring(1, 2);
            Integer length = Integer.valueOf(link.substring(2, 3));

            graph.drawLink(from, to, length);
        }

        return graph;
    }

    private void drawLink(String from, String to, Integer length) {
        List<Link> links = graph.computeIfAbsent(from, k -> new ArrayList<>());
        links.add(new Link(from, to, length));
    }

    private Integer getLinkLength(String from, String to) throws NoRouteException {
        List<Link> links = graph.get(from);

        for (Link toLink : links) {
            if (toLink.isTo(to)) {
                return toLink.getLength();
            }
        }

        throw new NoRouteException("No Route from " + from + " to " + to);
    }

    private Integer countRouteLength(String route) throws NoRouteException {
        String[] nodes = route.split("-");

        if (nodes.length < 2) {
            throw new NoRouteException("too few node.");
        }

        Integer routeLength = 0;
        String from = null;
        String to = null;

        for (String node : nodes) {
            if (from == null) {
                from = node;
            } else if (to == null) {
                to = node;
            } else {
                from = to;
                to = node;
            }

            if (from != null && to != null) {
                routeLength = routeLength + getLinkLength(from, to);
            }
        }

        return routeLength;
    }

    public String getRouteLength(String route) {
        try {
            Integer length = countRouteLength(route);
            return length.toString();
        } catch (NoRouteException e) {
            return "NO SUCH ROUTE";
        }
    }

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
