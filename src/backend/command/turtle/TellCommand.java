package backend.command.turtle;

import java.util.ArrayList;
import java.util.List;

import backend.command.Command;

public class TellCommand extends Command {
	
	@Override
	public double execute() {
		double returnVal = 0;
		List<Integer> newActiveTurtleIDs = new ArrayList<Integer>();
		returnVal = myParameters.get(0).execute();
//		for(int i = 0; i < myParameters.size(); i++) {
//			returnVal = myParameters.get(i).execute();
//			newActiveTurtleIDs.add((int)returnVal);
//			myController.addTurtle(returnVal);
//			System.out.println("should have added turtle " + returnVal);
//		}
//		System.out.println("size of newActiveTurtleIDs: " + newActiveTurtleIDs.size());
		myController.syncActiveTurtleIDs(newActiveTurtleIDs);
		return returnVal;
	}

}
