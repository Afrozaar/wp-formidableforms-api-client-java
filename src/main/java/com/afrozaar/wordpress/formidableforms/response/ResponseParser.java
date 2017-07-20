package com.afrozaar.wordpress.formidableforms.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author johan
 */
public class ResponseParser {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseParser.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ResponseParser() {
    }

    public static <T> List<T> fromObjectResponse(JsonNode responseNode, Class<T> clazz) {

        List<T> tlist = new ArrayList<>();

        responseNode.fields().forEachRemaining(stringJsonNodeEntry -> {
            stringJsonNodeEntry.getKey();
            final JsonNode value = stringJsonNodeEntry.getValue();
            try {
                T t = objectMapper.treeToValue(value, clazz);
                tlist.add(t);
            } catch (JsonProcessingException e) {
                LOG.error("Error parsing node {} to {}", value, clazz, e);
            }
        });

        return tlist;
    }
}
