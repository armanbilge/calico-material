package calico.material

import calico.html.Prop
import cats.effect.kernel.Async
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

opaque type Switch[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

object Switch:
  extension [F[_]](switch: Switch[F])
    def checked: Prop[F, Boolean, Boolean] = Prop("checked", identity)
    def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)

  @js.native
  @JSImport("@material/web/switch/switch.js")
  private[material] def use: Any = js.native

private trait MaterialSwitch[F[_]](using F: Async[F]):
  lazy val mdSwitch: MdTag[F, Switch[F]] =
    val _ = Switch.use
    MdTag("md-switch")
