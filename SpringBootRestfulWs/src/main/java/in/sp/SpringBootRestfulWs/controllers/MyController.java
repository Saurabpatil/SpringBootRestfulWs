package in.sp.SpringBootRestfulWs.controllers;


import in.sp.SpringBootRestfulWs.entites.User;
import in.sp.SpringBootRestfulWs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController
{
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user)
    {


        return   userService.createUser(user);
    }


    @GetMapping("/user")
    public List<User> getAllUserDetails()
    {
        return userService.getAllUsers();

    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id)
    {
     User user = userService.getUserDetails(id).orElse(null);
     if ( user != null)
     {
       return ResponseEntity.ok().body(user);

     }
     else
        {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user)
    {
        User updatedUser = userService.updateUserDetails(id, user);
        if ( user != null)
        {
            return ResponseEntity.ok().body(updatedUser);

        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        User user = userService.deleteUser(id);
        if ( user == null)
        {
            return ResponseEntity.ok("User deleted");
        }
        else
    {
        return  ResponseEntity.ok("User Not deleted");
    }

    }


}
