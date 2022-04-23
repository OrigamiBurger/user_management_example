package org.usermanagement.repositories

import org.springframework.stereotype.Repository
import org.usermanagement.entity.Users
import org.springframework.data.repository.CrudRepository
import java.lang.Long
import java.lang.Iterable
import scala.jdk.OptionConverters._

@Repository
trait UserRepository extends CrudRepository[Users, Long] {

  def findUserByUsername(username: String): Users
  def findAll(): Iterable[Users]
  def findById(id: Long): java.util.Optional[Users]
  def findByIdScala(id: Long): Option[Users] = {
      findById(id).toScala
  }

}
