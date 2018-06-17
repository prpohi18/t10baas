package dBase;
public class Player{
	protected String name;
	protected int number;
	protected String team;
	protected int goals;
	protected int assists;

	
	public Player(String name, int number, String team, int goals, int assists) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.goals = goals;
		this.assists = assists;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}

	public int getNumber() {
		return number;
	}

	public double getGoals() {
		return goals;
	}
	
	public int getAssists() {
		return assists;
	}


}	

	
	