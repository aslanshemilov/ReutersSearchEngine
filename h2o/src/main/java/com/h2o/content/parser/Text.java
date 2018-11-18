package com.h2o.content.parser;
import java.io.Serializable;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "TEXT")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Text implements Serializable {
 
    private static final long serialVersionUID = 1L;
/***
 * 
<TEXT>2;
<TITLE>BAHIA COCOA REVIEW</TITLE>
<DATELINE>    SALVADOR, Feb 26 - </DATELINE><BODY> * 
 * */ 
    private String TITLE;
    private String DATELINE;
    private String BODY;
 
    public Text() {
        super();
    }
 




	@Override
	public String toString() {
		return "Text [TITLE=" + TITLE + ", DATELINE=" + DATELINE + ", BODY=" + BODY + "]";
	}





	public String getTITLE() {
		return TITLE;
	}


	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}


	public String getDATELINE() {
		return DATELINE;
	}


	public void setDATELINE(String dATELINE) {
		DATELINE = dATELINE;
	}


	public String getBODY() {
		return BODY;
	}


	public void setBODY(String bODY) {
		BODY = bODY;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
