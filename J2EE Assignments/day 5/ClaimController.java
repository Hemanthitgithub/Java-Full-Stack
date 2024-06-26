package com.example.policyadminbackend.controller;

import com.example.policyadminbackend.model.ClaimModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Controller
public class ClaimController {

    // Existing methods and logic

    @GetMapping("/claim")
    public String showClaimForm(Model model) {
        model.addAttribute("claim", new ClaimModel());
        return "claimForm";
    }

    @PostMapping("/claim")
    public String submitClaimForm(@Valid @ModelAttribute ClaimModel claim, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "claimForm";
        }
        model.addAttribute("claim", claim);
        return "claimResult";
    }
}