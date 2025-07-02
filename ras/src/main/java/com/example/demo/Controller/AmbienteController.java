package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Ambiente;
import com.example.demo.Model.AmbienteService;


@Controller
@RequestMapping("/ambientes")
public class AmbienteController {
    
    @Autowired
    private AmbienteService ambienteService;

    @GetMapping
    public String listarAmbientes(Model model) {
        model.addAttribute("ambientes", ambienteService.getAllAmbientes());
        return "ambiente-list";
    }

    @GetMapping("/crear")
    public String crearAmbienteForm(Model model) {
        model.addAttribute("ambiente", new Ambiente());
        return "ambiente-form";
    }

    @PostMapping
    public String guardarAmbiente(Ambiente ambiente) {
        ambienteService.saveAmbiente(ambiente);
        return "redirect:/ambientes";
    }
    
    @GetMapping("/editar/{id}")
    public String editarAmbienteForm(@PathVariable Integer id, Model model) {
        model.addAttribute("ambiente", ambienteService.getAmbienteById(id));
        return "ambiente-form";
    }

    @GetMapping("eliminar/{id}")
    public String deleteAmbiente(@PathVariable Integer id) {
        ambienteService.deleteAmbiente(id);
        return "redirect:/ambientes";
    }
    

    
}
