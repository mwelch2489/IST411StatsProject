import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PlayerDbUtil {

	private static PlayerDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/fightin_beavs_hockey_stats";
	
	
	public static PlayerDbUtil getInstance() throws Exception{
		if (instance == null) {
			instance = new PlayerDbUtil();
		}
		return instance;
	}
	
	private PlayerDbUtil() throws Exception {
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException{
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}
	
	public List<Player> getPlayers() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by player_number";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByNumber() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by player_number DESC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByGamesPlayed() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by games_played DESC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByGamesPlayedLowToHigh() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by games_played ASC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByGoals() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by goals DESC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByGoalsLowToHigh() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by goals ASC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByAssists() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by assists DESC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByAssistsLowToHigh() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by assists ASC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByPoints() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by points DESC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByPointsLowToHigh() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by points ASC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByPim() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by pim DESC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByPimLowToHigh() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by pim ASC";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByFirstName() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by first_name";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	
	public List<Player> getPlayersByFirstNameZtoA() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by first_name desc";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public List<Player> getPlayersByLastName() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by last_name asc";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}

	public List<Player> getPlayersByLastNameZtoA() throws Exception{
		List<Player> players = new ArrayList<>();
		
		Connection myConn = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player order by last_name desc";
			
			mySt = myConn.createStatement();
			
			myRs = mySt.executeQuery(sql);
			
			//Process the resultSet
			while(myRs.next()){
				//retrieve data from result set
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				//Create a new student object
				Player tempPlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
				
				//Add it to list of students
				players.add(tempPlayer);
			}
			return players;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public Player getPlayer(int playerId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement mySt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();
			
			String sql = "select * from player where id = ?";
			
			mySt = myConn.prepareStatement(sql);
			
			//Set Parameters
			mySt.setInt(1, playerId);
			
			myRs = mySt.executeQuery();
			
			Player thePlayer = null;
	
			//retrieve data  from result set row
			if(myRs.next()) {
				int id = myRs.getInt("id");
				int number = myRs.getInt("player_number");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				int gamesPlayed = myRs.getInt("games_played");
				int goals = myRs.getInt("goals");
				int assists = myRs.getInt("assists");
				int points = myRs.getInt("points");
				int pim = myRs.getInt("pim");
				
				thePlayer = new Player(id, number, firstName, lastName, gamesPlayed, goals, assists, points, pim);
			}
			else {
				throw new Exception("Could not find the player id: " + playerId);
			}
			return thePlayer;
		}
		finally {
			close(myConn, mySt, myRs);
		}
	}
	public void addPlayer (Player thePlayer) throws Exception{
		Connection myConn = null;
		PreparedStatement mySt = null;
		try {
			myConn = getConnection();
			String sql = "insert into player (player_number, first_name, last_name, games_played, goals, assists, points, pim) values (?, ?, ?, ?, ?, ?, ?, ?)";
			mySt = myConn.prepareStatement(sql);
			
			//Set parameters
			mySt.setInt(1, thePlayer.getNumber());
			mySt.setString(2, thePlayer.getFirstName());
			mySt.setString(3, thePlayer.getLastName());
			mySt.setInt(4, thePlayer.getGamesPlayed());
			mySt.setInt(5, thePlayer.getGoals());
			mySt.setInt(6, thePlayer.getAssists());
			mySt.setInt(7, thePlayer.getPoints());
			mySt.setInt(8, thePlayer.getPim());
			
			mySt.execute();
		}
		finally {
			close(myConn, mySt);
		}
		
	}
	public void updatePlayer(Player thePlayer) throws Exception{
		Connection myConn = null;
		PreparedStatement mySt = null;
		try {
			myConn = getConnection();
			String sql = " update player set player_number = ?, first_name = ?, last_name = ? , games_played = ? , goals = ? , assists = ?, points = ?, pim = ? where id = ?";
			mySt = myConn.prepareStatement(sql);
			
			//Set parameters
			mySt.setInt(1, thePlayer.getNumber());
			mySt.setString(2, thePlayer.getFirstName());
			mySt.setString(3, thePlayer.getLastName());
			mySt.setInt(4, thePlayer.getGamesPlayed());
			mySt.setInt(5, thePlayer.getGoals());
			mySt.setInt(6, thePlayer.getAssists());
			mySt.setInt(7, thePlayer.getPoints());
			mySt.setInt(8, thePlayer.getPim());
			mySt.setInt(9,thePlayer.getId());
			
			mySt.execute();
		}
		finally {
			close(myConn, mySt);
		}
	}
	
	public void deletePlayer(int playerId) throws Exception{
		Connection myConn = null;
		PreparedStatement mySt = null;
		try {
			myConn = getConnection();
			String sql = " delete from player where id = ?";
			mySt = myConn.prepareStatement(sql);
			
			mySt.setInt(1, playerId);
			
			mySt.execute();
		}
		finally {
			close(myConn, mySt);
		}
	}
	
	private Connection getConnection() throws Exception{
		Connection theConn = dataSource.getConnection();
		return theConn;
	}
	private void close(Connection theConn, Statement theSt) {
		close(theConn, theSt, null);
	}
	private void close (Connection theConn, Statement theSt, ResultSet theRs) {
		try {
			if (theRs != null) {
				theRs.close();
			}
			if(theSt != null) {
				theSt.close();
			}
			if(theConn != null) {
				theConn.close();
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
