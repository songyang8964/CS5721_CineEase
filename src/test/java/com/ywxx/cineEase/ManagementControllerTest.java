package com.ywxx.cineEase;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ywxx.cineEase.controller.ManagementController;
import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.entity.Ticket;
import com.ywxx.cineEase.service.MovieService;
import com.ywxx.cineEase.service.TicketService;
import com.ywxx.cineEase.utils.Result;

import jakarta.persistence.Column;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ManagementController.class)
public class ManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MovieService movieService;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private ManagementController managementController;

    @Test
    public void testSaveMovie() throws Exception {
        Mockito.doNothing().when(movieService).addMovie(any(Movie.class));

        String movieJson = "{ " +
                "\"movieName\": \"Spiderman: No Way Home\"," +
                "\"summary\": \"With Spider-Man's identity now revealed, Peter asks Doctor Strange for help...\"," +
                "\"price\": 10," +
                "\"actors\": \"Tom Holland, Zendaya\"," +
                "\"language\": \"English\"," +
                "\"durationMins\": 148," +
                "\"genre\": \"Action\"" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/admin/movie/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movieJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateMovie() throws Exception {
        when(movieService.updateMovie(any(Long.class), any(Movie.class))).thenReturn(Result.ok());

        String movieJson = "{ " +
                "\"movieName\": \"Spiderman: No Way Home\"," +
                "\"summary\": \"With Spider-Man's identity now revealed, Peter asks Doctor Strange for help...\"," +
                "\"price\": 15," +
                "\"actors\": \"Tom Holland, Zendaya\"," +
                "\"language\": \"English\"," +
                "\"durationMins\": 148," +
                "\"genre\": \"Action\"" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .put("/admin/movie/update/{id}", 6) // 
                .contentType(MediaType.APPLICATION_JSON)
                .content(movieJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUndoLastCommand() throws Exception {
        when(movieService.undoLastCommand()).thenReturn(Result.ok());

        mockMvc.perform(MockMvcRequestBuilders
                .post("/admin/movie/undo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteTicketById() throws Exception {
        when(ticketService.deleteTicketById(any(Long.class))).thenReturn(Result.ok());

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/admin/ticket/delete/{ticketId}", 3) 
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
