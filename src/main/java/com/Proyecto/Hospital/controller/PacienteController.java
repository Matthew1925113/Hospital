package com.Proyecto.Hospital.controller;
 
import com.Proyecto.Hospital.Model.Paciente;
import com.Proyecto.Hospital.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class PacienteController {
 
    @Autowired
    private PacienteService service;
 
    @GetMapping("/pacientes")
    public String index(Model model) {
        model.addAttribute("pacientes", service.ListarPacientes());
        return "ListaPacientes";
    }
 
    @GetMapping("/pacienteNuevo")
    public String newPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "FormularioPaciente";
    }
 
    @GetMapping("/EditarPaciente/{id}")
    public String editPaciente(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", service.ObtenerPaciente(id));
        return "FormularioPaciente";
    }
 
    @PostMapping("/GuardarPaciente")
    public String updatePaciente(@ModelAttribute Paciente paciente) {
        service.GuardarPaciente(paciente);
        return "redirect:/pacientes";
    }
}