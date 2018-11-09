import java.beans.Beans;
import java.util.Date;


/**
 * Plain Old Java Object representing Reuters21578 story.
 * Contains getter and setter methods.
 * 
 * @author shilpakancharla
 */

public class Identifer extends Beans {
	
	/** Identification number the story has in Reuters21578 */
	private int newID;
	
	/** Identification number of story had in Reuters22173 */
	private int oldID;
	
	/** Indicates whether a story had at least one entry in the topics field */
	private boolean topicsBoolean;
	
	/**
	 * Indicates whether a document was in the training set, test set, 
	 * or not used for the experiments reported in HAYES89 and HAYES90b.
	 */
	private String lewisSplit;
	
	/** 
	 * Indicates whether a document was in the training set or test set 
	 * for the experiments reported in HAYES89 and HAYES90b.
	 */
	
	private String cgiSplit;
	
	/** Date and time of story */
	private Date date;
	
	/** Topic category of stories */
	private String topics;
	
	/** Place category of stories */
	private String places;
	
	/** People category of stories */
	private String people;
	
	/** Orgs category of stories */
	private String orgs;
	
	/** Exchanges category of stories */
	private String exchanges;
	
	/** Company information */
	private String companies;
	
	/** Title of story */
	private String title;
	
	/** Location the story originated from, and day of the year */
	private String dateLine;
	
	/** Author of story */
	private String author;
	
	/** The main text of the story */
	private String body;
	
	public int getID() {
		return newID;
	}
	
	public void setID(int newID) {
		this.newID = newID;
	}
	
	public int getNewID() {
		return newID;
	}
	
	public void setNewID(int newID) {
		this.newID = newID;
	}
	
	public int getOldID() {
		return oldID;
	}
	
	public void setOldID(int oldID) {
		this.oldID = oldID;
	}
	
	public boolean isTopicsBoolean() {
		return topicsBoolean;
	}
	
	public void setTopicsBoolean(boolean topicsBoolean) {
		this.topicsBoolean = topicsBoolean;
	}
	
	public String getLewisSplit() {
		return lewisSplit;
	}
	
	public void setLewisSplit(String lewisSplit) {
		this.lewisSplit = lewisSplit;
	}
	
	public String getCGISplit() {
		return cgiSplit;
	}
	
	public void setCGISplit(String cgiSplit) {
		this.cgiSplit = cgiSplit;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTopics() {
		return topics;
	}
	
	public void setTopics(String topics) {
		this.topics = topics;
	}
	
	public String getPlaces() {
		return places;
	}
	
	public void setPlaces(String places) {
		this.places = places;
	}
	
	public String getPeople() {
		return people;
	}
	
	public void setPeople(String people) {
		this.people = people;
	}
	
	public String getOrgs() {
		return orgs;
	}
	
	public void setOrgs(String orgs) {
		this.orgs = orgs;
	}
	
	public String getExchanges() {
		return exchanges;
	}
	
	public void setExchanges(String exchanges) {
		this.exchanges = exchanges;
	}
	
	public String getCompanies() {
		return companies;
	}
	
	public void setCompanies(String companies) {
		this.companies = companies;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDateLine() {
		return dateLine;
	}
	
	public void setDateLine(String dateLine) {
		this.dateLine = dateLine;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
