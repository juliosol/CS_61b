public class TestBody {

    public static void main(String[] args) {
        testBody();
    }

    private static void testBody(){
        System.out.println("General checking of Body constructor.");

        double xxPos1 = 1.0,
               yyPos1 = 2.0,
               xxVel1 = 3.0,
               yyVel1 = 4.0,
               mass1 = 5.0;

        String imgFileName1 = "jupiter.gif";

        Body b1 = new Body(xxPos1, yyPos1, xxVel1, yyVel1, mass1, imgFileName1);

        double xxPos2 = 2.3,
               yyPos2 = 9.5,
               xxVel2 = 11,
               yyVel2 = 12,
               mass2 = 10;

        String imgFileName2 = "mercury.gif";

        Body b2 = new Body(xxPos2, yyPos2, xxVel2, yyVel2, mass2, imgFileName2);

        System.out.println("Force x exerted is " + b1.calcForceExertedByX(b2) + " Force y exerted is " + b1.calcForceExertedByY(b2));

    }

}
