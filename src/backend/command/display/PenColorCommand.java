package backend.command.display;

import backend.command.Command;

public class PenColorCommand extends Command {
	public double execute(){
		return myController.getColorIndex(myTurtleID);
	}
}
