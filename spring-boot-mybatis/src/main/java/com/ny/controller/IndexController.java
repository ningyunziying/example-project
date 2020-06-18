package com.ny.controller;

import com.ny.bean.Student;
import com.ny.mapper.StudentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class IndexController {
    @Resource
    StudentMapper studentMapper;

    @GetMapping("index/insert")
    public void inset(Integer count) {
        for (int i = 0; i < count; i++) {
            Student student = new Student();
            student.setName(UUID.randomUUID().toString());
            studentMapper.insert(student);
        }
    }
}
