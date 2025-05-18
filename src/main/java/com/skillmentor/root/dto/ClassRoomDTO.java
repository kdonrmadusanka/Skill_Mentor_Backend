package com.skillmentor.root.dto;

import java.util.List;

public class ClassRoomDTO {

    private Integer objectId;
    private String classRoomId;
    private String title;
    private Double sessionFee;
    private Integer enrolledStudentCount;
    private List<MentorDTO> mentorDTO;

    public ClassRoomDTO(){};

    public ClassRoomDTO(Integer objectId, String classRoomId, String title, Integer enrolledStudentCount, Double sessionFee, List<MentorDTO> mentorDTO) {
        this.objectId = objectId;
        this.classRoomId = classRoomId;
        this.title = title;
        this.enrolledStudentCount = enrolledStudentCount;
        this.sessionFee = sessionFee;
        this.mentorDTO = mentorDTO;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSessionFee() {
        return sessionFee;
    }

    public void setSessionFee(Double sessionFee) {
        this.sessionFee = sessionFee;
    }

    public Integer getEnrolledStudentCount() {
        return enrolledStudentCount;
    }

    public void setEnrolledStudentCount(Integer enrolledStudentCount) {
        this.enrolledStudentCount = enrolledStudentCount;
    }

    public List<MentorDTO> getMentorDTO() {
        return mentorDTO;
    }

    public void setMentorDTO(List<MentorDTO> mentorDTO) {
        this.mentorDTO = mentorDTO;
    }
}
