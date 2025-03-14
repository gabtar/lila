package views.mod

import lila.app.UiEnv.{ *, given }
import lila.mod.ui.*

lazy val ui         = ModUi(helpers)
lazy val userTable  = ModUserTableUi(helpers, ui)
lazy val user       = ModUserUi(helpers, ui)
lazy val gamify     = GamifyUi(helpers, ui)
lazy val publicChat = PublicChatUi(helpers, ui)(lila.shutup.Analyser.highlightBad)
lazy val commUi     = ModCommUi(helpers)(lila.shutup.Analyser.highlightBad)

val timeline = lila.api.ui.ModTimelineUi(helpers)(publicLineSource = publicLineSource)

def permissions(u: User)(using Context, Me) =
  ui.permissions(u, lila.security.Permission.categorized)
