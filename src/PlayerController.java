
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PlayerController {

	private List<Player> players ;
	private PlayerDbUtil playerDbUtil;	
	private Logger logger = Logger.getLogger(getClass().getName());

	
	public PlayerController() throws Exception{
		players = new ArrayList<>();
		
		playerDbUtil = PlayerDbUtil.getInstance();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void loadPlayers() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayers();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players");
			//add error message for JSF
			addErrorMessage(exc);
		}
	}
	public String loadPlayersByNumber() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByNumber();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by Number");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_number?faces-redirect=true" ;
	}
	public String loadPlayersByGamesPlayed() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByGamesPlayed();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by games played");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_games_played?faces-redirect=true";
	}
	public String loadPlayersByGoals() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByGoals();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by Goals");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_goals?faces-redirect=true";
	}
	public String loadPlayersByAssists() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByAssists();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by Assists");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_assists?faces-redirect=true";
	}
	public String loadPlayersByPoints() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByPoints();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by Points");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_points?faces-redirect=true";
	}
	public String loadPlayersByPim() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByPim();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by PIM");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_pim?faces-redirect=true";
	}
	public String loadPlayersByFirstName() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByFirstName();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by First Name");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_first_name?faces-redirect=true";
	}
	public String loadPlayersByLastName() {
		logger.info("Loading players");
		
		players.clear();
		try {
			//get all students from database
			players = playerDbUtil.getPlayersByLastName();
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Players by Last Name");
			//add error message for JSF
			addErrorMessage(exc);
		}
		return "sort_by_last_name?faces-redirect=true";
	}
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public String loadPlayers(int playerId) {
		logger.info("Loading players" + playerId);
		
		players.clear();
		try {
			//get student from database
			Player thePlayer = playerDbUtil.getPlayer(playerId);
			
			// Put in the request attribute so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> requestMap = externalContext.getRequestMap(); 
			requestMap.put("player", thePlayer);
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Loading Player Id" + playerId);
			//add error message for JSF
			addErrorMessage(exc);
			return null;
		}
		return "update_player_form.xhtml";
	}
	public String addPlayer(Player thePlayer) {
		logger.info("Adding Player" + thePlayer);
		try {
			//Add student to DB
			playerDbUtil.addPlayer(thePlayer);
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Adding Players");
			//add error message for JSF
			addErrorMessage(exc);
			return null;
		}
		return "list_players?faces-redirect=true";
	}
	
	public String updatePlayer(Player thePlayer) {
		logger.info("Updating Player" + thePlayer);
		try {
			//Update student to DB
			playerDbUtil.updatePlayer(thePlayer);
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Updating Player" + thePlayer, exc);
			//add error message for JSF
			addErrorMessage(exc);
			return null;
		}
		return "list_players?faces-redirect=true";
	}
	public String deletePlayer(int playerId) {
		logger.info("Deleting Student" + playerId);
		try {
			//Update student to DB
			playerDbUtil.deletePlayer(playerId);
		}
		catch(Exception exc){
			//Send this to server log
			logger.log(Level.SEVERE, "Error Deleting player" + playerId, exc);
			//add error message for JSF
			addErrorMessage(exc);
			return null;
		}
		return "list_players";
	}


}
