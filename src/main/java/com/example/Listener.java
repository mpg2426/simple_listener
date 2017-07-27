package com.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

@RestController
public class Listener {

    @Bean
    @Primary
    Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter (){
        Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter = new XmlParser();
        return jaxb2RootElementHttpMessageConverter;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String accepter(@RequestBody (required = false) StixPackage stixObject){

                String version, id, title;
                version = stixObject.getVersion();
                id = stixObject.getId();
                title = stixObject.getStixHeader().getTitle();
                StringBuilder sb = new StringBuilder();
                sb.append("Here is the version: ");
                sb.append(version+"\n");
                sb.append("Here is the ID: ");
                sb.append(id+"\n");
                sb.append("finally here is the title: ");
                sb.append(title);

        return sb.toString();
    }
}
