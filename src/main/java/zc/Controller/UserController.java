package zc.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zc.Entity.User;
import zc.Service.UserService;
import zc.Vo.UserVo;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User GetByID(@PathVariable Integer id){
        logger.info("Getting user by ID: " + id);
        return userService.SelectUserById(id);
    }

    @GetMapping
    public List<User> GetAll(){
        return userService.SelectAllUser();
    }

    @PostMapping("/insert")
    public String Register(@RequestBody User user){
        logger.info("Registering user: " + user.getUserName());
        if(userService.InsertUser(user)){
            logger.info("Registration successful");
            return "注册成功";
        }
        else {
            logger.info("Registration failed");
            return "注册失败";
        }
    }
    @PostMapping
    public String Register2(@RequestBody User[] users){
        int i=userService.InsertTheseUser(users);
        if(i!=0){
            return "注册成功"+i+"个用户";
        }
        else {
            logger.info("Registration failed");
            return "注册失败";
        }
    }

    @PutMapping
    public String ModifyUser(@RequestBody User user){
        logger.info("Modifying user: " + user.getId());
        userService.update(user);
        logger.info("User modified successfully");
        return "修改成功";
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteUser(@PathVariable int id){
        logger.info("Deleting user with ID: " + id);
        userService.delete(id);
        logger.info("User deleted successfully");
        return "删除成功";
    }

    @DeleteMapping("/delete")
    public String DeleteAllUser(@RequestParam Integer[] ids){
        logger.info("Deleting multiple users: " + Arrays.toString(ids));
        userService.deleteThese(ids);
        logger.info("Users deleted successfully");
        return "删除成功";
    }

    @GetMapping("/findUserDept")
    public List<UserVo> getAllUserWithDepartment(){
        logger.info("Getting all users with department");
        return userService.getAllUserWithDepartment();
    }

    @GetMapping("/findUserDept/{id}")
    public UserVo getUserWithDepartment(@PathVariable int id){
        logger.info("Getting user with department by ID: " + id);
        return userService.getUserWithDepartment(id);
    }
}
