package SchoolSpells;

public class Spell {
	
	private String name; 
	private String level; 
	private String description; 
	private String pip_chance; 
	private String pips; 
	private int count; 
	private String type_Spell; 
	
	public Spell(String name, String level, String description, String pip_chance, String pips, int count, String type_Spell)
	{
		this.name = name; 
		this.level = level; 
		this.description = description; 
		this.pip_chance = pip_chance; 
		this.pips = pips; 
		this.count = count; 
		this.type_Spell = type_Spell;
	}
	
	public String getName()
	{
		return name; 
	}
	
	public String getLevel()
	{
		return level;
	}
	
	public String getDescription()
	{
		return description; 
	}
	
	public String getPipChance()
	{
		return pip_chance; 
	}
	
	public String getPips()
	{
		return pips; 
	}

	public int getCount()
	{
		return count; 
	}
	
	public String getTypeSpell()
	{
		return type_Spell; 
	}

	public void setCount(int count)
	{
		this.count = count; 
	}
	
}

