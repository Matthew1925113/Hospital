package com.Proyecto.Hospital.Service;
 
import com.Proyecto.Hospital.Model.Medico;
import com.Proyecto.Hospital.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
 
@Service
public class MedicoService {
   
    @Autowired
    private MedicoRepository repository;
   
    public List<Medico> ListarMedicos() {
        return repository.findAll();
    }
 
    public Medico ObtenerMedico(Long id) {
        return repository.findById(id).orElse(null);
    }
 
    public void GuardarMedico(Medico medico) {
        repository.save(medico);
    }
}