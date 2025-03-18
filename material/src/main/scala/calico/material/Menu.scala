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

// Define Menu component
opaque type Menu[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object Menu:
  extension [F[_]](menu: Menu[F])
    def open: Prop[F, Boolean, Boolean] = Prop("open", identity)
    def anchor: Prop[F, String, String] = Prop("anchor", identity)
    def positioning: Prop[F, String, String] = Prop("positioning", identity)
    def quick: Prop[F, Boolean, Boolean] = Prop("quick", identity)
    def hasOverflow: Prop[F, Boolean, Boolean] = Prop("hasOverflow", identity)
    def stayOpenOnOutsideClick: Prop[F, Boolean, Boolean] =
      Prop("stayOpenOnOutsideClick", identity)
    def stayOpenOnFocusout: Prop[F, Boolean, Boolean] = Prop("stayOpenOnFocusout", identity)
    def defaultFocus: Prop[F, String, String] = Prop("defaultFocus", identity)

  @js.native
  @JSImport("@material/web/menu/menu.js")
  private[material] def use: Any = js.native

// Define Menu Item component
opaque type MenuItem[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object MenuItem:
  extension [F[_]](menuItem: MenuItem[F])
    def headline: Prop[F, String, String] = Prop("headline", identity)
    def supportingText: Prop[F, String, String] = Prop("supportingText", identity)
    def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)

  @js.native
  @JSImport("@material/web/menu/menu-item.js")
  private[material] def use: Any = js.native

// Define Material Menu helper functions
private trait MaterialMenu[F[_]](using F: Async[F]):
  lazy val mdMenu: MdTag[F, Menu[F]] =
    val _ = Menu.use
    MdTag("md-menu")

  lazy val mdMenuItem: MdTag[F, MenuItem[F]] =
    val _ = MenuItem.use
    MdTag("md-menu-item")
