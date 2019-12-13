// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.Plybot2020;

import org.usfirst.frc2619.Plybot2020.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton brakeBtn;
    public JoystickButton hatchItBtn;
    public JoystickButton extendBtn;
    public JoystickButton retractBtn;
    public JoystickButton  ShiftHighBtn;
    public JoystickButton shiftLowBtn;
    public JoystickButton shooterBtn;
    public Joystick gamePad;
    public JoystickButton lineBtn;
    public Joystick rightJoystick;
    public JoystickButton retractClimberBtn;
    public JoystickButton helpClimberBtn;
    public Joystick leftJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        leftJoystick = new Joystick(1);
        
        helpClimberBtn = new JoystickButton(leftJoystick, 6);
        helpClimberBtn.whenPressed(new HelpClimber());
        retractClimberBtn = new JoystickButton(leftJoystick, 5);
        retractClimberBtn.whenPressed(new RetractClimber());
        rightJoystick = new Joystick(0);
        
        lineBtn = new JoystickButton(rightJoystick, 6);
        lineBtn.whenPressed(new DriveToLine(0));
        gamePad = new Joystick(4);
        
        shooterBtn = new JoystickButton(gamePad, 1);
        shooterBtn.whileHeld(new Shoot(0));
        shiftLowBtn = new JoystickButton(gamePad, 1);
        shiftLowBtn.whileHeld(new ShiftLow());
         ShiftHighBtn = new JoystickButton(gamePad, 1);
         ShiftHighBtn.whileHeld(new ShiftHigh());
        retractBtn = new JoystickButton(gamePad, 4);
        retractBtn.whenPressed(new Retract());
        extendBtn = new JoystickButton(gamePad, 3);
        extendBtn.whenPressed(new Extend());
        hatchItBtn = new JoystickButton(gamePad, 2);
        hatchItBtn.whileHeld(new HatchIt());
        brakeBtn = new JoystickButton(gamePad, 1);
        brakeBtn.whenPressed(new BrakesOn());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("TankDrive", new TankDrive());
        SmartDashboard.putData("BrakesOn", new BrakesOn());
        SmartDashboard.putData("HatchIt", new HatchIt());
        SmartDashboard.putData("DriveToLine: speed", new DriveToLine(1));
        SmartDashboard.putData("Extend", new Extend());
        SmartDashboard.putData("Retract", new Retract());
        SmartDashboard.putData("ShiftHigh", new ShiftHigh());
        SmartDashboard.putData("ShiftLow", new ShiftLow());
        SmartDashboard.putData("Shoot: speed", new Shoot(.75));
        SmartDashboard.putData("RetractClimber", new RetractClimber());
        SmartDashboard.putData("HelpClimber", new HelpClimber());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getGamePad() {
        return gamePad;
    }

    public Joystick getrightJoystick() {
        return rightJoystick;
    }

    public Joystick getleftJoystick() {
        return leftJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

