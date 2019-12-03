package com.mak.stack;

public class LinkedStack {

    private Node top;      //栈顶
    private int size;

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Node node){
        if(this.isEmpty()){
            top = node;
        }
        else{
            node.setNext(top);
            top = node;
        }
        size++;

    }


    public Node pull(){
        if(isEmpty()){
            throw new RuntimeException("the stack is null");
        }
        Node pullNode = top;
        top = top.getNext();
        size--;
        return pullNode;
    }

    public int getSize(){
        return size;
    }

    public Node getTop(){
        return top;
    }

    public void show(){
        if(isEmpty())
            throw new RuntimeException("stack is null can not show");
        Node  curNode = top;
        while (curNode != null){
            System.out.println(curNode);
            curNode = curNode.getNext();
        }

    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        for (int i = 0; i <5 ; i++) {
            linkedStack.push(new Node("T"+i));
        }

        linkedStack.show();
        System.out.println(linkedStack.getSize());
        System.out.println();

        System.out.println(linkedStack.pull());

        System.out.println();
        linkedStack.show();
        System.out.println();
        System.out.println(linkedStack.getTop());

    }

}

class Node<T>{

    private T value;
    private Node next;

    Node(){}
    Node(T value){
         this.value = value;
    }

    Node(T value,Node next){
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public String toString(){
        return "value "+this.value;
    }
}
