package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.google.common.truth.Truth.assertThat;

public class Assertions {
    public static void compareObjects(Object actual, Object expected){
        ObjectMapper mapper = new ObjectMapper();
        try {
            assertThat(mapper.writeValueAsString(actual)).isEqualTo(mapper.writeValueAsString(expected));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
