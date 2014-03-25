package backend.command.math;

import backend.command.Command;

public class QuotientCommand extends Command{
	private static final int myParameterCount = 2;
	
	public QuotientCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute(){
		if(myCurrentParameters != myParameterCount)
			return 0;//error
		return myParameters.get(0).execute() / myParameters.get(1).execute();
	}

}
