package backend.command.control;

import backend.command.Command;

public class RepeatCommand extends Command{
	private static final int myParameterCount = 2;
	
	public RepeatCommand(){
		super(myParameterCount);
	}
	
	public double execute(){
		int repcount; 
		Double finalVal =0.0;
		for(repcount = 1; repcount <= myParameters.get(0).execute(); repcount ++){
			myParameters.get(1).setRepCount(repcount);
			finalVal = myParameters.get(1).execute();
		}
		return finalVal;
	}
}
