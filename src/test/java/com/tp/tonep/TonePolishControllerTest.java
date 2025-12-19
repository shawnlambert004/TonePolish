package com.tp.tonep;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(TonePolishController.class)
public class TonePolishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TonePolishService tonePolishService;

    @Test
    void refineText_returnsPolished() throws Exception {
        String inputText = "I don't really care";
        String polishedText = "I'm not particulary concerned with that matter";

        when(tonePolishService.refineText(inputText)).thenReturn(polishedText);

        mockMvc.perform(post("/api/refine")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputText))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.polishedText").value(polishedText));
    }

}
