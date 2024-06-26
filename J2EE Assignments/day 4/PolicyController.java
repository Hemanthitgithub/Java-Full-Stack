package com.example.policyadminbackend.controller;

import com.example.policyadminbackend.model.Policy;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    // Other methods and constructor if needed

    @PostMapping
    public String createPolicy(@Valid @RequestBody Policy policy, BindingResult result) {
        if (result.hasErrors()) {
            return "Validation failed: " + result.getAllErrors();
        }

        // Save policy logic goes here
        // For example, you might inject PolicyService and call a method to save the policy
        // policyService.save(policy);

        return "Policy created successfully";
    }

    // Example of other methods if needed
    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        // Implement logic to fetch policy by ID
        return null;
    }
}
