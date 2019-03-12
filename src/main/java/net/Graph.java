package net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, List<Link>> graph = new HashMap<>();

    public static Graph build(String data) {
        Graph graph = new Graph();
        return graph.append(data);
    }

    public Graph append(String data) {
        /*删除所有空格, 再按逗号分隔*/
        String[] links = data.replaceAll(" +", "").split(",");

        for (String link : links) {
            String from = link.substring(0, 1);
            String to = link.substring(1, 2);
            Integer length = Integer.valueOf(link.substring(2, 3));

            drawLink(from, to, length);
        }

        return this;
    }

    private void drawLink(String from, String to, Integer length) {
        List<Link> links = graph.computeIfAbsent(from, k -> new ArrayList<>());
        links.add(new Link(from, to, length));
    }


    public String getRouteLength(String route) {
        try {
            Integer length = countRouteLength(route);
            return length.toString();
        } catch (NoRouteException e) {
            return "NO SUCH ROUTE";
        }
    }

    private Integer countRouteLength(String route) throws NoRouteException {
        String[] nodes = route.split("-");

        if (nodes.length < 2) {
            throw new NoRouteException("too few node.");
        }

        Integer routeLength = 0;
        for (int index = 0; index < nodes.length - 1; index++) {
            routeLength += getLinkLength(nodes[index], nodes[index + 1]);
        }

        return routeLength;
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

}
