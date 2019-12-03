package com.mak.stack;

public class SeqStack {

    private int top;
    private int size;
    private int[] arr;

    public SeqStack(){
        top = -1;
        arr = new int[10];
    }

    public SeqStack(int maxsize){
        this.top = -1;
        this.arr = new int[maxsize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == arr.length-1;
    }

    public void push(int value){
        if(isFull()){
            throw new RuntimeException("stack is full");
        }
        top++;
        arr[top] = value;
        size++;
    }

    public int pull(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int value = arr[top];
        top--;
        size--;
        return value;
    }
    public int getTop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return arr[top];
    }

    public void show(){
        if(isEmpty())
            throw new RuntimeException("stack is empty");
        for (int i = top; i >=0 ; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        SeqStack ss = new SeqStack(5);
        for (int i = 0; i <5 ; i++) {
            ss.push(i);

        }
        ss.show();
        ss.pull();
        System.out.println(ss.getTop());
        System.out.println();
        System.out.println(ss.size);
    }
}
