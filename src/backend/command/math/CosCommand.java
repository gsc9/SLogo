package backend.command.math;

import backend.command.Command;

public class CosCommand extends Command {
	private final static int myParameterCount = 1;
	
	public CosCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return Math.cos(myParameters.get(0).execute() * Math.PI / 180);
	}

}
