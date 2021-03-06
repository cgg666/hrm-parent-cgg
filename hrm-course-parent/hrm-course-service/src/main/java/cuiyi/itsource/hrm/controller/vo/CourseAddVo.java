package cuiyi.itsource.hrm.controller.vo;

import lombok.Data;

@Data
public class CourseAddVo {
    private String name;
    private String users;
    private Long courseTypeId;
    private Long grade;
    /**
     * 课程列表页展示课程的图片
     */
    private String pic;
    /**
     * 简介
     */
    private String intro;
    /**
     * 详情
     */
    private String description;
}
