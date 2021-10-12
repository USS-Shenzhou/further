package cn.ussshenzhou.further.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author USS_Shenzhou
 */
@Mixin(TileEntity.class)
public class MixinTileEntity {

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/tileentity/TileEntity;getMaxRenderDistanceSquared()D", cancellable = true)
    private void getMaxRenderDistanceSquared(CallbackInfoReturnable<Double> callback) {
        callback.setReturnValue(
                (double) (Minecraft.getInstance().gameSettings.entityDistanceScaling * 160)
        );
    }

}
