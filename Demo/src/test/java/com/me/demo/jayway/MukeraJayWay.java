package com.me.demo.jayway;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class MukeraJayWay {

    private static String jsonDataSourceString = "{\n" +
            "    \"tool\": \n" +
            "    {\n" +
            "        \"jsonpath\": \n" +
            "        {\n" +
            "            \"creator\": \n" +
            "            {\n" +
            "                \"name\": \"Jayway Inc.\",\n" +
            "                \"location\": \n" +
            "                [\n" +
            "                    \"Malmo\",\n" +
            "                    \"San Francisco\",\n" +
            "                    \"Helsingborg\"\n" +
            "                ]\n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
            " \n" +
            "    \"book\": \n" +
            "    [\n" +
            "        {\n" +
            "            \"title\": \"Beginning JSON\",\n" +
            "            \"price\": 49.99\n" +
            "        },\n" +
            " \n" +
            "        {\n" +
            "            \"title\": \"JSON at Work\",\n" +
            "            \"price\": 29.99\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Test
    public void testThings() {
        String jsonpathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
        String jsonpathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][*]";

        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        String jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
        List<String> jsonpathCreatorLocation = jsonContext.read(jsonpathCreatorLocationPath);

        System.out.println("jsonpathCreatorName: " + jsonpathCreatorName);
        System.out.println("jsonpathCreatorLocation: " + jsonpathCreatorLocation);

        assertEquals("Jayway Inc.", jsonpathCreatorName);
        assertThat(jsonpathCreatorLocation.toString(), containsString("Malmo"));
        assertThat(jsonpathCreatorLocation.toString(), containsString("San Francisco"));
        assertThat(jsonpathCreatorLocation.toString(), containsString("Helsingborg"));

    }
}
