package dev.aziz.messaging.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    private MessageService messageService = new MessageService();

    @Test
    void doMessage() {
        String request = "aaaaabcccc";
        String result = "\"a\":5, \"c\":4, \"b\":1";
        assertEquals(result, messageService.checkMessage(request));
    }

}