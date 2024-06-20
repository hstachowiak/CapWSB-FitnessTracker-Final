package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.training.internal.TrainingServiceImpl;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    @Autowired
    private TrainingServiceImpl trainingService;

    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public TrainingDto getTrainingById(@PathVariable Long id) {
        return trainingService.getTrainingById(id);
    }

    @GetMapping("/activityType")
    public List<TrainingDto> getTrainingsByActivityType(@RequestParam String activityType) {
        return trainingService.getTrainingsByActivityType(ActivityType.valueOf(activityType.toUpperCase()));
    }

    @GetMapping("/finished")
    public List<TrainingDto> getFinishedTrainingsAfter(@RequestParam String time) {
        LocalDateTime endTime = LocalDateTime.parse(time);
        return trainingService.getTrainingsByEndTimeAfter(endTime);
    }

    @PostMapping
    public TrainingDto createTraining(@RequestBody TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @PutMapping("/{id}")
    public TrainingDto updateTraining(@PathVariable Long id, @RequestBody TrainingDto trainingDto) {
        return trainingService.updateTraining(id, trainingDto);
    }
}
