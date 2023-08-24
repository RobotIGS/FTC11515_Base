package org.firstinspires.ftc.teamcode.Tools.Chassis;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Tools.DTypes.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

/**
 * Robot:
 *
 * W0+----+W1
 *   |    |
 *   |    |
 * W3+----+W2
 *
 */

//TODO: all ig
public class MecanumChassi extends ChassiBase {
    private final double ONE_OVER_R = 1; //TODO check + add variable(r) + const
    private final double R_OVER_4 = 1;
    private final int l = 1;
    public MecanumChassi() {
        super(4);
    }

    @Override
    public void setVelocity(Velocity velocity) {
        super.setVelocity(velocity);
        // TODO: add source (vy inverted + right side inverted)
        wheelSpeeds[0] =  (velocity.getVX() + velocity.getVY() - l * velocity.getWZ()) * ONE_OVER_R;
        wheelSpeeds[1] = -(velocity.getVX() - velocity.getVY() + l * velocity.getWZ()) * ONE_OVER_R; // negate because right
        wheelSpeeds[2] = -(velocity.getVX() + velocity.getVY() + l * velocity.getWZ()) * ONE_OVER_R; // negate because right
        wheelSpeeds[3] =  (velocity.getVX() - velocity.getVY() - l * velocity.getWZ()) * ONE_OVER_R;
    }

    @Override
    public void step() {
        super.step();



        double dx =  ( deltaWheelMotorSteps[0] + deltaWheelMotorSteps[1] + deltaWheelMotorSteps[2] + deltaWheelMotorSteps[3]) * R_OVER_4;
        double dy = -(-deltaWheelMotorSteps[0] + deltaWheelMotorSteps[1] + deltaWheelMotorSteps[2] - deltaWheelMotorSteps[3]) * R_OVER_4;
        //TODO comments
        dx /= 751.8;
        dy /= 751.8;

        dx *= 10 * Math.PI;
        dy *= 10 * Math.PI;

        drivenDistance = new Position2D(dx,dy);
    }
}
