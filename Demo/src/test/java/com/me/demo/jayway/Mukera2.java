package com.me.demo.jayway;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class Mukera2 {
    private  static String jsonDataSourceString = "{\n"+
            "    \"book\": \n"+
            "    [\n"+
            "        {\n"+
            "            \"title\": \"Beginning JSON\",\n"+
            "            \"author\": \"Ben Smith\",\n"+
            "            \"price\": 49.99\n"+
            "        },\n"+
            " \n"+
            "        {\n"+
            "            \"title\": \"JSON at Work\",\n"+
            "            \"author\": \"Tom Marrs\",\n"+
            "            \"price\": 29.99\n"+
            "        },\n"+
            " \n"+
            "        {\n"+
            "            \"title\": \"Learn JSON in a DAY\",\n"+
            "            \"author\": \"Acodemy\",\n"+
            "            \"price\": 8.99\n"+
            "        },\n"+
            " \n"+
            "        {\n"+
            "            \"title\": \"JSON: Questions and Answers\",\n"+
            "            \"author\": \"George Duckett\",\n"+
            "            \"price\": 6.00\n"+
            "        }\n"+
            "    ],\n"+
            " \n"+
            "    \"price range\": \n"+
            "    {\n"+
            "        \"cheap\": 10.00,\n"+
            "        \"medium\": 20.00\n"+
            "    }\n"+
            "}";

    @Test
    public void testThings(){
        Filter expensiveFilter = Filter.filter(Criteria.where("price").gt(20.00));
        List<Map<String, Object>> expensive = JsonPath.parse(jsonDataSourceString)
                .read("$['book'][?]", expensiveFilter);
        predicateUsageAssertionHelper(expensive);
    }

    @Test
    public void testJBH(){
        List<String> prices = JsonPath.parse(jsonDataSourceString).read("$.book[*].price");
        System.out.println(prices);
    }

    private void predicateUsageAssertionHelper(List<?> predicate) {
        assertThat(predicate.toString(), containsString("Beginning JSON"));
        assertThat(predicate.toString(), containsString("JSON at Work"));
        assertThat(predicate.toString(), not(containsString("Learn JSON in a DAY")));
        assertThat(predicate.toString(), not(containsString("JSON: Questions and Answers")));
    }

    private static String jsonString = "[\n" +
            "    {\n" +
            "        \"id\": 1,\n" +
            "        \"title\": \"Casino Royale\",\n" +
            "        \"director\": \"Martin Campbell\",\n" +
            "        \"starring\": \n" +
            "        [\n" +
            "            \"Daniel Craig\",\n" +
            "            \"Eva Green\"\n" +
            "        ],\n" +
            "        \"desc\": \"Twenty-first James Bond movie\",\n" +
            "        \"release date\": 1163466000000,\n" +
            "        \"box office\": 594275385\n" +
            "    },\n" +
            " \n" +
            "    {\n" +
            "        \"id\": 2,\n" +
            "        \"title\": \"Quantum of Solace\",\n" +
            "        \"director\": \"Marc Forster\",\n" +
            "        \"starring\": \n" +
            "        [\n" +
            "            \"Daniel Craig\",\n" +
            "            \"Olga Kurylenko\"\n" +
            "        ],\n" +
            "        \"desc\": \"Twenty-second James Bond movie\",\n" +
            "        \"release date\": 1225242000000,\n" +
            "        \"box office\": 591692078\n" +
            "    },\n" +
            " \n" +
            "    {\n" +
            "        \"id\": 3,\n" +
            "        \"title\": \"Skyfall\",\n" +
            "        \"director\": \"Sam Mendes\",\n" +
            "        \"starring\": \n" +
            "        [\n" +
            "            \"Daniel Craig\",\n" +
            "            \"Naomie Harris\"\n" +
            "        ],\n" +
            "        \"desc\": \"Twenty-third James Bond movie\",\n" +
            "        \"release date\": 1350954000000,\n" +
            "        \"box office\": 1110526981\n" +
            "    },\n" +
            " \n" +
            "    {\n" +
            "        \"id\": 4,\n" +
            "        \"title\": \"Spectre\",\n" +
            "        \"director\": \"Sam Mendes\",\n" +
            "        \"starring\": \n" +
            "        [\n" +
            "            \"Daniel Craig\",\n" +
            "            \"Lea Seydoux\"\n" +
            "        ],\n" +
            "        \"desc\": \"Twenty-fourth James Bond movie\",\n" +
            "        \"release date\": 1445821200000,\n" +
            "        \"box office\": 879376275\n" +
            "    }\n" +
            "]";

    @Test
    public void testToGetFromArray(){
        List<String> titles = JsonPath.parse(jsonString).read("[*].title");
        System.out.println(titles);
    }
}
