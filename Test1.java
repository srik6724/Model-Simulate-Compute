
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.base.Preconditions;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class Spell {
    private String name;
    private int pips;

    public Spell(String name, int pips) {
        this.name =  name;
        this.pips = pips;
    }

    public String getName() {
        return name;
    }

    public int getPips() {
        return pips;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Test1 {

    Test1() {
        
    }

    private void simulateWizardTurn(List<String> main_deck_wizard, List<String> tc_deck_wizard) {
        
    }
    public static void main(String[]args) {
        
        List<Spell> main_deck_wizard_1_t1 = new ArrayList<Spell>(); 
        main_deck_wizard_1_t1.add(new Spell("Balefrost", 2)); 
        main_deck_wizard_1_t1.add(new Spell("Balefrost", 2)); 
        main_deck_wizard_1_t1.add(new Spell("Balefrost", 2)); 
        main_deck_wizard_1_t1.add(new Spell("Balefrost", 2));
        main_deck_wizard_1_t1.add(new Spell("Wall Of Blades", 3));
        main_deck_wizard_1_t1.add(new Spell("Wall Of Blades", 3));
        main_deck_wizard_1_t1.add(new Spell("Wall Of Blades", 3));
        main_deck_wizard_1_t1.add(new Spell("Glacial Fortress", 3));
        main_deck_wizard_1_t1.add(new Spell("Glacial Fortress", 3));
        main_deck_wizard_1_t1.add(new Spell("Glacial Fortress", 3));
        main_deck_wizard_1_t1.add(new Spell("Glacial Fortress", 3));
        main_deck_wizard_1_t1.add(new Spell("Glacial Fortress", 3));
        main_deck_wizard_1_t1.add(new Spell("Glacial Fortress", 3));
        main_deck_wizard_1_t1.add(new Spell("Jinn's Vexation", 3));
        main_deck_wizard_1_t1.add(new Spell("Jinn's Vexation", 3));
        main_deck_wizard_1_t1.add(new Spell("Volcanic Shield", 0));
        main_deck_wizard_1_t1.add(new Spell("Volcanic Shield", 0));
        main_deck_wizard_1_t1.add(new Spell("Volcanic Shield", 0));
        main_deck_wizard_1_t1.add(new Spell("Volcanic Shield", 0));
        main_deck_wizard_1_t1.add(new Spell("Volcanic Shield", 0));
        main_deck_wizard_1_t1.add(new Spell("Volcanic Shield", 0));
        main_deck_wizard_1_t1.add(new Spell("Brilliant Light", 1));
        main_deck_wizard_1_t1.add(new Spell("Pacify on Any Wizard", 3));
        main_deck_wizard_1_t1.add(new Spell("Pacify on Any Wizard", 3));
        main_deck_wizard_1_t1.add(new Spell("Guiding Light", 0));
        main_deck_wizard_1_t1.add(new Spell("Guiding Light", 0));
        main_deck_wizard_1_t1.add(new Spell("Pacify on Self", 2));
        main_deck_wizard_1_t1.add(new Spell("Pacify on Self", 2));
        main_deck_wizard_1_t1.add(new Spell("Minor Blessing", 0));
        main_deck_wizard_1_t1.add(new Spell("Minor Blessing", 0));
        main_deck_wizard_1_t1.add(new Spell("Minor Blessing", 0));
        main_deck_wizard_1_t1.add(new Spell("Minor Blessing", 0));
        main_deck_wizard_1_t1.add(new Spell("Pixie", 2));
        main_deck_wizard_1_t1.add(new Spell("Pixie", 2));
        main_deck_wizard_1_t1.add(new Spell("Pixie", 2));
        main_deck_wizard_1_t1.add(new Spell("Pixie", 2));
        main_deck_wizard_1_t1.add(new Spell("Pixie", 2));
        main_deck_wizard_1_t1.add(new Spell("Regenerate", 5));
        main_deck_wizard_1_t1.add(new Spell("Regenerate", 5));
        main_deck_wizard_1_t1.add(new Spell("Regenerate", 5));
        main_deck_wizard_1_t1.add(new Spell("Regenerate", 5));
        main_deck_wizard_1_t1.add(new Spell("Regenerate", 5));
        main_deck_wizard_1_t1.add(new Spell("Regenerate", 5));
        main_deck_wizard_1_t1.add(new Spell("Sanctuary", 2));
        main_deck_wizard_1_t1.add(new Spell("Sanctuary", 2));
        main_deck_wizard_1_t1.add(new Spell("Sanctuary", 2));
        main_deck_wizard_1_t1.add(new Spell("Renew", 0));
        main_deck_wizard_1_t1.add(new Spell("Renew", 0));
        main_deck_wizard_1_t1.add(new Spell("Renew", 0));
        main_deck_wizard_1_t1.add(new Spell("Renew", 0));
        main_deck_wizard_1_t1.add(new Spell("Infection", 0));
        main_deck_wizard_1_t1.add(new Spell("Infection", 0));
        main_deck_wizard_1_t1.add(new Spell("Infection", 0));
        main_deck_wizard_1_t1.add(new Spell("Infection", 0));
        main_deck_wizard_1_t1.add(new Spell("Putrefaction", 3));
        main_deck_wizard_1_t1.add(new Spell("Putrefaction", 3));
        main_deck_wizard_1_t1.add(new Spell("Putrefaction", 3));
        main_deck_wizard_1_t1.add(new Spell("Putrefaction", 3));
        main_deck_wizard_1_t1.add(new Spell("Contagion", 3));
        main_deck_wizard_1_t1.add(new Spell("Contagion", 3));
        main_deck_wizard_1_t1.add(new Spell("Threefold Fever", 2));
        main_deck_wizard_1_t1.add(new Spell("Threefold Fever", 2));
        main_deck_wizard_1_t1.add(new Spell("Threefold Fever", 2));
        main_deck_wizard_1_t1.add(new Spell("Threefold Fever", 2));
        List<List<String>> tc_deck_wizards = new ArrayList<List<String>>();  
        List<Spell> tc_deck_wizard_1_t1 = new ArrayList<Spell>(); 
        tc_deck_wizard_1_t1.add(new Spell("TC Legion-Shield", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Legion-Shield", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Legion-Shield", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Legion-Shield", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Stun Block", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Stun Block", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Stun Block", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Stun Block", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Choke", 2));
        tc_deck_wizard_1_t1.add(new Spell("TC Choke", 2));
        tc_deck_wizard_1_t1.add(new Spell("TC Choke", 2));
        tc_deck_wizard_1_t1.add(new Spell("TC Choke", 2));
        tc_deck_wizard_1_t1.add(new Spell("TC Choke", 2));
        tc_deck_wizard_1_t1.add(new Spell("TC Empower", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Empower", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Empower", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Mass-Infection", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Mass-Infection", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Mass-Infection", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Mass-Infection", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Mass-Infection", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Cleanse Charm", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Cleanse Charm", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Cleanse Charm", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Cleanse Charm", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Cleanse Charm", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Balance Blade", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Reshuffle", 3));
        tc_deck_wizard_1_t1.add(new Spell("TC Elemental Blade", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Elemental Blade", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Elemental Blade", 1));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));
        tc_deck_wizard_1_t1.add(new Spell("TC Weakness", 0));

        Spell[] sevenRandomIndexes = new Spell[7];
        boolean firstIndexFlag = true; 
        boolean secondIndexFlag = true; 
        boolean thirdIndexFlag = true; 
        boolean fourthIndexFlag = true; 
        boolean fifthIndexFlag = true; 
        boolean sixthIndexFlag = true; 
        boolean seventhIndexFlag = true;
        int main_deck_size = main_deck_wizard_1_t1.size(); 
        int tc_deck_size = tc_deck_wizard_1_t1.size(); 
        int firstIndex = 0; 
        int firstIndex_ = 0; 
        int secondIndex = 0; 
        int secondIndex_ = 0; 
        int thirdIndex = 0;
        int thirdIndex_ = 0; 
        int fourthIndex = 0;
        int fourthIndex_ = 0; 
        int fifthIndex = 0;
        int fifthIndex_ = 0; 
        int sixthIndex = 0;
        int sixthIndex_ = 0; 
        int seventhIndex = 0;
        int seventhIndex_ = 0; 
        int pips = 3; 
        while((main_deck_size + tc_deck_size) > 0) {
            System.out.println("PIPS AT HAND: " + pips);
            System.out.println("CARDS REMAINING: " + (main_deck_size + tc_deck_size));
            if(firstIndexFlag == true) {
                firstIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[0] = main_deck_wizard_1_t1.get(firstIndex); 
                /*int firstSpellIndex = sevenRandomIndexes[0].indexOf(":") + 2; 
                String nameOfSpell = ""; 
                for(int i = firstSpellIndex; i < sevenRandomIndexes[0].indexOf(","); i++) {
                    nameOfSpell += sevenRandomIndexes[0].substring(i, i+1);
                }
                sevenRandomIndexes[0] = nameOfSpell;*/
                //System.out.println(sevenRandomIndexes[0]);
                while(sevenRandomIndexes[0].getName() == "X") {
                    firstIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[0] = main_deck_wizard_1_t1.get(firstIndex); 
                    /*int firstSpellIndex2 = sevenRandomIndexes[0].indexOf(":") + 2; 
                    String nameOfSpell2 = ""; 
                    for(int i = firstSpellIndex2; i < sevenRandomIndexes[0].indexOf(","); i++) {
                        nameOfSpell2 += sevenRandomIndexes[0].substring(i, i+1);
                    }
                    sevenRandomIndexes[0] = nameOfSpell2;*/
                }
            }
            if(secondIndexFlag == true) {
                secondIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[1] = main_deck_wizard_1_t1.get(secondIndex); 
                while(sevenRandomIndexes[1].getName() == "X") {
                    secondIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[1] = main_deck_wizard_1_t1.get(secondIndex); 
                }
            }
            if(thirdIndexFlag == true) {
                thirdIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[2] = main_deck_wizard_1_t1.get(thirdIndex); 
                while(sevenRandomIndexes[2].getName() == "X") {
                    thirdIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[2] = main_deck_wizard_1_t1.get(thirdIndex); 
                }
            }
            if(fourthIndexFlag == true) {
                fourthIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[3] = main_deck_wizard_1_t1.get(fourthIndex); 
                while(sevenRandomIndexes[3].getName() == "X") {
                    fourthIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[3] = main_deck_wizard_1_t1.get(fourthIndex); 
                }
            }
            if(fifthIndexFlag == true) {
                fifthIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[4] = main_deck_wizard_1_t1.get(fifthIndex); 
                while(sevenRandomIndexes[4].getName() == "X") {
                    fifthIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[4] = main_deck_wizard_1_t1.get(fifthIndex); 
                }
            }
            if(sixthIndexFlag == true) {
                sixthIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[5] = main_deck_wizard_1_t1.get(sixthIndex); 
                while(sevenRandomIndexes[5].getName() == "X") {
                    sixthIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[5] = main_deck_wizard_1_t1.get(sixthIndex); 
                }
            }
            if(seventhIndexFlag == true) {
                seventhIndex = (int)(Math.random() * 64);
                sevenRandomIndexes[6] = main_deck_wizard_1_t1.get(seventhIndex); 
                while(sevenRandomIndexes[6].getName() == "X") {
                    seventhIndex = (int)(Math.random() * 64);
                    sevenRandomIndexes[6] = main_deck_wizard_1_t1.get(seventhIndex); 
                }
            }
            System.out.println("Cards on display: " + sevenRandomIndexes[0].getName() + "," + sevenRandomIndexes[1].getName() + "," + sevenRandomIndexes[2].getName() + "," + sevenRandomIndexes[3].getName() + "," + sevenRandomIndexes[4].getName() + "," + sevenRandomIndexes[5].getName() + "," + sevenRandomIndexes[6].getName());
            System.out.println("First Index: " + firstIndex);
            System.out.println(sevenRandomIndexes[0].getName()); 
            String input = ""; 
            int noOfDiscards = 0; 
            Scanner sc = new Scanner(System.in); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[0].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(firstIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(firstIndex_, spell); 
                    tc_deck_size--;
                    System.out.println("Size Of TC Deck: " + tc_deck_size--);
                    sevenRandomIndexes[0].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(firstIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(firstIndex, spell);   
                    main_deck_size--;            
                    System.out.println("Size Of Main Deck: " + main_deck_size); 
                    sevenRandomIndexes[0].setName("X");
                }
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    firstIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[0] = tc_deck_wizard_1_t1.get(firstIndex_); 
                    System.out.println(sevenRandomIndexes[0].getName());
                    firstIndexFlag = false; 
                } else {
                    firstIndexFlag = true; 
                }
            } else {
                firstIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println(sevenRandomIndexes[1].getName()); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[1].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(secondIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(secondIndex_, spell);
                    tc_deck_size--;
                    System.out.println("Size of TC Deck: " + tc_deck_size); 
                    sevenRandomIndexes[1].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(secondIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(secondIndex, spell);
                    main_deck_size--;
                    System.out.println("Size of Main Deck: " + main_deck_size--); 
                    sevenRandomIndexes[1].setName("X");
                }
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    secondIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[1] = tc_deck_wizard_1_t1.get(firstIndex_); 
                    System.out.println(sevenRandomIndexes[1].getName());
                    secondIndexFlag = false; 
                } else {
                    secondIndexFlag = true; 
                }
            } else {
                secondIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println(sevenRandomIndexes[2].getName()); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[2].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(thirdIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(thirdIndex_, spell);
                    tc_deck_size--;
                    System.out.println("Size Of TC Deck: " + tc_deck_size); 
                    sevenRandomIndexes[2].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(thirdIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(thirdIndex, spell);
                    main_deck_size--;
                    System.out.println("Size Of Main Deck: " + main_deck_size); 
                    sevenRandomIndexes[2].setName("X");
                }                
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    thirdIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[2] = tc_deck_wizard_1_t1.get(thirdIndex_); 
                    System.out.println(sevenRandomIndexes[2].getName());
                    thirdIndexFlag = false; 
                } else {
                    thirdIndexFlag = true; 
                }
            } else {
                thirdIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println(sevenRandomIndexes[3].getName()); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[3].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(fourthIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(fourthIndex_, spell);
                    tc_deck_size--;
                    System.out.println("Size Of TC Deck: " + tc_deck_size); 
                    sevenRandomIndexes[3].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(fourthIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(fourthIndex, spell);
                    main_deck_size--;
                    System.out.println("Size Of Main Deck: " + main_deck_size); 
                    sevenRandomIndexes[3].setName("X");
                }      
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    fourthIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[3] = tc_deck_wizard_1_t1.get(fourthIndex_); 
                    System.out.println(sevenRandomIndexes[3].getName());
                    fourthIndexFlag = false; 
                } else {
                    fourthIndexFlag = true; 
                }
            } else {
                fourthIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println(sevenRandomIndexes[4].getName()); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[4].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(fifthIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(fifthIndex_, spell);
                    tc_deck_size--;
                    System.out.println("Size Of TC Deck: " + tc_deck_size); 
                    sevenRandomIndexes[4].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(fifthIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(fifthIndex, spell);
                    main_deck_size--;
                    System.out.println("Size Of Main Deck: " + main_deck_size); 
                    sevenRandomIndexes[4].setName("X");
                } 
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    fifthIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[4] = tc_deck_wizard_1_t1.get(fifthIndex_); 
                    System.out.println(sevenRandomIndexes[4].getName());
                    fifthIndexFlag = false; 
                } else {
                    fifthIndexFlag = true; 
                }
            } else {
                fifthIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println(sevenRandomIndexes[5].getName()); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[5].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(sixthIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(sixthIndex_, spell);
                    tc_deck_size--;
                    System.out.println("Size Of TC Deck: " + tc_deck_size); 
                    sevenRandomIndexes[5].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(sixthIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(sixthIndex, spell);
                    main_deck_size--;
                    System.out.println("Size Of Main Deck: " + main_deck_size); 
                    sevenRandomIndexes[5].setName("X");
                } 
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    sixthIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[5] = tc_deck_wizard_1_t1.get(sixthIndex_); 
                    System.out.println(sevenRandomIndexes[5].getName());
                    sixthIndexFlag = false; 
                } else {
                    sixthIndexFlag = true; 
                }
            }
            else {
                sixthIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println(sevenRandomIndexes[6].getName()); 
            System.out.println("discard/keep?"); 
            input = sc.nextLine(); 
            if(input.equals("discard")) {
                if(sevenRandomIndexes[6].getName().contains("TC")) {
                    Spell spell = tc_deck_wizard_1_t1.get(seventhIndex_);
                    spell.setName("X");
                    tc_deck_wizard_1_t1.set(seventhIndex_, spell);
                    tc_deck_size--;
                    System.out.println("Size Of TC Deck: " + tc_deck_size); 
                    sevenRandomIndexes[6].setName("X");
                } else {
                    Spell spell = main_deck_wizard_1_t1.get(seventhIndex);
                    spell.setName("X");
                    main_deck_wizard_1_t1.set(seventhIndex, spell);
                    main_deck_size--;
                    System.out.println("Size Of Main Deck: " + main_deck_size); 
                    sevenRandomIndexes[6].setName("X");
                } 
                noOfDiscards++; 
                String input2 = ""; 
                System.out.println("draw/nodraw?"); 
                input2 = sc.nextLine();
                if(input2.equals("draw")) {
                    seventhIndex_ = (int) (Math.random() * 36);
                    sevenRandomIndexes[6] = tc_deck_wizard_1_t1.get(seventhIndex_); 
                    System.out.println(sevenRandomIndexes[6].getName());
                    seventhIndexFlag = false; 
                } else {
                    seventhIndexFlag = true; 
                }
            }
            else {
                seventhIndexFlag = false; 
                System.out.println("Size Of Main Deck: " + main_deck_size); 
            }
            System.out.println("Number Of Discards: " + noOfDiscards); 
            boolean checker = true;
            while(checker) {
                System.out.print(sevenRandomIndexes[0].getName() + "," + sevenRandomIndexes[1].getName() + "," + sevenRandomIndexes[2].getName() + "," + sevenRandomIndexes[3].getName() + "," + sevenRandomIndexes[4].getName() + "," + sevenRandomIndexes[5].getName() + "," + sevenRandomIndexes[6].getName()); 
                System.out.println("select 1,2,3,4,5,6,7,pass");
                String selectInput = sc.nextLine(); 
                if(selectInput.equals("1")) {
                    System.out.println("Selected: " + sevenRandomIndexes[0].getName());
                    if(sevenRandomIndexes[0].getPips() <= pips) {
                        pips = pips - sevenRandomIndexes[0].getPips();
                        if(sevenRandomIndexes[0].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(firstIndex_);
                            spell.setName("X");
                            tc_deck_wizard_1_t1.set(firstIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(firstIndex);
                            spell.setName("X");
                            main_deck_wizard_1_t1.set(firstIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    }
                    else {
                        System.out.println("Pips: " + sevenRandomIndexes[0].getPips() + " > " + pips);
                        checker = true;
                    }
                    firstIndexFlag = true; 
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true; 
                    } else {
                        sixthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false; 
                    }
                }   
                else if(selectInput.equals("2")) {
                    System.out.println("Selected: " + sevenRandomIndexes[1].getName());
                    if(sevenRandomIndexes[1].getPips() <= pips) {
                        if(sevenRandomIndexes[1].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(secondIndex_);
                            spell.setName("X");
                            tc_deck_wizard_1_t1.set(secondIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(secondIndex);
                            spell.setName("X");
                            main_deck_wizard_1_t1.set(secondIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    } else {
                        System.out.println("Pips: " + sevenRandomIndexes[1].getPips() + " > " + pips);
                    }
                   
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false;
                    }
                    secondIndexFlag = true; 
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true; 
                    } else {
                        sixthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false; 
                    }
                }  
                else if(selectInput.equals("3")) {
                    System.out.println("Selected: " + sevenRandomIndexes[2].getName());
                    if(sevenRandomIndexes[2].getPips() <= pips) {
                        if(sevenRandomIndexes[2].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(thirdIndex_);
                            tc_deck_wizard_1_t1.set(thirdIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(thirdIndex);
                            spell.setName("X");
                            main_deck_wizard_1_t1.set(thirdIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    } else {
                        checker = true;
                        System.out.println("Pips: " + sevenRandomIndexes[2].getPips() + " > " + pips);
                    }
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false;
                    }
                    thirdIndexFlag = true; 
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true; 
                    } else {
                        sixthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false; 
                    }
                }  
                else if(selectInput.equals("4")) {
                    System.out.println("Selected: " + sevenRandomIndexes[3].getName());
                    if(sevenRandomIndexes[3].getPips() <= pips) {
                        if(sevenRandomIndexes[3].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(fourthIndex_);
                            tc_deck_wizard_1_t1.set(fourthIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(fourthIndex);
                            spell.setName("X");
                            main_deck_wizard_1_t1.set(fourthIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    } else {
                        checker = true;
                        System.out.println("Pips: " + sevenRandomIndexes[3].getPips() + " > " + pips);
                    }
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false;
                    }
                    fourthIndexFlag = true; 
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true;
                    } else {
                        sixthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false; 
                    }
                }  
                else if(selectInput.equals("5")) {
                    System.out.println("Selected: " + sevenRandomIndexes[4].getName());
                    if(sevenRandomIndexes[4].getPips() <= pips) {
                        if(sevenRandomIndexes[4].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(fifthIndex_);
                            spell.setName("X");
                            tc_deck_wizard_1_t1.set(fifthIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(fifthIndex);
                            main_deck_wizard_1_t1.set(fifthIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    } else {
                        checker = true;
                        System.out.println("Pips: " + sevenRandomIndexes[4].getPips() + " > " + pips);
                    }
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false;
                    }
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    }                
                    fifthIndexFlag = true;
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true;
                    } else {
                        sixthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false; 
                    }
                }  
                else if(selectInput.equals("6")) {
                    System.out.println("Selected: " + sevenRandomIndexes[5].getName());
                    if(sevenRandomIndexes[5].getPips() <= pips) {
                        if(sevenRandomIndexes[5].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(sixthIndex_);
                            spell.setName("X");
                            tc_deck_wizard_1_t1.set(sixthIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(sixthIndex);
                            spell.setName("X");
                            main_deck_wizard_1_t1.set(sixthIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    } else {
                        checker = true;
                        System.out.println("Pips: " + sevenRandomIndexes[5].getPips() + " > " + pips);
                    }
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false;
                    }
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    sixthIndexFlag = true; 
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false; 
                    }
                }  
                else if(selectInput.equals("7")) {
                    System.out.println("Selected: " + sevenRandomIndexes[6].getName());
                    if(sevenRandomIndexes[6].getPips() <= pips) {
                        if(sevenRandomIndexes[6].getName().contains("TC")) {
                            checker = false;
                            Spell spell = tc_deck_wizard_1_t1.get(seventhIndex_);
                            spell.setName("X");
                            tc_deck_wizard_1_t1.set(seventhIndex_, spell);
                            tc_deck_size--;
                            System.out.println("Size Of TC Deck: " + tc_deck_size); 
                        } else {
                            checker = false;
                            Spell spell = main_deck_wizard_1_t1.get(seventhIndex);
                            spell.setName("X");
                            main_deck_wizard_1_t1.set(seventhIndex, spell);
                            main_deck_size--;
                            System.out.println("Size Of Main Deck: " + main_deck_size); 
                        } 
                    } else {
                        checker = true;
                        System.out.println("Pips: " + sevenRandomIndexes[6].getPips() + " > " + pips);
                    }
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false;
                    }
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    } 
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true;
                    } else {
                        sixthIndexFlag = false; 
                    }
                    seventhIndexFlag = true; 
                }
                else if(selectInput.equals("pass")) {
                    if(sevenRandomIndexes[0].getName().equals("X")) {
                        firstIndexFlag = true; 
                    } else {
                        firstIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[1].getName().equals("X")) {
                        secondIndexFlag = true; 
                    } else {
                        secondIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[2].getName().equals("X")) {
                        thirdIndexFlag = true; 
                    } else {
                        thirdIndexFlag = false;
                    }
                    if(sevenRandomIndexes[3].getName().equals("X")) {
                        fourthIndexFlag = true; 
                    } else {
                        fourthIndexFlag = false; 
                    } 
                    if(sevenRandomIndexes[4].getName().equals("X")) {
                        fifthIndexFlag = true; 
                    } else {
                        fifthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[5].getName().equals("X")) {
                        sixthIndexFlag = true;
                    } else {
                        sixthIndexFlag = false; 
                    }
                    if(sevenRandomIndexes[6].getName().equals("X")) {
                        seventhIndexFlag = true; 
                    } else {
                        seventhIndexFlag = false;
                    }
                    checker = false; 
                }
            }
            
            pips += 2;
        }
    }
}