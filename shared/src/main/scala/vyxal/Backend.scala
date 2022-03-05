package vyxal

/** Platform-specific stuff that the shared code can't handle. */
trait Backend {
  def print(s: String): Unit
}
