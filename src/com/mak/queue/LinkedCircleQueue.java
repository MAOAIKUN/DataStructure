package com.mak.queue;


/**
 *
 * 环形链表实现循环队列
 */
public class LinkedCircleQueue {

    private Node front;
    private Node rear;
    private int size;

    public LinkedCircleQueue(){}

    public boolean isEmpty(){
        return front == null;
    }

    public void push(Node node){
        if (isEmpty()){
            front = node;
            rear = node;
            rear.setNext(front);
        }
        else {
            rear.setNext(node);
            rear = rear.getNext();
            rear.setNext(front);
        }
        size++;
    }

    public Node pull(){
        if(isEmpty())
            throw new RuntimeException("LinkedCirlceQueue is null");
        Node curNode = front;
        front = front.getNext();
        rear.setNext(front);
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
        if(isEmpty())
            return;

        Node curNode = front;
        while (true){
            System.out.println(curNode);
            curNode = curNode.getNext();
            if(curNode == front)
                break;
        }
    }


    public static void main(String[] args) {
        LinkedCircleQueue linkedCircleQueue = new LinkedCircleQueue();

        for (int i = 0; i <5 ; i++) {
            linkedCircleQueue.push(new Node<String,Integer>("key"+i,i));
        }
        linkedCircleQueue.show();
        System.out.println();
        System.out.println(linkedCircleQueue.getSize());

        System.out.println();
        linkedCircleQueue.pull();
        System.out.println(linkedCircleQueue.getFront());
        System.out.println(linkedCircleQueue.getSize());
        System.out.println();
        linkedCircleQueue.show();
    }

}

