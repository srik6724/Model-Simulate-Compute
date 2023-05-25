import gearItems

class Gear: 

  hat = None
  robe = None
  boots = None
  wand = None
  athame = None
  amulet = None
  ring = None
  deck = None

  def hatInput(self): 
    self.hat = input("Enter the name of your " + gearItems.hat() + ": ")
    try: 
        if(isinstance(self.hat, str) == True and isinstance(int(self.hat), int) == True): 
            print(self.hat + " is of type int.")
    except ValueError: 
      print(self.hat)
  
  def getHat(self): 
     if(self.hat != None): 
        print(self.hat)
        return self.hat

  def robeInput(self): 
    self.robe = input("Enter the name of your " + gearItems.robe() + ": ")
    try: 
        if(isinstance(self.robe, str) == True and isinstance(int(self.robe), int) == True): 
          print(self.robe + " is of type int.")
    except ValueError: 
      print(self.robe)
  
  def getRobe(self): 
     if(self.robe != None): 
        print(self.robe)
        return self.robe

  def bootsInput(self): 
    self.boots = input("Enter the name of your " + gearItems.boots() + ": ")
    try: 
        if(isinstance(self.boots, str) == True and isinstance(int(self.boots), int) == True): 
            print(self.boots + " is of type int.")
    except ValueError: 
      print(self.boots)
  
  def getBoots(self): 
     if(self.boots != None): 
        print(self.boots)
        return self.boots

  def wandInput(self): 
    self.wand = input("Enter the name of your " + gearItems.wand() + ": ")
    try: 
        if(isinstance(self.wand, str) == True and isinstance(int(self.wand), int) == True): 
            print(self.wand + " is of type int.")
            return None
    except ValueError: 
      print(self.wand)
  
  def getWand(self): 
     if(self.wand != None): 
        print(self.wand)
        return self.wand

  def athameInput(self): 
    self.athame = input("Enter the name of your " + gearItems.athame() + ": ")
    try: 
        if(isinstance(self.athame, str) == True and isinstance(int(self.athame), int) == True): 
            print(self.athame + " is of type int.")
    except ValueError: 
      print(self.athame)
  
  def getAthame(self): 
     if(self.athame != None): 
        print(self.athame)
        return self.athame

  def amuletInput(self): 
    self.amulet = input("Enter the name of your " + gearItems.amulet() + ": ")
    try: 
        if(isinstance(self.amulet, str) == True and isinstance(int(self.amulet), int) == True): 
            print(self.amulet + " is of type int.")
    except ValueError: 
      print(self.amulet)
  
  def getAmulet(self): 
     if(self.amulet != None): 
        print(self.amulet)
        return self.amulet

  def ringInput(self): 
    self.ring = input("Enter the name of your " + gearItems.ring() + ": ")
    try: 
        if(isinstance(self.ring, str) == True and isinstance(int(self.ring), int) == True): 
            print(self.ring + " is of type int.")
            return None
    except ValueError: 
      print(self.ring)
  
  def getRing(self): 
     if(self.ring != None): 
        print(self.ring)
        return self.ring

  def deckInput(self): 
    self.deck = input("Enter the name of your " + gearItems.deck() + ": ")
    try: 
        if(isinstance(self.deck, str) == True and isinstance(int(self.deck), int) == True): 
            print(self.deck + " is of type int.")
    except ValueError: 
      print(self.deck)
  
  def getDeck(self):
     if(self.deck != None): 
        print(self.deck)
        return self.deck
  
  def retrieveGearInput(self): 
    self.hatInput()
    self.robeInput()
    self.bootsInput()
    self.wandInput()
    self.athameInput()
    self.amuletInput()
    self.ringInput()
    self.deckInput()
    print("Gear is completed.")