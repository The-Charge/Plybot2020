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

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2619.Plybot2020.commands.*;
import org.usfirst.frc2619.Plybot2020.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */

 //The Robot Class:
 //"Main" of the Robot
 //Instantiates the subsystem
 //Also runs the SmartDashboard which serves as InputOutput/UserInterface
 //The scheduler
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drivetrain drivetrain;
    public static Elevatorr elevatorr;
    public static Hatch hatch;
    public static Extension extension;
    public static Intake intake;
    public static Shifter shifter;
    public static Shooter shooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static boolean DEBUG = true;
    // BEGIN Debug values
    public static boolean rewriteInitialValues = true;
    public static double TurnP = 0.007;
    public static double P = 0.007;
    public static double I = 0.0000725;
    public static double D = 0.0;
    public static double MinSpeed = 0.25;
    // END Debug values

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        elevatorr = new Elevatorr();
        hatch = new Hatch();
        extension = new Extension();
        intake = new Intake();
        shifter = new Shifter();
        shooter = new Shooter();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addObject("Extend", new Extend());
        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() { // TeleOp= Operated by a teller (Human controlled)
    //Or it can be autonomous
        Scheduler.getInstance().run(); // Runs the robot
        dashboardValues();
        if (DEBUG){
            dashboardDebugValues();
        }
        if(rewriteInitialValues)
        {
            writteInitialDashboardValues();
            rewriteInitialValues = false;
        }
    }

    /* The Smartdashboard
    Very useful during the debuging process
    Can be used to output velocity, power, ticks, position etc
    Can be used to call commands, edit the constants and more..
    */



    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    
    }

    /**
     * This function is called when the robot is running
     * Add useful Dashboard values that are always nessesary
     */
    public void dashboardValues() {
        //Outputtong stuff..thoughout the driving (driver will see)
        //SmartDashboard.putNumber("Shooter", shooter.isRunningOut);
       // SmartDashboard.putBoolean("Collection Running Out"), Intake.isRunningOut);


       SmartDashboard.putBoolean("Extended", extension.isExtended());
        //Used to Output public data members
    }
    
    /**
     * This function is called when Debuging or Tuning the Robot
     * Add useful Dashboard values that are only nessesary during debuging or testing
     * This code could be improved with a dictionary
     */
    public void dashboardDebugValues() {
        //Output stuff during debugging process (can disable)
        //SmartDashboard.putData("Stuff directlt wrtitten on Dashboard, Data tobe to displayed")

        //Input stuff:
        double tempDouble = TurnP;
        tempDouble = SmartDashboard.getNumber("TurnP"), tempDouble);
        if(tempDouble !=  TurnP){
            TurnP = tempDouble;
            rewriteInitialValues = true;
        }
    }

    public void writteInitialDashboardValues(){
        if(DEBUG){
            //Have all the commands here so we can run them without JS
            SmartDashboard.putData("Extend", new Extend());
            //Creates a digital button which when pressed runs the command
        }
    }
}
