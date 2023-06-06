package org.firstinspires.ftc.teamcode.Tools.Functions;

public class FunctionLinear extends FunctionBase {
    private double a;
    private double b;

    /**
     * f(x) = a*x + b
     * @param a slope of the function
     * @param b starting value
     */

    public FunctionLinear(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double apply(double x) {
        return a*x + b;
    }
}
	
