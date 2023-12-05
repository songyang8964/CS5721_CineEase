package com.ywxx.cineEase;

import com.ywxx.cineEase.controller.BookingController;
import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.entity.Screen;
import com.ywxx.cineEase.entity.Seat;
import com.ywxx.cineEase.entity.Ticket;
import com.ywxx.cineEase.repository.CustomerRepository;
import com.ywxx.cineEase.repository.ScreenRepository;
import com.ywxx.cineEase.repository.SeatRepository;
import com.ywxx.cineEase.repository.TicketRepository;
import com.ywxx.cineEase.service.MovieService;
import com.ywxx.cineEase.service.TicketService;
import com.ywxx.cineEase.service.impl.BookingServiceImpl;
import com.ywxx.cineEase.utils.type.PayMethodType;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
public class BookingControllerTest {

    @Mock
    private MovieService movieService;

    @Mock
    private ScreenRepository screenRepository;

    @Mock
    private SeatRepository seatRepository;

    @Mock
    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private BookingServiceImpl bookingService;

    @InjectMocks
    private BookingController bookingController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void bookSeatTest() throws Exception {
        String movieName = "Spiderman: No Way Home";
        long seatId = 1L;
        long userId = 1L;

        Movie mockMovie = new Movie();
        mockMovie.setMovieName(movieName);

        Screen mockScreen = new Screen();
        mockScreen.setScreenNum(1);

        Seat mockSeat = new Seat();
        mockSeat.setScreenId(mockScreen.getScreenId());
        mockSeat.setAvailable(true);

        Ticket mockTicket = new Ticket();
        mockTicket.setSeatId(seatId);
        mockTicket.setTicketStatus("0");
        mockTicket.setTime(mockSeat.getTime());
        mockTicket.setCustomer(customerRepository.findById(userId).get());
        mockTicket.setPaymentStatus("0");
        mockTicket.setScreenNum(mockScreen.getScreenNum());
        mockTicket.setTicketId(1L);
        mockTicket.setScreenId(mockSeat.getScreenId());

        Mockito.when(movieService.getMovieByName(movieName)).thenReturn(mockMovie);
        Mockito.when(screenRepository.findByScreenId(mockSeat.getScreenId())).thenReturn(mockScreen);
        Mockito.when(seatRepository.findById(seatId)).thenReturn(Optional.of(mockSeat));

        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/book/Spiderman: No Way Home/seat/" + seatId + "/" + userId);
        request.setContentType("application/json");
        request.setContent("{ \"payMethod\": \"CARD\" }".getBytes());


        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(request.getRequestURI()).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());

    }
}

