package com.shelest.controller;

import com.shelest.entity.Book;
import com.shelest.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class BooksControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookServiceMock;

    @InjectMocks
    private BooksController booksController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
    }

    @Test
    public void allBooks() throws Exception {
        Book first = new Book("Ing", "Yang");
        Book second = new Book("King", "Kong");

        when(bookServiceMock.listAll()).thenReturn(Arrays.asList(first, second));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].author", is("Ing")))
                .andExpect(jsonPath("$[1].author", is("King")));
        verify(bookServiceMock, times(1)).listAll();
        verifyNoMoreInteractions(bookServiceMock);
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}