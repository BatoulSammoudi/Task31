package com.example.task31;

public class DLL {
    Node head;
    Node tail;
    static int counter = 0;
    String displayList = "";

    public DLL() {

    }

    // at first
    public boolean push(int newData) {
        Node new_Node = new Node(newData);
        boolean flag = false;
        new_Node.next = head;
        new_Node.previous = null;
        if (head != null)
            head.previous = new_Node;
        head = new_Node;
        flag = true;
        counter++;
        return flag;
    }


    public boolean insertAt(Node newNode, int index) {
        boolean flag = false;
        newNode.next = null;
        newNode.previous = null;
        if (index < 0) {
            return false;
        }
        if (index == 1) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            flag = true;
        } else {
            Node temp = new Node();
            temp = head;
            // to get previous
            // temp is the prev for my newNode
            for (int i = 1; i < index - 1; i++) {
                if (temp != null) {
                    temp = temp.next;
                }
            }
            //previous not null
            if (temp != null) {
                newNode.next = temp.next;
                newNode.previous = temp;
                temp.next = newNode;
                if (newNode.next != null) {
                    newNode.next.previous = newNode;
                }
                counter++;
                flag = true;
            }
        }
        return flag;
    }

    public String printValuesBackward() {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (tail != head) {
            displayList += tail.data + " ";
            tail = tail.previous;
        }
        displayList += tail.data;
        return displayList;
    }

    public Node pop() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                return head;
            } else {
                Node temp = new Node();
                temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                Node last = temp.next;
                temp.next = null;
                last = null;
                return temp;
            }
        }
        return null;

    }

    public int size() {
        return counter;
    }

    public boolean contains(int value) {
        int i = 1;
        boolean flag = false;
        //Node current will point to head
        Node current = head;

        //Checks whether the list is empty
        if (head == null) {
            return flag;
        }
        while (current != null) {
            //Compare value to be searched with each node in the list
            if (current.data == value) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        return flag;
    }

    public boolean removeAt(int index) {
        tail = null;
        boolean flag = false;
        if (head == null || index < 0) {
            return flag;
        }
        Node current = head;
        int temp = index;
        for (int i = 1; current != null && i < index; i++) {
            current = current.next;
        }
        if (current == null) {
            flag = false;
            return flag;
        } else {
            deleteNode(current);
            flag = true;
            return flag;
        }

    }

    public Node deleteNode(Node deleted) {
        if (head == null || deleted == null)
            return null;

        if (head == deleted)
            head = deleted.next;

        if (deleted.next != null)
            deleted.next.previous = deleted.previous;

        if (deleted.previous != null)
            deleted.previous.next = deleted.next;

        deleted = null;

        return head;
    }

    public boolean isPalindrome() {
        Node left = head;
        if (left == null) {
            return true;
        }
        Node right = left;
        while (right.next != null) {
            right = right.next;
        }
        while (left != right) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.previous;
        }
        return true;

    }

}
