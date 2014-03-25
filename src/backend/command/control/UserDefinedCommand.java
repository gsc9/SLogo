package backend.command.control;

import backend.command.Command;

public class UserDefinedCommand extends Command {
	private String myName;
	private Command myVars;
	private Command myCode; 
	public UserDefinedCommand(String name, Command vars, Command code){
		super();
		myName = name;
		myVars = vars;
		myCode = code;
		myParameterCount =myVars.getParameterSize()-1; //get parameter count from vars and set myParameterCount to this
	}
	
	public UserDefinedCommand initialize(){
		return new UserDefinedCommand(myName, myVars, myCode);
	}
	
	
	public double execute(){
		for(int i =0; i < myParameterCount; i++){
			myVars.get(i).getCommand().setValue(myParameters.get(i).execute());
		}//shoud b setting each variable to be the inputted value
		return myCode.execute();
	}
	
}
