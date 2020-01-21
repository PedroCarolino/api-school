package com.app.apiFitness.database.repository.entity

import javax.persistence.*

@Entity
@Table(name = "appointment", schema = "db_apifitness", catalog = "")
open class AppointmentEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "data", nullable = true)
    var data: java.sql.Timestamp? = null
    @get:Basic
    @get:Column(name = "teacher_has_student_teacher_id", nullable = false, insertable = false, updatable = false)
    var teacherHasStudentTeacherId: Int? = null

    @get:OneToMany(mappedBy = "refAppointmentEntity")
    var refTeacherHasStudentEntities: List<TeacherHasStudentEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "data = $data " +
                    "teacherHasStudentTeacherId = $teacherHasStudentTeacherId " +
                    ")"
    
}
