package vn.edu.hcmut.cse.adsoftweng.lab.service;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public List<Student> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }

    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Student deleteById(String id) {
        Student student = getById(id);
        if (student != null) {
            repository.deleteById(id);
        }
        return student;
    }

    public void save(Student student) {
        repository.save(student);
    }
}
