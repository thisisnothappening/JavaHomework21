package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.Actor;
import com.fasttrackit.JH21.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getActors() {
        return actorRepository.findAll();
    }

    public Actor getActor(Integer id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not found!"));
    }
}
