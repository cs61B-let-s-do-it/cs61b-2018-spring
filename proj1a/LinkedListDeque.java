public class LinkedListDeque<Item> {
    public class Node()
    {
        private Item item;
        private Node next, prev;
    }

    public Node(Item i, Node n, Node p) {
        this.item = i;
        this.next= n;
        this.prev = p;
    }

    private int size = 0;
    private Node sentinel, last;

    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    public void addFirst(Item item) {
        Node newNode = new Node(item, this.sentinel.next, this.sentinel);
        this.sentinel.next.prev = newNode;
        this.sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, this.sentinel, this.sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int szie() {
        return size;
    }

    public void printDeque() {
        Node p = this.sentinel.next;
        while(true){
            System.out.print(p.item + " ");
            if(p == sentinel.prev) {
                break;
            }
            p = p.next;
        }
    }

    public Item removeFirst() {
        if (sentinel.next == null) {
            return null;
        }
        Item item = (Item) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return item;
    }

    public Item removeLast(){
        Item item = (Item) last.item;
        last = last.prev;
        last.next = sentinel;
        size -= 1;
        return item;
    }

    public Item get(int index){
        if(this.size() == 0){
            return null;
        }else{
            Node p = this.sentinel.next;
            while(index != 0 ){
                if(p.next == this.sentinel){
                    return null;
                }
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
    }

    public Item getRecursive(int index){
        if (index == 0){
            return this.sentinel.next.item;
        }
        Node p = this.sentinel.next;
        return getHelper(index,p);
    }


    private Item getHelper(int index, Node p){
        if(index == 0){
            return p.item;
        }else{
            p = p.next;
            return this.getHelper(index - 1, p);
        }

    }
}
