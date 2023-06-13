package org.firstinspires.ftc.teamcode.Tools.DTypes;

public class Position2D {
    private double x;
    private double y;

    /**
     * create position object
     * @param x x value
     * @param y y value
     */
    public Position2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * create position object in origin
     */
    public Position2D() {
        this(0.0, 0.0);
    }

    public void add(Position2D pos){
        this.x += pos.x;
        this.y += pos.y;
    }

    public void subract(Position2D pos){
        this.x -= pos.x;
        this.y -= pos.y;
    }

    /**
     * get x position
     * @return x position
     */
    public double getX(){
        return x;
    }

    /**
     * get y position
     * @return y position
     */
    public double getY() {
        return y;
    }

    /**
     * set x position
     * @param x x position
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * set y position
     * @param y y position
     */
    public void setY(double y){
        this.y = y;
    }

    /**
     * rotate position around origin
     * @param alpha rotation angle (mathematical positive)
     */
    public void rotate(double alpha){
        double beta;
        double h;

        beta = Math.atan(y/x) + alpha;
        h = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        this.x = Math.cos(beta) * h;
        this.y = Math.sin(beta) * h;
    }

    /**
     * return absolute value
     * @return distance from origin
     */
    public double getAbsolute() {
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    /**
     * copy position object
     * @return copy of object
     */
    public Position2D copy() {
        return new Position2D(this.x, this.y);
    }

    /**
     * normalize position (absolute value = 1)
     * @return normalized copy
     */
    public Position2D getNormalization() {
        if (this.x == 0.0 && this.y == 0)
            return copy();
        else if (this.x == 0.0)
            return new Position2D(0.0,1);
        else if (this.y == 0.0)
            return new Position2D(1,0.0);

        double alpha = Math.atan(this.y / this.x);
        return new Position2D(Math.cos(alpha),Math.sin(alpha));
    }
}