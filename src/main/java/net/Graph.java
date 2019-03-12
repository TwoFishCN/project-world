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

    public static void main(String[] args) {
        char[] chars = "AB5".toCharArray();

        String from = "AB5".substring(0,1);
        String to = String.valueOf(chars[1]);
        Integer length = Integer.valueOf(String.valueOf(chars[2]));
    }
}
