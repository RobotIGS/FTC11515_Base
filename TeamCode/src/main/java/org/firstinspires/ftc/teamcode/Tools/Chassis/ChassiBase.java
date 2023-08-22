package org.firstinspires.ftc.teamcode.Tools.Chassis;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Tools.DTypes.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

//TODO add l_x, l_y
public abstract class ChassiBase implements Chassi {
    protected Position2D drivenDistance;
    protected double[] wheelSpeeds;
    protected double[] wheelSpeedsFactors;
    private DcMotor[] wheelMotors;
    protected int[] deltaWheelMotorSteps;

    /**
     * create chassi
     */
    public ChassiBase(int numWheels) {
        drivenDistance = new Position2D();
        wheelMotors = new DcMotor[numWheels];
        wheelSpeeds = new double[numWheels];
        wheelSpeedsFactors = new double[numWheels];
        deltaWheelMotorSteps = new int[numWheels];
    }

    // TODO: javadoc
    public void populateMotorArray(HardwareMap hw_map) {
        for (int i = 0; i < this.wheelMotors.length; i++) {
            wheelMotors[i] = hw_map.get(DcMotor.class, String.format("wheelMotor_%d", i));
            wheelSpeeds[i] = 0.0;
            wheelSpeedsFactors[i] = 1.0;
            deltaWheelMotorSteps[i] = wheelMotors[i].getCurrentPosition();
        }
    }

    public void setFactor(int wheelIndex, double factor) {
        if (wheelIndex > 0 && wheelIndex < wheelSpeedsFactors.length)
            wheelSpeedsFactors[wheelIndex] = factor;
    }

    /**
     * set Motor powers
     */
    private void setMotorSpeeds() {
        for (int i = 0; i < wheelMotors.length; i++) {
            wheelMotors[i].setPower(wheelSpeeds[i] * wheelSpeedsFactors[i]);
        }
    }

    /**
     * set wheel speeds based on velocity
     * @param v robot velocity
     */
    public abstract void setVelocity(Velocity v);

    /**
     * get driven distance since last step
     * @return driven distance
     */
    public Position2D getDrivenDistance() {
        return drivenDistance;
    }

    /**
     * stop chassi movement
     */
    public void stopMotors() {
        setVelocity(new Velocity());
        setMotorSpeeds();
    }

    /**
     * update info about delta steps of motors
     */
    private void updateMotorSteps() {
        for (int i=0; i<deltaWheelMotorSteps.length; i++) {
            deltaWheelMotorSteps[i] = wheelMotors[i].getCurrentPosition() - deltaWheelMotorSteps[i];
        }
    }

    /**
     * update
     */
    public void step() {
        setMotorSpeeds();
        updateMotorSteps();
    }
}