package backend.command.math;

import backend.command.Command;

public class PowCommand extends Command {
	private static final int myParameterCount = 2;
	
	public PowCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return Math.pow(myParameters.get(0).execute(), myParameters.get(1).execute());
	}

}
