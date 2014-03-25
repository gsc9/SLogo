package backend.command.turtle;

import backend.command.Command;

public class SetXYCommand extends Command {
	
	private final static int myParameterCount = 2;
	
	public SetXYCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		double newX = myParameters.get(0).execute();
		double newY = myParameters.get(1).execute();
		double dist = calculateDistance(myController.getX(myTurtleID), 0, myController.getY(myTurtleID), 0);
		myController.setXY(newX, newY, myTurtleID);
		return dist;
	}

}
