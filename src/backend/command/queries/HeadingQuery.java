package backend.command.queries;

import backend.command.Command;

public class HeadingQuery extends Command {
	
	@Override
	public double execute() {
		return myController.getHeading(myTurtleID);
	}

}
