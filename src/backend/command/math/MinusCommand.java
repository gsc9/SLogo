package backend.command.math;

import backend.command.Command;

public class MinusCommand extends Command {
	private final static int myParameterCount = 1;
	
	public MinusCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute(){
		return -1 * myParameters.get(0).execute();
	}

}
