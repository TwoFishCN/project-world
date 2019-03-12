package net;

import lombok.Data;

@Data
public class Link {

    private String from;

    private String to;

    private Integer length;

    public Link(String from, String to, Integer length) {
        this.from = from;
        this.to = to;

        this.length = length;
    }
}
