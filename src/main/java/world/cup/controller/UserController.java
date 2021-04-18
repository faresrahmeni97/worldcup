package world.cup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.cup.models.User;
import world.cup.models.UserDto;
import world.cup.repositories.UserRepository;
import world.cup.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {

    @Autowired
    UserRepository userv;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> pro = userv.findAll();


        return pro;

    }

    // @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long Id) {
        return userv.findById(Id).orElseThrow(null);
        // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/userdelete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userv.findById(userId).orElseThrow(null);
        //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        // userRepository.deleteById(userId);
        userv.delete(user);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/adduser")

    public User createUser(@Valid @RequestBody User user) {
        return userv.save(user);
    }

    @PutMapping("/userupdate/{id}")
    public User updateUser(@PathVariable(value = "id") Long Id,
                           @Valid @RequestBody User userDetails) {

        User user = userv.findById(Id).orElseThrow(null);


        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUsername(userDetails.getUsername());
        User updatedUser = userv.save(user);
        return updatedUser;
    }

}


