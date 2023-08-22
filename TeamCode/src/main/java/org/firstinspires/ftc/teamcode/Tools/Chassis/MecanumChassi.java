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
    private final int l = 1;
    public MecanumChassi() {
        super(4);
    }

    @Override
    public void setVelocity(Velocity v) {
        wheelSpeeds[0] = (v.getVX() - v.getVY() - l * v.getWZ()) * ONE_OVER_R;
        wheelSpeeds[1] = (v.getVX() + v.getVY() + l * v.getWZ()) * ONE_OVER_R;
        wheelSpeeds[2] = (v.getVX() - v.getVY() + l * v.getWZ()) * ONE_OVER_R;
        wheelSpeeds[3] = (v.getVX() + v.getVY() - l * v.getWZ()) * ONE_OVER_R;
    }
    @Override
    public void step() {
        super.step();

        // calculate driven distance


        drivenDistance = new Position2D(0.0,0.0);
    }
}
