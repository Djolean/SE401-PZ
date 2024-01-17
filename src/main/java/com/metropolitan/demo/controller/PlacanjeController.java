package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Placanje;
import com.metropolitan.demo.service.PlacanjeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/placanjes")
@RequiredArgsConstructor
public class PlacanjeController {
    private final PlacanjeService placanjeService;

    @GetMapping
    public String getAllPlacanjes(Model model) {
        List<Placanje> placanjes = placanjeService.findAll();
        model.addAttribute("placanjes", placanjes);
        return "placanje-list";
    }

    @GetMapping("/{placanjeId}")
    public String getPlacanjeById(@PathVariable Integer placanjeId, Model model) {
        Placanje placanje = placanjeService.findById(placanjeId);
        model.addAttribute("placanje", placanje);
        return "placanje-details";
    }

    @PostMapping
    public String savePlacanje(@ModelAttribute("placanje") Placanje placanje) {
        placanjeService.save(placanje);
        return "redirect:/placanjes";
    }

    @PutMapping
    public String updatePlacanje(@ModelAttribute("placanje") Placanje placanje) {
        placanjeService.update(placanje);
        return "redirect:/placanjes";
    }

    @DeleteMapping("/{placanjeId}")
    public String deletePlacanjeById(@PathVariable Integer placanjeId) {
        placanjeService.deleteById(placanjeId);
        return "redirect:/placanjes";
    }

    @PostMapping("/naplati")
    public String naplati(@RequestParam("narudzbinaPlacanjeId") Integer narudzbinaId) {
        placanjeService.naplati(narudzbinaId);
        return "redirect:/stos";
    }
}

