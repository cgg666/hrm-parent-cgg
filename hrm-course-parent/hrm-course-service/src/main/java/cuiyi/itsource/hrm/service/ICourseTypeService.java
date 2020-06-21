package cuiyi.itsource.hrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuiyi.itsource.hrm.domain.CourseType;

import java.util.List;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-18
 */
public interface ICourseTypeService extends IService<CourseType> {

    List<CourseType> loadTypeTree();

}
