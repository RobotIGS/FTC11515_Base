package org.firstinspires.ftc.teamcode.OpModes.TeleOp.Examples;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.teamcode.OpModes.TeleOp.BaseTeleOp;
import org.firstinspires.ftc.teamcode.Tools.Chassi;
import org.firstinspires.ftc.teamcode.Tools.ChassiBase;
import org.firstinspires.ftc.teamcode.Tools.FieldNavigation;
import org.firstinspires.ftc.teamcode.Tools.MecanumChassi;
import org.firstinspires.ftc.teamcode.Tools.NormalChassi;
import org.firstinspires.ftc.teamcode.Tools.Robot;

import java.util.Date;

@TeleOp(name="FullControl", group="Examples")
public class FullControl extends BaseTeleOp {
    private Robot robot;
    private FieldNavigation navi;
    private ChassiBase chassi;

    @Override
    public void initialize() {
        navi = new FieldNavigation();
        chassi = new MecanumChassi();
        //chassi.setRotation(0.0f);
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
