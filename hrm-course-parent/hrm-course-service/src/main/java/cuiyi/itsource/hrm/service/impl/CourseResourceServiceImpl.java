package cuiyi.itsource.hrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuiyi.itsource.hrm.domain.CourseResource;
import cuiyi.itsource.hrm.mapper.CourseResourceMapper;
import cuiyi.itsource.hrm.service.ICourseResourceService;
import org.springframework.stereotype.Service;

@Service
public class CourseResourceServiceImpl extends ServiceImpl<CourseResourceMapper, CourseResource> implements ICourseResourceService {
}
