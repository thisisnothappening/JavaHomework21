package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.Studio;
import com.fasttrackit.JH21.repository.StudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {
    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public List<Studio> getStudios() {
        return studioRepository.findAll();
    }

    public Studio getStudio(Integer id) {
        return studioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Studio not found!"));
    }
}
