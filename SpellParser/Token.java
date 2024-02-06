package SpellParser;

public class Token {
  String lexeme; 

  enum TokenType {
    DECK, ACTION, ATTACK, DEFENSE, UTILITY, REGENERATION, SPELL, LIFE, DEATH, BALANCE, ICE, MYTH, FIRE, STORM, 
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
    EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, X, STMT, NUM, TARGET, ERROR, SPELL_PERCENTAGE, END_OF_FILE
  }
  TokenType token_type;

  Token() 
  {

  }
  
}
