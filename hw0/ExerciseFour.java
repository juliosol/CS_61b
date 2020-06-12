public class ExerciseFour{
    public static void windowsPosSum(int[] a, int n){
        for (int counter = 0; counter < a.length; counter += 1){
            if (a[counter] < 0){
                continue;
            } else if (counter == a.length - 1){
                break;
            } else {}
            for (int num_counter = 1; num_counter <= n; num_counter += 1){
                if (counter + num_counter < a.length){
                    a[counter] += a[counter + num_counter];
                } else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1, 2 , -3, 4, 5, 4};
        int n = 3;
        windowsPosSum(a, n);

        System.out.println(java.util.Arrays.toString(a));
    }
}