package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/req")
public class VerificationController {

    @GetMapping("/verify")
    public String verify() {
        // Aquí podrías manejar la verificación de token si usas uno.
        return "login"; // o redirigir a una vista personalizada
    }
}