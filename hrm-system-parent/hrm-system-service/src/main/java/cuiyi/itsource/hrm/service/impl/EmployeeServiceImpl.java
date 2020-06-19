package cuiyi.itsource.hrm.service.impl;

import cuiyi.itsource.hrm.domain.Employee;
import cuiyi.itsource.hrm.mapper.EmployeeMapper;
import cuiyi.itsource.hrm.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-19
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
