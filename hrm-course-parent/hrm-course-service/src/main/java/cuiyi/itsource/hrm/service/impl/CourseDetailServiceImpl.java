package cuiyi.itsource.hrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuiyi.itsource.hrm.domain.CourseDetail;
import cuiyi.itsource.hrm.mapper.CourseDetailMapper;
import cuiyi.itsource.hrm.service.ICourseDetailService;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailServiceImpl extends ServiceImpl<CourseDetailMapper, CourseDetail> implements ICourseDetailService {
}
