package dev.aziz.messaging.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aziz.messaging.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageController.class)
class MessageControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public MessageService messageService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createMessagePath() throws Exception {
        //given
        String message = "aaaaabcccc";

        //when
        when(messageService.checkMessage(message)).thenReturn("\"a\":5, \"c\":4, \"b\":1");

        //then
        mockMvc.perform(post("/api/v1/messages/" + message))
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                        "\"a\":5, \"c\":4, \"b\":1",
                        result.getResponse().getContentAsString())
                );
    }
}