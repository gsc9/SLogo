package backend.command.booleanops;

import backend.command.Command;

public class EqualCommand extends Command {
	private static final int myParameterCount = 2;
	
	public EqualCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return (myParameters.get(0).execute().equals(myParameters.get(1).execute())) ? 1 : 0;
	}

}
