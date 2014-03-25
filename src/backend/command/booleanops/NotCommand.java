package backend.command.booleanops;

import backend.command.Command;

public class NotCommand extends Command {
	private final static int myParameterCount = 1;
	
	public NotCommand(){
		super(myParameterCount);
	}

	@Override
	public double execute() {
		return ((myParameters.get(0).execute() == 0.0)) ? 1 : 0;
	}
}
