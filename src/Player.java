/*
 * Author: Lauren MacDonald
 * Java Program for Assignment 1, PROG1400 at NSCC
 * Due Date: February 1st, 2023
 * Submission Date: January 31st, 2023
 * General requirements: Create a fantasy hockey league by accepting user input for 3 teams who have 3 players each.
 *   Output information about each team, and information about each player on the team.
 * */
public class Player {
    //region "DECLARING PROPERTIES"
    private String playerName;
    private int playerGoals;
    private int playerAssists;
    private int playerTotals = getPlayerGoals() + getPlayerAssists();
    //endregion
    //region "CONSTRUCTOR"
    public Player(String playerName, int playerGoals, int playerAssists) {
        this.playerName = playerName;
        this.playerGoals = playerGoals;
        this.playerAssists = playerAssists;
    }
    //endregion
    //region "GETTERS AND SETTERS"
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }
    public int getPlayerGoals(){
        return playerGoals;
    }
    public void setPlayerGoals(int playerGoals){
        this.playerGoals=playerGoals;
    }
    public int getPlayerAssists(){
        return playerAssists;
    }
    public void setPlayerAssists(int playerAssists){
        this.playerAssists=playerAssists;
    }
    //endregion
    //region "METHODS"
    //METHOD: Calculate player totals, adding goals and assists.
    //(this) used as parameters for output to access the total score for 'this' player
    public int calculatePlayerTotals(Player player) {
        int playerTotals = 0;
        playerTotals = playerTotals + playerGoals + playerAssists;
        this.playerTotals = playerTotals;
        return this.playerTotals;
    }

    //METHOD: Output player stats report.
    //Player object datatype parameters used.
    public void outputPlayerDetails(Player player){
        System.out.println(player.getPlayerName().toUpperCase());//.toUpperCase for consistent style on output.
        System.out.println("GOALS: " + player.getPlayerGoals() + "      ASSISTS: "
                + player.getPlayerAssists() + "       TOTAL: " + player.calculatePlayerTotals(this));
    }
    //endregion
}
