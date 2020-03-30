package com.project.world.algorithm.tree;

public class Node {
    User user;

    Node left;
    Node right;

    public Node(User user) {
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
}
