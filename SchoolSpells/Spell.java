package SchoolSpells;

public class Spell {
	
	private String name; 
	private String level; 
	private String description; 
	private String pip_chance; 
	private String pips; 
	private String type_Spell; 
	
	public Spell(String name, String level, String description, String pip_chance, String pips, String type_Spell)
	{
		this.name = name; 
		this.level = level; 
		this.description = description; 
		this.pips = pips; 
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
	
	public String getTypeSpell()
	{
		return type_Spell; 
	}
	
}

