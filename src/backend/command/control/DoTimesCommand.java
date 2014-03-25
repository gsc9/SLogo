package backend.command.control;

import backend.command.Command;

public class DoTimesCommand extends Command {
	private static final int myParameterCount = 2;
	
	public DoTimesCommand(){
		super(myParameterCount);
	}
	public double execute(){ 
		double returnVal = 0.0;
		double limit = myParameters.get(0).getCommand().get(1).execute();
		for(double i =0; i < limit; i++){
			myParameters.get(0).getCommand().get(0).getCommand().setValue(i);
			returnVal = myParameters.get(1).execute();
		}
		return returnVal; //change to return final command run after refactoring
	}
}
