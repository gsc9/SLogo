package backend.command.turtle;

import backend.command.Command;

/**
 * Moving the turtle forward (relative to its heading, not to the 
 * absolute orientation of the canvas)
 */
public class ForwardCommand extends Command {
	private final static int myParameterCount = 1;
	
	public ForwardCommand(){
		super(myParameterCount);
	}

	public double execute(){
		double finalArgument = myParameters.get(0).execute();
		myController.move(finalArgument, myTurtleID);
		return finalArgument;
	}


	public boolean equals(Object obj) { //Code for testing purposes, 
		if (obj instanceof ForwardCommand){
			ForwardCommand f = (ForwardCommand)obj;
			return (myParameters.get(0).equals(f.myParameters.get(0)));
		}
		else
			return false;
	}
}
