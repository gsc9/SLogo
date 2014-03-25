package backend.command.turtle;

import backend.command.Command;

public class SetHeadingCommand extends Command {
	private final static int myParameterCount = 1;
	
	public SetHeadingCommand(){
		super(myParameterCount);
	}
	
	public double execute() {
		double finalArgument = myParameters.get(0).execute();
		double currentHeading = myController.getHeading(myTurtleID);
		myController.setHeading(finalArgument, myTurtleID);
		return finalArgument - currentHeading;
	}

}
