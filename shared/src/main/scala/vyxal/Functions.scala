package vyxal

//These represent normal Scala functions, not functions operating on the stack
type Monad = VAny => Context ?=> VAny
type Dyad = (VAny, VAny) => Context ?=> VAny
type Triad = (VAny, VAny, VAny) => Context ?=> VAny
//These are the same as Monad, Dyad, and Triad, except they don't work on lists
type SimpleMonad = VAtom => Context ?=> VAny
type SimpleDyad = (VAtom, VAtom) => Context ?=> VAny
type SimpleTriad = (VAtom, VAtom, VAtom) => Context ?=> VAny

extension (f: Monad)
  /** Turn the monad into a normal function of type `VAny => VAny`
    */
  def norm(using ctx: Context): VAny => VAny = f(_)(using ctx)
extension (f: Dyad)
  /** Turn the dyad into a normal function of type `(VAny, VAny) => VAny`
    */
  def norm(using ctx: Context): (VAny, VAny) => VAny =
    f(_, _)(using ctx)
extension (f: Triad)
  /** Turn the triad into a normal function of type `(VAny, VAny, VAny) => VAny`
    */
  def norm(using ctx: Context): (VAny, VAny, VAny) => VAny =
    f(_, _, _)(using ctx)

extension (f: SimpleMonad)
  def vectorised: Monad = {
    lazy val res: Monad = {
      case VAtom(lhs) => f(lhs)
      case lst: VList => lst.vmap(res)
    }
    res
  }
extension (f: SimpleDyad)
  def vectorised: Dyad = {
    lazy val res: Dyad = {
      case (VAtom(lhs), VAtom(rhs)) =>f(lhs, rhs)
      case (VAtom(lhs), rhs: VList) =>rhs.vmap(res(lhs, _))
      case (lhs: VList, VAtom(rhs)) =>lhs.vmap(res(_, rhs))
      case (lhs: VList, rhs: VList) =>lhs.zipWith(rhs)(res(_, _))
    }
    res
  }
extension (f: SimpleTriad) def vectorised: Triad = ???
