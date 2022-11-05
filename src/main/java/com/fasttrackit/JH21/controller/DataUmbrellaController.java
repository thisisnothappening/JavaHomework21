package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.DataUmbrella;
import com.fasttrackit.JH21.service.DataUmbrellaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("data")
public class DataUmbrellaController {
    private final DataUmbrellaService dataUmbrellaService;

    public DataUmbrellaController(DataUmbrellaService dataUmbrellaService) {
        this.dataUmbrellaService = dataUmbrellaService;
    }

    @GetMapping
    List<DataUmbrella> getAllData() {
        return dataUmbrellaService.getAllData();
    }

    @GetMapping("{id}")
    DataUmbrella getDataById(@PathVariable Integer id) {
        return dataUmbrellaService.getDataById(id);
    }

    @PostMapping
    DataUmbrella postDataUmbrella(@RequestBody DataUmbrella dataUmbrella) {
        return dataUmbrellaService.postDataUmbrella(dataUmbrella);
    }

    @PutMapping("{id}")
    DataUmbrella updateDataUmbrella(@PathVariable Integer id, @RequestBody DataUmbrella dataUmbrella) {
        return dataUmbrellaService.updateDataUmbrella(id, dataUmbrella);
    }

    @DeleteMapping("{id}")
    void deleteDataUmbrella(@PathVariable Integer id) {
        dataUmbrellaService.deleteDataUmbrella(id);
    }
}
