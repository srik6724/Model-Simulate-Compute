package Object_Types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Data_Structures.Object_Types.Element;

public class Domain_Category_Product_List<T> {
	
	public static List<List<List<Element>>> allSchoolSpells = new ArrayList<List<List<Element>>>(); 
	static int universalIndex = -1; 
	public static int lifeIndex; 
	public static int deathIndex; 
	public static int balanceIndex; 
	public static int iceIndex; 
	public static int mythIndex; 
	public static int stormIndex; 
	public static int fireIndex; 
	
	public Domain_Category_Product_List(String school) throws IOException
	{
		System.out.println(school); 
		switch(school.toLowerCase())
		{
			case "life": 
				universalIndex++; 
				lifeIndex = universalIndex; 
				allSchoolSpells.add(new Subdomain_Category_Product_List_5(lifeIndex+1).retrieveFullDeck()); 
				break;
			case "death": 
				universalIndex++;
				deathIndex = universalIndex;
				allSchoolSpells.add(new Subdomain_Category_Product_List_2(deathIndex+1).retrieveFullDeck()); 
				break;
			case "balance": 
				universalIndex++; 
				balanceIndex = universalIndex;
				allSchoolSpells.add(new Subdomain_Category_Product_List_1(balanceIndex+1).retrieveFullDeck());
				break;
			case "ice": 
				universalIndex++; 
				iceIndex = universalIndex;
				allSchoolSpells.add(new Subdomain_Category_Product_List_4(iceIndex+1).retrieveFullDeck()); 
				break;
			case "myth": 
				universalIndex++; 
				mythIndex = universalIndex;
				allSchoolSpells.add(new Subdomain_Category_Product_List_6(mythIndex+1).retrieveFullDeck());
				break;
			case "storm": 
				universalIndex++; 
				stormIndex = universalIndex;
				allSchoolSpells.add(new Subdomain_Category_Product_List_7(stormIndex+1).retrieveFullDeck()); 
				break;
			case "fire": 
				universalIndex++; 
				fireIndex = universalIndex;
				allSchoolSpells.add(new Subdomain_Category_Product_List_3(fireIndex+1).retrieveFullDeck()); 
				break;
			default: 
				System.out.println("Sorry, wrong school input received."); 
		}
	}
	
	
}

