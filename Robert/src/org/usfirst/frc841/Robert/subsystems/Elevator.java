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

import org.usfirst.frc841.Robert.Robot;
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
  	private double kp = 1.7; // P
  	private double ki = 0.01; // I
  	private double kd = 0.07; // D
  	private double Setpoint = 3.25; //goal
  	private boolean EnablePID = false; // PID loop enable 
  	private boolean reachDestination = false; // PID within range
  	private double upperlimit = 4.5;
  	private double lowerlimit = 0.0;
 
  	 Timer ControllerTimer;
  	 PIDLoop cloop;
    
     
     //Creates a new timer at the desired time
     public Elevator(){
    	 
    	 cloop = new PIDLoop(X,Y);
    	 cloop.SetControllerDirection(true);
    	 cloop.SetOutputLimits(-1, 1);
    	 cloop.SetSampleTime((long) period);
    	 cloop.SetReference(Setpoint);
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
    				
    				//Implements PID Loop
    				if (elevator.EnablePID){
    					elevator.cloop.SetTunings(elevator.kp,elevator.ki,elevator.kd);
    					elevator.cloop.SetReference(Setpoint);
    					elevator.SetMotors(elevator.cloop.Compute(elevator.GetHieght()));
    					
    					if ( (Setpoint - (Setpoint* 0.03)) < elevator.GetHieght() && elevator.GetHieght() < (Setpoint + (Setpoint* 0.03))){
    						reachDestination = true;
    					}
    					else{
    						reachDestination = false;
    					}
    				}
   
    			}
     	}
     public void updatePIDValues(double _kp,double _ki, double _kd){
     	kp = _kp;
     	ki = _ki;
     	kd = _kd;
     }
     public void enableControlLoop(){
     	EnablePID = true;
     }
     public void disableControlLoop(){
     	EnablePID = false;
     }
     public void SetGoal(double goal){
     	
     	Setpoint = goal;
     		
     }
     public boolean reachDestination() {
     	return reachDestination;
     }
     
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    

    public double GetHieght(){
    	return heightSensor.getVoltage();
    }
    public void SetMotors(double power){
    	if( this.GetHieght() > lowerlimit && this.GetHieght() < upperlimit)
    	{
    		elevatorDrive1.set( power );
    		elevatorDrive2.set( power );
    	}
    	else{
    		EnablePID = false;
    		Joystick stick = Robot.oi.getCoDriver();
    		//stick.
    		elevatorDrive1.set( 0 );
    		elevatorDrive2.set( 0 );
    	}
    }


 

    
}

