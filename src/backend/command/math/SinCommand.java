package backend.command.math;

import backend.command.Command;

public class SinCommand extends Command {
	private final static int myParameterCount = 1;
	
	public SinCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return Math.sin(myParameters.get(0).execute() * Math.PI / 180);
	}

}
