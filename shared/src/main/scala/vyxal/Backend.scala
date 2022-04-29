package vyxal

/** Platform-specific stuff that the shared code can't handle. */
trait Backend {
  def print(s: String): Unit = Predef.print(s)

  /** Log an error */
  def err(s: String): Unit = this.print(s)

  /** Log a warning */
  def warn(s: String): Unit = this.print(s)
}
