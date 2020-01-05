public class ArrayDeque<Item>{
    private Item[] arr;
    private int size = 0;
    private int nextFirst = 0;
    private int nextLast = 1;

    public ArrayDeque(){
        arr =  (Item[]) new Object[8];
    }

    public void addFirst(Item item){
        arr[nextFirst] = item;
        if(this.nextFirst == 0){
            nextFirst = this.arr.length - 1;
        }else{
            this.nextFirst -= 1;
        }
        size += 1;
        if( size == arr.length){
            this.resize(arr.length*2);
        }
    }

    public void addLast(Item item){
        if (item == null){
            throw new NullPointerException();
        }
        arr[nextLast] = item;
        nextLast = (nextLast + 1) % (this.arr.length - 1);
        size += 1;
        if( size == arr.length){
            this.resize(arr.length*2);
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return this.size;
    }

    public void printDeque(){

        int pointer = nextFirst % (arr.length - 1) + 1;
        while( pointer <= arr.length - 1){
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }
        pointer = 0;
        while( pointer <= nextFirst ){
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }

    }

    public Item removeFirst(){
        if(size == 0){
            return null;
        }
        Item item;
        if(nextFirst == arr.length - 1){
            item = (Item) arr[0];
            arr[0] = null;
            nextFirst = 0;
        }else{
            item = (Item) arr[nextFirst + 1];
            arr[nextFirst + 1] = null;
            nextFirst += 1;
        }
        size -= 1;
        if(arr.length >= 16 && size > 0 && size == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    public Item removeLast(){
        if(size == 0){
            return null;
        }
        Item item;
        if(nextLast == 0){
            item = (Item) arr[arr.length - 1];
            arr[arr.length - 1] = null;
            nextLast = arr.length - 1;
            //return item;
        }else{
            item = (Item) arr[nextLast - 1];
            arr[nextLast - 1] = null;
            nextLast -= 1;
        }
        size -= 1;
        if(arr.length >= 16 && size > 0 && size == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    public void resize(int capacity){
        int n = arr.length;
        Item[] a = (Item[]) new Object[capacity];
        int pointer = 0;
        while(arr[pointer] == null){
            pointer ++;
        }
        System.arraycopy(this.arr, pointer, a, 0, size);
        arr = a;
        nextFirst = capacity - 1;
        nextLast = n;
    }

    public Item get(int index){
        int indexInArray;
        int starter = nextFirst + 1;
        if(index > this.size - 1){
            return null;
        }else{
            if(nextFirst == arr.length - 1){
                indexInArray = index;
            }else{
                if( index < arr.length - 1 - starter ){
                    indexInArray = (starter + index ) % ( arr.length - 1);
                }else if( index == arr.length -1 - starter){
                    indexInArray = arr.length -1;
                }else{
                    indexInArray = (starter + index ) % ( arr.length - 1) - 1;
                }
            }
        }
        return arr[indexInArray];
    }
}