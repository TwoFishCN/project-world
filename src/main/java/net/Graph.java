package net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, List<Link>> graph = new HashMap<>();

    public void drawLink(String from, String to, Integer length) {
        List<Link> links = graph.computeIfAbsent(from, k -> new ArrayList<>());
        links.add(new Link(from, to, length));
    }


    public Integer getLength(String from, String to) {
        Integer length = 0;

        List<Link> links = graph.get(from);

        getToLength(links, to);

        /*TODO some error.*/
        return -1;
    }

    private Integer getToLength(List<Link> toLinks, String to) {
        for (Link toLink : toLinks) {
            if (toLink.isTo(to)) {
                return toLink.getLength();
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        /*Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7 */

        Graph graph = new Graph();

        String[] links = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7".split(", ");
        for (String link : links) {
            String from = link.substring(0, 1);
            String to = link.substring(1, 2);
            Integer length = Integer.valueOf(link.substring(2, 3));

            graph.drawLink(from, to, length);
        }

        System.out.println(graph);

    }
}
