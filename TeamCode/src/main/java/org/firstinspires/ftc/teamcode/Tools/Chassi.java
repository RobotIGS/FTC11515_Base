package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Tools.DTypes.Velocity;
import org.firstinspires.ftc.teamcode.Tools.DTypes.Position2D;

public interface Chassi {
	void populateMotorArray(HardwareMap hw_map);
	void setVelocity(Velocity v);
	void step();
	Position2D getDrivenDistance();
	void stopMotors();
}