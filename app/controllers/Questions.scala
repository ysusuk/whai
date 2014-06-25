package controllers

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.functional.syntax._
import play.api.libs.json._
import play.api.mvc._
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api._

case class Question(id: String, text: String, answer: Boolean)

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
  }
}

