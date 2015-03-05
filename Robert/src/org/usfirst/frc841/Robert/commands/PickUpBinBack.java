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

public class PickUpBinBack extends CommandGroup {
    
    public  PickUpBinBack() {
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
    	
    	//The code will ensure that the claw is open
    	addParallel(new OpenClaw());
    	
    	//It will go directly to the angle associated with this value
    	addSequential(new SetClawAngle( .865 ));
    	
    	//It will go up a little bt so it will tilt the bin over 
    	addSequential(new SetClawAngle( .974 ));
    	
    	//This will close the claw automatically
    	addParallel(new CloseClaw());
    }
}
