package hello.thymeleafbasic.StudentService.Controller;

import hello.thymeleafbasic.StudentService.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public String students(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/studentList";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("student", new Student());
        Map<Integer, String> clubs = new LinkedHashMap<>();
        clubs.put(1, "중앙동아리");
        clubs.put(2, "과동아리");
        clubs.put(3, "연합동아리");
        clubs.put(4, "과학생회");
        clubs.put(5, "총학생회");
        model.addAttribute("clubs", clubs);
        model.addAttribute("genders", Gender.values());
        model.addAttribute("grades", Grade.values());
        List<String> majors = new ArrayList<>();
        majors.add("컴퓨터공학부");
        majors.add("기계공학부");
        majors.add("전자전기공학부");
        model.addAttribute("majors", majors);
        return "student/registerForm";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/student";
    }

    @GetMapping("/studentInfo/{Id}")
    public String studentInfo(@PathVariable Long Id, Model model) {
        Student student = studentRepository.findById(Id);
        model.addAttribute("student", student);
        Map<Integer, String> clubs = new LinkedHashMap<>();
        clubs.put(1, "중앙동아리");
        clubs.put(2, "과동아리");
        clubs.put(3, "연합동아리");
        clubs.put(4, "과학생회");
        clubs.put(5, "총학생회");
        model.addAttribute("clubs", clubs);
        return "student/studentInfo";
    }
}
