package SpellParser;

import java.util.ArrayList;
import java.util.List;

import SpellParser.Token.TokenType;
import wizPackage.Match;

public class Parser {
  private LexicalAnalyzer lexer; 
  private List<Token> token_list;

  public Parser(List<String> inputLines)
  {
    lexer = new LexicalAnalyzer(inputLines);
    // Get the token_list as it contains all the tokens
    token_list = lexer.get_token_list(); 
    System.out.println(token_list.size()); 
    System.exit(0); 
    // this.parse_deck_list(); 
  }
  
  /*void syntax_error()
  {
	  System.out.println("SYNTAX ERROR!!!\n"); 
  }

  Token expect(TokenType expected_type)
  {
    Token t = lexer.GetToken(); 
    if (t.token_type != expected_type)
        syntax_error(); 
    return t; 
  }

  public Parser() {
    new InputBuffer(); 
    System.out.println("Starting the process for parser."); 
    parse_deck_list(); 
  }

   void parse_number_players_affected()
   {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == ONE)
    {
      expect(ONE); 
    }
    else if(t.token_type == TWO)
    {
      expect(TWO); 
    }
    else if(t.token_type == THREE)
    {
      expect(THREE); 
    }
    else if(t.token_type == FOUR)
    {
      expect(FOUR); 
    }
  }

  void parse_conditional()
  {
    expect(STMT); 
    expect(TARGET); 
  }

  void parse_proposition()
  {
    expect(ACTION); 
    parse_conditional(); 
  }

  void parse_proposition_list()
  {
    parse_proposition(); 
    Token t; 
    t = lexer.peek(1); 
    if(t.token_type == ACTION)
    {
      parse_proposition_list();
    }
  }

  void parse_description() 
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == TEXT)
    {
      expect(TEXT); 
      parse_proposition_list(); 
      expect(NUM); 
      parse_number_players_affected(); 
    }
  }

  void parse_regeneration()
  {
    parse_number_players_affected();
    expect(HEALING); 
  }

  void parse_conditional_protect_percentage()
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == NUM)
    {
      expect(NUM); 
      t = lexer.peek(1); 
      if(t.token_type == PERCENTAGE)
      {
        expect(PERCENTAGE); 
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
    expect(DAMAGE); 
  }

  void parse_type_of_spell()
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == ATTACK)
    {
      expect(ATTACK); 
      parse_attack(); 
    }
    else if(t.token_type == DEFENSE)
    {
      expect(DEFENSE); 
      parse_defense();
    }
    else if(t.token_type == REGENERATION)
    {
      expect(REGENERATION); 
      parse_regeneration(); 
    }
  }

  void parse_pips() 
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == ZERO)
    {
      expect(ZERO); 
    }
    else if(t.token_type == ONE)
    {
      expect(ONE); 
    }
    else if(t.token_type == TWO)
    {
      expect(TWO); 
    }
    else if(t.token_type == THREE)
    {
      expect(THREE); 
    }
    else if(t.token_type == FOUR)
    {
      expect(FOUR); 
    }
    else if(t.token_type == FIVE)
    {
      expect(FIVE); 
    }
    else if(t.token_type == SIX)
    {
      expect(SIX); 
    }
    else if(t.token_type == SEVEN)
    {
      expect(SEVEN); 
    }
    else if(t.token_type == EIGHT)
    {
      expect(EIGHT); 
    }
    else if(t.token_type == NINE)
    {
      expect(NINE); 
    }
    else if(t.token_type == TEN)
    {
      expect(TEN);  
    }
    else if(t.token_type == ELEVEN)
    {
      expect(ELEVEN); 
    }
    else if(t.token_type == TWELVE)
    {
      expect(TWELVE); 
    }
    else if(t.token_type == THIRTEEN)
    {
      expect(THIRTEEN); 
    }
    else if(t.token_type == X)
    {
      expect(X); 
    }
  }

  void parse_pip_chance() {
    Token t; 
    t = lexer.peek(1); 
    if(t.token_type == SPELL_PERCENTAGE) {
      expect(SPELL_PERCENTAGE); 
    }
  }

  void parse_spell_school()
  {
    Token t; 
    t = lexer.peek(1); 

    if(t.token_type == LIFE)
    {
      expect(LIFE); 
    }
    else if(t.token_type == DEATH)
    {
      expect(DEATH); 
    }
    else if(t.token_type == BALANCE)
    {
      expect(BALANCE); 
    }
    else if(t.token_type == ICE) 
    {
      expect(ICE); 
    }
    else if(t.token_type == MYTH) 
    {
      expect(MYTH); 
    }
    else if(t.token_type == FIRE) 
    {
      expect(FIRE); 
    }
    else if(t.token_type == STORM)
    {
      expect(STORM); 
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

    if(t.token_type == SPELL)
    {
      expect(SPELL); 
      parse_spell(); 
      t = lexer.peek(1); 
      if(t.token_type == END_OF_FILE)
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

    if(t.token_type == LIFE) 
    {
      expect(LIFE); 
    }
    else if(t.token_type == DEATH)
    {
      expect(DEATH); 
    }
    else if(t.token_type == BALANCE)
    {
      expect(BALANCE); 
    }
    else if(t.token_type == ICE)
    {
      expect(ICE); 
    }
    else if(t.token_type == MYTH) 
    {
      expect(MYTH); 
    }
    else if(t.token_type == FIRE) 
    {
      expect(FIRE); 
    }
    else if(t.token_type == STORM)
    {
      expect(STORM); 
    }
  }

  void parse_deck()
  {
    parse_school(); 
    parse_spellList(); 
  }

  void parse_deck_list() 
  {
    expect(DECK); 
    parse_deck(); 
    Token t; 
    t = lexer.peek(1); 
    if(t.token_type == DECK)
    {
      parse_deck_list(); 
    }
  }

  List<Token> get_deck_list() {
    return this.token_list;
  }*/
}
