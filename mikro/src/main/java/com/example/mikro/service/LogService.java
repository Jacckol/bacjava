package com.example.mikro.service;

import com.example.mikro.model.LogEntry;
import com.example.mikro.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogEntryRepository logRepo;

    public void registrarAccion(String mensaje) {
        logRepo.save(new LogEntry(mensaje));
    }
}
