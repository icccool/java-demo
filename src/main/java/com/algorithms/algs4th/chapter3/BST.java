package com.algorithms.algs4th.chapter3;

/**
 * 二叉查找树
 * algs4th 251
 * Created by WANG on 2018/7/27.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    class Node {

        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public Node put(Node r,Key key, Value val) {
        if (root == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(r.key);
        if(cmp < 0){
            r.left = put(r.left, key, val);
        }
        return null;
    }

}
