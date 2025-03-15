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
import fs2.dom.HtmlElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

opaque type TextField[F[_]] <: HtmlElement[F] = HtmlElement[F]

object TextField:
  extension [F[_]](textfield: TextField[F])
    def value: Prop[F, String, String] = Prop("value", identity)
    def label: Prop[F, String, String] = Prop("label", identity)

  @js.native
  @JSImport("@material/web/textfield/filled-text-field.js", JSImport.Namespace)
  private[material] object MaterialTextFieldJS extends js.Object

  def mdTextField[F[_]: Async]: MdTag[F, TextField[F]] =
    val _ = MaterialTextFieldJS
    MdTag("md-filled-text-field")
