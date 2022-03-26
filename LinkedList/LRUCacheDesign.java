import java.util.HashMap;

class NodeD {
    int data;
    NodeD next;
    NodeD prev;

    NodeD(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class LRUcache { // O(1) insertion | O(1) auxSpace
    int capacity;
    int count;
    HashMap<Integer, NodeD> hm;
    NodeD head, tail;

    LRUcache(int capacity) {
        hm = new HashMap<>();
        head = tail = null;
        this.capacity = capacity;
        count = 0;
    }

    void show() {
        NodeD cur = head;
        if (cur == null) {
            System.out.println("cache is empty");
            return;
        }
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    void insert(int val) {
        if (hm.get(val) != null) { // hit
            NodeD cur = hm.get(val);
            if (cur == head)
                return;
            if (cur.next != null) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.next = head;
                head.prev = cur;
                cur.prev = null;
                head = cur;
            } else {
                tail = cur.prev;
                tail.next = null;
                cur.next = head;
                head.prev = cur;
                cur.prev = null;
                head = cur;
            }
        } else { // miss
            NodeD in = new NodeD(val);
            if (count < capacity) {
                hm.put(val, in);
                if (count == 0) {
                    head = in;
                    tail = in;
                    count++;
                } else {
                    in.next = head;
                    head.prev = in;
                    in.prev = null;
                    head = in;
                    count++;
                }

            } else {
                if (count == 1) {
                    hm.remove(head.data);
                    head = in;
                    tail = in;
                    hm.put(val, in);
                } else {
                    hm.remove(tail.data);
                    tail = tail.prev;
                    tail.next = null;
                    in.next = head;
                    head.prev = in;
                    in.prev = null;
                    head = in;
                    hm.put(in.data, in);
                }

            }
        }
    }
}

public class LRUcacheDesign {
    public static void main(String[] args) {
        var cache = new LRUcache(3);
        cache.insert(10);
        cache.show();
        cache.insert(20);
        cache.show();
        cache.insert(60);
        cache.show();
        cache.insert(10);
        cache.show();
        cache.insert(69);
        cache.show();
        cache.insert(69);
        cache.show();
        cache.insert(10);
        cache.show();
    }
}
