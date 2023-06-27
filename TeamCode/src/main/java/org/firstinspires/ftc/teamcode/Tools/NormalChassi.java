package org.firstinspires.ftc.teamcode.Tools;

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

public class NormalChassi extends ChassiBase {
    public NormalChassi() {
        super(4);
    }

    @Override
    public void setVelocity(Velocity v) {
        // TODO: rotate
        wheelSpeeds[0] = -v.getVX() - v.getWZ();
        wheelSpeeds[1] =  v.getVX() - v.getWZ();
        wheelSpeeds[2] =  v.getVX() - v.getWZ();
        wheelSpeeds[3] = -v.getVX() - v.getWZ();
    }
}
