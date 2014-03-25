package backend.command.display;

import backend.command.Command;

public class SetPenColorCommand extends Command{
	private final static int myParameterCount = 1;
	
	public SetPenColorCommand(){
		super(myParameterCount);
	}
	public double execute(){
		double colorIndex = myParameters.get(0).execute();
		myController.setPenColor(colorIndex, myTurtleID);
		return colorIndex;
	}
}
