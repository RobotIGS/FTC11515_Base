package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public class Robot {
    public FieldNavigation navi;
    public Chassi chassi;
    protected Profile profile;

    // TODO: javadoc
    public Robot(FieldNavigation navi, Chassi chassi) {
        this.navi = navi;
        this.chassi = chassi;
    }

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
    public void setSpeed(double vx, double vy, double wz, boolean p) {
        navi.drive_speed(vx,vy,wz);
        // TODO: handle profile parameter p
    }

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
    public void drive(Position2D d, boolean rel) {
        if (rel)
            navi.drive_rel(d);
        else
            navi.drive_pos(d);
    }

    /**
     * drive to relative position
     * @param d relative position
     */
    public void drive(Position2D d) {
        drive(d, true);
    }

    /**
     * stop all
     */
    public void stop() {
        navi.stop();
        chassi.stopMotors();
    }

    /**
     * refresh
     */
    public void step() {
        navi.addDrivenDistance(chassi.getDrivenDistance());
        navi.step();
        chassi.setVelocity(navi.getVelocity());
        chassi.step();
    }
}
