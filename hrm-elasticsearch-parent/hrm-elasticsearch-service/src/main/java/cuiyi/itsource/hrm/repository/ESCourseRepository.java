package cuiyi.itsource.hrm.repository;

import cuiyi.itsource.hrm.domain.ESCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESCourseRepository extends ElasticsearchRepository<ESCourse,Long> {
}
