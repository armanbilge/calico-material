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

package calico
package material

import calico.html.io.{*, given}
import calico.material.io.{*, given}
import fs2.concurrent.SignallingRef
import cats.effect.IO
import cats.effect.Resource
import scala.scalajs.js
import org.scalajs.dom

object Demo extends IOWebApp:
  def render =
    Resource.eval(SignallingRef[IO].of(false)).flatMap { isDialogOpen =>
      div(
        // Checkbox component
        label(
          "Material 3",
          mdCheckbox { cb =>
            cb.checked := true
          },
        ),

        // Button components
        div(
          mdOutlinedButton { b =>
            "Back"
          },
          mdFilledButton { b =>
            "Next"
          },
        ),

        // Icon Button component
        div(
          h3("Icon Button"),
          mdIconButton { b =>
            b.ariaLabel := "Favorite"
            "❤️"
          },
        ),

        // TextArea component
        div(
          h3("Text Area"),
          mdTextArea { t =>
            t.label := "Enter your text here"
            t.required := true
            t.value := "Default text"
          },
        ),
      )
    }
