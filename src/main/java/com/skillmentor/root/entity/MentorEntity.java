package com.skillmentor.root.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "Mentor")
public class MentorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer objectId;
    @Column(name = "mentor_id")
    private String mentorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "class_room_id", referencedColumnName = "object_id")
    @JsonBackReference
    private ClassRoomEntity classRoomEntity;

    public MentorEntity(Integer objectId, String mentorId, String firstName, String email, String lastName, String phoneNumber, String address, Integer age) {
        this.objectId = objectId;
        this.mentorId = mentorId;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    public MentorEntity(){};

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ClassRoomEntity getClassRoomEntity() {
        return classRoomEntity;
    }

    public void setClassRoomEntity(ClassRoomEntity classRoomEntity) {
        this.classRoomEntity = classRoomEntity;
    }
}
