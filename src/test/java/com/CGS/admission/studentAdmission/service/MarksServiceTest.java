package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Marks;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarksServiceTest {
    private static Long id;
    @Mock
    Marks marks;

    @Mock
    MarksRepository marksRepository;

    @InjectMocks
    MarksService marksService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMarks() {
        Mockito.when(marksRepository.findById(id)).thenReturn(Optional.of(marks));
        marksService.getMarks(id);
        Mockito.verify(marksRepository).findById(id);

        System.out.println("Test findBy methode");
    }

    @Test
    void getAll() {
        List<Marks> markses=new ArrayList<>();
        Mockito.when(marksRepository.findAll()).thenReturn(markses);
        marksService.getAll();
        Mockito.verify(marksRepository).findAll();
        System.out.println("Test findAll methode");
    }

    @Test
    void addMarksTest() {
        Mockito.when(marksRepository.save(marks)).thenReturn(marks);
        marksService.addMarks(marks);
        Mockito.verify(marksRepository).save(marks);
        System.out.println("Test AddMarks methode");
    }

    @Test
    void deleteMarksTest() {
       marksService.deleteMarks(id);
       Mockito.verify(marksRepository).deleteById(id);
        System.out.println("Test deleteMarks methode");
    }

    @Test
    void updateMarksTest() {
        marksService.updateMarks(id,marks);
        Mockito.verify(marksRepository).save(marks);
    }

    @Test
    void getByLastNameTest() {
        String ln=TestUtil.generateRandomString();
        marksService.getByLastName(ln, Pageable.unpaged());
        Mockito.verify(marksRepository).findByStLastNameContains(ln,Pageable.unpaged());
        System.out.println("Test findByLastName methode");
    }
}