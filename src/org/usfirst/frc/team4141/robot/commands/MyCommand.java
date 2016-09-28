package org.usfirst.frc.team4141.robot.commands;

import org.usfirst.frc.team4141.MDRobotBase.MDCommand;
import org.usfirst.frc.team4141.MDRobotBase.MDRobotBase;

public class MyCommand extends MDCommand {

	public MyCommand(MDRobotBase robot, String name) {
		super(robot, name);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	protected void execute() {
		super.execute();
		int count = getRobot().getSubsystems().get("mySubsystem").getConfigSettings().get("setting").getInt();
		for(int i=0;i<count;i++){
			log("execute", "MyCommand executed");
		}
	}
}
