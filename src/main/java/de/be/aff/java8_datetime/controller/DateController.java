package de.be.aff.java8_datetime.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.be.aff.java8_datetime.domain.JsonFormatPerson;
import de.be.aff.java8_datetime.domain.CustomSerializedPerson;
import de.be.aff.java8_datetime.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class DateController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/")
    public List<Person> getPersons() throws IOException {

        //momentOfBirth is UTC time
        String json2Deserialize="{\"explanation\":\"xoxo\", \"momentOfBirth\":\"2018-12-12T10Z\"}";

        //there is custom class which will do deserialization work for JsonFormatPerson.momentOfBirth
        JsonFormatPerson jsonFormatPerson = objectMapper.readValue(json2Deserialize, JsonFormatPerson.class);

        //just changing xoxo to this string
        jsonFormatPerson.setExplanation("Serialized/Deserialized in custom classes");

        CustomSerializedPerson customSerializedPerson =objectMapper.readValue(json2Deserialize, CustomSerializedPerson.class);

        //just changing xoxo to this string
        customSerializedPerson.setExplanation("Serialized/Deserialized by using @JsonFormat annotation");

        return Arrays.asList(customSerializedPerson, jsonFormatPerson);

    }
}
