package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MentorDTO {

    private Integer objectId;
    private String mentorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Integer age;
    @JsonIgnore
    private ClassRoomDTO classRoomDTO;
    @JsonIgnore
    private Integer classRoomId;

    public MentorDTO(Integer objectId, String firstName, String mentorId, String lastName, String email, String phoneNumber, Integer age, String address, ClassRoomDTO classRoomDTO, Integer classRoomId) {
        this.objectId = objectId;
        this.firstName = firstName;
        this.mentorId = mentorId;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
        this.classRoomDTO = classRoomDTO;
        this.classRoomId = classRoomId;
    }

    public MentorDTO(){};

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ClassRoomDTO getClassRoomDTO() {
        return classRoomDTO;
    }

    public void setClassRoomDTO(ClassRoomDTO classRoomDTO) {
        this.classRoomDTO = classRoomDTO;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }
}
