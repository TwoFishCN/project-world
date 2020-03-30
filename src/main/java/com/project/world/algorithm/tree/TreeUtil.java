package com.project.world.algorithm.tree;

public class TreeUtil {

    public static Node insertNode(Node node, User user) {
        if (node == null) {
            return new Node(user);
        }

        if (node.user.idGreaterThan(user)) {
            node.left = insertNode(node.left, user);
        } else {
            node.right = insertNode(node.right, user);
        }

        return node;
    }

    public static Node searchNode(Node node, User user) {
        if (node == null || node.user.equals(user)) {
            return node;
        } else if (node.user.idGreaterThan(user)) {
            return searchNode(node.left, user);
        } else {
            return searchNode(node.right, user);
        }
    }

    public static void deleteNode(Node p) {
        if (p != null) {
            //如果结点有左子树
        /*1、若p有左子树，找到其左子树的最右边的叶子结点r，用该叶子结点r来替代p，把r的左孩子作为r的父亲的右孩子。
        2。若p没有左子树，直接用p的右孩子取代它。
        */
            if (p.left != null) {
                Node r = p.left;
                Node prev = p.left;
                while (r.right != null) {
                    prev = r;
                    r = r.right;
                }
                p.user = r.user;
                //若r不是p的左子树,p的左子树不变，r的左子树作为r的父结点的右孩子结点
                if (prev != r) {
                    prev.right = r.left;
                } else {
                    //若r是p的左子树，则p的左子树指向r的左子树
                    p.left = r.left;
                }
            } else {
                p = p.right;
            }
        }
    }
}
