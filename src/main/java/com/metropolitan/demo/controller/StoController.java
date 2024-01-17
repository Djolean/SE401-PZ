package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/stos")
public class StoController {

    private final StoService stoService;

    @GetMapping
    public String getAllStos(Model model) {
        List<Sto> stos = stoService.findAll();
        model.addAttribute("stos", stos);
        return "klijent/klijenti";
    }

}
