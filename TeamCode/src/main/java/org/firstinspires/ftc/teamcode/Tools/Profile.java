package org.firstinspires.ftc.teamcode.Tools;

// TODO: replace t in step by internal variable saving the starttime (call of setDIrection)

public class Profile {
    private boolean acceleration;
    private FunctionLinear accelerationFunction;
    private FunctionLinear deccelerationFunction;

    /*
     * Profile used to accelerate and deccelerate based on a function
     * @param acceFunc function used for acceleration
     * @param decceFunc function used for decceleration
     */
    public Profile(FunctionLinear acceFunc, FunctionLinear deccelFunc) {
        acceleration = true;
        accelerationFunction = acceFunc;
        deccelerationFunction = deccelFunc;
    }

    /*
     * set if acceleration or decceleration is used
     * @param acce if acceleration is used
     */
    public void setDirection(boolean acce) {
        acceleration = acce;
    }

    /*
     * apply functions and return their values
     * @param t time since start
     * @return some factor
     */
    public double step(double t) {
        if (t >= 0)
            return accelerationFunction.apply(t);
        return deccelerationFunction.apply(t);
    }
}
