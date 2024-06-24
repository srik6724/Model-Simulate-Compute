package Object_Types_Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Object_Types_Parser.Token.TokenType;
import Category_Process.Category_;

public class Parser {
  private LexicalAnalyzer lexer; 
  private List<Token> token_list;

  public Parser(List<String> inputLines, String deckType, String school) throws IOException
  {
    System.out.println("OBJECT TYPE: " + school);
    lexer = new LexicalAnalyzer(inputLines, deckType, school);
    // Get the token_list as it contains all the tokens
    // token_list = lexer.get_token_list(); 
    // System.out.println(token_list.size()); 
    this.parse_deck_list(school); 
  }
  
  void syntax_error()
  {
	  System.out.println("SYNTAX ERROR!!!\n"); 
    System.exit(0); 
  }

  Token expect(TokenType expected_type)
  {
    System.out.println("PROCESSING TOKEN"); 
    System.out.println("EXPECTED TYPE: " + expected_type);
    Token t = lexer.getToken(); 
    System.out.println("TOKEN TYPE: " + t.token_type);
    if (t.token_type != expected_type)
        syntax_error(); 
    return t; 
  }

   void parse_number_players_affected()
   {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.ONE)
    {
      expect(TokenType.ONE); 
    }
    else if(t.token_type == TokenType.TWO)
    {
      expect(TokenType.TWO); 
    }
    else if(t.token_type == TokenType.THREE)
    {
      expect(TokenType.THREE); 
    }
    else if(t.token_type == TokenType.FOUR)
    {
      expect(TokenType.FOUR); 
    }
  }

  void parse_conditional()
  {
    expect(TokenType.STMT); 
    expect(TokenType.TARGET); 
  }

  void parse_proposition()
  {
    expect(TokenType.ACTION); 
    parse_conditional(); 
  }

  void parse_proposition_list()
  {
    parse_proposition(); 
    Token t; 
    t = lexer.peek(1); 
    if(t.token_type == TokenType.ACTION)
    {
      parse_proposition_list();
    }
  }

  void parse_description() 
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.TEXT)
    {
      expect(TokenType.TEXT); 
      parse_proposition_list(); 
      expect(TokenType.NUM); 
      parse_number_players_affected(); 
    }
  }

  void parse_regeneration()
  {
    parse_number_players_affected();
    expect(TokenType.HEALING); 
  }

  void parse_conditional_protect_percentage()
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.NUM)
    {
      expect(TokenType.NUM); 
      t = lexer.peek(1); 
      if(t.token_type == TokenType.PERCENTAGE)
      {
        expect(TokenType.PERCENTAGE); 
      }
    }
  }

  void parse_defense()
  {
    parse_number_players_affected(); 
    parse_conditional_protect_percentage(); 
  }

  void parse_attack()
  {
    parse_number_players_affected(); 
    expect(TokenType.DAMAGE); 
  }

  void parse_type_of_spell()
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.ATTACK)
    {
      expect(TokenType.ATTACK); 
      parse_attack(); 
    }
    else if(t.token_type == TokenType.UTILITY)
    {
      expect(TokenType.UTILITY); 
      parse_defense();
    }
    else if(t.token_type == TokenType.REGENERATION)
    {
      expect(TokenType.REGENERATION); 
      parse_regeneration(); 
    }
  }

  void parse_pips() 
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.ZERO)
    {
      expect(TokenType.ZERO); 
    }
    else if(t.token_type == TokenType.ONE)
    {
      expect(TokenType.ONE); 
    }
    else if(t.token_type == TokenType.TWO)
    {
      expect(TokenType.TWO); 
    }
    else if(t.token_type == TokenType.THREE)
    {
      expect(TokenType.THREE); 
    }
    else if(t.token_type == TokenType.FOUR)
    {
      expect(TokenType.FOUR); 
    }
    else if(t.token_type == TokenType.FIVE)
    {
      expect(TokenType.FIVE); 
    }
    else if(t.token_type == TokenType.SIX)
    {
      expect(TokenType.SIX); 
    }
    else if(t.token_type == TokenType.SEVEN)
    {
      expect(TokenType.SEVEN); 
    }
    else if(t.token_type == TokenType.EIGHT)
    {
      expect(TokenType.EIGHT); 
    }
    else if(t.token_type == TokenType.NINE)
    {
      expect(TokenType.NINE); 
    }
    else if(t.token_type == TokenType.TEN)
    {
      expect(TokenType.TEN);  
    }
    else if(t.token_type == TokenType.ELEVEN)
    {
      expect(TokenType.ELEVEN); 
    }
    else if(t.token_type == TokenType.TWELVE)
    {
      expect(TokenType.TWELVE); 
    }
    else if(t.token_type == TokenType.THIRTEEN)
    {
      expect(TokenType.THIRTEEN); 
    }
    else if(t.token_type == TokenType.X)
    {
      expect(TokenType.X); 
    }
  }

  void parse_pip_chance() {
    Token t; 
    t = lexer.peek(1); 
    if(t.token_type == TokenType.PERCENTAGE) {
      expect(TokenType.PERCENTAGE); 
    }
  }

  void parse_spell_school()
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.LIFE)
    {
      expect(TokenType.LIFE); 
    }
    else if(t.token_type == TokenType.DEATH)
    {
      expect(TokenType.DEATH); 
    }
    else if(t.token_type == TokenType.BALANCE)
    {
      expect(TokenType.BALANCE); 
    }
    else if(t.token_type == TokenType.ICE) 
    {
      expect(TokenType.ICE); 
    }
    else if(t.token_type == TokenType.MYTH) 
    {
      expect(TokenType.MYTH); 
    }
    else if(t.token_type == TokenType.FIRE) 
    {
      expect(TokenType.FIRE); 
    }
    else if(t.token_type == TokenType.STORM)
    {
      expect(TokenType.STORM); 
    }
  }

  void parse_spell() 
  {
    parse_spell_school(); 
    parse_pip_chance(); 
    parse_pips(); 
    parse_type_of_spell(); 
    parse_description(); 
  }

  void parse_spellList() 
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.SPELL)
    {
      expect(TokenType.SPELL); 
      parse_spell(); 
      t = lexer.peek(1); 
      if(t.token_type == TokenType.END_OF_FILE)
      {
        return; 
      }
      else 
      {
        parse_spellList(); 
      }
    }
  }

  void parse_school() 
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TokenType.LIFE) 
    {
      expect(TokenType.LIFE); 
    }
    else if(t.token_type == TokenType.DEATH)
    {
      expect(TokenType.DEATH); 
    }
    else if(t.token_type == TokenType.BALANCE)
    {
      expect(TokenType.BALANCE); 
    }
    else if(t.token_type == TokenType.ICE)
    {
      expect(TokenType.ICE); 
    }
    else if(t.token_type == TokenType.MYTH) 
    {
      expect(TokenType.MYTH); 
    }
    else if(t.token_type == TokenType.FIRE) 
    {
      expect(TokenType.FIRE); 
    }
    else if(t.token_type == TokenType.STORM)
    {
      expect(TokenType.STORM); 
    }
  }

  void parse_deck()
  {
    parse_school(); 
    parse_spellList(); 
  }

  void parse_deck_list(String school) 
  {
    school = school.toUpperCase();
    if(school.equals("ICE")){
      expect(TokenType.ICE);
    }
    else if(school.equals("FIRE")) {
      expect(TokenType.FIRE);
    }
    else if(school.equals("STORM")) {
      expect(TokenType.STORM);
    }
    else if(school.equals("LIFE")) {
      expect(TokenType.LIFE);
    }
    else if(school.equals("MYTH")) {
      expect(TokenType.MYTH);
    }
    else if(school.equals("DEATH")) {
      expect(TokenType.DEATH);
    }
    else if(school.equals("BALANCE")) {
      expect(TokenType.BALANCE);
    }
    expect(TokenType.DECK); 
    parse_deck(); 
  }

  List<Token> get_deck_list() {
    return this.token_list;
  }
}
