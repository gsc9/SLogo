package slogo;

import java.awt.Dimension;
import javax.swing.JFrame;
import backend.Backend;

import frontend.View;

/**
 * Initializes the GUI.
 */
public class Main {

	public static View VIEW;

	public static void main(String[]args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		// Initialize both frontend and backend
		final Controller c = new Controller();
		VIEW =  new View(c, new Dimension(500,500));
		final Backend be = new Backend(c);
		c.instantiate(be, VIEW);


		// Initialize GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		VIEW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VIEW.pack();
		VIEW.setVisible(true);
	}
}