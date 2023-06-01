package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class BaseAutonomous extends LinearOpMode {
    public abstract void initialize();
    public abstract void run();

    public void runOpMode() {
        initialize();
        waitForStart();
        run();
    }
}
