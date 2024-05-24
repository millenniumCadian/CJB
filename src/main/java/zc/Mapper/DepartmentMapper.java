package zc.Mapper;

import org.apache.ibatis.annotations.Mapper;
import zc.Entity.Department;
import zc.Vo.DeptVo;


import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> selectAll();


    Department selectById(Integer id);


    Integer insertToDepartment(Department department);


    Integer update(Department department);

    Integer delete(Integer id);

    DeptVo findDeptAllUser(Integer id);

    List<DeptVo> findDeptAll();
}
