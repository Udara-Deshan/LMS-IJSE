package dao.student.Impl;

import dao.CrudOperation;
import dao.student.StudentDAO;
import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) throws Exception {
        String sql = "INSERT INTO student VALUES(?,?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql,
                entity.getStudentId(),
                entity.getStudentName(),
                entity.getEmail(),
                entity.getContact(),
                entity.getAddress(),
                entity.getNic()
        );
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        String sql = "SELECT * FROM student";
        ResultSet rs = CrudOperation.executeQuery(sql);
        return getStudents(rs);
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM student WHERE studentId=?";
        return CrudOperation.executeUpdate(sql, id);    }

    @Override
    public boolean update(Student entity) throws Exception {
        String sql = "UPDATE student SET studentId=?,studentName=?,email=?,contact=?,address =?, nic=? WHERE studentId=?";
        return CrudOperation.executeUpdate(
                sql,
                entity.getStudentId(),
                entity.getStudentName(),
                entity.getEmail(),
                entity.getContact(),
                entity.getAddress(),
                entity.getNic()
        );
    }

    @Override
    public ArrayList<Student> search(Student entity) throws Exception {
        String sql = "SELECT * FROM student WHERE studentId LIKE ?";
        ResultSet rs = CrudOperation.executeQuery(sql, entity.getStudentId());
        return getStudents(rs);
    }

    private ArrayList<Student> getStudents(ResultSet rs) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
            );
            students.add(student);
        }
        return students;
    }
}
