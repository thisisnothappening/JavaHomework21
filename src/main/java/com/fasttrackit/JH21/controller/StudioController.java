package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.Studio;
import com.fasttrackit.JH21.service.StudioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("studios")
public class StudioController {
    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping
    List<Studio> getStudios() {
        return studioService.getStudios();
    }

    @GetMapping("{id}")
    Studio getStudio(@PathVariable Integer id) {
        return studioService.getStudio(id);
    }
}
