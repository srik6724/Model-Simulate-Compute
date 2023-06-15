package ItemCards;

public class ItemCard {
  
  private String nameOfCard; 
  private String description; 
  private int number; 

  public ItemCard(String nameOfCard, String description, int number)
  {
    this.nameOfCard = nameOfCard; 
    this.description = description; 
    this.number = number; 
  }

  public String getNameOfCard()
  {
    return nameOfCard; 
  }

  public String getDescription()
  {
    return description; 
  }

  public int getNumber()
  {
    return number; 
  }
}
