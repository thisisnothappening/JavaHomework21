package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.DataUmbrella;
import com.fasttrackit.JH21.repository.DataUmbrellaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataUmbrellaService {
    private final DataUmbrellaRepository dataUmbrellaRepository;

    public DataUmbrellaService(DataUmbrellaRepository dataUmbrellaRepository) {
        this.dataUmbrellaRepository = dataUmbrellaRepository;
    }

    public List<DataUmbrella> getAllData() {
        return dataUmbrellaRepository.findAll();
    }

    public DataUmbrella getDataById(Integer id) {
        return dataUmbrellaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found!"));
    }

    public DataUmbrella postDataUmbrella(DataUmbrella dataUmbrella) { // this is not done
        return dataUmbrellaRepository.save(dataUmbrella);
    }

    public DataUmbrella updateDataUmbrella(Integer id, DataUmbrella dataUmbrella) { // this is not done
        return dataUmbrellaRepository.save(dataUmbrella);
    }

    public void deleteDataUmbrella(Integer id) {
        dataUmbrellaRepository.delete(dataUmbrellaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found")));
    } // this one throws exception
}
