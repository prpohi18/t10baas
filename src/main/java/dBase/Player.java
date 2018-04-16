package dBase;
public class Player{
	protected String name;
	protected int number;
	protected String team;
	protected double points;
	protected int games;
	protected double minutes;
	protected int salary;
	
	public Player(String name, int number, String team, double points, int games, double minutes, int salary) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.points = points;
		this.games = games;
		this.minutes = minutes;
		this.salary = salary;
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

	public double getPoints() {
		return points;
	}
	
	public int getGames() {
		return games;
	}

	public double getMinutes() {
		return minutes;
	}

	public int getSalary(){
		return salary;
	}
}	

	
	