class Node {

    int data;
    Node next; // self referntial data type

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class SimpleLL {
    public static void main(String[] args) {
        var head = new Node(10);
        var temp1 = new Node(20);
        var temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;

        System.out.println(head.data + " --> " + temp1.data + " --> " + temp2.data);
    }
}
