package backend.command.control;

import backend.command.Command;

public class IfCommand extends Command{	
	private static final int myParameterCount = 2;
	
	public IfCommand(){
		super(myParameterCount);
	}

	public double execute(){
//		if(myCurrentParameters != myArgumentCount) //&& !myParameters[0].isNumber() && !myParameters[1].getCommand().getClass().toString().endsWith("Bracket")
//			return 0.0;//error message
		if(myParameters.get(0).execute() != 0)
			return myParameters.get(1).execute();
		else
			return 0.0;
	}
}
