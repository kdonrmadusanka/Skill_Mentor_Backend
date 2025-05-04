package com.skillmentor.root.DAO.impl;

import com.skillmentor.root.DAO.StudentDAO;
import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    public DatabaseConnection databaseConnection;

    StudentDAOImpl(DatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            final String sql = "INSERT INTO student (first_name, last_name, email, phone_number, address, age) VALUES (?,?,?,?,?,?)";
            connection = databaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentDTO.getFirstName());
            preparedStatement.setString(2, studentDTO.getLastname());
            preparedStatement.setString(3, studentDTO.getEmail());
            preparedStatement.setString(4, studentDTO.getPhoneNumber());
            preparedStatement.setString(5, studentDTO.getAddress());
            preparedStatement.setInt(6, studentDTO.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of();
    }

    @Override
    public List<StudentDTO> getStudentsByAge(Integer age) {
        return List.of();
    }

    @Override
    public Optional<StudentDTO> getStudentById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> updateStudent(String id, StudentDTO studentDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<StudentDTO> deleteStudent(String id) {
        return Optional.empty();
    }
}
