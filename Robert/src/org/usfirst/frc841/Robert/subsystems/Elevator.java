// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc841.Robert.subsystems;

import org.usfirst.frc841.Robert.RobotMap;
import org.usfirst.frc841.Robert.commands.*;
import org.usfirst.frc841.Robert.lib.PIDLoop;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class Elevator extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController elevatorDrive1 = RobotMap.elevatorElevatorDrive1;
    SpeedController elevatorDrive2 = RobotMap.elevatorElevatorDrive2;
    AnalogInput heightSensor = RobotMap.elevatorHeightSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


  
  	private double Y[] = {0,0,0};
  	private double X[] = {0,1,2};
  	private int period = 100; //mSec 
  	private double kp = 1.7;
  	private double ki = 0.01;
  	private double kd = 0.07;
 
  	 Timer ControllerTimer;
  	 PIDLoop cloop;
     int Count = 0;
     
     //Creates a new timer at the desired time
     public Elevator(){
    
    	 cloop = new PIDLoop(X,Y);
    	 cloop.SetControllerDirection(true);
    	 cloop.SetOutputLimits(-1, 1);
    	 cloop.SetSampleTime((long) period);
    	 cloop.SetReference(3.25);
    	 cloop.SetTunings(kp, ki, kd);// PID Tuning values
    	 
    	 
    	 ControllerTimer = new Timer();
    	 ControllerTimer.schedule(new Update(this), 0L, period); // schedule PID
     }
     
     	class Update extends TimerTask{
    	 	private Elevator elevator;
    	    	
    	    	public Update(Elevator elevator){
    	    		this.elevator = elevator; 
    	 
    	    	}
    			@Override
    			public void run() {
    				// TODO Auto-generated method stub
    				System.out.println("Test");
    				//elevator.Count++;
    				elevator.SetMotors(elevator.cloop.Compute(elevator.GetHieght()));
   
    				}
    	    	}
    	
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public int getCount(){
    	return this.Count;
    }
    public double GetHieght(){
    	return heightSensor.getVoltage();
    }
    public void SetMotors(double power){
    	elevatorDrive1.set( power );
    	elevatorDrive2.set( power );
    }
  
    
    
}

