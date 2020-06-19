import javax.swing.event.HyperlinkListener;
import java.lang.Math;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b1){
        double dx = b1.xxPos - this.xxPos;
        double dy = b1.yyPos - this.yyPos;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public double calcForceExertedBy(Body b1){
        double num = G * this.mass * b1.mass;
        double denom = this.calcDistance(b1);
        double force = num / (denom * denom);
        return force;
    }

    public double calcForceExertedByX(Body b1){
        double dx = b1.xxPos - this.xxPos;
        double force = calcForceExertedBy(b1);
        double distance = calcDistance(b1);
        return force * dx / distance;
    }

    public double calcForceExertedByY(Body b1){
        double dy = b1.yyPos - this.yyPos;
        double force = calcForceExertedBy(b1);
        double distance = calcDistance(b1);
        return force * dy / distance;
    }

    public double calcNetForceExertedByX(Body[] bodies){
        double netX = 0;
        for (Body body1:bodies){
            if (this.equals(body1)){
                continue;
            }
            netX += this.calcForceExertedByX(body1);
        }
        return netX;
    }

    public double calcNetForceExertedByY(Body[] bodies){
        double netY = 0;
        for (Body body1:bodies){
            if (this.equals(body1)){
                continue;
            }
            netY += this.calcForceExertedByY(body1);
        }
        return netY;
    }

    public void update(double dt, double fX, double fY){
        double aNetX = fX / this.mass;
        double aNetY = fY / this.mass;
        double vNewX = this.xxVel + dt * aNetX;
        double vNewY = this.yyVel + dt * aNetY;
        double pNewX = this.xxPos + dt * vNewX;
        double pNewY = this.yyPos + dt*vNewY;

        this.xxPos = pNewX;
        this.yyPos = pNewY;
        this.xxVel = vNewX;
        this.yyVel = vNewY;
    }
}
