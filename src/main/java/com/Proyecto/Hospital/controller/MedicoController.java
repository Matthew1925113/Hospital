package com.Proyecto.Hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicoController {

    @GetMapping("/medicos")
    public String medicos() {
        return "medicos";
    }
}