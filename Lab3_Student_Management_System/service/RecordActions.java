package service;

import model.Student;
import exception.StudentNotFoundException;

public interface RecordActions {
    void addStudent(Student s);
    Student searchStudent(Integer rollNo) throws StudentNotFoundException;
}
