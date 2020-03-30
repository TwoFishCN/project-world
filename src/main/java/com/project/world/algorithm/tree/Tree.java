package com.project.world.algorithm.tree;

import static com.project.world.algorithm.tree.TreeUtil.*;

public class Tree {
    Node root;

    public void insert(User user) {
        insertNode(root, user);
    }

    public Node search(User user) {
        return searchNode(root, user);
    }

    public void delete(User user) {
        Node node = search(user);
        deleteNode(node);
    }

}
