package bo.student;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.ArrayList;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public interface StudentBO extends SuperBO {

    public boolean addStudent(StudentDTO studentDTO) throws Exception;

    public ArrayList<StudentDTO> getAllStudents() throws Exception;

    public ArrayList<StudentDTO> searchStudent(StudentDTO studentDTO) throws Exception;

    public boolean deleteStudent(String studentId) throws Exception;

    public boolean updateStudent(StudentDTO studentDTO) throws Exception;

}
