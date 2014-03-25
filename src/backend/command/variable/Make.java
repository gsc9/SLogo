package backend.command.variable;

import backend.command.Command;

public class Make extends Command{
	private final static int myParameterCount = 2;
	
	public Make(){
		super(myParameterCount);
	}
	
	public double execute(){
		return myParameters.get(0).getCommand().setValue(myParameters.get(1).execute());
	}
}
