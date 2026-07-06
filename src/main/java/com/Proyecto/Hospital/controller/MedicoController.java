package com.Proyecto.Hospital.controller;
 
import com.Proyecto.Hospital.Model.Medico;
import com.Proyecto.Hospital.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class MedicoController {
 
    @Autowired
    private MedicoService service;
 
    @GetMapping("/medicos")
    public String index(Model model) {
        model.addAttribute("medicos", service.ListarMedicos());
        return "ListaMedicos";
    }
 
    @GetMapping("/medicoNuevo")
    public String newMedico(Model model) {
        model.addAttribute("medico", new Medico());
        return "FormularioMedico";
    }
 
    @GetMapping("/EditarMedico/{id}")
    public String editMedico(@PathVariable Long id, Model model) {
        model.addAttribute("medico", service.ObtenerMedico(id));
        return "FormularioMedico";
    }
 
    @PostMapping("/GuardarMedico")
    public String updateMedico(@ModelAttribute Medico medico) {
        service.GuardarMedico(medico);
        return "redirect:/medicos";
    }
}