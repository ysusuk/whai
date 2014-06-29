package controllers

import play.api.mvc._
import model.Item
import play.api.libs.json._

/**
 * @author Yura.Susuk yurasusuk@gmail.com.
 */
object Items extends Controller {

  def list = Action {
    Ok(Json.obj())
  }

  def items: List[Item] = List.empty
}
