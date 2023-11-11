package dev.aziz.messaging.service;

import dev.aziz.messaging.exceptions.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    public String checkMessage(String message) {
        if (message.matches("^[a-zA-Z]+$")) {
            return getLetterCount(message);
        } else {
            throw new AppException("Message pattern is wrong!", HttpStatus.BAD_REQUEST);
        }
    }

    private String getLetterCount(String message) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : message.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charCountMap.entrySet());
        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            result.append("\"").append(entry.getKey()).append("\":").append(entry.getValue()).append(", ");
        }
        result.setLength(result.length() - 2);
        return result.toString();
    }
}
