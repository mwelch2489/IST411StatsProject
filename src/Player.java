import javax.faces.bean.ManagedBean;

@ManagedBean
public class Player {

	private int id;
	private int number;
	private String firstName;
	private String lastName;
	private int gamesPlayed;
	private int goals;
	private int assists;
	private int points;
	private int pim;
	
	public Player() {
		
	}
	
	public Player(int id,int number, String firstName, String lastName, int gamesPlayed, int goals, int assists, int points, int pim) {
		this.id = id;
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gamesPlayed = gamesPlayed;
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.pim = pim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPim() {
		return pim;
	}

	public void setPim(int pim) {
		this.pim = pim;
	}

	@Override
	public String toString() {
		
		return "Student [id =" + id + " , number =" + number +  "firstName = " + firstName + ", lastName=" + lastName+ ", gamesPlayed=" + gamesPlayed 
				+ ", goals= " + goals + ", assists=" +  assists +  ", points=" + points + ", pim= " + pim +"]"   ;
	}	
}
