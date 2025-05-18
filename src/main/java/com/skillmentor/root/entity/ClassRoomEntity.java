package com.skillmentor.root.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.skillmentor.root.dto.MentorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ClassRoom")
public class ClassRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer objectId;
    @Column(name = "class_room_id")
    private String classRoomId;
    @Column(name = "title")
    private String title;
    @Column(name = "session_fee")
    private Double sessionFee;
    @Column(name = "enrolled_student_count")
    private Integer enrolledStudentCount;
    @OneToMany(mappedBy = "classRoomEntity", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<MentorEntity> mentorEntities = new ArrayList<>();


    public ClassRoomEntity(){};

    public ClassRoomEntity(Integer objectId, String classRoomId, String title, Integer enrolledStudentCount, Double sessionFee, List<MentorEntity> mentorEntity) {
        this.objectId = objectId;
        this.classRoomId = classRoomId;
        this.title = title;
        this.enrolledStudentCount = enrolledStudentCount;
        this.sessionFee = sessionFee;
        this.mentorEntities = mentorEntity;
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

    public List<MentorEntity> getMentorEntities() {
        return mentorEntities;
    }

    public void setMentorEntities(List<MentorEntity> mentorEntities) {
        this.mentorEntities = mentorEntities;
    }
}
