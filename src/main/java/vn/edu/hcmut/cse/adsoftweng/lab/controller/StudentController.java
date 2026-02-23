// package vn.edu.hcmut.cse.adsoftweng.lab.controller;

// import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
// import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.ui.Model;

// import java.util.List;

// @RestController
// @RequestMapping("/api/students")
// public class StudentController {

//     @Autowired
//     private StudentService service;

//     @GetMapping
//     public String getAllStudents(
//             @RequestParam(required = false) String keyword, Model model) {
//         List<Student> students;
//         if (keyword != null
//                 && !keyword.isEmpty()) {
//             // Cầần viết thêm hàm searchByName trong Service/Repository
//             students = service.searchByName(keyword);
//         } else {
//             students = service.getAll();
//         }
//         model.addAttribute(
//                 "dsSinhVien", students);
//         return "students";
//     }

//     @GetMapping("/students")
//     public String listStudents(
//             @RequestParam(required = false) String keyword,
//             Model model) {

//         List<Student> students = (keyword == null || keyword.isBlank())
//                 ? service.getAll()
//                 : service.searchByName(keyword);

//         model.addAttribute("dsSinhVien", students);

//         return "students";
//     }

//     @GetMapping("/students/{id}")
//     public String getStudentDetail(@PathVariable String id, Model model) {
//         Student student = service.getById(id);
//         if (student != null) {
//             model.addAttribute("student", student);
//             return "student-detail"; // Tên file HTML
//         }
//         return "redirect:/students"; // Nếu không thấy, quay về danh sách
//     }

//     @GetMapping("/students/new")
//     public String createForm(Model model) {

//         model.addAttribute("student", new Student());

//         return "student-form";
//     }

//     @GetMapping("/delete/{id}")
//     public String deleteStudent(@PathVariable String id) {
//         service.deleteById(id);
//         return "redirect:/students"; // Xóa xong quay về trang danh sách [cite: 182]
//     }
// }
