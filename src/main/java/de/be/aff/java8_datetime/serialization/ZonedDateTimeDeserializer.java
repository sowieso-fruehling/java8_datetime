package de.be.aff.java8_datetime.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.be.aff.java8_datetime.util.Constants;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern(Constants.PREFFERED_DATE_FORMAT);

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        LocalDateTime dt = LocalDateTime.parse(jsonParser.getText(), fmt);
        return ZonedDateTime.of(dt, ZoneId.of("UTC"));
    }

}