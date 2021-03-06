package net.badlion.shinyinventory.gui;

import net.badlion.shinyinventory.gui.buttons.Button;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShinyDialga45 on 3/28/2015.
 */
public class InterfaceManager {

    private static List<Interface> inventories = new ArrayList<>();

    public static void registerInventory(Interface gui) {
        inventories.add(gui);
    }

    public static void unregisterInventories() {
        inventories.clear();
    }

    public static Interface getInterface(InventoryView inventory) {
        if (inventory.getTopInventory().getHolder() instanceof SimpleInterfaceHolder) {
            SimpleInterfaceHolder holder = (SimpleInterfaceHolder)inventory.getTopInventory().getHolder();
            return holder.getInterface();
        }
        return null;
    }

    public static Interface getInterface(InventoryHolder holder) {
        if (holder instanceof SimpleInterfaceHolder) {
            SimpleInterfaceHolder interfaceHolder = (SimpleInterfaceHolder)holder;
            return interfaceHolder.getInterface();
        }
        return null;
    }

    public static Interface getInterface(Inventory inventory) {
        for (Interface gui : inventories) {
            if (gui.getInventory().equals(inventory)) {
                return gui;
            }
        }
        return null;
    }

    public static List<Button> getButtons(Interface gui, int slot) {
        List<Button> buttons = new ArrayList<>();
        for (Button button : gui.getButtons()) {
            if (button.getSlot() == slot) {
                buttons.add(button);
            }
        }
        return buttons;
    }

    public static Button getButton(Interface gui, ItemStack itemStack) {
        for (Button button : gui.getButtons()) {
            if (button.getIcon().create().equals(itemStack)) {
                return button;
            }
        }
        return null;
    }

}
