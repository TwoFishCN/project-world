package com.project.world.algorithm.tree;

public class Node {
    Integer value;

    Node left;
    Node right;

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
}
