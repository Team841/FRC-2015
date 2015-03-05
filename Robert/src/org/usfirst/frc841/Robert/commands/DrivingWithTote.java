// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc841.Robert.commands;
import org.usfirst.frc841.Robert.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

public class DrivingWithTote extends CommandGroup {
    
    public  DrivingWithTote() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//Keep the angle of the elevator at 65 deg
    	addParallel(new SetElevatorAngle( .233 ));
    	/*
    	//bring down the carrage to to the top of the one tote
    	addSequential(new SetElevatorHeight( .011 ));
    	
    	I put this in her, but can't remember why
    	*/
    	
    	//change the angle off the elevator to 90 deg
    	addParallel(new SetElevatorAngle( .52 ));
    	
    	//bring down the carrage at the same time to the pickup point of the bottom tote
    	addSequential(new SetElevatorHeight( .011 ));  
    	   
    	//Open Intakes
    	addParallel(new ReleaseTote());
    	//Turn on Intakes
    	addSequential(new BringInTote());
    	
    	
    	//bring carriage up to to pick up tote slightly off the ground
    	addSequential(new SetElevatorHeight( .027 ));
    	 
    }
}

