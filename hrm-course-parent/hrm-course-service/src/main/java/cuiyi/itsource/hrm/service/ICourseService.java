package cuiyi.itsource.hrm.service;

import cuiyi.itsource.hrm.controller.vo.CourseAddVo;
import cuiyi.itsource.hrm.domain.Course;
import cuiyi.itsource.hrm.query.CourseQuery;
import cuiyi.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-18
 */
public interface ICourseService extends IService<Course> {
    PageList<Course> page(CourseQuery query);
    void add(CourseAddVo courseAddVo);

}
