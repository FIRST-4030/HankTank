
package org.ingrahamrobotics.frc2016.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.ingrahamrobotics.frc2016.RobotMap;
import org.ingrahamrobotics.frc2016.commands.*;

public class TankMotors extends Subsystem {

	private Jaguar left = new Jaguar(RobotMap.pwmDriveLeft);
	private Jaguar right = new Jaguar(RobotMap.pwmDriveRight);
    private RobotDrive drive = new RobotDrive(left, right);
	
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
