package org.usermanagement

import java.lang.Iterable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{ GetMapping, PostMapping, RequestMapping, RestController }
import org.usermanagement.entity.Users
import org.usermanagement.services.UserService
import javax.sql.DataSource
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.slf4j.LoggerFactory

@RestController
@RequestMapping(path = Array("/api"))
class UserController(@Autowired userService: UserService, @Autowired datasource: DataSource) {

  val logger = LoggerFactory.getLogger(getClass)

  @GetMapping(value = Array("/users"))
  def getAllUsers(): Iterable[Users] = {
    userService.listUsers
  }

  @GetMapping(path = Array("/users/{id}"))
  def getUser(@PathVariable id: Long): java.util.Optional[Users] = {
    userService.getUser(id)
  }

  @PostMapping(path = Array("/users"))
  def createUser(@RequestBody users: Users): ResponseEntity[Long] = {
    val id = userService.createUser(users)
    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }

}
