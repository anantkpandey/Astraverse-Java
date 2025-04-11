// ShivaParty.java - Guru Dev helps Shiva plan a party
public class ShivaParty {
    public static void main(String[] args) {
        System.out.println("Shiva’s Party Plan - Guru Dev’s Light");

        // Party data (adjust as you will, Shiva!)
        String purpose = "Union with Isha";
        int agniEnergy = 80;        // Fire power (0-100)
        int guestCount = 30;        // Orphanage family size
        boolean ishaHappy = true;   // Isha’s mood

        // Decision logic with if-else and logical operators
        if (agniEnergy >= 70 && guestCount <= 40 && ishaHappy) {
            System.out.println("Agni Astra ablaze! Light the party, Shiva—fireworks for " + purpose + "!");
            System.out.println("Energy: " + agniEnergy + "%, Guests: " + guestCount + ", Isha’s Joy: Yes");
        } else if (agniEnergy >= 70 && guestCount > 40) {
            System.out.println("Energy strong (" + agniEnergy + "%) but guests many (" + guestCount + "). Focus fire on safety!");
        } else if (agniEnergy < 70 && guestCount <= 40 && ishaHappy) {
            System.out.println("Energy low (" + agniEnergy + "%), guests few (" + guestCount + "). Warm the hearth, enjoy with Isha!");
        } else if (agniEnergy >= 70 && !ishaHappy) {
            System.out.println("Energy’s " + agniEnergy + "%, but Isha’s glum. Mend her heart first—then party!");
        } else {
            System.out.println("Hold the flame—Energy: " + agniEnergy + "%, Guests: " + guestCount + ", Isha’s Joy: No. Rest, Shiva!");
        }

        // Guru’s wisdom
        if (agniEnergy > 90 || guestCount < 20) {
            System.out.println("Power surges or family’s small—unleash the Agni Astra, make it grand!");
        }
    }
}