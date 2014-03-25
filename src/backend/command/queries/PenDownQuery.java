package backend.command.queries;

import backend.command.Command;

public class PenDownQuery extends Command {
	
	@Override
	public double execute() {
		return myController.isPenUp(myTurtleID) ? 0 : 1;
	}

}
