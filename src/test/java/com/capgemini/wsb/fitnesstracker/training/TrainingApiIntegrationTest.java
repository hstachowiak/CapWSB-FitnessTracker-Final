package com.capgemini.wsb.fitnesstracker.training;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class TrainingApiIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldCreateTraining() throws Exception {
        TrainingDto training = new TrainingDto();
        training.setActivityType(ActivityType.RUNNING);
        training.setStartTime(LocalDateTime.now());
        training.setEndTime(LocalDateTime.now().plusHours(1));
        training.setDistance(10.0);
        training.setAverageSpeed(10.0);
        training.setUserId(1L);

        mockMvc.perform(post("/api/trainings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(training)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetAllTrainings() throws Exception {
        mockMvc.perform(get("/api/trainings"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetTrainingById() throws Exception {
        mockMvc.perform(get("/api/trainings/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetTrainingsByActivityType() throws Exception {
        mockMvc.perform(get("/api/trainings/activityType/RUNNING"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetFinishedTrainingsAfterDate() throws Exception {
        mockMvc.perform(get("/api/trainings/finishedAfter/2023-01-01T00:00:00"))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
