package com.me.demo.tariku;

public class PracticeNode<T> {

    private T data;
    private PracticeNode<T> next;
    private PracticeNode<T> prev;

    PracticeNode() {
        next = null;
        prev = null;
        data = null;
    }

    PracticeNode(T data) {
        this(data, null, null);
    }

    PracticeNode(T data, PracticeNode<T> next, PracticeNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public void setNextNode(PracticeNode<T> next) {
        this.next = next;
    }

    public void setPrevNode(PracticeNode<T> prev) {
        this.prev = prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PracticeNode<T> getNextNode() {
        return next;
    }
    public PracticeNode<T> getPrevNode() {
        return prev;
    }

    public T getData() {
        return data;
    }

}
