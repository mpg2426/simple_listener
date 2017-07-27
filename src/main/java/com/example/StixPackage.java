package com.example;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "STIX_Package",namespace = "http://stix.mitre.org/stix-1")
public class StixPackage implements Serializable {

    String version;
    StixHeader stixHeader;
    String id;

    @XmlElement(name = "STIX_Header")
    public StixHeader getStixHeader() {
        return stixHeader;
    }

    public void setStixHeader(StixHeader stixHeader) {
        this.stixHeader = stixHeader;
    }

    @XmlAttribute(name="version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
