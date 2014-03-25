package backend.command.math;

import backend.command.Command;

public class RemainderCommand extends Command {
	private static final int myParameterCount = 2;
	
	public RemainderCommand(){
		super(myParameterCount);
	}
	@Override
	public double execute(){
		if(myCurrentParameters != myParameterCount)
			return 0;//error
		return (int) (myParameters.get(0).execute() % myParameters.get(1).execute());
	}

}
