package zc.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zc.Entity.Department;
import zc.Entity.User;
import zc.Mapper.DepartmentMapper;
import zc.Vo.DeptVo;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> SelectAll() {
        List<Department> departmentList = departmentMapper.selectAll();
        for (Department department:departmentList) {
            System.out.println(department);
        }
        return departmentList;
    }

    public Department SelectDepartmentById(int id) {
        Department department = departmentMapper.selectById(id);
        return department;
    }

    public boolean InsertDepartment(Department department) {
        String description=department.getDescription()+"_insert";
        department.setDescription(description);
        int result=departmentMapper.insertToDepartment(department);
        System.out.println(result);
        if(result==0){
            return false;
        }else {
            return true;
        }
    }
    public int InsertTheseDepartments(Department[] depts) {
        int count=0;
        for (Department d:depts ) {
            String description=d.getDescription()+"_insert";
            d.setDescription(description);
            int result=departmentMapper.insertToDepartment(d);
            count++;
        }
        return count;
    }
    public void update(Department department) {
        String description=department.getDescription()+"_update";
        department.setDescription(description);
        System.out.println(departmentMapper.update(department));
    }

    public void delete(int id) {
        // System.out.println(user);
        departmentMapper.delete(id);
    }
    public void deleteThese(int[] ids) {
        // System.out.println(user);
        for (int i:ids) {
            departmentMapper.delete(i);
        }
    }
    public DeptVo findDeptAllUser(int id){
        DeptVo department=departmentMapper.findDeptAllUser(id);
        return department;
    }
    public List<DeptVo> findDeptAll(){
        List<DeptVo> deptVoList=departmentMapper.findDeptAll();
        return deptVoList;
    }
}
