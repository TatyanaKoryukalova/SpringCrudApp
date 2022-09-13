package spring_crud.services;

import spring_crud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_crud.repositories.UserRepository;

import java.util.List;

@Service
public class UserService implements MyService<User> {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public String read(int id) {
        return userRepository.findById(id).toString();
    }

    @Override
    public void update(User user, int id) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
