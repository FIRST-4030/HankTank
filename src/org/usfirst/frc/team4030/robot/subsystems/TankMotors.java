
package org.usfirst.frc.team4030.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4030.robot.RobotMap;
import org.usfirst.frc.team4030.robot.commands.*;

public class TankMotors extends Subsystem {

	private Jaguar left = new Jaguar(RobotMap.pwmDriveLeft);
	private Jaguar right = new Jaguar(RobotMap.pwmDriveRight);
    private RobotDrive drive = new RobotDrive(right, left);
    
    public TankMotors() {
    	right.setInverted(true);
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
    
    public void drive(GenericHID stick) {
    	drive.arcadeDrive(stick);
    }

    public void drive(GenericHID left, GenericHID right) {
    	drive.tankDrive(left, right);
    }
    
    protected void set(double left, double right) {
    	this.left.set(left);
    	this.right.set(right);
    }
    
    public void stop() {
    	left.disable();
    	right.disable();
    }
}
