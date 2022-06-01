package vyxal

import spire.math.Number

/** Settings that you can configure with flags
  * @param defaultValue
  *   The default value if popping off an empty stack or accessing an undefined
  *   variable.
  * @param numToList
  *   The function used to convert numbers to lists
  */
case class Settings(
    defaultValue: VAny = 0.vnum,
    numToList: VNum => VList = n => Helpers.range(0.vnum, n)
)
