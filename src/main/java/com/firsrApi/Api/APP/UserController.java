package com.firsrApi.Api.APP;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    private UsetService usetService = new UsetService();

//    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UsetService usetService) {
        this.usetService = usetService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createUser =  usetService.createUser(user);
//        UserDb.put(user.getId(),user);
//        //return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return new ResponseEntity<>(createUser,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateuser( @RequestBody User user){
//        if(UserDb.containsKey(user.getId()))
//            UserDb.put(user.getId(),user);
        User updated = usetService.updateUser(user);
        if(updated == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable int id){
//        if(!UserDb.containsKey(id)){
//            return "user not find";
//        }
//        UserDb.remove(id);
//        return "user delete ";
        boolean isDeleted = usetService.deleteUser(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }

    // /user/1025
    //@GetMapping({"/users" , "/user/{id}"})
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUser(@PathVariable("userid") int id){
        User user = usetService.getUserById(id);
        if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }

//    @GetMapping("/{userid}/Order/{orderId}")
//    public ResponseEntity<User> getUserOrder(@PathVariable("userid") int id , @PathVariable(value = "orderId" , required = false) int orderId){
//        System.out.println("order id " + orderId);        if(!UserDb.containsKey(id))
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        return ResponseEntity.ok(UserDb.get(id));
//    }



//    @GetMapping("/search")
//    // /user/search?name=sajal&email=new444@gamil.com
//    //search return in list
//    public ResponseEntity<List<User>> searchUsers(@RequestParam(required = false) String name,
//                                                  @RequestParam(required = false) String email){
//        //name = null
//        System.out.println(name);
//        return ResponseEntity.ok(new ArrayList<>(UserDb.values()));
//    }
//
//    @GetMapping("/info")
//    public String getInfo(@RequestHeader("User-Agent") String userAgent){
//        return "user Agent :" + userAgent;
//    }

    //exception handling method
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(IllegalArgumentException exception){
//        Map<String ,Object> errorResponse = new HashMap<>();
//        errorResponse.put("timestemp" , LocalDate.now());
//        errorResponse.put("status" , HttpStatus.BAD_REQUEST.value());
//        errorResponse.put("message" , exception.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

}
