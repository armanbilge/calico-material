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

import calico.material.Slider
import calico.html.io.{*, given}
import calico.material.io.{*, given}

object Demo extends IOWebApp:
  def render = div(
    label(
      "Material 3",
      mdCheckbox { cb =>
        cb.checked := true
      },
    ),
    mdOutlinedButton { b =>
      "Back"
    },
    mdFilledButton { b =>
      "Next"
    },
    label(
      "Volume Control",
      Slider.mdSlider { s =>
        s.min := 0
        s.max := 100
        s.value := 50
      },
    ),
    label(
      "Enter Text",
      TextField.mdTextField { tf =>
        tf.value := "Hello, World!"
      },
    ),
    label(
      "Enable Feature",
      Switch.mdSwitch { sw =>
        sw.checked := false
      },
    ),
  )
