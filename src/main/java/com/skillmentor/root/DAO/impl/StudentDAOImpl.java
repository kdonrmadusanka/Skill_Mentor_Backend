package com.skillmentor.root.DAO.impl;

import com.skillmentor.root.DAO.StudentDAO;
import com.skillmentor.root.dto.StudentDTO;
import com.skillmentor.root.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            final String sql = "INSERT INTO student (student_id ,first_name, last_name, email, phone_number, address, age) VALUES (?,?,?,?,?,?,?)";
            connection = databaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,studentDTO.getStudentId());
            preparedStatement.setString(2, studentDTO.getFirstName());
            preparedStatement.setString(3, studentDTO.getLastname());
            preparedStatement.setString(4, studentDTO.getEmail());
            preparedStatement.setString(5, studentDTO.getPhoneNumber());
            preparedStatement.setString(6, studentDTO.getAddress());
            preparedStatement.setInt(7, studentDTO.getAge());
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
        final List<StudentDTO> studentDTOS = new ArrayList<>();

        final String sql = "SELECT * FROM student";
        try(
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery(sql);
            ) {
            while(resultSet.next()) {
                final StudentDTO studentDTO = new StudentDTO(
                        resultSet.getString("student_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getInt("age")
                );
                studentDTOS.add(studentDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return studentDTOS;

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
