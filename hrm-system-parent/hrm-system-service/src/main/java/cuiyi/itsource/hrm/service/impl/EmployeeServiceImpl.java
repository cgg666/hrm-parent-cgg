package cuiyi.itsource.hrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuiyi.itsource.hrm.domain.Employee;
import cuiyi.itsource.hrm.mapper.EmployeeMapper;
import cuiyi.itsource.hrm.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements IEmployeeService {
}
