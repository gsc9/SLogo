package backend.command.queries;

import backend.command.Command;

public class YCorQuery extends Command {
	
	@Override
	public double execute() {
		return myController.getY(myTurtleID);
	}

}
