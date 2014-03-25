package backend.command.queries;

import backend.command.Command;

public class XCorQuery extends Command {

	@Override
	public double execute() {
		return myController.getX(myTurtleID);
	}
}
