package dev.aziz.messaging.controllers;


import dev.aziz.messaging.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @Operation(
            description = "This post method calculates the frequency of occurrence of characters in a given string, otherwise it will throw custom RuntimeException."

    )
    @PostMapping("/{message}")
    public ResponseEntity<String> createMessagePath(@PathVariable String message) {
        return ResponseEntity.ok(messageService.checkMessage(message));
    }
}
