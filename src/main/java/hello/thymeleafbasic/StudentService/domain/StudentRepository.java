package hello.thymeleafbasic.StudentService.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private static final Map<Long, Student> store = new HashMap<>();
    private static long sequence = 0L;

    public Long save(Student student) {
        student.setId(++sequence);
        store.put(student.getId(), student);
        return student.getId();
    }

    public Student findById(Long id) {
        return store.get(id);
    }
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }

}
