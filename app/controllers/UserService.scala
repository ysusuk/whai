package controllers

import play.api.Application
import securesocial.core.{Identity, IdentityId, UserServicePlugin}
import securesocial.core.providers.Token

class UserService(application: play.api.Application) extends UserServicePlugin(application) {
  var users: Map[IdentityId, Identity] = Map.empty

  override def find(id: IdentityId): Option[Identity] = users get id

  override def findByEmailAndProvider(email: String, providerId: String): Option[Identity] = None

  override def deleteToken(uuid: String): Unit = Unit

  override def save(user: Identity): Identity = {
    users = users + (user.identityId -> user)
    user
  }

  override def save(token: Token): Unit = Unit

  override def findToken(token: String): Option[Token] = None

  override def deleteExpiredTokens(): Unit = Unit
}
