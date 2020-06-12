public class ClassNameHere {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int output = m[0];
        for (int counter = 0;counter < m.length; counter += 1){
            if (output <= m[counter]){
                output = m[counter];
            }
            counter = counter + 1;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}