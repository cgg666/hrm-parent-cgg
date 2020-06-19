package cuiyi.itsource.hrm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cuiyi.itsource.hrm.domain.Employee;
import cuiyi.itsource.hrm.service.IEmployeeService;
import cuiyi.itsource.hrm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody Employee employee){
        if (StringUtils.isEmpty(employee.getUsername())){
            return AjaxResult.me().setSuccess(false).setMessage("用户名不能为空");
        }
        if (StringUtils.isEmpty(employee.getUsername())){
            return AjaxResult.me().setSuccess(false).setMessage("密码不能为空");
        }

        Employee loginUser = employeeService.getOne(new QueryWrapper<Employee>().eq("username", employee.getUsername()));

        if (loginUser == null){
            return AjaxResult.me().setSuccess(false).setMessage("用户名或密码错误");
        }

        loginUser.setPassword(null);
        return AjaxResult.me().setSuccess(true).setMessage("登陆成功").setResultObj(loginUser);

    }

}
