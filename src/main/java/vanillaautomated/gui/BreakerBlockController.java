package vanillaautomated.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import vanillaautomated.VanillaAutomated;
import vanillaautomated.VanillaAutomatedBlocks;

public class BreakerBlockController extends SyncedGuiDescription {
    public BreakerBlockController(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(VanillaAutomatedBlocks.breakerBlockScreen, syncId, playerInventory, getBlockInventory(context, 4), getBlockPropertyDelegate(context, 4));

        setTitleAlignment(HorizontalAlignment.LEFT);
        WPlainPanel root = new WPlainPanel();
        root.setSize(176, 170);
        setRootPanel(root);

        WGridPanel machinePanel = new WGridPanel();
        machinePanel.setSize(9, 3);

        WBar fire = new WBar(VanillaAutomated.flames_background, VanillaAutomated.flames, 0, 2, WBar.Direction.UP);
        machinePanel.add(fire, 3, 1);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        machinePanel.add(itemSlot, 3, 0);

        WSprite toolOverlay = new WSprite(VanillaAutomated.tool_slot);
        machinePanel.add(toolOverlay, 3, 0);

        WItemSlot fuelSlot = WItemSlot.of(blockInventory, 1);
        machinePanel.add(fuelSlot, 3, 2);

        WBar progress = new WBar(VanillaAutomated.progress_background, VanillaAutomated.progress, 1, 3, WBar.Direction.RIGHT);
        machinePanel.add(progress, 5, 1);

        root.add(machinePanel, 0, 20);

        root.add(this.createPlayerInventoryPanel(true), 7, 76);
        root.validate(this);
    }
}
