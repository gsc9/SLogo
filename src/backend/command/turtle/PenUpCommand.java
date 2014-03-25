package backend.command.turtle;

import backend.command.Command;

public class PenUpCommand extends Command {
	
	@Override
	public double execute() {
		myController.togglePen(false, myTurtleID);
		return 0;
	}
	
}
