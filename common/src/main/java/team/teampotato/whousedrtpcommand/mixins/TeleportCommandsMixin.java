package team.teampotato.whousedrtpcommand.mixins;

import com.mojang.brigadier.context.CommandContext;
import dev.ftb.mods.ftbessentials.command.TeleportCommands;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.teampotato.whousedrtpcommand.CommandMessage;

import static team.teampotato.whousedrtpcommand.WhoUsedRTPCommandMod.loadedConfig;

@Mixin(TeleportCommands.class)
public abstract class TeleportCommandsMixin {



    @Inject(method = "lambda$register$0",at=@At("HEAD"))
    private static void onRegisterBack(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Integer> cir) {
        if(loadedConfig.SendBackMessage) CommandMessage.usePlayerCommand(CommandMessage.messageType.back,context);
    }
    @Inject(method = "lambda$register$1",at=@At("HEAD"))
    private static void onRegisterSpawn(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Integer> cir) {
        if(loadedConfig.SendSpawnMessage) CommandMessage.usePlayerCommand(CommandMessage.messageType.spawn,context);
    }
    @Inject(method = "lambda$register$2",at=@At("HEAD"))
    private static void onRegisterRTP(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Integer> cir) {
        if(loadedConfig.SendRTPMessages) CommandMessage.usePlayerCommand(CommandMessage.messageType.rtp,context);
    }
    @Inject(method = "lambda$register$3",at=@At("HEAD"))
    private static void onRegisterTPL(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Integer> cir) {
        if(loadedConfig.SendTPLMessage) CommandMessage.usePlayerCommand(CommandMessage.messageType.teleport_last,context);
    }
    @Inject(method = "lambda$register$4",at=@At("HEAD"))
    private static void onRegisterTPX(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Integer> cir) {
        if(loadedConfig.SendTPXMessage)CommandMessage.usePlayerCommand(CommandMessage.messageType.tpx,context);
    }
}
