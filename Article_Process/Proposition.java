package Article_Process;

import java.util.Scanner;

public class Proposition {
		
		//Process a sentence 
		//And check the validity 
		//Assign an annotation of 0 or 1. 
		
		public static Scanner sc = new Scanner(System.in);
		public String formatOfSentence = "I think that "; 
		public String input; 
		
		public String establishStatement(String firstTeamName, String secondTeamName)
		{
			System.out.println("Enter a statement in the form of " + formatOfSentence + " and state which team you think will win"); 
			System.out.println("Try to enter the names of the teams correctly. Otherwise, you will be redirected to try once again."); 
			
			input = sc.nextLine();
			String retrieveInput = ""; 
			
			for(int i = 0; i < firstTeamName.length(); i++)
			{
				if(firstTeamName.substring(i,i+1).equals(input.substring(i, i+1)))
				{
					retrieveInput += firstTeamName.substring(i,i+1); 
				}
				else
				{
					break; 
				}
			}
			
			for(int j = 0; j < secondTeamName.length(); j++)
			{
				if(secondTeamName.substring(j,j+1).equals(input.substring(j,j+1)))
				{
					retrieveInput += secondTeamName.substring(j,j+1);
				}
				else
				{
					break;
				}
			}
			
			return retrieveInput; 
			
			
		}

    public String establishStatement(StringBuilder retrieveFirstTeamName, StringBuilder retrieveSecondTeamName) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'establishStatement'");
    }
		
		
	}
