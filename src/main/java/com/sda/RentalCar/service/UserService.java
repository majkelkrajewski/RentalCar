package com.sda.RentalCar.service;

import com.sda.RentalCar.domain.User;
import com.sda.RentalCar.dto.CreateUserDto;
import com.sda.RentalCar.repository.UserRepository;
import com.sda.RentalCar.view.CarView;
import com.sda.RentalCar.view.UserAndCar;
import com.sda.RentalCar.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static String USERS_URL = "http://localhost:8081/car/external/";

    private RestTemplate restTemplate;
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public User save(CreateUserDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .age(dto.getAge())
                .build();

        repository.save(user);
        return user;
    }

    public List<UserView> findAll() {
        return repository.findAll().stream().map(u -> u.ge)
    }

    public UserAndCar findUserById(Long userId) {
        User user = repository.findById(userId).get();
        List<CarView> cars = restTemplate.getForObject(USERS_URL + userId, List.class);

        //znalezc uzytkownika po id w repo
        //przez rest template popbrac dane od kolezanki po liste samochodow
        //zbudopwac nowy obiekt skladajacy sie z danych uzytkownika + listy samochodow
    }

}


