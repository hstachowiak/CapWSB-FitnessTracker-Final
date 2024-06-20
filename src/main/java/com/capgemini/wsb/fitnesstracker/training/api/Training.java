package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double distance;
    private double averageSpeed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Training(ActivityType activityType, LocalDateTime startTime, LocalDateTime endTime, double distance, double averageSpeed, User user) {
        this.activityType = activityType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.user = user;
    }

    public Training() {}
}
