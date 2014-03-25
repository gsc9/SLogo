package backend.command.booleanops;

import backend.command.Command;

public class LessThanCommand extends Command {
	private static final int myParameterCount = 2;
	
	public LessThanCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return (myParameters.get(0).execute() < myParameters.get(1).execute()) ? 1 : 0;
	}

}
