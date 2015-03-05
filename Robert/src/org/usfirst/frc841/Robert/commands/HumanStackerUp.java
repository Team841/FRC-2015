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
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

public class HumanStackerUp extends CommandGroup {
    
    public  HumanStackerUp() {
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
    	
    	//bring down the carriage at the same time to the pickup point of the bottom tote
    	addSequential(new SetElevatorHeight( .0011 ));
    	
    	//Change the elevator angle to 65 deg
    	addSequential(new SetElevatorAngle( .233 ));
    	
    	//bring up the carriage right below the handle before picking it up
    	addSequential(new SetElevatorHeight( 1.465 ));
    	
    	//Keep the angle of the elevator at 90 deg
    	addParallel(new SetElevatorAngle( .52 ));
    	
    	//bring down the carriage at the same time to the pickup point of the bottom tote
    	addSequential(new SetElevatorHeight( 1.992 ));
    	
    	//Keep the angle of the elevator at 65 deg
    	addParallel(new SetElevatorAngle( .233));  
    	
    	//bring up the carriage up above two totes
    	addSequential(new SetElevatorHeight( 3.878 ));
    	
    }
}
