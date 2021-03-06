package civ.core.unit;

import static civ.core.instance.IData.*;
import civ.core.data.hex.HexCoordinate;
import civ.core.data.utils.GFXUtils;
import civ.core.display.menu.UnitMenu;
import civ.core.display.menu.button.UnitMenuButton;
import civ.core.event.Events;
import civ.core.map.civilization.BaseCivilization;

public class Settler extends Unit {
  
  public Settler() {
    super("Settler", null, null, GFXUtils.loadImage("./gfx/units/SETTLER_WHITE.png"), 2.0D, 0.0D,
        106, false, false);
  }
  
  public Settler(BaseCivilization civOwner, HexCoordinate curPos, boolean isSpawned) {
    super("Settler", civOwner, curPos,
        GFXUtils.loadImage(
            "./gfx/units/SETTLER_" + GFXUtils.getViewableColour(civOwner.getColour()) + ".png"),
        2.0D, 0.0D, 106, false, isSpawned);
    
    int b = 0;
    actionMenu = new UnitMenu(false);
    actionMenu.addButton(new UnitMenuButton(Events.FOUND_CITY, b++));
    actionMenu.addButton(new UnitMenuButton(Events.MOVE, b++));
    actionMenu.addButton(new UnitMenuButton(Events.DO_NOTHING, b++));
    actionMenu.addButton(new UnitMenuButton(Events.AUTO_EXPLORE, b));
  }

  public void foundCity() {
    if (civs.get(0).createCity(curPos)) {
      currentUnit.deleteFromMapAndCiv();
      ui.resetFocusData();
    }
  }
}
