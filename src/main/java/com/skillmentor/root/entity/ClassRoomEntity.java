package com.skillmentor.root.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "classroom")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents a classroom entity in the system")
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_room_id")
    @Schema(description = "Unique ID of the classroom", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer classRoomId;
    @NotNull(message = "Title must not be null")
    @Column(name = "title", nullable = false)
    @Schema(description = "Title of the classroom", example = "Math 101")
    private String title;
    @NotNull(message = "Enrolled student count must not be null")
    @Column(name = "enrolled_student_count", nullable = false)
    @Schema(description = "Number of students enrolled", example = "30")
    private Integer enrolledStudentCount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor_id", referencedColumnName = "mentor_id")
    @Schema(description = "Mentor assigned to this classroom")
    private MentorEntity mentor;
    @OneToMany(mappedBy = "classRoomEntity", fetch = FetchType.EAGER)
    @Schema(description = "List of sessions associated with this classroom")
    @JsonManagedReference
    private List<SessionEntity> sessionEntityList = new ArrayList<>();
}