package backend.command.math;

import backend.command.Command;

public class TanCommand extends Command {
	private final static int myParameterCount = 1;
	
	public TanCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return Math.tan(myParameters.get(0).execute() * Math.PI / 180);
	}

}
