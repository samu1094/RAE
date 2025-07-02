package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Centro_Formacion;
import com.example.demo.Model.Centro_FormacionService;


@Controller
@RequestMapping("/centros")
public class Centro_FormacionController {
    
    @Autowired
    private Centro_FormacionService Centro_FormacionService;

    @GetMapping
    public String listarCentros(Model model) {
        model.addAttribute("centros", Centro_FormacionService.getAllCentros());
        return "centros-list";
    }

    @GetMapping("/crear")
    public String crearCentroForm(Model model) {
        model.addAttribute("centros", new Centro_Formacion());
        return "centro-form";
    }

    @PostMapping
    public String guardarCentro(Centro_Formacion Centro_Formacion) {
        Centro_FormacionService.saveCentros(Centro_Formacion);
        return "redirect:/centros";
    }
    
    @GetMapping("/editar/{id}")
    public String editarCentroForm(@PathVariable Integer id, Model model) {
        model.addAttribute("centros", Centro_FormacionService.getCentrosById(id));
        return "centro-form";
    }

    @GetMapping("eliminar/{id}")
    public String deleteCentro(@PathVariable Integer id) {
        Centro_FormacionService.deleteCentro(id);
        return "redirect:/centros";
    }
    

    
}
