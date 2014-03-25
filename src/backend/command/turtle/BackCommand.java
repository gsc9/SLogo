package backend.command.turtle;

import backend.command.Command;

/**
 * Moving the turtle backward (relative to its heading, not to the 
 * absolute orientation of the canvas)
 */
public class BackCommand extends Command {
	private final static int myParameterCount = 1;
	
	public BackCommand(){
		super(myParameterCount);
	}
	
	public double execute() {
		double finalArgument = myParameters.get(0).execute();
		myController.move(-1 * finalArgument, myTurtleID);
		return -1 * finalArgument;
	}

	public boolean equals(Object obj) { //Code for testing purposes, 
		if (obj instanceof BackCommand){
			BackCommand b = (BackCommand)obj;
			return (myParameters.get(0).equals(b.myParameters.get(0)));
		}
		else
			return false;
	}
}
