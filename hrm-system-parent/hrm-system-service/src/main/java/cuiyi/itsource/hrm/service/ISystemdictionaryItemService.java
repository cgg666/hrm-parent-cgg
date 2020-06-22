package cuiyi.itsource.hrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuiyi.itsource.hrm.domain.SystemdictionaryItem;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-19
 */
public interface ISystemdictionaryItemService extends IService<SystemdictionaryItem> {
    List<SystemdictionaryItem> getBySn(String course_level);

}
