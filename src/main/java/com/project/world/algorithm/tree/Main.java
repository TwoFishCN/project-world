package com.project.world.algorithm.tree;

public class Main {
    public static void solution(Node node){
        System.out.println(node.user);

        if (node.hasLeft()){
            solution(node.left);
        }
        if (node.hasRight()){
            solution(node.right);
        }
    }
}
