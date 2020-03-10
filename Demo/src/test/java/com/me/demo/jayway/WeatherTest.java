package com.me.demo.jayway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherTest {

    @Test
    public void givenTwoJsonFormats_whenDeserialized_thenWeatherObjectsCreated() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Weather weather = mapper.readValue("{\n"
                + "  \"location\": \"London\",\n"
                + "  \"temp\": 15,\n"
                + "  \"weather\": \"Cloudy\"\n"
                + "}", Weather.class);

        assertEquals("London", weather.getLocation());
        assertEquals("Cloudy", weather.getOutlook());
        assertEquals(15, weather.getTemp());

        Weather weather2 = mapper.readValue("{\n"
                + "  \"place\": \"Lisbon\",\n"
                + "  \"temperature\": 35,\n"
                + "  \"outlook\": \"Sunny\"\n"
                + "}", Weather.class);

        assertEquals("Lisbon", weather2.getLocation());
        assertEquals("Sunny", weather2.getOutlook());
        assertEquals(35, weather2.getTemp());
        System.out.println(mapper.writeValueAsString(weather));
        System.out.println(mapper.writeValueAsString(weather2));
    }
}
