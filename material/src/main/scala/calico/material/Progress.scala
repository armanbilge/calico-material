/*
 * Copyright 2023 Arman Bilge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package calico.material

import calico.html.Prop
import cats.effect.kernel.Async
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

opaque type LinearProgress[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

object LinearProgress:
  extension [F[_]](progress: LinearProgress[F])
    def progress: Prop[F, Double, Double] = Prop("progress", identity)
    def indeterminate: Prop[F, Boolean, Boolean] = Prop("indeterminate", identity)
    def buffer: Prop[F, Double, Double] = Prop("buffer", identity)

  @js.native
  @JSImport("@material/web/progress/linear-progress.js")
  private[material] def use: Any = js.native

opaque type CircularProgress[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

object CircularProgress:
  extension [F[_]](progress: CircularProgress[F])
    def progress: Prop[F, Double, Double] = Prop("progress", identity)
    def indeterminate: Prop[F, Boolean, Boolean] = Prop("indeterminate", identity)

  @js.native
  @JSImport("@material/web/progress/circular-progress.js")
  private[material] def use: Any = js.native

private trait MaterialProgress[F[_]](using F: Async[F]):
  lazy val mdLinearProgress: MdTag[F, LinearProgress[F]] =
    val _ = LinearProgress.use
    MdTag("md-linear-progress")

  lazy val mdCircularProgress: MdTag[F, CircularProgress[F]] =
    val _ = CircularProgress.use
    MdTag("md-circular-progress")
