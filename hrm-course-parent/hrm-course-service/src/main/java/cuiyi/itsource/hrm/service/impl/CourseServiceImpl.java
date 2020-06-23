package cuiyi.itsource.hrm.service.impl;

import cuiyi.itsource.hrm.client.ESCourseClient;
import cuiyi.itsource.hrm.controller.vo.CourseAddVo;
import cuiyi.itsource.hrm.domain.Course;
import cuiyi.itsource.hrm.domain.CourseDetail;
import cuiyi.itsource.hrm.domain.ESCourse;
import cuiyi.itsource.hrm.domain.SystemdictionaryItem;
import cuiyi.itsource.hrm.mapper.CourseDetailMapper;
import cuiyi.itsource.hrm.mapper.CourseMapper;
import cuiyi.itsource.hrm.mapper.CourseTypeMapper;
import cuiyi.itsource.hrm.query.CourseQuery;
import cuiyi.itsource.hrm.service.ICourseService;
import cuiyi.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuiyi.itsource.hrm.client.SystemdictionaryItemClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-18
 */
@Service
public class  CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private SystemdictionaryItemClient systemdictionaryItemClient;
    @Autowired
    private CourseDetailMapper courseDetailMapper;
    @Autowired
    private CourseTypeMapper courseTypeMapper;
    @Autowired
    private ESCourseClient esCourseClient;

    /**
     * 课程高级分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageList<Course> page(CourseQuery query) {
        IPage<Course> iPage = baseMapper.selectPageByQuery(new Page<Course>(query.getPageNum(), query.getPageSize()), query);
        PageList<Course> pageList = new PageList<>();
        pageList.setTotal(iPage.getTotal());
        pageList.setRows(iPage.getRecords());
        return pageList;
    }

    /**
     * 添加课程基本信息
     *
     * @param courseAddVo
     */
    @Override
    public void add(CourseAddVo courseAddVo) {
        //课程基本信息表
        Course course = new Course();
        BeanUtils.copyProperties(courseAddVo, course);
        SystemdictionaryItem systemdictionaryItem = systemdictionaryItemClient.get(courseAddVo.getGrade());
        if (systemdictionaryItem != null) {
            course.setGradeName(systemdictionaryItem.getName());
        }
        //当前登录的用户中获取用户的登录信息
        //后面会讲解单点登录，现在暂时把用户信息写死 TODO
        course.setTenantId(26L);
        course.setTenantName("源码时代");
        course.setUserId(42L);
        course.setUserName("admin");
        course.setStatus(0);
        baseMapper.insert(course);
        //课程详情表
        CourseDetail courseDetail = new CourseDetail();
        BeanUtils.copyProperties(courseAddVo, courseDetail);
        courseDetail.setCourseId(course.getId());
        courseDetailMapper.insert(courseDetail);
    }




    @Override
    public void onLine(List<Long> ids) {
        System.out.println("当前时间："+System.currentTimeMillis());
        //批量修改课程上线时间
        baseMapper.onLine(System.currentTimeMillis(),ids);
        //查询所有课程信息
        List<Course> courses = baseMapper.selectBatchIds(ids);
        //调用批量保存
        esCourseClient.saveAll(courses2Docs(courses));
    }

    private List<ESCourse> courses2Docs(List<Course> courses) {
        List<ESCourse> docs = new ArrayList<>();
        ESCourse doc = null;
        for (Course cours : courses) {
            doc = course2Docs(cours);
            docs.add(doc);
        }
        return docs;

    }

    //课程对象的转换
    private ESCourse course2Docs(Course courses) {
        ESCourse doc = new ESCourse();
        doc.setId(courses.getId());
        doc.setName(courses.getName());
        doc.setUsers(courses.getUsers());
        doc.setCourseTypeId(courses.getCourseTypeId());
        CourseDetail courseDetail = courseDetailMapper.selectOne(new QueryWrapper<CourseDetail>().eq("course_id", courses.getId()));
        doc.setDescription(courseDetail!=null?courseDetail.getDescription():"");

        doc.setIntro(courseDetail!=null?courseDetail.getIntro():"");
        //课程名称
        String courseName = courses.getName();
        //课程类型名称
        String typeName = courseTypeMapper.selectById(courses.getCourseTypeId()).getName();
        //机构名称
        String tenantName = courses.getTenantName();
        //加上空格后，空格前后会自动分词
        String all = courseName+" "+typeName  +" "+tenantName;
        doc.setAll(all);
        doc.setStartTime(courses.getStartTime());
        doc.setGrade(courses.getGrade());

        return doc;

    }
    //课程下线
    @Override
    public void offLine(List<Long> ids) {
        //批量修改课程下线时间
        baseMapper.offLine(System.currentTimeMillis(), ids);
        //删除es
        esCourseClient.deleteAll(ids);
    }
}
