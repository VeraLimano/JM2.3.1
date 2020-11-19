package Solution.controllers;

import Solution.dao.UsersDao;
import Solution.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersDao usersDao;

    @Autowired
    public UsersController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping()
    public String index(Model model) {
//        получим всех юзеров из DAO и передадим на представление
        model.addAttribute("users", usersDao.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
//      получим юзера по id из DAO и передадим на представление
        model.addAttribute("user", usersDao.show(id));
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
       usersDao.save(user);
       return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user",usersDao.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        usersDao.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersDao.delete(id);
        return "redirect:/users";
    }
}
