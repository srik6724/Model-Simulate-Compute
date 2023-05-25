class Test: 

  word = 'Abstract'
  numPossibleWords = 0
  ls = []

  def test_input(self): 
    incorrect_spelled_word = input("Spell the word abstract incorrectly: ")
    new_word = self.fix_word(incorrect_spelled_word)
    if(new_word.lower() == Test.word.lower()): 
      print("Here was the incorrectly spelled word: " + incorrect_spelled_word)
      print("Here is the new word: " + new_word)
    else: 
      print("Sorry, the word could not be spelled correctly.")
      print("The word " + incorrect_spelled_word + " is unrecognizable to match the word " + Test.word) 


  def fix_word(self,word): 
    iteration = 0
    final_str = ''
    for character in list(word): 
        character_match = self.compare_char(character, iteration)
        if(character_match == True): 
            final_str += character
            iteration = iteration + 1
            continue 
        else: 
            character = self.fix_char(character, iteration)
            final_str += character
            iteration = iteration + 1
    return final_str

  def compare_char(self,character,number): 
      dictionary = {
          0: "a", 
          1: "b", 
          2: "s", 
          3: "t", 
          4: "r",
          5: "a",
          6: "c",
          7: "t"
      }
      try: 
        if(str(character).lower() == dictionary[number]): 
          return True 
        return False
      except KeyError: 
        return False


  def fix_char(self,character,number): 
      dictionary = {
          0: "a", 
          1: "b", 
          2: "s", 
          3: "t", 
          4: "r",
          5: "a",
          6: "c",
          7: "t"
      }
      try: 
        character = dictionary[number]
        return character
      except KeyError: 
        character = ''
        return character

# Test Algorithm detecting whether word is semantically in proper format to correctly spell incorrect word.
  def find_incorrect_combinations(self): 
    dictionary = {
        0: "a", 
        1: "b", 
        2: "s", 
        3: "t", 
        4: "r",
        5: "a",
        6: "c",
        7: "t",
        8: " ", 
        9: "a",
        10: "e",
        11: "o",
        12: "n", 
        13: " ", 
        14: "h", 
        15: "e",
        16: "l", 
        17: "m"
    }
    word_incorrectInput = input("Enter the incorrect spelling of the word abstract: ")
    count_letters = 0
    i = 0
    characters = list(word_incorrectInput)
    if(len(word_incorrectInput) > len(Test.word)):
       for index in range(0, len(word_incorrectInput)): 
          if(index < len(Test.word)): 
             continue
          else: 
             characters[index] = ''
       word_incorrectInput = ''.join(characters)
       print(word_incorrectInput)
    print(len(word_incorrectInput))
    for character in list(word_incorrectInput): 
        if(character == dictionary[i]): 
          print(character + " matches to " + str(dictionary[i]) + " at position " + str(i))
          count_letters = count_letters + 1
          i = i + 1
        else: 
           i = i + 1
    percentage = (count_letters/len(word_incorrectInput)) * 100
    print("There is a " + str(percentage) + "% match " + "to the word " + Test.word)
    if(percentage >= 37.5):
       corrected_word = self.fix_word(word_incorrectInput)
       print("Corrected Word: " + corrected_word)
    else: 
       print("Word " + str(word_incorrectInput) + " could not be corrected.")
    

t = Test()
t.find_incorrect_combinations()


