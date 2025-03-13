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

opaque type Slider[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

object Slider:
  extension [F[_]](slider: Slider[F])
    def value: Prop[F, Int, Int] = Prop("value", identity)
    def min: Prop[F, Int, Int] = Prop("min", identity)
    def max: Prop[F, Int, Int] = Prop("max", identity)
    def step: Prop[F, Int, Int] = Prop("step", identity)
    def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)
    def labeled: Prop[F, Boolean, Boolean] = Prop("labeled", identity)

  @js.native
  @JSImport("@material/web/slider/slider.js")
  private[material] def use: Any = js.native

private trait MaterialSlider[F[_]](using F: Async[F]):
  lazy val mdSlider: MdTag[F, Slider[F]] =
    val _ = Slider.use
    MdTag("md-slider")
