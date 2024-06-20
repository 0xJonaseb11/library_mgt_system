package com.exam.library.services;

import com.exam.library.models.User;
import com.exam.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService  {

    private  final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }
}
