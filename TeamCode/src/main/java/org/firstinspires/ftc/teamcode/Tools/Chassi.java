package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

public interface Chassi {
	private Position drivenDistance;
	private double[] wheelSpeeds;
	private DcMotor[] wheelMotors;

	public void setVelocity(Velocity v);
	protected void setMotorSpeeds(double[] v);
	public void step();
	public Velocity getDistance();
	public void stopMotors();
}
