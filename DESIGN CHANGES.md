Changes to the Frontend Design
===

1) Initially, the canvas contained all the turtles the commands would tell the canvas to move the turtle. Instead, the turtles just live in the canvas, but commands call the turtles movements directly.

2) In order to support tabs we had to create a TabPane class that instantiates the entire interface.

3) The Frontend.java was basically renamed to View.java and doesn't really exist or doesn't really have anything in it.

Changes to the Frontend-Backend API
===

1) Rather than passing turtles between front and backend, we elected to have a 
Controller class that the backend could access to call commands on turtles based on
the turtles' ID numbers. An instance of the Controller class holds methods that take
in an ID number and appropriate parameters for a specific command, and calls a mirror
command in the Canvas class, where the command is actually carried out.
