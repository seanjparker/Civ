package civ.core.map.cities;

import static civ.core.instance.IData.HEX_RADIUS;
import static civ.core.instance.IData.TEXT_SIZE;
import static civ.core.instance.IData.layout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import civ.core.data.Point;
import civ.core.data.hex.HexCoordinate;
import civ.core.data.map.HexMap;
import civ.core.data.utils.GFXUtils;

public class City {
  private static final int FOOD_INITIAL = 1;
  private static final int GOLD_INITIAL = 3;
  private static final int PROD_INITIAL = 1;
  private static final int SCIE_INITIAL = 4;
  private static final int CULT_INITIAL = 1;
  private static final int STRG_INITIAL = 8;
  private static final int POPU_INITIAL = 1;
  
  private static final int INITIAL_CITY_AREA = 1;


  private String cityName;
  private HexCoordinate cityPos;
  private int cityPopulation;
  private int cityFood;
  private int cityGold;
  private int cityProduction;
  private int cityScience;
  private int cityCulture;
  private int cityStrength;
  
  private List<HexCoordinate> cityHexes;
  
  private static final BufferedImage SHIELD;
  private static final BufferedImage POPULATION;
  
  static {
    SHIELD = GFXUtils.loadImage("./gfx/icons/SHIELD.png");
    POPULATION = GFXUtils.loadImage("./gfx/icons/POPULATION.png");
  }

  public City(String cityName, HexCoordinate cityPos) {
    this.cityName = cityName;
    this.cityPos = cityPos;
    
    this.cityPopulation = POPU_INITIAL;
    this.cityFood = FOOD_INITIAL;
    this.cityGold = GOLD_INITIAL;
    this.cityProduction = PROD_INITIAL;
    this.cityScience = SCIE_INITIAL;
    this.cityCulture = CULT_INITIAL;
    this.cityStrength = STRG_INITIAL;
    
    //Get all the hexes with the range of this hex
    this.cityHexes = HexMap.getAllInRange(cityPos, INITIAL_CITY_AREA);
    //Remove the city hex from the List
    this.cityHexes.remove(cityPos);
  }

  public void draw(Graphics2D g, Color cityColour, int scrollX, int scrollY) {
    Point pos = layout.hexToPixel(cityPos);

    int xCentre = (int) (pos.x + scrollX);
    int yCentre = (int) (pos.y + scrollY) - (HEX_RADIUS / 2);
    
    //Set up the font for text and calculate width of city name box
    int nameWidth = g.getFontMetrics().stringWidth(cityName);
    int nameHeight = g.getFontMetrics().getHeight();
    int cityNameCentreOffset = nameWidth >> 1;
    int textHeightOffset = nameHeight * 4 / 3;
    
    //Draw the city name box
    g.setColor(new Color(cityColour.getRed(), cityColour.getGreen(), cityColour.getBlue(), 180));
    g.fillRoundRect(xCentre - (nameWidth / 2), yCentre, nameWidth, textHeightOffset, 5, 5);
    g.setColor(cityColour);
    g.drawRoundRect(xCentre - (nameWidth / 2), yCentre, nameWidth + 1, textHeightOffset + 1, 5, 5);
    
    //Write the city name in the box
    g.setColor(GFXUtils.getColourForReadableText(cityColour));
    g.drawString(cityName, xCentre - cityNameCentreOffset, yCentre + nameHeight);
    
    //Draw the shield icon
    int width = HEX_RADIUS / 2;
    int height = (int) (width * 1.2); //Maintain the image 1:1.2 w:h ratio
    g.drawImage(SHIELD, xCentre - (3 * width / 2), yCentre + height, width, height, null);
    
    //Next draw the city strength value 
    g.setFont(new Font("SansSerif", Font.BOLD, HEX_RADIUS / 3));
    g.drawString(Integer.toString(this.cityStrength), xCentre - (HEX_RADIUS / 3) - (width / 2), yCentre + height + textHeightOffset);
    
    //Draw the city population icon
    g.drawImage(POPULATION, xCentre + (width / 2), yCentre + height, width, width, null);
    
    //Draw the city population number
    int populationWidth = g.getFontMetrics().stringWidth(Integer.toString(this.cityPopulation));
    //g.setColor(ui.getColourForReadableText(hexMap.getHex(cityPos).getLandscape().getColour()));
    g.setColor(Color.WHITE);
    g.drawString(Integer.toString(this.cityPopulation), xCentre + width - (populationWidth / 2), yCentre + height + textHeightOffset);
    
    
    g.setFont(new Font("SansSerif", Font.BOLD, TEXT_SIZE));
  }

  public int getPopulation() {
    return cityPopulation;
  }

  public int getFood() {
    return cityFood;
  }

  public int getGold() {
    return cityGold;
  }

  public int getProduction() {
    return cityProduction;
  }

  public int getScience() {
    return cityScience;
  }

  public int getCulture() {
    return cityCulture;
  }
  
  public int getStrength() {
    return cityStrength;
  }

  public List<HexCoordinate> getCityHexes() {
    return this.cityHexes;
  }
  
  public HexCoordinate getCityPosition() {
    return this.cityPos;
  }
  
  public BufferedImage getPopulationImage() {
    return POPULATION;
  }

}
