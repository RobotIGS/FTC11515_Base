package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public interface Chassi {
	void setVelocity(Velocity v);
	void step();
	Position2D getDrivenDistance();
	void stopMotors();
}