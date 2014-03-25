package backend.command.variable;

import backend.command.Command;
import java.util.HashMap;

public class Variable extends Command {
	private String name;
	
	public Variable(String varName, HashMap<String, Double> var){
		name = varName;
		myVariables = var;
		if(!myVariables.containsKey(name)){
			myVariables.put(name, 0.0);
		}
	}
	
	public double setValue(double val){
		myVariables.put(name, val);
		return val;
	}
	
	public double execute(){
		System.out.println(myVariables.get(name));
		return myVariables.get(name);
	}
}
