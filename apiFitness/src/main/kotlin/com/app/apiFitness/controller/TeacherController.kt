package com.app.apiFitness.controller

import com.app.apiFitness.controller.dto.request.TeacherProfileRequestDTO
import com.app.apiFitness.controller.dto.request.UserProfileRequestDTO
import com.app.apiFitness.controller.dto.response.StandardResponseDTO
import com.app.apiFitness.service.TeacherProfileService
import com.app.apiFitness.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URI

@Controller
@RequestMapping("/createTeacher")
class TeacherController @Autowired constructor(private val teacherProfileService: TeacherProfileService) {

    @PostMapping(value = ["/createTeacher"])
    fun createTeacherProfile(@RequestBody teacherProfileRequestDTO: TeacherProfileRequestDTO): ResponseEntity<StandardResponseDTO> {
        try {
            teacherProfileService.create(teacherProfileRequestDTO)
        } catch (ex : Exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(StandardResponseDTO(1, "500"))
        }
        return ResponseEntity.created(URI("")).body(StandardResponseDTO(0,"200"))
    }

}