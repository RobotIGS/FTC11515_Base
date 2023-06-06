package org.firstinspires.ftc.teamcode.Tools.Functions;

public class FunctionSigmoid extends FunctionBase {
    private double r;
    private double n;
    private double a;
    private double k;

    /**
     * f(x) = r - (e^(-(x-n)/a))^k
     * @param a shift of turning point and increase of slope
     * @param r shift on y-axis
     * @param n shift on x-axis
     * @param k change of slope and turning point stays the same
     */
    public FunctionSigmoid(double a, double r, double n, double k) {
        this.r = r < 0 ? r = 1 : Math.abs(r);
        this.n = n > 0 ? n = 0 : -Math.abs(n);
        this.a = a == 0 ? 0.1 : a ;
        this.k = k < 2 ? 2 : Math.abs(k);
    }

    public double apply(double x) {return r - Math.exp(Math.pow(-((x-n)/a),k));};

    }

