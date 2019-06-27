import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    TennisPlayer max = new TennisPlayer("Max");
    TennisPlayer bob = new TennisPlayer("Bob");
    TennisPlayer chris = new TennisPlayer("Chris");
    TennisPlayer michael = new TennisPlayer("Michael");
    Team <TennisPlayer>tsu = new Team("TSU");
    tsu.addPlayer(max);
    tsu.addPlayer(bob);
    tsu.printPlayers();
    Team<TennisPlayer> mtsu = new Team("MTSU");
    mtsu.addPlayer(chris);
    mtsu.addPlayer(michael);
    mtsu.printPlayers();

    Team <SoccerPlayer> realMadrid = new Team("Real Madrid");
    SoccerPlayer ronaldo = new SoccerPlayer("Ronaldo");
    SoccerPlayer benzema = new SoccerPlayer("Benzema");
    realMadrid.addPlayer(ronaldo);
    realMadrid.addPlayer(benzema);
    realMadrid.printPlayers();

    Team<SoccerPlayer> barcelona = new Team("Barcelona");
    SoccerPlayer havier = new SoccerPlayer("Havier");
    SoccerPlayer messi = new SoccerPlayer("Messi");
    barcelona.addPlayer(havier);
    barcelona.addPlayer(messi);

    League<Team<TennisPlayer>> div1 = new League("Division I");
    div1.addTeam(tsu);
    div1.addTeam(mtsu);
    div1.printTeams();

    tsu.matchResult(mtsu, 2,5);
    mtsu.matchResult(tsu, 3,1);
    tsu.matchResult(mtsu,2,2);
    div1.showRankings();

    League<Team<SoccerPlayer>> spain = new League<>("Spain League");
    spain.addTeam(barcelona);
    spain.addTeam(realMadrid);
    spain.printTeams();
    }
}

public class League<T extends Team> {
    private String leagueName;
    private ArrayList<T> league = new ArrayList<>();

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void addTeam(T team){
        if(team.getName() != null){
            System.out.println("Team " + team.getName() + " added to " + getLeagueName() + " league");
            league.add(team);
        } else {
            System.out.println("Such team doesn't exist");
        }
    }
    public void printTeams(){
        System.out.println("League teams: ");
        for(Team x: league){
            System.out.println(x.getName());
        }
    }
    public void showRankings(){
        Collections.sort(league);
        for(Team x : league){
            System.out.println(x.getName() + ": " + x.ranking());
        }
    }
}

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class TennisPlayer extends Player {
    public TennisPlayer(String name) {
        super(name);
    }
}

public class SoccerPlayer extends Player {
    public SoccerPlayer(String name) {
        super(name);
    }
}

import java.util.ArrayList;
import java.util.ListIterator;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private ArrayList<T> team = new ArrayList<>();
    int win = 0;
    int lose = 0;
    int tie = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(T player){
        if(player.getName() != null ){
            team.add(player);
            System.out.println("Player " + player.getName() + " has been added to team " + getName());
        } else {
            System.out.println("Player doesn't exist");
        }
    }
    public int teamSize(){
        return team.size();
    }
    public void printPlayers(){
        System.out.println("Players of team: " + getName());
        for ( Player x : team){
            System.out.println(x.getName());

        }
    }
    public void matchResult(Team<T> opponent, int homeScore, int opponentScore){
        String message;
        if ( homeScore > opponentScore){
            win++;
            message = " won ";
        } else if ( opponentScore > homeScore ){
            lose++;
            message = " lost ";
        } else {
            tie++;
            message = " got draw with ";
        }
        if ( opponent != null) {
            System.out.println(getName() + message + opponent.getName());
            opponent.matchResult(null, opponentScore, homeScore);
        }
    }
    public int ranking(){
        return win*2+tie;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        } else if (this.ranking() < team.ranking()){
            return 1;
        } else {
            return 0;
        }
    }
}
