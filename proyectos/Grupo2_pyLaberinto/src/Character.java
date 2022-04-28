package src;

public class Character{
    
    private string name;
    private string CharacterRep;

    public Character(string name, string CharacterRep){
        this.name = name;
        this.CharacterRep = CharacterRep;
    }

    public void move(Position position, int velocity){

    }

    public string choose(string option){
        boolean boat = false;
        boolean horse = false;
        boolean flyingCarpet = false;

        if (option == "h") {
            if (boat == true || flyingCarpet == true) {
                boat = false;
                flyingCarpet = false;
            }
            horse = !horse;
        } else if (option == "b") {
            if (horse == true || flyingCarpet == true) {
                horse = false;
                flyingCarpet = false;
            }
            boat = !boat;
        } else if (option == "c") {
            if (boat == true || horse == true) {
                boat = false;
                horse = false;
            }
            flyingCarpet = !flyingCarpet;
        }

        if (boat == false && horse == false && flyingCarpet == false) {
            selectedCharacter = "_O_";
        } else if (boat == true) {
            selectedCharacter = ":_;";
        } else if (horse == true) {
            selectedCharacter = "_/*";
        } else if (flyingCarpet == true) {
            selectedCharacter = "|_|";
        }
        
        return selectedCharacter;
    }
}