package com.mak.queue;

/**
 *
 *front,rear默认初始化为0
 * 本来采用牺牲一个元素空间来达到队列满的判断条件
 * 因为我加了属性size可以据此判断数队列是否满，所以这里可不再牺牲空间；
 *
 */
public class CircleQueue<T> {

    private int front;
    private int rear;
    private Object[] arr;
    private int size;
    private int maxsize;

    public CircleQueue(){
        this.maxsize = 10;
        this.arr = new Object[maxsize];
    }

    public CircleQueue(int maxsize){
        this.maxsize = maxsize;
        this.arr = new Object[maxsize];
    }

    public boolean isEmpty(){
        return size == 0;      //front == rear;
    }

    public boolean isFull(){
        return size == maxsize ; //(rear+1)%maxsize == front;
    }

    public void push(T val){
        if(isFull())
            return;
        arr[rear] = val;
        rear = (rear+1)%maxsize;
        size++;
    }

    public T pull(){
        if(isEmpty())
            throw new RuntimeException("circleQueue is null");
        T val = (T)arr[front];
        //没有多余空间，出队列一定要置null，不然这些值还在的；
        arr[front] = null;
        front = (front+1)%maxsize;
        size--;
        return val;

    }

    public T getFront(){
        return (T)arr[front];
    }

    public void show(){
        if (isEmpty())
            return;
        for (int i = front; i <front + size ; i++) {
            System.out.println(arr[i%maxsize]);

        }
    }

    public static void main(String[] args) {
        CircleQueue<String> circleQueue = new CircleQueue<>(5);
        for (int i = 0; i <5 ; i++) {
            circleQueue.push(i+"");

        }
        circleQueue.show();
        for (int i = 0; i <5 ; i++) {
            circleQueue.pull();

        }
        System.out.println(circleQueue.getFront());
    }


}
