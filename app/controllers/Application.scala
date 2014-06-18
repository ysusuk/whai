package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object Application extends Controller {

  implicit val questionWrite: Writes[Question] = (
      (JsPath \ "id").write[Int] and
      (JsPath \ "text").write[String] and
      (JsPath \ "answer").write[Boolean]
    )(unlift(Question.unapply))


  val questions: List[Question] = List(Question(1, "You are almost never late for your appointments?", false))

  def questions = Action {
    val json = Json.toJson()
    Ok(json)
  }
}

case class Question(id: Int, text: String, answer: Boolean)