package com.example


import chandu0101.scalajs.react.components.Implicits._
import chandu0101.scalajs.react.components.materialui.{MuiAppBar, MuiDialog, MuiFlatButton, MuiMuiThemeProvider, MuiRaisedButton, TouchTapEvent}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

import scala.scalajs.js

object Main extends js.JSApp {
  def base(name: String, params: String*): Callback =
    Callback.info(s"Event handler: $name(${params.mkString(", ")})")

  def f1(name: String): js.UndefOr[Callback] = base(name)

  override def main(): Unit = {

    case class State(isOpen: Boolean)

    class Backend($: BackendScope[_, State]) {
      val open = $.setState(State(true))
      val close = $.setState(State(false))

      def handleDialogCancel: TouchTapEvent => Callback =
        e => close >> Callback.info("Cancel Clicked")

      def handleDialogSubmit: TouchTapEvent => Callback =
        e => close >> Callback.info("Submit Clicked")

      val openDialog: TouchTapEvent => Callback =
        e => open >> Callback.info("Opened")

      def render(S: State) = {
        val actions: VdomNode = js
          .Array(
            MuiFlatButton(key = "1",
              label = "Cancel",
              secondary = true,
              onTouchTap = handleDialogCancel)(),
            MuiFlatButton(key = "2",
              label = "Submit",
              secondary = true,
              onTouchTap = handleDialogSubmit)()
          )
          .toVdomArray
        <.div(
          <.div(
            MuiMuiThemeProvider()(
              <.div(
                MuiDialog(
                  title = "Dialog With Actions",
                  actions = actions,
                  open = S.isOpen
                )(
                  "Dialog example with floating buttons"
                ),
                MuiRaisedButton(label = "Dialog", onTouchTap = openDialog)()
              )
            )
          )
        )
      }
    }

    val component = ScalaComponent
      .builder[Unit]("MuiDialogDemo")
      .initialState(State(isOpen = false))
      .renderBackend[Backend]
      .build

    component().renderIntoDOM(dom.document.getElementById("playground"))
  }
}
