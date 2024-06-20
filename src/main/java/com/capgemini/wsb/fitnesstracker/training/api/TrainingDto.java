package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Getter
@Setter
public class TrainingDto {
    private Long id;
    private ActivityType activityType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double distance;
    private double averageSpeed;
    private Long userId;

    public TrainingDto() {
    }

    public TrainingDto(Long id, ActivityType activityType, LocalDateTime startTime, LocalDateTime endTime, double distance, double averageSpeed, Long userId) {
        this.id = id;
        this.activityType = activityType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.userId = userId;
    }
}
