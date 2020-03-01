package com.app.apiFitness.repository.entity

import lombok.*
import javax.persistence.*

@Entity
@Table(name = "teacher")
data class TeacherEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column(name = "CREF")
    var CREF: String? = null,
    @Column(name = "user_id", nullable = false)
    var userId: Int? = null,
    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    var refUserEntity: UserEntity? = null,
    @OneToMany(mappedBy = "refTeacherEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null,
    @OneToMany(mappedBy = "refTeacherEntity", fetch = FetchType.LAZY, cascade = [(CascadeType.ALL)])
    var refTrainingSheetEntities: List<TrainingSheetEntity>? = null
)