package backend.command.turtle;

import backend.command.Command;

public class PenDownCommand extends Command {
	
	@Override
	public double execute() {
		myController.togglePen(true, myTurtleID);
		return 1;
	}
	
}
