package com.capgemini.wsb.fitnesstracker.training.api;

public class TrainingNotFoundException extends RuntimeException {
    public TrainingNotFoundException(Long id) {
        super("Training not found with id " + id);
    }
}
