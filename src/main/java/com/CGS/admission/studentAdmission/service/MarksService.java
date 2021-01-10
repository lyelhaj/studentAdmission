package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.Marks;
import com.CGS.admission.studentAdmission.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {
    @Autowired
    MarksRepository marksRepository;

    public Marks getMarks(Long id){
        return marksRepository.findById(id).get();
    }

    public List<Marks> getAll(){
        return marksRepository.findAll();
    }

    public Marks addMarks(Marks marks){
        return marksRepository.save(marks);
    }

    public void deleteMarks(Long id){
        marksRepository.deleteById(id);
    }

    public Marks updateMarks(Long id, Marks marks){
        marks.setMarksId(id);
        return marksRepository.save(marks);
    }

    public Page<Marks> getByLastName(String ln, Pageable pageable){
        return marksRepository.findByStLastNameContains(ln,pageable);
    }




}
