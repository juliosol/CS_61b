public class SLList{

    private class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    /** The first item (if it exists) is a sentinel.next */
    private IntNode sentinel;
    private int size;

    public SLList(){
        sentinel = new IntNode(2, null);
        size = 0;
    }

    public SLList(int x){
        sentinel = new IntNode(2, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int  x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }

}