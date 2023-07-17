package com.example.Banking.service;

import com.example.Banking.Repository.RoleRepository;
import com.example.Banking.Repository.UserRepository;
import com.example.Banking.model.User;
import com.example.Banking.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Override
//    public List<User> getAllCustomer() {
//        return customerRepository.findAll();
//    }

//    @Override
//    public User findCustomerById(Long id) {
//        return customerRepository.findCustomerById(id).orElseThrow(() -> new UserNotFoundException("User with id:" + id +"not found !"));
//    }


    //Adding User

//    @Override
//    public User addCustomer(User customer) {
//        return customerRepository.save(customer);
//    }

    //first checks if the user is present... if yes throws messages else add the user
    @Override
    public User addUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUserName(user.getUserName());
        if(local != null){
            throw new Exception("User already present!");
        }else{
            //user create
           for (UserRole ur: userRoles){
               roleRepository.save(ur.getRole());
           }
           user.getUserRoles().addAll(userRoles);
           local = this.userRepository.save(user);
        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public void deleteUser(Long userId) {
         userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User userId) {
        return null;
    }

    @Override
    public int loginValidation(String email, String password) {

        return 0;
    }

//    @Override
//    public User updateCustomer(User customer) {
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public void deleteCustomer(Long id) {
//        customerRepository.deleteCustomerById(id);
//    }



}
