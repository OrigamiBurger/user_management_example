package org.usermanagement.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.usermanagement.repositories.UserRepository
import org.usermanagement.entity.Users
import java.util.List
import java.lang.Iterable

@Service
class UserService(@Autowired private val userRepository: UserRepository) {

  // @PreAuthorize("hasRole('admin')")
  def listUsers(): Iterable[Users] = {
    userRepository.findAll
  }

  // @PreAuthorize("hasRole('user')")
  // @PostAuthorize("returnObject.username==principal.username || hasRole('admin')")
  def getUser(id: Long): java.util.Optional[Users] = {
    userRepository.findById(id)
  }

  // @PreAuthorize("hasRole('admin')")
  def createUser(users: Users): Long = {
    userRepository.save(users)
    users.id
  }

}
