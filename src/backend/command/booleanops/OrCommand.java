package backend.command.booleanops;

import backend.command.Command;

public class OrCommand extends Command {
	private static final int myParameterCount = 2;
	
	public OrCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return ((myParameters.get(0).execute() != 0.0) || (myParameters.get(1).execute() != 0.0))
				? 1 : 0;
	}

}
