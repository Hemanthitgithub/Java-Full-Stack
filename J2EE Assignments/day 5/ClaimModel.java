package com.example.policyadminbackend.model;


/*
public class ClaimModel {
    private String policyNumber;
    private String description;
    // Getters and setters
}
*/



import javax.validation.constraints.NotBlank;

public class ClaimModel {
    @NotBlank(message = "Policy number is mandatory")
    private String policyNumber;

    @NotBlank(message = "Description is mandatory")
    private String description;

    // Other existing fields and methods
    
    // Getters and setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
