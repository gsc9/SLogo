package backend.command.control;

import backend.command.Command;

public class ForCommand extends Command {
	private static final int myParameterCount = 2;
	
	public ForCommand(){
		super(myParameterCount);
	}
	public double execute(){
		double returnVal =0.0;
		double start = myParameters.get(0).getCommand().get(1).execute();
		double end = myParameters.get(0).getCommand().get(2).execute();
		double increment = myParameters.get(0).getCommand().get(3).execute();
		for(double i = start; i <= end; i+=increment){
			myParameters.get(0).getCommand().get(0).getCommand().setValue(i);
			returnVal = myParameters.get(1).execute();
		}
		return returnVal; 
	}
}
