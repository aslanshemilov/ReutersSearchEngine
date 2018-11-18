package com.h2o.content.parser;
import java.io.Serializable;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "REUTERS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Reuters implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
/**
<REUTERS TOPICS="YES" LEWISSPLIT="TRAIN" CGISPLIT="TRAINING-SET" OLDID="5544" NEWID="1">
<DATE>26-FEB-1987 15:01:01.79</DATE>
<TOPICS><D>cocoa</D></TOPICS>
<PLACES><D>el-salvador</D><D>usa</D><D>uruguay</D></PLACES>
<PEOPLE></PEOPLE>
<ORGS></ORGS>
<EXCHANGES></EXCHANGES>
<COMPANIES></COMPANIES>
<UNKNOWN> * 
<TEXT>&#2;
<TITLE>BAHIA COCOA REVIEW</TITLE>
<DATELINE>    SALVADOR, Feb 26 - </DATELINE><BODY>
 * */    
    private Integer NEWID;
    private String DATE;
    private String TOPICS;
    private String PLACES;
    private String PEOPLE;
    private String ORGS;
    private String EXCHANGES;
    private String COMPANIES;
    private String UNKNOWN;
    private Text TEXT;
 
    public Reuters() {
        super();
    }
 
    // It is called immediately after the object is created and before the unmarshalling begins.
    // The callback provides an opportunity to initialize JavaBean properties prior to unmarshalling.
    void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) {
        System.out.println("Before Unmarshaller Callback");
    }
 
    // It is called after all the properties are unmarshalled for this object,
    // but before this object is set to the parent object.
    void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        System.out.println("After Unmarshaller Callback");
    }

	public Integer getNEWID() {
		return NEWID;
	}

	public void setNEWID(Integer nEWID) {
		NEWID = nEWID;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public String getTOPICS() {
		return TOPICS;
	}

	public void setTOPICS(String tOPICS) {
		TOPICS = tOPICS;
	}

	public String getPLACES() {
		return PLACES;
	}

	public void setPLACES(String pLACES) {
		PLACES = pLACES;
	}

	public String getPEOPLE() {
		return PEOPLE;
	}

	public void setPEOPLE(String pEOPLE) {
		PEOPLE = pEOPLE;
	}

	public String getORGS() {
		return ORGS;
	}

	public void setORGS(String oRGS) {
		ORGS = oRGS;
	}

	public String getEXCHANGES() {
		return EXCHANGES;
	}

	public void setEXCHANGES(String eXCHANGES) {
		EXCHANGES = eXCHANGES;
	}

	public String getCOMPANIES() {
		return COMPANIES;
	}

	public void setCOMPANIES(String cOMPANIES) {
		COMPANIES = cOMPANIES;
	}

	public String getUNKNOWN() {
		return UNKNOWN;
	}

	public void setUNKNOWN(String uNKNOWN) {
		UNKNOWN = uNKNOWN;
	}

	public Text getTEXT() {
		return TEXT;
	}

	public void setTEXT(Text tEXT) {
		TEXT = tEXT;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reuters [NEWID=" + NEWID + ", DATE=" + DATE + ", TOPICS=" + TOPICS + ", PLACES=" + PLACES + ", PEOPLE="
				+ PEOPLE + ", ORGS=" + ORGS + ", EXCHANGES=" + EXCHANGES + ", COMPANIES=" + COMPANIES + ", UNKNOWN="
				+ UNKNOWN + ", TEXT=" + TEXT + "]";
	}

}
