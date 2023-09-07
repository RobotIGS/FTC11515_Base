package org.firstinspires.ftc.teamcode.OpModes.Testing;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OpModes.TeleOp.BaseTeleOp;
@TeleOp
public class GyroTest extends BaseTeleOp {
    private BNO055IMU imu;
    @Override
    public void initialize() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.jason";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class,"imu");
        imu.initialize(parameters);
    }

    @Override
    public void run() {
        telemetry.addData("AngularOrientation",imu.getAngularOrientation());
        telemetry.update();
    }
}