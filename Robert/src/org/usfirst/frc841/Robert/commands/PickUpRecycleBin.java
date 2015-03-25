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
public class PickUpRecycleBin extends CommandGroup {
    
    public  PickUpRecycleBin() {
    	
    	addSequential(new SetElevatorAngle(.233)); //Lean Elevator 90  deg
    	addSequential(new SetElevatorHeight(4)); //Move Elevator height to hook bin
    	addSequential(new ReleaseTote());	//Let elevator go
    	addSequential(new SetElevatorAngle(0.133)); //Lean Back.
    
    }
}
  