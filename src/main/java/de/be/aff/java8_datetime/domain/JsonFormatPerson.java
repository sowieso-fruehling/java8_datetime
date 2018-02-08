package de.be.aff.java8_datetime.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.be.aff.java8_datetime.serialization.ZonedDateTimeDeserializer;
import de.be.aff.java8_datetime.serialization.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

public class JsonFormatPerson extends Person {

    //we don't need setter nor getter for this field, because @Json(De)serialize will do serialization/ deserialization work
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime momentOfBirth;
}
