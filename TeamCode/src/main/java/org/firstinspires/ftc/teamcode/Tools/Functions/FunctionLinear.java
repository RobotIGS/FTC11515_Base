package org.firstinspires.ftc.teamcode.Tools.Functions;

public class FunctionLiniear {
    private double a;
    private double b;

    public FunctionLiniear(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double apply(double x) {
        return a*x + b;
    }
}
	
