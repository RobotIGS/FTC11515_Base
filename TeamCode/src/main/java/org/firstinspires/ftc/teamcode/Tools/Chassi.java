package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

public interface Chassi {
	Position drivenDistance;
	double[] wheelSpeeds;

	void setVelocity(Velocity v);
	void setMotorSpeeds(double[] v);
	void step();
	Velocity getDistance();
	void stopMotors();
}
