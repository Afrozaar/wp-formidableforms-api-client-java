package com.afrozaar.wordpress.formidableforms.response;

import com.afrozaar.wordpress.formidableforms.model.Entry;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author johan
 */
public class ResponseParserTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void parseResponseTest() throws IOException {
        Resource resource = new ClassPathResource("/json/formentries.json");

        final JsonNode jsonNode = mapper.readTree(resource.getInputStream());

        final List<Entry> entries = ResponseParser.fromObjectResponse(jsonNode, Entry.class);

        System.out.println("entries = " + entries);
    }

}