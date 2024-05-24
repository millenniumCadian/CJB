package zc.Mapper;

import org.apache.ibatis.annotations.Mapper;
import zc.Entity.User;
import zc.Vo.UserVo;

import java.util.List;
@Mapper
public interface UserMapper {
    // @Select("select * from user")
    List<User> selectAll();

    // @Select("select * from user where id=#{id}")
    User selectById(Integer id);

    // @Insert("insert into user(user_name,password) values (#{userName},#{password})")
    Integer insertToUser(User user);

    // @Update("update user set user_name=#{userName} where id=#{id}")
    Integer update(User user);

    // @Insert("delete from user where id=#{id}")
    Integer delete(Integer id);

    List<UserVo> getAllUserWithDepartment();

    UserVo getUserWithDepartment(Integer id);
}
