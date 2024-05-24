package zc.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zc.Entity.User;
import zc.Mapper.UserMapper;
import zc.Vo.UserVo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> SelectAllUser() {
        List<User> userList = userMapper.selectAll();
        for (User user:userList) {
            System.out.println(user);
        }
        return userList;
    }

    public User SelectUserById(int id) {
        User user = userMapper.selectById(id);
        System.out.println(user);
        return user;
    }

    public boolean InsertUser(User user) {
        String password=user.getPassword()+"_insert";
        user.setPassword(password);
        int result=userMapper.insertToUser(user);
        System.out.println(result);
        if(result==0){
            return false;
        }else {
            return true;
        }
    }

    public int InsertTheseUser(User[] users) {
        int count=0;
        for (User user:users ) {
            String password=user.getPassword()+"_insert";
            user.setPassword(password);
            int result=userMapper.insertToUser(user);
            count++;
        }
        return count;
    }

    public void update(User user) {

        String password=user.getPassword()+"_update";
        user.setPassword(password);
        System.out.println(userMapper.update(user));
    }

    public void delete(int id) {
        // System.out.println(user);
        userMapper.delete(id);
    }

    public void deleteThese(Integer[] ids) {
        // System.out.println(user);
        for (int i:ids) {
            userMapper.delete(i);
        }
    }
    public List<UserVo> getAllUserWithDepartment(){
        List<UserVo> userVoList= userMapper.getAllUserWithDepartment();
        return  userVoList;
    }

    public UserVo getUserWithDepartment(int id){
        UserVo userVo=userMapper.getUserWithDepartment(id);
        return userVo;
    }
}
