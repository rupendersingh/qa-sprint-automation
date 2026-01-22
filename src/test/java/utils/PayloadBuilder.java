package utils;

import java.util.HashMap;
import java.util.Map;

public class PayloadBuilder {
    public static Map<String, Object> createUserPayload() {
        Map<String, Object> payload = new HashMap<>();
        //payload.put("Content-Type", "application/json");
        payload.put("name","morpheus");
        payload.put("job","leader");
        return payload;
    }
}
