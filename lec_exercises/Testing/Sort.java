public class Sort{

    /** Helper function to find the index of the smallest element in an array.*/
    public static int findSmallest(String[] x, int start){
        int smallestIdx = start;
        String smallestValue = x[smallestIdx];
        for (int i = start; i < x.length; i += 1){
            if (x[i].compareTo(smallestValue) <= 0){
                smallestIdx = i;
                smallestValue = x[smallestIdx];
            }
        }
        return smallestIdx;
    }

    /** Swap item a with item b. */
    public static void swap(String[] x, int a, int b){
        String tempA = x[a];
        x[a] = x[b];
        x[b] = tempA;
        tempA = null;
    }

    /** Sorts x starting at position start. */
    public static void sortHelper(String[] x, int start){
        if (start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sortHelper(x, start + 1);
    }

    /** Sort strings destructively. */
    public static void sort(String[] x){
        sortHelper(x, 0);
    }
}