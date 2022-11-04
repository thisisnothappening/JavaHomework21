package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.Actor;
import com.fasttrackit.JH21.service.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    List<Actor> getActors() {
        return actorService.getActors();
    }

    @GetMapping("{id}")
    Actor getActor(@PathVariable Integer id) {
        return actorService.getActor(id);
    }
}
