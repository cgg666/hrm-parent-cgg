package cuiyi.itsource.hrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuiyi.itsource.hrm.controller.vo.RegisterVo;
import cuiyi.itsource.hrm.domain.Tenant;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-19
 */
public interface ITenantService extends IService<Tenant> {
    void register(RegisterVo registerVo);
}
