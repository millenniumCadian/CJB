package zc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zc.Entity.Department;
import zc.Entity.Department;
import zc.Service.DepartmentService;
import zc.Vo.DeptVo;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department GetByID(@PathVariable Integer id){
        return departmentService.SelectDepartmentById(id);
    }
    @GetMapping
    public List<Department> GetAll(){
        return departmentService.SelectAll();
    }

    @PostMapping("/insert")
    public String Register(@RequestBody Department department){
        if(departmentService.InsertDepartment(department)){
            return "注册成功";
        }
        else {
            return "注册失败";
        }
    }
    @PostMapping
    public String RegisterThese(@RequestBody Department[] departments){
        int i=departmentService.InsertTheseDepartments(departments);
        if(i!=0){
            return "注册成功"+i+"个部门";
        }
        else {
            return "注册失败";
        }
    }

    @PutMapping
    public String ModifyDepartment(@RequestBody Department department){
        departmentService.update(department);
        return "修改成功";
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteDepartment(@PathVariable int id){
        departmentService.delete(id);
        return "删除成功";
    }

    @DeleteMapping("/delete")
    public String DeleteTheseDepartment(@RequestParam("ids") int[] ids){
        departmentService.deleteThese(ids);
        return "删除成功";
    }

    @GetMapping("/findDeptAllUser/{id}")
    public DeptVo findDeptAllUser(@PathVariable int id){
        return departmentService.findDeptAllUser(id);
    }

    @GetMapping("/findDeptAllUser")
    public List<DeptVo> findDeptAll(){
        return departmentService.findDeptAll();
    }
}
