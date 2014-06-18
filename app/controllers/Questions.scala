package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object Questions extends Controller {

  implicit val questionWrites: Writes[Question] = (
      (JsPath \ "id").write[Int] and
      (JsPath \ "text").write[String] and
      (JsPath \ "answer").write[Boolean]
    )(unlift(Question.unapply))

  def list = Action {
    val json = Json.toJson(Question.questions)
    Ok(json)
  }
}

case class Question(id: Int, text: String, answer: Boolean)

object Question {
  var questions = Set(
    Question(1, "You are almost never late for your appointments?", false),
    Question(2, "You like to be engaged in an active and fast-paced job?", false),
    Question(3, "You enjoy having a wide circle of acquaintances?", false),
    Question(4, "You feel involved when watching TV soaps?", false),
    Question(5, "You are usually the first to react to a sudden event, such as the telephone ringing or unexpected question?", false)
  )
}