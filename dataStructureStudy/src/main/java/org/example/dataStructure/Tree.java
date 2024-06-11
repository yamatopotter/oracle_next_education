package org.example.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node newNode = new Node(value);

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size()>0){
                Node currentNode = queue.remove();

                if(currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                }
                else{
                    queue.add(currentNode.left);
                }

                if(currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                }
                else{
                    queue.add(currentNode.right);
                }
            }
        }
    }

//    A pré ordem é utilizada na Busca por profundidade
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(final Node node){
//        Raiz, Esquerda e Direita

        if(node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(final Node node){
//        Esquerda, Raiz e Direita

        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void posOrder(){
        posOrder(root);
    }

    private void posOrder(final Node node){
//        Esquerda, Direita e Raiz

        if(node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

//    Busca em largura
    public void BFS(){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

            System.out.println(node);
        }
    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        System.out.println("#################");
        tree.preOrder();
        System.out.println("#################");

        System.out.println("#################");
        tree.inOrder();
        System.out.println("#################");

        System.out.println("#################");
        tree.posOrder();
        System.out.println("#################");

        System.out.println("#################");
        tree.BFS();
        System.out.println("#################");
    }
}
