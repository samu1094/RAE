package com.example.demo.Controller;

import com.example.demo.Model.TblUsuario;
import com.example.demo.Model.TblUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/req")
public class RegistrationController {

    @Autowired
    private TblUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("usuario", new TblUsuario());
        return "signup";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute TblUsuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol_usuario("Usuario"); 
        usuarioRepository.save(usuario);
        return "redirect:/req/login";
    }
}
