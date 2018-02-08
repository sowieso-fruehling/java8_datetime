package de.be.aff.java8_datetime.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.be.aff.java8_datetime.util.Constants;

import java.time.ZonedDateTime;

public class CustomSerializedPerson extends Person {

    //we don't need setter nor getter for this field, because @JsonFormat will do serialization/ deserialization work
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.PREFFERED_DATE_FORMAT)
    private ZonedDateTime momentOfBirth;
}
