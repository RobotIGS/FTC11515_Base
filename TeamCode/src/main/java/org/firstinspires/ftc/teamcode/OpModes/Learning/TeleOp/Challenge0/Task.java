// package to include files in the same directory
package org.firstinspires.ftc.teamcode.OpModes.Learning.TeleOp.Challenge0;

// must have imports for TeleOp (start with com.qualcomm)
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// imports from org.firstinspires.ftc.teamcode
import org.firstinspires.ftc.teamcode.OpModes.TeleOp.BaseTeleOp;
import org.firstinspires.ftc.teamcode.Tools.Chassis.NormalChassis;
import org.firstinspires.ftc.teamcode.Tools.FieldNavigation;
import org.firstinspires.ftc.teamcode.Tools.Chassis.Chassis;
import org.firstinspires.ftc.teamcode.Tools.Robot;

// imports from Java like Math/etc.

// declare as TeleOp to make it appear on the selection screen
@TeleOp(name="Task 0", group="Challenges")
@Disabled // to disable this TeleOp (hide it on the screen)
public class Task extends BaseTeleOp {
    // declaration of important objects
    private Robot robot;
    private FieldNavigation navi;
    private Chassis chassis;

    // declaration of global variables
    private double speed;

    /*
     * method run once at the beginning of the OpMode
     * used for initializing objects
     * and setting default values for variables
     */
    @Override // override the method of the same name of the parent class
    public void initialize() {
        // create default objects
        navi = new FieldNavigation(); // navigation system for the robot
        chassis = new NormalChassis(); // control interface for the drive train
        chassis.populateMotorArray(hardwareMap); // load motor interfaces

        // create important objects
        robot = new Robot(navi, chassis); // create robot control interface

        // setting default values for variables
        speed = 0.0;
    }

    // method run in a loop from pressing start until stop is pressed
    @Override
    public void run() {
        // tell the robot to set the speed to gamepad values
        robot.setSpeed(-gamepad1.left_stick_y,0.0,-gamepad1.right_stick_x);

        // run robot step method (recursive) to update everything
        robot.step();
    }
}
