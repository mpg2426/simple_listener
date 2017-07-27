package com.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlType()
public class StixHeader implements Serializable{
    String Title;
    @XmlElement(name = "Title")
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        this.Title = title;
    }



}
