package backend.command.display;

import backend.command.Command;

public class SetShapeCommand extends Command{
	private final static int myParameterCount = 1;
	
	public SetShapeCommand(){
		super(myParameterCount);
	}
	public double execute(){
		double shapeIndex = myParameters.get(0).execute();
		//Call to controller to get shape index
		//call to controller to change shape of turtle to color index[myArgument/myParameter]
		
		//myController.setShape(shapeIndex, myTurtleID);
		return shapeIndex;
	}
}
