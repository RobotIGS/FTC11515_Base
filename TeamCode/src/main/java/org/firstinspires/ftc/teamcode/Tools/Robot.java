package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Position;

public class Robot {
    public FieldNavigation navi;
    public Chassi chassi;
    protected Profile profile;


    /**
     * Set acceleration profile
     * @param p new acceleration profile
     */
    public void setProfile(Profile p) {
        profile = p;
    }

    /**
     * get current acceleration profile
     * @return the current acceleration profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * set robot speed
     * @param vx forward speed (+ => forward)
     * @param vy sideways speed (+ => left)
     * @param wz rotation speed (+ => turn left)
     * @param p use of acceleration profile
     */
    public void setSpeed(double vx, double vy, double wz, boolean p) {}

    /**
     * set robot speed not utilising the acceleration profile
     * @param vx forward speed (+ => forward)
     * @param vy sideways speed (+ => left)
     * @param wz rotation speed (+ => turn left)
     */
    public void setSpeed(double vx, double vy, double wz) {
        setSpeed(vx, vy, wz, false);
    }

    /**
     * drive to position
     * @param d relative or absolute target position
     * @param rel interpret d as a relative position
     */
    public void drive(Position d, boolean rel) {
    }

    /**
     * drive to relative position
     * @param d relative position
     */
    public void drive(Position d) {
        drive(d, true);
    }

    /**
     * refresh
     */
    public void step() {
    }

    /**
     * stop all
     */
    public void stop() {

    }
}
