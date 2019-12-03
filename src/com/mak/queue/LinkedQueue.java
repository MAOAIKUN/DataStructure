package com.mak.queue;

public class LinkedQueue {
    private Node front;     //队头
    private Node rear;      //队尾
    private int size;

    public boolean isEmpty(){
        return front == null;
    }

    public void push(Node node){
        if(isEmpty()){
            front = node;
            rear = node;
        }
        else{
            rear.setNext(node);
            rear = rear.getNext();
        }
        size++;
    }

    public Node pull(){
        if (isEmpty())
            throw new RuntimeException("queue is null");
        Node curNode = front;
        front = front.getNext();
        size--;
        return curNode;
    }

    public Node getFront(){
        return front;
    }

    public int getSize(){
        return size;
    }

    public void show(){
        if (isEmpty())
            return;

        Node curNode = front;
        while(curNode != null){
            System.out.println(curNode);
            curNode = curNode.getNext();
        }

    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i <5 ; i++) {
            linkedQueue.push(new Node<String,Integer>("key"+i,i));
        }
        linkedQueue.show();
        System.out.println();
        System.out.println(linkedQueue.getSize());

        System.out.println();
        linkedQueue.pull();
        System.out.println(linkedQueue.getFront());
        System.out.println(linkedQueue.getSize());
        System.out.println();
        linkedQueue.show();


    }


}

class Node<K,V>{
    private K key;
    private V value;
    private Node next;

    Node(){}

    Node(K key,V value){
        this.key = key;
        this.value = value;
    }

    Node(K key,V value,Node next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "key:"+this.key+"-->"+"value:"+this.value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
