package backend.command.math;

import backend.command.Command;

public class ArcTanCommand extends Command {
	private final static int myParameterCount = 1;
	
	public ArcTanCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return Math.atan(myParameters.get(0).execute() * Math.PI / 180);
	}

}
