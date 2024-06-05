package Object_Types_Parser;

public class Token {
  String lexeme; 

  enum TokenType {
    DECK, LIFE, DEATH, BALANCE, ICE, MYTH, FIRE, STORM, ZERO, ONE, TWO, THREE, FOUR, 
    FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, X, TEXT, DAMAGE, 
    HEALING, NUM, PERCENTAGE, DESCRIPTION, SPELL, ACTION, ATTACK, UTILITY, REGENERATION,
    STMT, TARGET, ERROR, END_OF_FILE 
  }

  TokenType token_type;

  Token() 
  {

  }
  
}
