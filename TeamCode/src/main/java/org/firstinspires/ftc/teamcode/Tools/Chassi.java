package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

public interface Chassi {
	void setVelocity(Velocity v);
	void step();
	Position getDistance();
	void stopMotors();
}