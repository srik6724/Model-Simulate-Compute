import Gear
import gearItems
class FilterGear: 
    hatName = None
    robeName = None 
    bootsName = None 
    wandName = None 
    athameName = None 
    amuletName = None 
    ringName = None 
    deckName = None 
    
    def __init__(self): 
        g = Gear.Gear()
        g.retrieveGearInput()
        self.hatName = g.hat
        self.robeName = g.robe 
        self.bootsName = g.boots 
        self.wandName = g.wand 
        self.athameName = g.athame 
        self.amuletName = g.amulet 
        self.ringName = g.ring 
        self.deckName = g.deck

    def extractKeyWords(self, str): 
        result = self.isWhiteSpace(str)
        if(result == True): 
          ls = []
          for word in str.split(' '): 
              print(word)
              ls.append(word)
          return ls
    
    def isWhiteSpace(self, str): 
        result = False
        for character in list(str): 
            if(character == ' '): 
                result = True
                break 
        return result
    
    def hatProperGearName(self): 
        list_keywords = self.extractKeyWords(self.hatName)

        hat_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "hat")
            if(check_word == True):
              hat_str += word
              hat_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word, 1)
                hat_str += word
                hat_str += ' '
            print(hat_str)
            
    
    def robeProperGearname(self): 
        list_keywords = self.extractKeyWords(self.robeName)

        robe_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "robe")
            if(check_word == True):
              robe_str += word
              robe_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                robe_str += word
                robe_str += ' '
            print(robe_str)

    
    def bootsProperGearName(self): 
        list_keywords = self.extractKeyWords(self.bootsName)

        boots_str = ''
        for word in list_keywords:
            check_word = self.isCorrectWord(word, "boots")
            if(check_word == True):
              boots_str += word
              boots_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                boots_str += word
                boots_str += ' '
            print(boots_str)


    
    def wandProperGearName(self): 
        list_keywords = self.extractKeyWords(self.wandName)

        wand_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "wand")
            if(check_word == True):
              wand_str += word
              wand_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                wand_str += word
                wand_str += ' '
            print(wand_str)

    
    def athameProperGearName(self):
        list_keywords = self.extractKeyWords(self.athameName)

        athame_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "athame")
            if(check_word == True):
              athame_str += word
              athame_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                athame_str += word
                athame_str += ' '
            print(athame_str)


    def amuletProperGearName(self): 
        list_keywords = self.extractKeyWords(self.amuletName)

        amulet_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "amulet")
            if(check_word == True):
              amulet_str += word
              amulet_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                amulet_str += word
                amulet_str += ' '
            print(amulet_str)
    
    def ringProperGearName(self): 
        list_keywords = self.extractKeyWords(self.ringName)

        ring_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "ring")
            if(check_word == True):
              ring_str += word
              ring_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                ring_str += word
                ring_str += ' '
            print(ring_str)
    
    def deckProperGearName(self): 
        list_keywords = self.extractKeyWords(self.deckName)

        deck_str = ''
        for word in list_keywords: 
            check_word = self.isCorrectWord(word, "deck")
            if(check_word == True):
              deck_str += word
              deck_str += ' '
            elif(check_word == False): 
                word = self.fixWord(word)
                deck_str += word
                deck_str += ' '
            print(deck_str)
    
    def isCorrectWord(self, str, nameOfGear):
        check = True
        if(nameOfGear == "hat"): 
            if(str == "Abstract Aeon Helm"): 
                return check
        if(nameOfGear == "robe"): 
            if(str == "Abstract Aeon Cape"): 
                return check
        if(nameOfGear == "boots"): 
            if(str == "Abstract Aeon Boots"): 
                return check
        if(nameOfGear == "wand"): 
            if(str == "Abstract Aeon Sword"): 
                return check
        if(nameOfGear == "athame"): 
            if(str == "Abstract Aeon Athame"): 
                return check
        if(nameOfGear == "amulet"): 
            if(str == "Abstract Aeon Charm"): 
                return check
        if(nameOfGear == "ring"): 
            if(str == "Abstract Aeon Ring"): 
                return check
        if(nameOfGear == "deck"): 
            if(str == "Abstract Aeon Deck"): 
                return check
        check = False
        return check
          
    
    def fixWord(word, iteration_no): 
        print()
       #if(iteration_no == 1): 
            
       # if(iteration_no == 2): 
       #     print()
       # if(iteration_no == 3): 
        #    print()

      
f = FilterGear()
f.hatProperGearName()