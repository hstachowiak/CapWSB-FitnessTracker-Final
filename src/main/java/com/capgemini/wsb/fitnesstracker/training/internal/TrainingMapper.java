package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public TrainingDto toDto(Training training) {
        return new TrainingDto(
                training.getId(),
                training.getActivityType(),
                training.getStartTime(),
                training.getEndTime(),
                training.getDistance(),
                training.getAverageSpeed(),
                training.getUser().getId()
        );
    }

    public Training toEntity(TrainingDto trainingDto) {
        Training training = new Training();
        training.setId(trainingDto.getId());
        training.setActivityType(trainingDto.getActivityType());
        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setDistance(trainingDto.getDistance());
        training.setAverageSpeed(trainingDto.getAverageSpeed());
        return training;
    }
}
