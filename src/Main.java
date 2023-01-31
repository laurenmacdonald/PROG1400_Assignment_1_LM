/*
 * Author: Lauren MacDonald
 * Java Program for Assignment 1, PROG1400 at NSCC
 * Due Date: February 1st, 2023
 * Submission Date: January 31st, 2023
 * General requirements: Create a fantasy hockey league by accepting user input for 3 teams who have 3 players each.
 *   Output information about each team, and information about each player on the team.
 * */

//Importing java.util classes to be used in program
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //region "HOUSEKEEPING"
        //Scanner for user input
        Scanner userInput = new Scanner(System.in);

        //Java provided Random class will be used in the Team constructor for budget
        Random random = new Random();
        double limit = 100000;


        //ArrayList of Team objects. Used to hold Teams in the fantasy hockey league.
        ArrayList<Team> league = new ArrayList<>();
        //endregion

        //START OF PROGRAM!
        System.out.print("""
                FANTASY HOCKEY APPLICATION
                TEAM ENTRY
                ================================
                """);
        //region "USER INPUT"
        //1. Creating the league of teams! Team information user input
        for(int i = 0; i < 3; i ++){
            //creating the double variable which will be the random budget, with the limit of 100,000 as the highest possibility.
            double randomBudget = random.nextDouble(limit);
            //creating a new instance of Team, with their random budget parameter input.
            Team team = new Team(randomBudget);
            //TEAM NAME INPUT AND VALIDATION
            System.out.println("Enter name for team # " + (i + 1) + ": ");
            //Setting up a temporary variable for teamName to hold the input value to be checked for length.
            String teamName = userInput.nextLine();
            //Checking that the input is at least 3 characters long.
            while(teamName.length() < 3){
                System.out.println("Sorry, the team name must have at least 3 characters. Please try again!");
                System.out.println("Enter name for team # " + (i + 1) + ": ");
                teamName = userInput.nextLine();
            }
            //Once valid length requirement met, teamName stored in Team object's teamName property.
            team.setTeamName(teamName);
            //Adding the new team data to the league ArrayList
            league.add(team);
            //Now repeat through the loop!
        }

        //2. Adding players to each team! Player information user input
        //Nested for loop used.
        //First, a for each loop used here to iterate through and hit each object in the 'league' ArrayList
        for(Team team : league){
            System.out.println("\nEnter players for " + team.getTeamName() + ": ");
            //Then while iterating through the for each loop, run through a for loop to add 3 player objects to the specified team in above for each loop
            for(int i = 0; i < 3; i ++) {
                //new Player created, with placeholder variables assigned per the constructor.
                Player player = new Player("", 0, 0);
                //PLAYER NAME INPUT AND VALIDATION.
                System.out.println("Enter name for player # " + (i + 1) + ": ");
                //(Same user input validation method used for player name as used for team name, see above for explanation.)
                String playerName = userInput.nextLine();
                while(playerName.length() < 3){
                    System.out.println("Sorry, the player name must have at least 3 characters. Please try again!");
                    System.out.println("Enter name for player # " + (i + 1) + ": ");
                    playerName = userInput.nextLine();
                }
                player.setPlayerName(playerName);

                //PLAYER GOALS INPUT AND VALIDATION.
                //Declaring int variable to hold the number of goals.
                int playerGoals;
                //do while loop with a while loop nested inside is used for input validation.
                //Will continue to prompt for goals until the condition of integer 0 or greater is entered.
                do{
                    System.out.println("Enter number of goals for " + player.getPlayerName() + ": ");
                    while(!userInput.hasNextInt()) {
                        //Checking that the user input is an integer
                        System.out.println("Oops that's not a number. Try again. Enter number of goals for " + player.getPlayerName());
                        userInput.next(); }
                    playerGoals = userInput.nextInt();
                }while (playerGoals < 0 ); //Making sure that the input is 0 or greater, if not will run again.
                //taking the playerGoals variable and saving it to the current looping player object's property 'playerGoals'.
                player.setPlayerGoals(playerGoals);

                //PLAYER ASSISTS INPUT AND VALIDATION.
                //The same method for validating user input on assists is used here, see above for notes on goals input.
                int playerAssists;
                do{
                    System.out.println("Enter number of assists for " + player.getPlayerName() + ": ");
                    while(!userInput.hasNextInt()) {
                        System.out.println("Oops that's not a number. Try again. Enter number of assists for " + player.getPlayerName());
                        userInput.next(); }
                    playerAssists = userInput.nextInt();
                }while (playerAssists < 0 );
                player.setPlayerAssists(playerAssists);
                userInput.nextLine(); //nextLine used to move on from the Scanner.
                //Use the newTeamPlayer method to take the player name, goals and asissts information just entered and save it to the team's ArrayList of team players!
                team.newTeamPlayer(player);
                //Now repeat through the loop to continue to add your 3 players to each of the 3 teams...
            }
        }
        //endregion
        //region "CALCULATIONS"
        //2. Calculate each team's score totals (stats)
        //for each loop to run through each team in the league, used below as well.
        for(Team team : league){
            team.calculateTeamStats(team);
        }
        //3. Calculate each team's rating
        for(Team team : league){
            team.calculateTeamRating(team);
        }
        //endregion
        //region "OUTPUT"
        //4. Print the teams' stats reports!
        System.out.print("""
                
                REPORT: Stats per Team
                ==================================
                """);
        for(Team team : league){
            team.outputTeamStats(team);
        }

        //5. Print the players' stats reports!
        System.out.print("""
                
                REPORT: Stats per Player
                ================================
                """);
        //for each loop to run through each team in the league, with a for each loop nested to run through each player on each team.
        for(Team team : league){
            System.out.println("TEAM " + team.getTeamName().toUpperCase());//.toUpperCase for consistent style on output.
            System.out.println("----------------------------------");
            for(Player player : team.getTeamPlayers()){
                player.outputPlayerDetails(player);
                System.out.print("\n");
            }
        }
        //endregion
        //END OF PROGRAM
        System.out.print("""
                THANKS FOR USING THE FANTASY HOCKEY APPLICATION!
                ================================
                """);
    }
}