package backend.command.turtle;

import backend.command.Command;

public class IDCommand extends Command {
	
	@Override
	public double execute() {
		System.out.println(myTurtleID);
		return myTurtleID;
	}

}
