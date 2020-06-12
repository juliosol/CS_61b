public class DrawTriangle{

    public static void drawTriangle(int N){
        int pos_x = 0;
        int pos_y = 0;
        int ROW = N;
        int COL = N;
        while (pos_x < ROW && pos_y < COL){
            if (pos_x < pos_y){
                System.out.print('*');
                pos_x = pos_x + 1;
            } else if (pos_x == pos_y){
                System.out.println('*');
                pos_x = 0;
                pos_y = pos_y + 1;
            }
        }
    }

    public static void main(String[] args){
        drawTriangle(10);
    }
}