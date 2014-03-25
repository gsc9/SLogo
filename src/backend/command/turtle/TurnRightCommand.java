package backend.command.turtle;

import backend.command.Command;

public class TurnRightCommand extends Command {
	private final static int myParameterCount = 1;
	
	public TurnRightCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		double finalArgument = myParameters.get(0).execute();
		myController.rotate(finalArgument, myTurtleID);
		return finalArgument;
	}
	
	public boolean equals(Object o) { //Code for testing purposes, 
		if (o instanceof TurnRightCommand){
			TurnRightCommand r = (TurnRightCommand) o;
			return (myParameters.get(0).equals(r.myParameters.get(0)));
		}
		else
			return false;
	}
	
}
