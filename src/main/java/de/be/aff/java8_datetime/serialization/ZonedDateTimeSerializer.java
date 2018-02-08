package de.be.aff.java8_datetime.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.be.aff.java8_datetime.util.Constants;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern(Constants.PREFFERED_DATE_FORMAT);

    @Override
    public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        // get the timestmap in the current system's timezone
        ZonedDateTime z = value.toInstant().atZone(ZoneId.systemDefault());
        String str = fmt.format(z);

        gen.writeString(str);
    }


}