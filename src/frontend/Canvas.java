package frontend;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

import frontend.objects.Turtle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

	private View myView;
	private List<Turtle> turtles = new ArrayList<Turtle>(); 
	private Turtle DEFAULT_TURTLE;
	private static int DEFAULT_WIDTH;
	private static int DEFAULT_HEIGHT;
	private static int WIDTH_OFFSET;
	private static int HEIGHT_OFFSET;

	public Canvas(int width, int height) {
		DEFAULT_WIDTH = width;
		DEFAULT_HEIGHT = height;
		WIDTH_OFFSET = DEFAULT_WIDTH/2;
		HEIGHT_OFFSET = DEFAULT_HEIGHT/2;
		setBorder(BorderFactory.createLineBorder(Color.black));
		DEFAULT_TURTLE = new Turtle(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2, turtles.size());
		turtles.add(DEFAULT_TURTLE);
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < turtles.size(); i++){
			turtles.get(i).paint(g);
			turtles.get(i).getPen().paint(g);
		}
	} 

	public Turtle getTurtle(int id) {
		return turtles.get(id);
	}

	public void setView(View v) {
		myView = v;
	}

	public void addTurtle() {
		turtles.add(new Turtle(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2, turtles.size()));
		repaint();
	}
	
	public void addTurtle(int id) {
		turtles.add(new Turtle(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2, id));
	}

	public void clear() {
		turtles.removeAll(turtles);
		turtles.add(DEFAULT_TURTLE);
		repaint();
	}
	
	public List<Integer> getAllTurtleIDs() {
		List<Integer> answer = new ArrayList<Integer>();
		for(Turtle t : turtles) {
			answer.add(t.getId());
		}
		return answer;
	}

	public void changeTurtle(BufferedImage img) {
		// TODO Auto-generated method stub
		
	}

}