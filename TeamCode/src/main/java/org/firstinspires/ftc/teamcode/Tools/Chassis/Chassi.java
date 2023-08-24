package org.firstinspires.ftc.teamcode.Tools.Chassis;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Tools.DTypes.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public interface Chassi {
	void populateMotorArray(HardwareMap hw_map);
	void setFactor(int wheelIndex, double factor);
	void setVelocity(Velocity velocity);
	void step();
	Position2D getDrivenDistance();
	void stopMotors();
	String debug();
}
