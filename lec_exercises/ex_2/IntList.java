public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize(){
        IntList p = this;
        int totalSize = 0;
        while (p != null){
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i){
        if (i == 0){
            return this.first;
        }
        return this.rest.get(i-1);
    }

    public void print(){
        IntList p = this;
        while (p != null){
            System.out.print(p.first);
            System.out.print(" -> ");
            p = p.rest;
        }
        System.out.println("null");
    }

    public static IntList incrList(IntList L, int x){
        if (L.rest == null){
            IntList Q = new IntList(L.first + x, null);
            return Q;
        }
        IntList Q = new IntList(L.first + x, incrList(L.rest, x));
        return Q;
    }

    public static IntList dincrList(IntList L, int x){
        IntList Q = L;
        IntList P = L;
        while (Q != null){
            Q.first = Q.first + x;
            Q = Q.rest;
        }
        return P;
    }

    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        IntList P = dincrList(L, 3);
        L.print();
        P.print();
    }
}