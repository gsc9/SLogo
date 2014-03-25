package backend.command.math;

import backend.command.Command;

public class LogCommand extends Command {
	private final static int myParameterCount = 1;
	
	public LogCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return Math.log(myParameters.get(0).execute());
	}

}
