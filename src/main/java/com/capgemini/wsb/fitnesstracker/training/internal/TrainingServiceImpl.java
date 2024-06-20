package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl {
    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

    public TrainingServiceImpl(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    public List<TrainingDto> getAllTrainings() {
        return trainingRepository.findAll().stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public TrainingDto getTrainingById(Long id) {
        return trainingRepository.findById(id)
                .map(trainingMapper::toDto)
                .orElseThrow(() -> new TrainingNotFoundException(id));
    }

    public TrainingDto createTraining(TrainingDto trainingDto) {
        Training training = trainingMapper.toEntity(trainingDto);
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    public TrainingDto updateTraining(Long id, TrainingDto trainingDto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException(id));
        training.setActivityType(trainingDto.getActivityType());
        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setDistance(trainingDto.getDistance());
        training.setAverageSpeed(trainingDto.getAverageSpeed());
        training = trainingRepository.save(training);
        return trainingMapper.toDto(training);
    }

    public void deleteTraining(Long id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException(id));
        trainingRepository.delete(training);
    }

    public List<TrainingDto> getTrainingsByActivityType(ActivityType activityType) {
        return trainingRepository.findByActivityType(activityType)
                .stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TrainingDto> getTrainingsByEndTimeAfter(LocalDateTime endTime) {
        return trainingRepository.findByEndTimeAfter(endTime)
                .stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }
}
