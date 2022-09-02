package spring_crud.controllers;

import spring_crud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring_crud.services.MyService;

@Controller
@RequestMapping(value = "/users")
public class UserController implements MyController<User> {
    private MyService<User> service;

    @Autowired
    public UserController(MyService<User> service) {
        this.service = service;
    }

    //тут я пока сама не очень поняла что написала, но да ладно
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @GetMapping("/create")
    public String createUserForm(){
        return "create_user";
    }

    @GetMapping
    public String mainUsersPage() {
        return "users_main";
    }
}

