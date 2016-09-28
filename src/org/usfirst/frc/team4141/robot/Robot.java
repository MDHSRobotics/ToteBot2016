
package org.usfirst.frc.team4141.robot;


import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MD_BuiltInAccelerometer;
import org.usfirst.frc.team4141.MDRobotBase.sensors.MD_IMU;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;
import org.usfirst.frc.team4141.MDRobotBase.config.DoubleConfigSetting;
import org.usfirst.frc.team4141.MDRobotBase.config.StringConfigSetting;
import org.usfirst.frc.team4141.robot.commands.MDPrintCommand;
import org.usfirst.frc.team4141.robot.subsystems.CoreSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem.MotorPosition;
import org.usfirst.frc.team4141.robot.subsystems.MDDriveSubsystem.Type;

import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends MDRobotBase {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */

	@Override
	protected void configureRobot() {

		//A commands needs to be configured for the autonomous mode.
		//In some cases it is desirable to have more than 1 auto command and make a decision at game time which command to use
		setAutonomousCommand(new MDCommand[]{
				new MDPrintCommand(this,"AutonomousCommand","AutonomousCommand message")
			}, "AutonomousCommand"  //specify the default
		);

		//Subsystem to manage robot wide config settings
		add( new CoreSubsystem(this, "core")
				 .add("name",new StringConfigSetting("MaterBot"))					//go ahead name your robot
				 .add("autoCommand",new StringConfigSetting("AutonomousCommand"))		//name of autoCommand you wish to start with
				 .configure()
		);		
		
		//A robot is composed of subsystems
		//A robot will typically have 1 drive system and several other fit to purpose subsystems		
		//The Drive system is a special subsystem in that it has specific logic handle the speed controllers
		add(new MDDriveSubsystem(this, "driveSystem", Type.TankDrive)
				.add(MotorPosition.left, new Victor(0))
				.add(MotorPosition.right, new Victor(1))
				.add("accelerometer", new MD_BuiltInAccelerometer())
				.add("IMU", new MD_IMU())
				.add("a", new DoubleConfigSetting(0.0, 1.0, 0.25))
				.add("b", new DoubleConfigSetting(0.0, 1.0, 0.4))
				.add("c", new DoubleConfigSetting(0.0, 1.0, 1.0))
				.configure()
		);	

	}



	
	//Override lifecycle methods, as needed
	//	@Override
	//	public void teleopPeriodic() {
	//		super.teleopPeriodic();
	//		...
	//	}
	//	@Override
	//	public void autonomousPeriodic() {
	//		super.autonomousPeriodic();
	//		...
	//	}	
	
		
		//Event manager WebSocket related methods
		//Override as needed
	//	@Override
	//	public void onConnect(Session session) {
	//		super.onConnect(session);
	//		...
	//	}
		
}
