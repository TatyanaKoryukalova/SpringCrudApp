package spring_crud.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring_crud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring_crud.services.MyService;

import java.net.URI;

@Controller
@RequestMapping(value = "/users")
public class UserController implements MyController<User> {
    private MyService<User> service;

    @Autowired
    public UserController(MyService<User> service) {
        this.service = service;
    }

    @GetMapping
    public String mainUsersPage(Model model) {
        model.addAttribute("user",service.getAll());
        return "users_main";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String aboutUser(@PathVariable int id){
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("id",id);
        model.addAttribute("path","/users/update/" + id);
        return "edit_user";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute User user) {
        user.setId(id);
        service.update(user,id);
        return "redirect:/users";
    }

    //TODO rework to DELETE mapping
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        service.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/create")
    public String passParametersWithModel(Model model) {
        model.addAttribute("path","/users/create");
        return "edit_user";
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        service.create(user);
//        return new RedirectView("/users");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/users"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}

