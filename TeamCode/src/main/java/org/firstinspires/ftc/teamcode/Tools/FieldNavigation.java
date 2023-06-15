package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public class FieldNavigation {
    private boolean driving;
    private Position2D position;
    private double rotation;
    private Position2D target_position;
    private double driving_accuracy;
    private Velocity velocity;

    /**
     * create new FieldNavigation object with given position and rotation
     * @param position position of the robot in CM
     * @param rotation rotation of the robot in Degrees
     */
    public FieldNavigation(Position2D position, double rotation) {
        this.driving = false;
        this.position = position;
        this.rotation = rotation;
        this.target_position = position;
        this.driving_accuracy = 1;
    }

    /**
     * create new FieldNavigation object with (0|0) as position and 0 as rotation
     */
    public FieldNavigation() {
        this(new Position2D(), 0.0);
    }

    /**
     * return if the robot is currently driving
     * @return is driving
     */
    public boolean getDriving() {
        return driving;
    }

    /**
     * set driving accuracy
     * @param accu accuracy in CM
     */
    public void setDriving_accuracy(double accu) {
        driving_accuracy = accu;
    }

    /**
     * drive to position
     * @param p target position
     */
    public void drive_pos(Position2D p) {
        driving = true;
        target_position = p;
    }

    /**
     * drive a relative distance
     * @param d relative target position
     */
    public void drive_rel(Position2D d) {
        d.rotate(-this.rotation);
        d.add(this.position);
        drive_pos(d);
    }

    /**
     * get target velocity
     * @return target velocity
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * get current position
     * @return current position
     */
    public Position2D getPosition(){
        return position;
    }

    /**
     * set current rotation
     * @param rot current rotation
     */
    public void setRotation(double rot) {
        rotation = rot;
    }

    /**
     * set current position
     * @param p position
     */
    public void setPosition(Position2D p) {
        position = p;
    }

    /**
     * calculate current position utilising the driven distance since the last refresh
     * @param d the driven distance
     */
    public void addDrivenDistance(Position2D d) {
        position.add(d);
    }

    /**
     * manual drive
     * @param vx forward speed (+ => forward)
     * @param vy sideways speed (+ => left)
     * @param wz rotation speed (+ => turn left)
     */
    public void drive_speed(double vx, double vy, double wz){
        if (driving)
           driving = false;

        this.velocity.xVeloc = vx;
        this.velocity.yVeloc = vy;
        this.velocity.zVeloc = wz;
    }

    public void stop(){
        drive_speed(0,0,0);
    }

    /**
     * refresh
     */
    public void step() {
        Position2D distance;

        distance = target_position.copy();
        distance.subract(position);

        if (Math.abs(distance.getAbsolute()) <= this.driving_accuracy) {
            stop();
        }

        if (driving) {
            distance = distance.getNormalization();
            velocity.xVeloc = distance.getX();
            velocity.yVeloc = distance.getY();
        }
    }
}
