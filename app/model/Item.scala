package model

/**
 * @author Yura.Susuk yurasusuk@gmail.com.
 */
public class Item(price: Float)

case class TShirt(price: Float, size: String, color: String) extends Item(price)
case class Mug(price: Float, size: String) extends Item(price)
case class Trinket(price: Float, size: String) extends Item(price)
