package service;

import model.Student;
import exception.StudentNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class StudentManager implements RecordActions {

    private Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        studentMap.put(s.getRollNo(), s);
        System.out.println("Student added successfully!\n");
    }

    @Override
    public Student searchStudent(Integer rollNo) throws StudentNotFoundException {
        if (!studentMap.containsKey(rollNo)) {
            throw new StudentNotFoundException("Student with roll no " + rollNo + " not found!");
        }
        return studentMap.get(rollNo);
    }
}
