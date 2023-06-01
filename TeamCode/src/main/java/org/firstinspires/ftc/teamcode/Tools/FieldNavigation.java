package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Date;

public class FieldNavigation {
    private boolean driving;
    private Position position;
    private double rotation;
    private Position target_position;
    private double driving_accuracy;
    private Velocity velocity;
    private Date last_exec;

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
    public void drive_pos(Position p) {
        driving = true;
        target_position = p;
    }

    /**
     * drive a relative distance
     * @param d relative target position
     */
    public void drive_rel(Position d) {
        // TODO: calculate and set real target position
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
    public Position getPosition(){
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
    public void setPosition(Position p) {
        position = p;
    }

    /**
     * calculate current position utilising the driven distance since the last refresh
     * @param d the driven distance
     */
    public void calculatePosition(Position d) {
        // TODO: replace with function
        position.x += d.x;
        position.y += d.y;
    }


    /**
     * refresh
     */
    public void step() {
        // TODO: calculate and set new target velocity
        // TODO: unset driving if target reached (with driving_accuracy)
    }
}
