package backend.command.control;

import backend.command.Command;

public class IfElseCommand extends Command{
	
	private static final int myParameterCount = 3;

	public IfElseCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		if(myParameters.get(0).execute() != 0)
			return myParameters.get(1).execute();
		else 
			return myParameters.get(2).execute();
	}
	
}
