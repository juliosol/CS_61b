public class NBody {
    
    public static Double readRadius(String s){
        In in = new In(s);

        int numPlanets = in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static Body[] readBodies(String s){
        In in = new In(s);
        
        int numPlanets = in.readInt();
        double radius = in.readDouble();

        Body planets[] = new Body[numPlanets];

        for (int i = 0; i < numPlanets; i++){
            Double xxPos = in.readDouble();
            Double yyPos = in.readDouble();
            Double xxVel = in.readDouble();
            Double yyVel = in.readDouble();
            Double mass = in.readDouble();
            String name = in.readString();
            Body b1 = new Body(xxPos, yyPos, xxVel, yyVel, mass, name);
            planets[i] = b1;
        }

        return planets;
    }

    public static void main(String[] args){
        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = NBody.readBodies(filename);

        Double radius = NBody.readRadius(filename);

        StdDraw.enableDoubleBuffering();

        //StdAudio.play("audio/2001.mid");

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Body b1:bodies){
            b1.draw();
        }

        for (int time=0; time < T; time++){
            Double xForces[] = new Double[bodies.length];
            Double yForces[] = new Double[bodies.length];
            for (int k = 0; k < bodies.length; k++){
                Body b1 = bodies[k];
                Double xxForce = b1.calcNetForceExertedByX(bodies); 
                Double yyForce = b1.calcNetForceExertedByY(bodies);
                xForces[k] = xxForce;
                yForces[k] = yyForce;
            }
            for (int l = 0; l < bodies.length; l++){
                Body b1 = bodies[l];
                b1.update(dt, xForces[l], yForces[l]);
            }

            StdDraw.setScale(-radius, radius);
            //StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Body b1:bodies){
                b1.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                      bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                      bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }

        //StdDraw.show();
    }

}