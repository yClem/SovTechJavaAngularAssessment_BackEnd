package com.sovtech.sovtech_se_assessment_on_graphql.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseHandler {
    public static ResponseEntity<Object> response(HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", responseObj);
        /**
        map.put("pageNumber", number);
        map.put("pageSize", size);
        map.put("totalPages", totalPages);
        map.put("totalElements", totalElements);
        */
        return new ResponseEntity<Object>(map, status);
    }
}
