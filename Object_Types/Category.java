package Object_Types;

public class Category<T> {
	
	private String name; 
	private String description; 
	
	public Category(String name, String description)
	{
		this.name = name; 
		this.description = description;
	}
	
	public String getName()
	{
		return name; 
	}

	
	public String getDescription()
	{
		return description; 
	}
	
}

