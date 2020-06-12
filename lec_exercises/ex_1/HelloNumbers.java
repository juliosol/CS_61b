public class HelloNumbers {
    public static void main(String[] args){
        int x = 0;
        int cum = 0;
        while (x < 10) {
            System.out.print(cum + " ");
            cum = cum + x;
            x = x + 1;
        }
        System.out.println(5 + "10");
    }
}