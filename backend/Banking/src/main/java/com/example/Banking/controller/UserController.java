package com.example.Banking.controller;

//import com.example.Banking.contant.BankingConstant;
//import com.example.Banking.helper.AuthMessage;
import com.example.Banking.model.Role;
import com.example.Banking.model.User;
import com.example.Banking.model.UserRole;
import com.example.Banking.service.UserService;
//import com.example.Banking.utils.BankingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

//   //creating user
//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
//        Set<UserRole> roles = new HashSet<>();
//
//        Role role = new Role();
//        role.setRoleId(45L);
//        role.setRoleName("NORMAL");
//
////        role.setRoleId(44L);
////        role.setRoleName("ADMIN");
//
//        UserRole userRole = new UserRole();
//        userRole.setRole(role);
//        userRole.setUser(user);
//
//        roles.add(userRole);
//        User addedUser = userService.addUser(user, roles);
//
//        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        roles.add(userRole);
        User addedUser;
        try {
            addedUser = userService.addUser(user, roles);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (addedUser != null) {
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        } else {
            return  new ResponseEntity<String>("AlreadyExist", HttpStatus.CONFLICT);
        }
    }

    //get user
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username){

        User user = userService.getUser(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

        //get all user
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> customers = userService.getAllUser();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    //Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/basicauth")
//    public AuthMessage basicauth(){
//        return new AuthMessage("Your are authenticated");
//    }

    //update User
//    public ResponseEntity<User> updateUser(@RequestBody(""))

//    //get all customer
//    @GetMapping("/all")
//    public ResponseEntity<List<User>> getAllCustomer(){
//        List<User> customers = customerService.getAllCustomer();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<User> findCustomerById(@PathVariable("id") Long id){
//        User customer = customerService.findCustomerById(id);
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<User> addCustomer(@RequestBody User customer){
//        User newCustomer = customerService.addCustomer(customer);
//        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<User> updateCustomer(@RequestBody User customer){
//        User updateCustomer = customerService.updateCustomer(customer);
//        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
//        customerService.deleteCustomer(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
