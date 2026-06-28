package com.Proyecto.Hospital.Service;

import com.Proyecto.Hospital.Model.Paciente;
import com.Proyecto.Hospital.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository repository;
    
    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Paciente paciente) {
        repository.save(paciente);
    }
}
