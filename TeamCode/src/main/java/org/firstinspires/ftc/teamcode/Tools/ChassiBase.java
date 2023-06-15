package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Tools.DTypes.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public abstract class ChassiBase implements Chassi {
    private Position2D drivenDistance;
    private double[] wheelSpeeds;
    private DcMotor[] wheelMotors;

    /**
     * create chassi
     */
    public ChassiBase() {
        drivenDistance = new Position2D();
    }

    /**
     * set Motor powers
     */
    private void setMotorSpeeds() {
        for (int i = 0; i < wheelMotors.length; i++) {
            wheelMotors[i].setPower(wheelSpeeds[i]);
        }
    }

    /**
     * set wheel speeds based on velocity
     * @param v robot velocity
     */
    @Override
    public abstract void setVelocity(Velocity v);

    /**
     * get driven distance since last step
     * @return driven distance
     */
    @Override
    public Position2D getDrivenDistance() {
        return drivenDistance;
    }

    /**
     * stop chassi movement
     */
    @Override
    public void stopMotors() {
        setVelocity(new Velocity());
        setMotorSpeeds();
    }

    /**
     * update
     */
    @Override
    public void step() {
        setMotorSpeeds();
    }

}