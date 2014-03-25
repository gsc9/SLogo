package backend.command.turtle;

import backend.command.Command;

public class ClearScreenCommand extends Command {
	
	@Override
	public double execute() {
		double dist = calculateDistance(myController.getX(myTurtleID), 0, myController.getY(myTurtleID), 0);
		myController.clearAll();
		return dist;
	}

}
