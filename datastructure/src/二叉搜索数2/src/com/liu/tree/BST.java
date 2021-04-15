package com.liu.tree;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class BST<E> extends BinaryTree {

    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    public void add(E element) {
        elementNotNullCheck(element);

        if(root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //添加的不是第一个结点
        //找到父结点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while(node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if(cmp > 0) {
                node = node.right;
            } else if(cmp < 0) {
                node = node.left;
            } else {//相等
                node.element = element;
                return;
            }
        }

        //看看插入到父结点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if(cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    //找出element对应的节点
    private Node<E> node(E element) {
        Node<E> node = root;
        while(node != null) {
            int cmp = compare(element, node.element);
            if(cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.right;
            } else {//cmp < 0
                node = node.left;
            }
        }
        //此时没有该元素对应的结点
        return null;
    }

    public void remove(Node<E> node) {
        if(node == null) return;

        size--;

        if(node.hasTwoChildren()) {//度为2的结点
            //找到后继结点
            Node<E> s = successor(node);
            //用后继结点的值覆盖度为2的结点的值
            node.element = s.element;
            //删除后继结点
            node = s;//node指向后继结点
        }

        //删除node，此时node的度为1或0
        Node<E> replacement = node.left != null ? node.left :node.right;
        if(replacement != null) {//node是度为1的结点
            //更改parent
            replacement.parent = node.parent;
            //更改parent的left、right的指向
            if(node.parent == null) {//node是度为1的结点并且是根节点
                root = replacement;
            } else if(node == node.parent.left) {
                node.parent.left = replacement;
            } else {//node == node.parent.right
                node.parent.right = replacement;
            }
        } else if(node.parent == null) {//node是叶子结点并且是根结点
            root = null;
        } else {//node是叶子结点但不是根结点
            if(node == node.parent.left) {
                node.parent.left = null;
            } else {//node == node.parent.right
                node.parent.right = null;
            }
        }
    }

    public boolean contains(E element) {
        return node(element) != null;
    }


    private int compare(E e1, E e2) {
        if(comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if(element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }


//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        toString(root, sb, "");
//        return sb.toString();
//    }
//
//    private void toString(Node<E> node, StringBuilder sb, String prefix) {
//        if(node == null) return;
//        sb.append(prefix).append(node.element).append("\n");
//        toString(node.left, sb, prefix + "L---");
//        toString(node.right, sb, prefix + "R---");
//    }

}
