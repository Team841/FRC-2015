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
public class AutoStack3Totes extends CommandGroup {
    
    public  AutoStack3Totes() {
    	
    	//Pick tote up
    	addSequential(new HoldTote());
    	addSequential(new SuckTote());
    	addSequential(new WaitCommand(0.25));
    	addSequential(new ReleaseTote());
    	addSequential(new SetElevatorHeight(0.691 )); //hook
    	addSequential(new SetElevatorAngle( 0.113)); // tilt back
    	addSequential(new SetElevatorHeight(2.313)); // lift up
    	
    	//Turn right forward
    	addSequential(new TurnToDistance(6,0.8,true));
    	//Drive straight around bin
    	//turn on intakes and suck in tote
    	addSequential(new HoldTote());
    	addSequential(new SuckTote());
    	addSequential(new DriveStraightToDistance(30,0.8,false));
    	addSequential(new WaitCommand(0.25));

    	//Turn left 
    	addSequential(new TurnToDistance(12,0.8,false));
    	//Drive straight to tote
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightToDistance(55,0.5,false));
    	addSequential(new WaitCommand(0.1));
    	//stop intakes
    	addSequential(new HoldTote());
    	//Stack tote
    	addSequential(new WaitCommand(0.5));
    	addSequential(new PickUpTote());
    	///drive straight around bin
    	addSequential(new DriveStraightToDistance(32,0.8,false));
    	// turn right
    	addSequential(new TurnToDistance(29,0.8,true));
    	//turn on intakes
    	addSequential(new HoldTote());
    	addSequential(new SuckTote());
    	//drive straight to tote
    	addSequential(new DriveStraightToDistance(50,0.5,false));
    	addSequential(new WaitCommand(0.1));
    	//stop intakes
    	addSequential(new HoldTote());
    	//turn right towards auto zone
    	addSequential(new TurnToDistance(20,0.8,true));
    	//drive to auto zone
    	addParallel(new DriveStraightToDistance(30,1,false));
    	//place stack down
    	addSequential(new PlaceStackDown());
    	addSequential(new ReleaseTote());
    	addSequential(new DriveStraightToDistance(5,1,true));
    	
    	
    	
    	///Cooprtition stackd
    	//
    	///////////
    	
    	/*
      	//Pick tote up
    	addSequential(new HoldTote());
    	addSequential(new SuckTote());
    	addSequential(new WaitCommand(0.25));
    	addSequential(new ReleaseTote());
    	addSequential(new SetElevatorHeight(0.691 )); //hook
    	addSequential(new SetElevatorAngle( 0.113)); // tilt back
    	addSequential(new SetElevatorHeight(2.313)); // lift up
    	
    	//Turn right forward
    	addSequential(new TurnToDistance(8,0.6,true));
    	//Drive straight around bin
    	//turn on intakes and suck in tote
    	addSequential(new HoldTote());
    	addSequential(new SuckTote());
    	addSequential(new DriveStraightToDistance(30,0.5,false));
    	addSequential(new WaitCommand(0.25));

    	//Turn left 
    	addSequential(new TurnToDistance(8,0.6,false));
    	//Drive straight to tote
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightToDistance(55,0.25,false));
    	addSequential(new WaitCommand(0.1));
    	//stop intakes
    	addSequential(new HoldTote());
    	//Stack tote
    	addSequential(new WaitCommand(0.1));
    	addSequential(new PickUpTote());
    	///drive straight around bin
    	addSequential(new DriveStraightToDistance(50,0.5,false));
    	// turn right
    	addSequential(new TurnToDistance(20,0.6,true));
    	//turn on intakes
    	addSequential(new HoldTote());
    	addSequential(new SuckTote());
    	//drive straight to tote
    	addSequential(new DriveStraightToDistance(50,0.25,false));
    	addSequential(new WaitCommand(0.1));
    	//stop intakes
    	addSequential(new HoldTote());
    	//turn right towards auto zone
    	addSequential(new TurnToDistance(10,0.6,true));
    	//drive to auto zone
    	addSequential(new DriveStraightToDistance(30,0.5,false));
    	//place stack down
    	addSequential(new PlaceStackDown());
    	addSequential(new ReleaseTote());
    	addSequential(new DriveStraightToDistance(10,0.5,true));
    	*/
        // Add Commandds here:
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
    }
}