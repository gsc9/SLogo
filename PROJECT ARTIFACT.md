SLogo Project Artifact
=====

Introduction
==
The SLogo program a replica of Logo, where a basic person can type in commands and move a turtle on the canvas. It is an easy interface for someone to learn the language as well as create models and interesting logic-based simulations.

The GUI provides an easy way to test out the different commands for the turtle: forwards, backwards, rotate left and right. There is a panel that keeps track of the position and and the heading of the turtle so that the user knows where the turtle is oriented.

The user can also execute his/her own commands in the textbox, and this is where the GUI has to interact with the backend in order to parse and have the turtle reflect those respective commands.

Overview
==
There are 3 primary modules in our SLogo projecta: Backend.java, View.java and the Controller.java.

### View.java

The view consists of the canvas, turtle, textarea for commands and all the buttons that the user can use to quickly test out the fucntionality of Slogo. The View can hold multiple TabPanel.java classes, and each of those modules load the entire user interface. The user interface contains one Canvas.java class that can hold as many Turtle.java classes as the user wants and instantiates all the fucntional buttons as well as the textarea and the panel containing information about the turtle. When the user enters text in the text area and presses the run button, the information from the textarea gets passed into the Controller.java class.

### Controller.java

The controller handles the communication between the view and the backend. There is a method that passes the string to the backend and mutiple methods that pass backend commands to the current canvas and the current activated turtle. The view takes the command from there are executes them.

### Backend.java

The Backend class contains the method "parse," which takes in a string of user input and sends the input through the appropriate chain of classes to be tokenized and parsed into executable commands. Basically, the Backend takes in information from the frontend, including the string input, the language, and the instance of the controller, and passes these pieces of data down the backend to the Command superclass.

A string is passed into backend by the controller. This string is turned into a list of tokens by the tokenizer where phrases separated by strings or whitespace are broken up into seperate strings. This list of tokens is then passed into the parser. The parser iterates through this list of tokens, creating a new instance of the command corresponding to a token. This command is then given its parameters which can be either numbers or other commands. If the parameter is a command, this new command is recursively created before being added. Commands are subclasses of the Command data type which holds its arguments in the form of Parameter objects. A list of commands in order is the final result of the parser. This list is passed into the Executor which calls the execute of each command in the list. When a command is executed, the function the command corresponds to is run, which may call a controller function to make the turtle move in the frontend or just return a calculation. 




User Interface Design
==

Design Details
==

### View.java
The View.java is instantiated by the Main.java class. It is a JFrame that contains a JTabbedPane private variable called TABS. 

### TabPanel.java
The TabPanel.java class is a JPanel that holds the bulk of what the user sees. The user can add mutliple TabPanel.java classes to the TABS variable through the Add Tab button. The TabPanel.java instantiates everything that the user would see in a tab. This means the buttons for testing turtle movements are instantiated, the panel that reports the turtles position and heading as well as the canvas that acutally holds the turtle and the textarea for the user to type commands in. The TabPanel.java class also contains all the button listners and executes those commands respectively. There are methods to organize the different pieces of the GUI but these could be better placed in individual classes for further clarity.

### Canvas.java
The Canvas.java holds and keeps track of all the turtles that the user creates in a specific tab. 

### Controller.java

### Backend.java
The Backend.java class is instantiated by the Main.java class. It contains the other components of the backend and keeps track of the data that the frontend needs such as the list of variables and the list of userdefined commands.

### Tokenizer.java
The Tokenizer.java class splits the string input into a list of tokens for the parser.

### Parser.java
The Parser.java class creates the tree of commands from the string input. It iterates through the tokens, checking if the string is a command or not. If it is a class, it gets an instance of this command from the CommandFactory. It then completes this command by filling in the specific command's parameters with the completeCommand() method which can be either numbers or commands themselves. It recursively creates nested commands. Once finished, it returns a list of commands to be executed. This type of design was chosen because of the need to handle nested commands. 

### Executor.java
This class executes the commands in order.

### Command.java
The Command class is the superclass for all the specific commands. It allows for adding of parameters and executing a function. Parameters are held in a list of Paramater objects. The dervied subclasses can define how many parameters they have and can access this data when they execute. 

### Parameter.java
This is a container class for either a double or a command. Allows commands to execute without knowing exactly what the parameter is and so allows for running of nested commands like fd fd 50.

### CommandFactory.java
This is a factory class that creates instances of each command using reflection. This design was chosen to allow for multilanguage commands and so commands could be added without hard coding classes into the code.
