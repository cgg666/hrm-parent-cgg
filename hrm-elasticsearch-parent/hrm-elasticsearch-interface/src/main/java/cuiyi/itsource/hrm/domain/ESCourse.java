package cuiyi.itsource.hrm.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "hrm")
public class ESCourse {
    private Long id;
    private String name;
    private String users;
    private Long courseTypeId;
    private String intro;
    private String description;
    private String all;
    private Long startTime;
    private Long grade;

}
