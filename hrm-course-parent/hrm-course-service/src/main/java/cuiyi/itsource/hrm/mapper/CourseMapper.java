package cuiyi.itsource.hrm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cuiyi.itsource.hrm.domain.Course;
import cuiyi.itsource.hrm.query.CourseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cuigege
 * @since 2020-06-18
 */
public interface CourseMapper extends BaseMapper<Course> {
    IPage<Course> selectPageByQuery(Page<?> page, @Param("query") CourseQuery query);

    void onLine(@Param("time") long l,@Param("ids") List<Long> ids);

    void offLine(@Param("time") long l,@Param("ids") List<Long> ids);

}
