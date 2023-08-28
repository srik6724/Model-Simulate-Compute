package dataStructures;

public class Element {
  private String spellName; 
  private int count; 
  private String description; 
  private String pipChance; 
  private String pips; 
  private String school; 
  private String typeSpell; 

  public Element(String spellName, int count, String description, String pipChance, String pips, String school, String typeSpell)
  {
    this.spellName = spellName; 
    this.count = count; 
    this.description = description; 
    this.pipChance = pipChance; 
    this.pips = pips; 
    this.school = school; 
    this.typeSpell = typeSpell;
  }

  public String getSpellName()
  {
    return this.spellName; 
  }

  public int getCount()
  {
    return this.count; 
  }

  public String getDescription()
  {
    return this.description; 
  }

  public String getPipChance()
  {
    return this.pipChance; 
  }

  public String getPips()
  {
    return this.pips; 
  }

  public String getSchool()
  {
    return this.school; 
  }

  public String getTypeSpell()
  {
    return this.typeSpell; 
  }

  public void setSpellName(String spellName)
  {
    this.spellName = spellName; 
  }

  public void setPipChance(String pipChance)
  {
    this.pipChance = pipChance;
  }

  public void setPips(String pips)
  {
    this.pips = pips;
  }

  public void setCount(int count)
  {
    this.count = count; 
  }

  public void setDescription(String description)
  {
    this.description  = description; 
  }

  public void setTypeSpell(String typeSpell)
  {
    this.typeSpell = typeSpell;
  }
}
