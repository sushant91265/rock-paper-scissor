# Problem
Paper-Rock-Scissors is a game for two players. Each player simultaneously opens his/her hand to display
a symbol:
• Fist equals rock
• Open hand equals paper
• Showing the index and middle finger equals scissors.

The winner is determined by the following schema:
• Paper beats (wraps) rock
• Rock beats (blunts) scissors
• Scissors beats (cuts) paper.
Write a program that plays Paper-Rock-Scissors between the computer and a real player. You should be
able to play the game n times before the program exits.

# Solution
- The solution is implemented in Java with more than 85% unit test coverage and the logs are saved in a log file as well. 
- The program is run from the command line. The rules are defined in the `game.properties` file.
- Run the Main.java file to start the program. The program will ask for the number of rounds to play. The user
  will then be asked to enter a choice for each round. The computer will randomly generate a choice for each
  round. The winner of each round will be displayed.

# Libraries used
- JUnit 5 for unit testing
- Maven for build and dependency management
- Lombok for getter and setter generation
- Mockito for mocking
- Logback for logging

