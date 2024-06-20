package com.capgemini.wsb.fitnesstracker.loader;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import com.capgemini.wsb.fitnesstracker.training.internal.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class InitialDataLoader {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @PostConstruct
    private void initDatabase() {
        verifyDependenciesAutowired();
        List<User> users = createUsers();
        createTrainings(users);
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("User1", "LastName1", LocalDate.of(1990, 1, 1), "user1@example.com"));
        users.add(new User("User2", "LastName2", LocalDate.of(1991, 2, 2), "user2@example.com"));
        users.add(new User("User3", "LastName3", LocalDate.of(1992, 3, 3), "user3@example.com"));
        users.add(new User("User4", "LastName4", LocalDate.of(1993, 4, 4), "user4@example.com"));
        users.add(new User("User5", "LastName5", LocalDate.of(1994, 5, 5), "user5@example.com"));
        users.add(new User("User6", "LastName6", LocalDate.of(1995, 6, 6), "user6@example.com"));
        users.add(new User("User7", "LastName7", LocalDate.of(1996, 7, 7), "user7@example.com"));
        users.add(new User("User8", "LastName8", LocalDate.of(1997, 8, 8), "user8@example.com"));
        users.add(new User("User9", "LastName9", LocalDate.of(1998, 9, 9), "user9@example.com"));
        users.add(new User("User10", "LastName10", LocalDate.of(1999, 10, 10), "user10@example.com"));

        users.forEach(user -> userRepository.save(user));

        return users;
    }

    private List<Training> createTrainings(List<User> users) {
        List<Training> trainingData = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Training training1 = new Training(ActivityType.RUNNING,
                    sdf.parse("2024-01-10 12:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-10 13:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    10.5,
                    10.5,
                    users.get(0));
            Training training2 = new Training(ActivityType.CYCLING,
                    sdf.parse("2024-01-11 10:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-11 11:30:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    20.0,
                    15.0,
                    users.get(1));
            Training training3 = new Training(ActivityType.WALKING,
                    sdf.parse("2024-01-12 08:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-12 09:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    5.0,
                    5.0,
                    users.get(2));
            Training training4 = new Training(ActivityType.SWIMMING,
                    sdf.parse("2024-01-13 14:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-13 15:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    1.0,
                    2.0,
                    users.get(3));
            Training training5 = new Training(ActivityType.TENNIS,
                    sdf.parse("2024-01-14 17:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-14 18:30:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    0.0,
                    0.0,
                    users.get(4));
            Training training6 = new Training(ActivityType.RUNNING,
                    sdf.parse("2024-01-15 07:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-15 08:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    12.0,
                    11.0,
                    users.get(5));
            Training training7 = new Training(ActivityType.CYCLING,
                    sdf.parse("2024-01-09 09:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-09 10:45:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    25.5,
                    18.0,
                    users.get(6));
            Training training8 = new Training(ActivityType.SWIMMING,
                    sdf.parse("2024-01-08 15:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-08 16:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    1.5,
                    3.0,
                    users.get(7));
            Training training9 = new Training(ActivityType.WALKING,
                    sdf.parse("2024-01-11 07:15:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-11 08:30:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    4.2,
                    4.5,
                    users.get(8));
            Training training10 = new Training(ActivityType.RUNNING,
                    sdf.parse("2024-01-10 14:00:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    sdf.parse("2024-01-10 15:15:00").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    11.8,
                    8.5,
                    users.get(9));

            trainingData.add(training1);
            trainingData.add(training2);
            trainingData.add(training3);
            trainingData.add(training4);
            trainingData.add(training5);
            trainingData.add(training6);
            trainingData.add(training7);
            trainingData.add(training8);
            trainingData.add(training9);
            trainingData.add(training10);

            trainingData.forEach(training -> trainingRepository.save(training));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return trainingData;
    }

    private void verifyDependenciesAutowired() {
        if (isNull(userRepository) || isNull(trainingRepository)) {
            throw new IllegalStateException("Initial data loader was not autowired correctly " + this);
        }
    }
}
