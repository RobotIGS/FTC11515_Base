package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public class MecanumChassi implements Chassi {
    @Override
    public void setVelocity(Velocity v) {
    }

    @Override
    public Position2D getDrivenDistance() {
        return new Position2D();
    }

    @Override
    public void stopMotors() {
    }

    @Override
    public void step() {
    }
}
