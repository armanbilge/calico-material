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

        // Switch component
        div(
          label(
            "Toggle Feature",
            mdSwitch { s =>
              s.selected := true
              s.icons := true
            },
          ),
        ),

        // Chip components
        div(
          h3("Chips"),
          mdChip { c =>
            c.selected := false
            "Basic"
          },
          mdChip { c =>
            c.selected := true
            "Selected"
          },
          mdChip { c =>
            c.disabled := true
            "Disabled"
          },
        ),

        // Slider component
        div(
          h3("Slider"),
          label(
            "Adjust value:",
            mdSlider { s =>
              s.min := 0
              s.max := 100
              s.value := 40
              s.labeled := true
            },
          ),
        ),

        // Progress indicators
        div(
          h3("Progress Indicators"),
          // Linear progress
          div(
            p("Linear Progress:"),
            mdLinearProgress { p =>
              p.progress := 0.5 // 50% complete
            },
          ),
          // Indeterminate linear progress
          div(
            p("Indeterminate Linear:"),
            mdLinearProgress { p =>
              p.indeterminate := true
            },
          ),
          // Indeterminate circular progress
          div(
            p("Indeterminate Circular:"),
            mdCircularProgress { p =>
              p.indeterminate := true
            },
          ),
        ),

        // Dialog component
        div(
          h3("Dialog Example"),
          // Button to open dialog
          mdFilledButton { b =>
            onClick(e =>
              IO {
                isDialogOpen.update(_ => true)
              },
            )
            "Open Dialog"
          },
          // The dialog component
          mdDialog { d =>
            d.id := "demo-dialog"
            d.open <-- isDialogOpen

            div(
              h2("Dialog Title"),
              p("Dialog content goes here"),
              div(
                mdOutlinedButton { b =>
                  onClick(e =>
                    IO {
                      isDialogOpen.update(_ => false)
                    },
                  )
                  "Close"
                },
              ),
            )
          },
        ),
      )
    }
