package frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frontend.objects.Turtle;

public class TurtleManager {
	private Map<Integer, Turtle> myTurtleMap;
	private HashMap<Integer, Boolean> myToggleMap;
	
	public TurtleManager() {
		myTurtleMap = new HashMap<Integer, Turtle>();
		myToggleMap = new HashMap<Integer, Boolean>();
	}
	
	public void update() {
		//polling method that notifies backend that state has been changed
	}
	
	public void add(Turtle t) {
		myTurtleMap.put(t.getId(), t);
	}
	public void remove(Turtle t) {
		myTurtleMap.put(t.getId(), null);
	}
	
	public void move(double offset) {
		for (Turtle t : myTurtleMap.values()) {
			if(t.isShown())
				t.move(offset);
		}
	}
	
	public void rotate(double heading) {
		for (Turtle t : myTurtleMap.values()) {
			if(t.isShown())
				t.rotate(heading);
		}
	}
//	
//	public void makeActive(Turtle t) {
//		t.toggle();
//	}
//	
	private Turtle myCurr;
	
	public Turtle getCurrentTurtle() {
		return myCurr;
	}
	
	private void setCurrentTurtle(Turtle curr) {
		myCurr = curr;
	}
	
	public List<Turtle> getTurtles() {
		ArrayList<Turtle> turtles = new ArrayList<Turtle>(myTurtleMap.values());
		return turtles;
	}

	public Map<Integer, Turtle> getTurtleMap() {
		return myTurtleMap;
	}

}
