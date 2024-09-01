package Object_Types;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Data_Structures.Object_Types.Element;
import Data_Structures.Object_Types.Heap;
import Object_Types_Build.Unit;

public class Subdomain_Category_Product_List_5<T> {
	
	private Heap hp = new Heap(); 
	
	private List<List<Element>> fullDeck; 

	public ArrayList<Category<Unit>> lifeSpells = new ArrayList<Category<Unit>>(); 
	
	Subdomain_Category_Product_List_5(int selectionNo) throws IOException
	{
		Connection conn1 = null;
        try {
            String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
            String user = "srik6724";
            String password = "28892K0shair!";
 
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
            	Statement st1 = conn1.createStatement(); 
            	if(st1 != null)
            	{
            		ResultSet rs = st1.executeQuery("SELECT * FROM wizard_schema.verbs_english");
            		while(rs.next())
            		{
            			String name = rs.getString("tag"); 
            			String level = rs.getString("lifetime"); 
            			String description = rs.getString("information"); 
            			String pip_chance = rs.getString("success_build_rate");
            			String pips = rs.getString("assembly_no_of_steps"); 
									String school = rs.getString("category"); 
            			String life_typeSpell = rs.getString("industryType"); 
            			
            			Category<Unit> spell = new Category<Unit>(name, description); 
            			
            			lifeSpells.add(spell); 
            		}
								conn1.close();
								//List<List<Spell>> createdLifeSpells = null; 
								fullDeck = anotherDefaultDeck(lifeSpells, selectionNo); 
								/*if(givenLifeSpells != null)
								{
									System.out.println("Deck has been successfully created."); 
									deckInformation(createdLifeSpells, givenLifeSpells); 
								}*/
            		System.out.println("Execution is done.");
            	}
            	else
            	{
            		System.out.println("Cannot execute database statement.");
            	}
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
	}
	
	public ArrayList<Category<Unit>> retrieveLifeSpells()
	{
		return lifeSpells; 
	}

	public List<List<Element>> anotherDefaultDeck(ArrayList<Category<Unit>>spells, int selectionNo) throws InterruptedException, IOException
	{
		String input; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Select CD for custom deck, DD for default deck"); 
		input = sc.nextLine(); 

		if(input.equals("CD"))
		{
			List<List<Element>> fullDeck = hp.selectYESOption("Life", "YES", selectionNo); 
			return fullDeck;
		}
		else if(input.equals("DD"))
		{
			List<Map<String,List<String>>> givenDeck = hp.selectNOoption("Life", "NO", selectionNo); 
			return null;
		}
		return null;
	}
	
	public List<List<Element>> retrieveFullDeck()
	{
		return fullDeck;
	}
	
	public void deckInformation(List<List<Category<Unit>>> spells, List<Map<String, List<String>>> setOfSpells)
	{

		/*if(spells != null)
		{

			Set<String> TCInfo = computeTCInformation(spells, setOfSpells); 
			Set<String> mainDeckInfo = computeMainDeckInformation(spells, setOfSpells); 
		
			/*for(Spell spell: spells.get(0))
			{
				int capacity = 40; 
				countOfEachSpell(spell.getName(), spells.get(0), capacity); 
			}
		
			for(Spell spell: spells.get(1))
			{
				int capacity = 64;  
				countOfEachSpell(spell.getName(), spells.get(1), capacity); 
			}

		}*/
		if(setOfSpells != null)
		{
			computeMainDeckInformation(setOfSpells); 
			computeTCInformation(setOfSpells); 
		}
	}
	
	public Set<String> computeTCInformation(List<Map<String,List<String>>> setOfSpells)
	{
		if(setOfSpells != null)
		{
			for(String spell: setOfSpells.get(0).keySet())
			{
				System.out.println("Spell Name: " + spell); 
				System.out.println("Count of Spell: " + setOfSpells.get(0).get(spell).get(0)); 
				System.out.println("Pip Chance: " + setOfSpells.get(0).get(spell).get(1)); 
				System.out.println("Pips of Spell: " + setOfSpells.get(0).get(spell).get(2)); 
				System.out.println("School Name: " + setOfSpells.get(0).get(spell).get(3)); 
				System.out.println("---------------------------------------------------------"); 
			}
		}
		return null; 
	}
	
	public Set<String> computeMainDeckInformation(List<Map<String,List<String>>> setOfSpells)
	{
		if(setOfSpells != null)
		{
			for(String spell: setOfSpells.get(0).keySet())
			{
				System.out.println("Spell Name: " + spell); 
				System.out.println("Count of Spell: " + setOfSpells.get(0).get(spell).get(0)); 
				System.out.println("Pip Chance: " + setOfSpells.get(0).get(spell).get(1)); 
				System.out.println("Pips of Spell: " + setOfSpells.get(0).get(spell).get(2)); 
				System.out.println("School Name: " + setOfSpells.get(0).get(spell).get(3)); 
				System.out.println("---------------------------------------------------------"); 
			}
		}
		return null; 
	}
	
	public void countOfEachSpell(String name, List<Category<Unit>> spells, int capacity)
	{
		int count = 0; 
		for(Category<Unit> spell: spells)
		{
			if(spell.getName().equals(name))
			{
				count = count + 1; 
			}
		}
		System.out.println(count + "/" + capacity + name + "found."); 
	}
	
	public static void main(String[]args) throws IOException
	{
	 //FireSpells spells = new FireSpells(); 
	 new Subdomain_Category_Product_List_5(0); 
	}
	
	
}
