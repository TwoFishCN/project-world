package com.project.world.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class NumberToStr {

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> keys = new HashMap<>();

        keys.put(2, Arrays.asList("a", "b", "c"));
        keys.put(3, Arrays.asList("d", "e", "f"));
        keys.put(4, Arrays.asList("g", "h", "i"));
        keys.put(5, Arrays.asList("j", "k", "l"));
        keys.put(6, Arrays.asList("m", "n", "o"));
        keys.put(7, Arrays.asList("p", "q", "r", "s"));
        keys.put(8, Arrays.asList("t", "u", "v"));
        keys.put(9, Arrays.asList("w", "x", "y", "z"));

        List<List<String>> listStream = digits.chars()
                .mapToObj(i -> String.valueOf((char) i))
                .map(it -> keys.get(Integer.parseInt(it)))
                .collect(Collectors.toList());

        return asString(listStream);
    }

    private List<String> asString(List<List<String>> listStream) {

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < listStream.size(); i++) {
            if (queue.isEmpty()) {
                queue.addAll(listStream.get(i));
            } else {
                int len = queue.size();
                for (int j = 0; j < len; j++) {
                    String poll = queue.poll();

                    listStream.get(i).forEach(it -> queue.add(poll + it));
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        List<String> strings = new NumberToStr().letterCombinations("23");
        System.out.println(strings);
    }
}
