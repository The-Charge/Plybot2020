// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.Plybot2020.subsystems;


import org.usfirst.frc2619.Plybot2020.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
//import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX rightFrontMotor;
    private WPI_TalonSRX rightRearMotor;
    private WPI_TalonSRX leftFrontMotor;
    private WPI_TalonSRX leftRearMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private static final double SPEED_P_CONSTANT = 0;
    private static final double SPEED_I_CONSTANT = 0;
    private static final double SPEED_D_CONSTANT = 0;
    private static final double SPEED_F_CONSTANT = 0;
    private static final int TIMEOUT_MS = 10; //maximum processing time threshold
    private static final int MAX_TICKS_PER_SECOND = 6500;

    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rightFrontMotor = new WPI_TalonSRX(1);
        
        
        
        rightRearMotor = new WPI_TalonSRX(2);
        
        
        
        leftFrontMotor = new WPI_TalonSRX(3);
        
        
        
        leftRearMotor = new WPI_TalonSRX(4);
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    //private static final AHRS ahrs = new AHRS(Port.kMXP);
    //sets motors to coast mode neutral mode
    setNeutralMode();

    //inverts it so +1 on right motoe == +1 on left motor
    rightFront.setInverted(true);
    rightRear.setInverted(true);

    //Rear motos have the same properties
    leftRear.follow(leftFront);
    rightRear.follow(rightFront);
    }

    
    

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void run(double l, double r){
        double leftSpeed = l;
        double rightSpeed = r;

        /*
        if (quarterspeed) {
            leftSpeed = 0.25 * l;
            rightSpeed = 0.25 * r;
        }
        */

        leftFront.set(leftSpeed);
        rightFront.set(rightSpeed);
        /* other things we do here:
        drivelocked - to drive straight 
        isReverse - forward on JS = backward
         */
    }

    public void stop(){
        leftFront.set(0);
        rightFront.set(0);
    }

    /**
     * SetPercentVBus - PercentOutput Mode -- Telling motor to run at fixed power
     * When its gets resistance (high friction) -- slow down 
     * low resistance (low friction) -- speed up
     * 
     * Speed Control Mode -- Telling motor to run at fixed power
     * Would run at same speed no matter conditions
     */
    public void setPercentVBus(){
        leftFront.set(ControlMode.PercentOutput, 0);
        rightFront.set(ControlMode.PercentOutput, 0);
    }

    public void setNeutralMode()
    {
        leftFront.setNeutralMode(NeutralMode.Coast);
        rightFront.setNeutralMode(NeutralMode.Coast);
        leftRear.setNeutralMode(NeutralMode.Coast);
        rightRear.setNeutralMode(NeutralMode.Coast);
    }
    public void initSpeedMode()
    {
        leftFront.set(ControlMode.Velocity, 0);
        rightFront.set(ControlMode.Velocity, 0);
        //Assign PID constants to motors
        leftFront.config_kP(1, SPEED_P_CONSTANT, TIMEOUT_MS);
        leftFront.config_kI(1, SPEED_I_CONSTANT, TIMEOUT_MS);
        leftFront.config_kD(1, SPEED_D_CONSTANT, TIMEOUT_MS);
        leftFront.config_kF(1, SPEED_F_CONSTANT, TIMEOUT_MS);

        rightFront.config_kP(1, SPEED_P_CONSTANT, TIMEOUT_MS);
        rightFront.config_kI(1, SPEED_I_CONSTANT, TIMEOUT_MS);
        rightFront.config_kD(1, SPEED_D_CONSTANT, TIMEOUT_MS);
        rightFront.config_kF(1, SPEED_F_CONSTANT, TIMEOUT_MS);
        //Don't know what this is yet...
        leftFront.selectProfileSlot(1, 0);
        rightFront.selectProfileSlot(1, 0);
    }
    public void setPercentSpeedPID (double setSpeed)
    {
        setSpeed = MathUtil.clamp(setSpeed, -1, 1);
        leftFront.set(ControlMode.Velocity, MAX_TICKS_PER_SECOND * setSpeed);
        rightFront.set(ControlMode.Velocity, MAX_TICKS_PER_SECOND * setSpeed);   
    }
    public void setPercentSpeedPID (double setSpeedleft, double setSpeedRight)
    {
        setSpeedleft = MathUtil.clamp(setSpeedleft, -1, 1);
        setSpeedRight = MathUtil.clamp(setSpeedRight, -1, 1);
        leftFront.set(ControlMode.Velocity, MAX_TICKS_PER_SECOND * setSpeedleft);
        rightFront.set(ControlMode.Velocity, MAX_TICKS_PER_SECOND * setSpeedRight);   
    }
    public void writeIndivPIDs(double outputl, double outputr)
    {
        leftFront.pidWrite(outputl);
        rightFront.pidWrite(outputr);
    }
}

