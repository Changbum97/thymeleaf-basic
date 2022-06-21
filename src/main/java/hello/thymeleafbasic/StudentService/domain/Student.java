package hello.thymeleafbasic.StudentService.domain;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private Long id;
    private String name;
    private Long studentId;     // 학번
    private Integer age;
    private Boolean attending;  // 재학여부
    private List<String> clubs; // 참여활동
    private Gender gender;      // 성별
    private Grade grade;        // 학년
    private String major;       // 전공
}
