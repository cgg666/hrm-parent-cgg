package cuiyi.itsource.hrm.client.impl;

import cuiyi.itsource.hrm.client.ESCourseClient;
import cuiyi.itsource.hrm.domain.ESCourse;
import cuiyi.itsource.hrm.query.ESCourseQuery;
import cuiyi.itsource.hrm.util.AjaxResult;
import cuiyi.itsource.hrm.util.PageList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ESCourseClientImpl implements ESCourseClient {
    @Override
    public AjaxResult save(ESCourse courseDocument) {
        return null;
    }

    @Override
    public AjaxResult saveAll(List<ESCourse> courseDocuments) {
        return null;
    }

    @Override
    public AjaxResult delete(Long id) {
        return null;
    }

    @Override
    public AjaxResult deleteAll(List<Long> ids) {
        return null;
    }

    @Override
    public PageList<ESCourse> search(ESCourseQuery documentQuery) {
        return null;
    }
}
