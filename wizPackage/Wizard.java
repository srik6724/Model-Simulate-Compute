package wizPackage;

//Simulation of a 4v4 match 

//Outline of a 4v4 match 

//Retrieve the names of the players enrolled in the match. 

//Retrieve the levels of the players enrolled in the match. 

//Retrieve the schools or identities of the players enrolled in the match. 

//Process for a Round listed below. 

//Set a clock for 30 seconds for the first team to make their move. 
//This also includes discarding cards to select the move they want to use. 

//Ask Player 1, whatever name to make their move and who they decide to cast it on. 
//Give the following 4 options of the opposing team. 

//Then ask Player 2, whatever name to make their move and who they decide to cast it on. 
//Give the following 4 opposing players of the opposing team. 

//Then ask Player 3, whatever name to make their move and who they decide to cast it on. 
//Give the following 4 opposing players of the opposing team. 

//Then ask Player 4, whatever name to make their move and who they decide to cast it on. 
//Give the following 4 opposing players of the opposing team. 

//End the clock right here and there, because now the next team will make their move. 
//Make methods to retrieve info about player information every consecutive round 
//regarding their health, their current hand, etc.

//----------------------------END OF ROUND-------------------------------------------

//Apply health deduction changes after this health clock resets. 

//Repeat the process for the next round. 

//-----------------------------FEATURES----------------------------------------------
//Match only ends when every person's health is at 0. 
//There should be an option to flee any time during a round and that option will be 
//given as self-select. If this happens, the match is considered to be ended
//and the simulation will stop. 

//Options can also be given to add spectators in the arena and a count of all spectators will be given. 
//Betting on these matches will also be a thing.

//Before the 4v4 match starts, an application is going to be made to create your own self-starting deck
//of 64 cards. This will include the main deck and side deck.

//Implement database of all 4v4 pvp spells in mySQL Database.


//Possible Combinations of 4v4 matches. 
//Consider death jade and life jade as part of the team already. 
//Just consider 2 jades for the time-being. 

//Death, Life, Death, Death 
//Death, Life, Balance, Balance
//Death, Life, Balance, Death 
//Death, Life, Death, Fire
//Death, Life, Storm, Storm
//Death, Life, Fire, Storm
//Death, Life, Fire, Fire
//Death, Life, Myth, Fire
//Death, Life, Myth, Myth
//Death, Life, Myth, Death 
//Death, Life, Life, Death 
//Death, Life, Myth, Balance 

//Fire, Life, Death, Myth(hitters, one healer)
//Documentation 
//Smoke Screen
//Stun Block
//Plague
//Empower
//1st round


//Dream shield
//Plague
//Ice Blade
//Weakness
//2nd round

//Conviction
//Tower shield
//Banshee
//Myth Bubble
//3rd round

//Volanica shield
//Empower
//Jinn vex
//Dream shield
//4th round

//Tower shield
//Pass
//Empower
//Delusion
//5th round

//Flawless
//Plague
//Blade
//Stun block
//6th round

//Smoke screen
//Jinn vexation
//Fortify
//Blinding Light
//7th round

//Fizzle
//Fizzle
//Stunned
//Stunned

//Smoke Screen
//Feint
//Jinn's Defense
//Myth Blade

//Fizzle
//Legion shield
//Legion shield
//Mythic fuel 

//Jinn vexation
//Pass
//Spiritual blade
//Jinn vexation

//Meteor strike
//Plague
//Wall Of Blades
//Delusion

//Empower
//Brace
//Jinn vexation
//Reliquary 

//Fire Dragon
//Choke
//Delusion
//Reliquary 

//Stunned
//Mass Triage
//Stunned
//Stunned

//Meteor Strike
//Feint
//Freeze Ray
//Shrike

//Fizzle
//Pigsie
//Weakness
//Fizzle

//Glacial Shield
//Feint
//Cleanse Charm
//Orthrus

//Krampus 
//Pigsie


//Fire wand hit
//Mythblade
//Infection
//Fizzle

//Smoke-screen
//Brace
//Spirit shield
//Myth jInn

//Fizzle
//Clenase charm
//Fizzle
//Jinn

//Tower Shield
//Doom Oni

//Bull
//Pigsie
//Freeze ray
//


//New match 
//Life, Death, Ice, fire
//Against 
//Balance, storm, Ice, Fire

//Life, Death, Ice and fire started first
//Fortify
//Stun Block
//Legion shield
//Fire Blade
//1st round

//Bladestorm
//Legion shield
//Legend shield
//Infallible
//1st round

//Plague
//Stun block
//Ice Blade
//Infallible
//2nd round

//Legion shield
//Ice Blade
//Glacial shield
//Storm Blade
//2nd round


//Plague
//Brace
//Infallible
//Scald
//3rd round

//Mass triage
//Stun block
//Volcanic shield
//Storm Blade
//3rd round

//Putrefaction
//Stun Block
//Glacial shield
//Super scorch 
//4th round

//Legion shield
//Ice pierce bub
//Infallible
//glacial fortress
//4th round

//Brace
//pass 
//thiermic shield
//Glaical shield
//5th round

//Balance Blade
//Snow Angel
//Fire Dragon
//Storm wyvern
//5th round

//Stun block
//Pigsie
//IceBlade
//Flawless
//6th round

//Mass infection
//Ice wand hit
//Bull
//Storm wand hit
//6th round

//Plague
//Unicorn
//Snow Angel
//Bull
//7th round

//Mass Triage
//Infection
//Fire Bubble
//Storm bugs
//7th round

//Sacrifice
//Elemental blade
//Freeze ray
//Fire Blade
//8th round

//


public class Wizard {
	//Attributes to add about Wizard
	private String name; 
	private String identity; 
	private int health; 
	private int level; 

	
	public Wizard(String name, String identity, int health, int level)
	{
		this.name = name; 
		this.identity = identity; 
		this.health = health; 
		this.level = level; 
	}
	
	public String getIdentity()
	{
		return identity; 
	}
	
	public String getName()
	{
		return name; 
	}
	
	public int getHealth()
	{
		return health; 
	}
	
	public int getLevel()
	{
		return level; 
	}
	
	/*public int calculateHealth() 
	{
		int starterHealth = gear.health; 
		return starterHealth; 
	}*/
	
	/*public int newHealth(int damageTaken)
	{
		int collectStarterHealth = calculateHealth(); 
		int newResultingHealth = collectStarterHealth - damageTaken; 
		
		return newResultingHealth; 
	}*/
	
	public void classifyBySchool(Wizard[] wizards, Wizard101LinkedList ls, String school)
	{
		Wizard101LinkedList.Node retrieveHead = ls.head; 
		for(Wizard wizard: wizards)
		{
			if(wizard.identity == school && retrieveHead.data == school)
			{
				System.out.println("It's a match."); 
			}
			else 
			{
				retrieveHead = retrieveHead.next; 
			}
		}
		System.out.println("No match found.");
	}
	
	public Wizard constructNewWizard(String name, String identity, int health, int level)
	{
		return new Wizard(name, identity, health, level); 
	}
	
	public void DefaultMessage()
	{
		System.out.println("My Wizard Name is " + name); 
		System.out.println("My Wizard Identity is " + identity); 
		System.out.println("My Wizard health is " + health); 
		System.out.println("My Wizard level is " + level); 
	}
	
	
	
}
