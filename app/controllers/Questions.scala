package controllers

import play.api._
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.functional.syntax._
import play.api.libs.json._
import scala.concurrent.Future

import reactivemongo.api._

import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.bson.BSONObjectID
import com.google.common.base.Optional

object Questions extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("questions")

  //  def list = Action.async {
  //    collection
  //  }

  implicit val questionWrites: Writes[Question] = (
     (JsPath \ "id" ).write[String] and
      (JsPath \ "text").write[String] and
      (JsPath \ "answer").write[Boolean]
    )(unlift(Question.unapply))

  implicit val questionReads: Reads[Question] = (
    (JsPath \ "_id" \ "$oid" ).read[String] and
      (JsPath \ "text").read[String] and
      (JsPath \ "answer").read[Boolean]
    )(Question.apply _)

  def list = Action.async {
    val cursor: Cursor[Question] = collection.find(Json.obj()).cursor[Question]

    cursor.collect[List]().map(questions => Ok(Json.obj("questions" -> questions)));

//    val json = Json.obj(
//      "questions" -> Json.toJson()
//    )
//    Ok(json)
  }
}

case class Question(id: String, text: String, answer: Boolean)

// case class Question(id: Int, text: String, answer: Boolean)

//object Question {
//  var questions = Set(
//    Question(1, "You are almost never late for your appointments?", false),
//    Question(2, "You like to be engaged in an active and fast-paced job?", false),
//    Question(3, "You enjoy having a wide circle of acquaintances?", true),
//    Question(4, "You feel involved when watching TV soaps?", false),
//    Question(5, "You are usually the first to react to a sudden event, such as the telephone ringing or unexpected question?", false)
//  )
//}