package Solution.controllers;

import Solution.model.User;
import Solution.service.UsersServiceImpl;
import Solution.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

//    private final UserServiceImpl userServiceImpl;
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    //    public UsersController(UsersDaoImpl usersDaoImpl) {
//        this.usersDaoImpl = usersDaoImpl;
//    }


    @GetMapping()
    public String index(Model model) {
//        получим всех юзеров из DAO и передадим на представление
        model.addAttribute("users", usersService.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
//      получим юзера по id из DAO и передадим на представление
        model.addAttribute("user", usersService.show(id));
        return "users/show";
    }

//    @GetMapping("/new")
//    public String newUser(Model model) {
////      возвращает html форму для создания нового юзера
//        model.addAttribute("user", new User());
//        return "users/new";
//    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
//      возвращает html форму для создания нового юзера
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute ("user") User user) {
//    принимать на вход post запрос, создавать нового юзера, и добавлять в БД
        usersService.save(user);
       return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user",usersService.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        usersService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersService.delete(id);
        return "redirect:/users";
    }
}
