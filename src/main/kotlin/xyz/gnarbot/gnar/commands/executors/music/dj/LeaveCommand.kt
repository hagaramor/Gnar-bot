package xyz.gnarbot.gnar.commands.executors.music.dj

import com.google.inject.Inject
import net.dv8tion.jda.core.entities.Guild
import xyz.gnarbot.gnar.commands.executors.music.parent.MusicExecutor
import xyz.gnarbot.gnar.commands.handlers.Command
import xyz.gnarbot.gnar.members.BotPermission
import xyz.gnarbot.gnar.utils.Note

@Command(aliases = arrayOf("leave"), botPermission = BotPermission.DJ, inject = true)
class LeaveCommand : MusicExecutor() {
    @Inject lateinit var guild: Guild

    override fun execute(note: Note, args: List<String>) {
        guild.audioManager.sendingHandler = null
        guild.audioManager.closeAudioConnection()
    }
}
