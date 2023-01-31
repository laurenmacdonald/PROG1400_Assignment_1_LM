/*
 * Author: Lauren MacDonald
 * Java Program for Assignment 1, PROG1400 at NSCC
 * Due Date: February 1st, 2023
 * Submission Date: January 31st, 2023
 * General requirements: Create a fantasy hockey league by accepting user input for 3 teams who have 3 players each.
 *   Output information about each team, and information about each player on the team.
 * */
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Team {
    //region "DECLARING PROPERTIES"
    //**Aggregation used to reference the Player class for Team property 'players'
    private String teamName;
    //Note about ArrayLists... used to make use of provided methods, also no set limit to size of ArrayList, can easily grow teams from 3
    //Program could also be written with use of arrays, but personally prefer ArrayLists for above reasons!
    private ArrayList<Player> teamPlayers = new ArrayList<>();
    private int teamGoals;
    private int teamAssists;
    private int teamTotals;
    private String teamRating;
    private double teamBudget;
    //endregion

    //region "CONSTRUCTOR"
    public Team(double teamBudget) {
        this.teamBudget = teamBudget;
    }
    //endregion

    //region "GETTERS AND SETTERS"
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public int getTeamGoals() {
        return teamGoals;
    }

    public int getTeamAssists() {
        return teamAssists;
    }

    public int getTeamTotals() {
        return teamTotals;
    }

    public String getTeamRating() {
        return teamRating;
    }

    public double getTeamBudget() {
        return teamBudget;
    }

    //endregion

    //region "METHODS"
    //METHOD: Add a new team player to the ArrayList of players in the team
    public void newTeamPlayer(Player player) {

        teamPlayers.add(player);
    }

    //METHOD: Calculate the Team's Total Score Using Team Players Goals and Assists
    public void calculateTeamStats(Team team) {
        int teamGoals = 0;
        int teamAssists = 0;
        int teamTotals = 0;
        //for each loop used to iterate through the player objects in the team player list
        for (Player player : team.getTeamPlayers()) {
            teamGoals = teamGoals + player.getPlayerGoals();
            teamAssists = teamAssists + player.getPlayerAssists();
            teamTotals = teamTotals + player.getPlayerGoals() + player.getPlayerAssists();
        }
        //Like in a setter method, using 'this.' to reference current object and store the temporary variables declared in the for each loop into the instance of the player.
        this.teamGoals = teamGoals;
        this.teamAssists = teamAssists;
        this.teamTotals = teamTotals;
    }

    //METHOD: Calculate the Team Rating Based on Team Total Score
    //Parameters declared in method for 'team', will access the team object's total score via 'this.' keyword
    public void calculateTeamRating(Team team) {
        if (team.getTeamTotals() > 20) {
            this.teamRating = "*** stars";
        } else if (team.getTeamTotals() > 10) {
            this.teamRating = "** stars";
        } else if (team.getTeamTotals() > 0) {
            this.teamRating = "* stars";
        } else if (team.getTeamTotals() == 0) {
            this.teamRating = "0 stars";
        }
    }

    //METHOD: Output Team Stats Report
    public void outputTeamStats(Team team) {
        //New object of DecimalFormat class created to set the float output to two decimal places.
        DecimalFormat df = new DecimalFormat("#.##");
        //Note: could format the output with ASCII but to keep things simple did not include. If there were more information to output can change.
        System.out.println("TEAM " + team.getTeamName().toUpperCase() + ": ");//.toUpperCase used for consistent output style.
        System.out.println("GOALS: " + team.getTeamGoals() + "      ASSISTS: " + team.getTeamAssists()
                + "       TOTAL SCORE: " + team.getTeamTotals());
        System.out.println("BUDGET: $" + df.format(team.getTeamBudget()));//df.format method used to apply the declared pattern above.
        System.out.println("RATING: " + team.getTeamRating());
        System.out.println("----------------------------------");
    }
    //endregion
}
