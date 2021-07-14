package com.example.task31;

import androidx.annotation.NonNull;

public class Node {
    int data;
    Node previous;
    Node next;

    Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public Node() {
    }

    @NonNull
    @Override
    public String toString() {
        String prevValue = "";
        String nextValue = "";

        if (previous == null) {
            prevValue = "null";
        }
        if (next == null) {
            nextValue = "null";
        }


        return "Node{" +
                "data=" + data +
                ", previous=" + prevValue +
                ", next=" + nextValue +
                '}';
    }
}
