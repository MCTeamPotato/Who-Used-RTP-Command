package team.teampotato.whousedrtpcommand;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import static team.teampotato.whousedrtpcommand.WhoUsedRTPCommandMod.loadedConfig;
public class CommandMessage {
    public static void usePlayerCommand(@NotNull messageType type, @NotNull CommandContext<ServerCommandSource> context) {
        String playerName = Objects.requireNonNull(context.getSource().getPlayer()).getName().getString();
        String message = I18n.translate("whousedrtpcommand.used.command."+type);
        context.getSource().sendFeedback(Text.literal(loadedConfig.PlayerNameColor+playerName+loadedConfig.MessageColor+message),true);
        WhoUsedRTPCommandMod.LOGGER.info("{} Send Command",playerName);
    }
    public enum messageType{back,spawn,rtp,teleport_last,tpx}// :3
}
