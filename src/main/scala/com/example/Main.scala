package com.example


import chandu0101.scalajs.react.components.Implicits._
import chandu0101.scalajs.react.components.materialui.MuiAppBar
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

import scala.scalajs.js

object Main extends js.JSApp {
  def base(name: String, params: String*): Callback =
    Callback.info(s"Event handler: $name(${params.mkString(", ")})")

  def f1(name: String): js.UndefOr[Callback] = base(name)

  override def main(): Unit = {
    val component = ScalaComponent.builder[Unit]("MuiAppBarDemo")
      .render(P =>
        <.div(
            MuiAppBar (
            title = "Title",
            showMenuIconButton = true
            ) ()
        )
      ).build

    component().renderIntoDOM(dom.document.getElementById("playground"))
  }
}
