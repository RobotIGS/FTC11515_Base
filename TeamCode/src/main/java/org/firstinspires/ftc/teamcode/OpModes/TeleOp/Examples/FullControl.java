package org.firstinspires.ftc.teamcode.OpModes.TeleOp.Examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OpModes.TeleOp.BaseTeleOp;
import org.firstinspires.ftc.teamcode.Tools.FieldNavigation;
import org.firstinspires.ftc.teamcode.Tools.Chassis.ChassiBase;
import org.firstinspires.ftc.teamcode.Tools.Chassis.MecanumChassi;
import org.firstinspires.ftc.teamcode.Tools.Chassis.NormalChassi;
import org.firstinspires.ftc.teamcode.Tools.Robot;

import java.util.Date;

@TeleOp(name="FullControl", group="Examples")
//@Disabled
public class FullControl extends BaseTeleOp {
    private Robot robot;
    private FieldNavigation navi;
    private ChassiBase chassi;

    @Override
    public void initialize() {
        navi = new FieldNavigation();
        chassi = new MecanumChassi();
        chassi.setRotationAxis(1);
        chassi.populateMotorArray(hardwareMap);

        robot = new Robot(navi, chassi);
    }

    @Override
    public void run() {
        robot.setSpeed(-gamepad1.left_stick_y*0.5, -gamepad1.left_stick_x*0.5, -gamepad1.right_stick_x*0.5);
        robot.step();

        telemetry.addLine(chassi.debug());
        telemetry.addLine(navi.debug());
        telemetry.update();
    }
}
