package backend.command.booleanops;

import backend.command.Command;

public class NotEqualCommand extends Command{
	private static final int myParameterCount = 2;
	
	public NotEqualCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		return (myParameters.get(0).execute().equals(myParameters.get(1).execute())) ? 0 : 1;
	}

}
