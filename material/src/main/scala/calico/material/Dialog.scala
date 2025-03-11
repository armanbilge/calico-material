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

opaque type Dialog[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

// Check that this is implemented correctly
object Dialog:
  extension [F[_]](dialog: Dialog[F])
    def open: Prop[F, Boolean, Boolean] = Prop("open", identity)
    def fullscreen: Prop[F, Boolean, Boolean] = Prop("fullscreen", identity)
    def stacked: Prop[F, Boolean, Boolean] = Prop("stacked", identity)
    def defaultAction: Prop[F, String, String] = Prop("default-action", identity)
    def escapeKeyAction: Prop[F, String, String] = Prop("escape-key-action", identity)
    def scrimClickAction: Prop[F, String, String] = Prop("scrim-click-action", identity)
    def returnValue: Prop[F, String, String] = Prop("returnValue", identity)
    def id: Prop[F, String, String] = Prop("id", identity) // Add this line

  @js.native
  @JSImport("@material/web/dialog/dialog.js")
  private[material] def use: Any = js.native

private trait MaterialDialog[F[_]](using F: Async[F]):
  lazy val mdDialog: MdTag[F, Dialog[F]] =
    val _ = Dialog.use
    MdTag("md-dialog")
