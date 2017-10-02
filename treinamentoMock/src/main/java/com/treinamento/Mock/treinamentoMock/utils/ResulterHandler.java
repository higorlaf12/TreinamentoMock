package com.treinamento.Mock.treinamentoMock.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResulterHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResulterHandler.class);
    public static String asJsonString(final Object obj) {

        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (RuntimeException | JsonProcessingException e) {
            LOGGER.warn("Error while converting to JsonString", e);
            return null;
        }
    }
}
