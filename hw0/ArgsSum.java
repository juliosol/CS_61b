public class ArgsSum{
    public static void main(String[] args){
        int totalSum = 0;
        for (String elt : args){
            totalSum = totalSum + Integer.parseInt(elt);
        }

        System.out.println(totalSum);
    }
}