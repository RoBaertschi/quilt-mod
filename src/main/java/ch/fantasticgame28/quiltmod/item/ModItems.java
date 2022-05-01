package ch.fantasticgame28.quiltmod.item;

import ch.fantasticgame28.quiltmod.QuiltMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {



	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(QuiltMod.MOD_ID, name), item);
	}

	public static void registerModItems() {
		System.out.println("Registering Mod Items for " + QuiltMod.MOD_ID);
	}

}
