package bo.student.Impl;

import bo.student.StudentBO;
import dao.DAOFactory;
import dao.student.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class StudentBOImpl implements StudentBO {

    private StudentDAO studentDAO;

    public StudentBOImpl() {
        studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOType.STUDENT);
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(makeStudent(studentDTO));
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<Student> students = studentDAO.getAll();
        ArrayList<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student c : students) {
            studentDTOs.add(makeStudentDTO(c));
        }
        return studentDTOs;
    }

    private Student makeStudent(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getEmail(),
                studentDTO.getContact(),
                studentDTO.getAddress(),
                studentDTO.getNic()
        );
        return student;
    }

    private StudentDTO makeStudentDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getEmail(),
                student.getContact(),
                student.getAddress(),
                student.getNic()
        );

    }

    @Override
    public ArrayList<StudentDTO> searchStudent(StudentDTO studentDTO) throws Exception {
        ArrayList<Student> students = studentDAO.search(makeStudent(studentDTO));
        ArrayList<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student c : students) {
            studentDTOs.add(makeStudentDTO(c));
        }
        return studentDTOs;
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(makeStudent(studentDTO));
    }
}
