package com.example.getmesocialservice.Resource;
import com.example.getmesocialservice.Service.UserService;
import com.example.getmesocialservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//resource class is for creating end points
@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/-api")
public class UserResource {

    @Autowired
    private UserService userService; //userService is an object here which we created
    @GetMapping("/user")
    public User getUser(){ return userService.getUser();}

}
