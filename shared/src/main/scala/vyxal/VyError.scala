package vyxal

/** An error caused by passing arguments of the wrong type
  */
class VyOverloadError(msg: String) extends RuntimeException(msg)
