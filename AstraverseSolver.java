import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AstraverseSolver {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome, Protagonist of Astraverse!");
        System.out.println("Your folks are facing a dire problem. What information can you provide?");

        // Gather information about the problem
        String problemDescription = getProblemDescription();
        List<Resource> availableResources = getAvailableResources();
        List<Skill> protagonistSkills = getProtagonistSkills();

        System.out.println("\nAnalyzing the situation...");

        // Attempt to find a solution based on available information
        SolutionFinder solver = new SolutionFinder(problemDescription, availableResources, protagonistSkills);
        String solution = solver.findSolution();

        if (solution != null && !solution.isEmpty()) {
            System.out.println("\nSolution found!");
            System.out.println("Here's a possible way to help your folks:");
            System.out.println("---------------------------------------");
            System.out.println(solution);
            System.out.println("---------------------------------------");
            System.out.println("Go forth and bring hope to Astraverse!");
        } else {
            System.out.println("\nNo immediate solution found based on the information provided.");
            System.out.println("Perhaps gathering more information or utilizing different skills might be necessary.");
            System.out.println("The fate of your folks rests in your hands, Protagonist!");
        }

        scanner.close();
    }

    private static String getProblemDescription() {
        System.out.print("Describe the problem your folks are facing: ");
        return scanner.nextLine();
    }

    private static List<Resource> getAvailableResources() {
        List<Resource> resources = new ArrayList<>();
        System.out.print("Enter any available resources (e.g., 'healing herbs, ancient texts', or type 'none'): ");
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("none") && !input.isEmpty()) {
            String[] resourceNames = input.split(",");
            for (String name : resourceNames) {
                resources.add(new Resource(name.trim()));
            }
        }
        return resources;
    }

    private static List<Skill> getProtagonistSkills() {
        List<Skill> skills = new ArrayList<>();
        System.out.print("Enter your known skills (e.g., 'combat, healing, knowledge of lore', or type 'none'): ");
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("none") && !input.isEmpty()) {
            String[] skillNames = input.split(",");
            for (String name : skillNames) {
                skills.add(new Skill(name.trim()));
            }
        }
        return skills;
    }
}

// Represents a resource available to the protagonist
class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Represents a skill possessed by the protagonist
class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Class responsible for analyzing the problem and suggesting a solution
class SolutionFinder {
    private String problemDescription;
    private List<Resource> availableResources;
    private List<Skill> protagonistSkills;

    public SolutionFinder(String problemDescription, List<Resource> availableResources, List<Skill> protagonistSkills) {
        this.problemDescription = problemDescription.toLowerCase();
        this.availableResources = availableResources;
        this.protagonistSkills = protagonistSkills;
    }

    public String findSolution() {
        // This is a very basic and illustrative solution finder.
        // In a real game, this would involve much more complex logic,
        // potentially using AI or rule-based systems.

        if (problemDescription.contains("sickness") || problemDescription.contains("plague")) {
            if (hasResource("healing herbs") && hasSkill("healing")) {
                return "Use your knowledge of healing and the available healing herbs to treat the sick.";
            } else if (hasSkill("knowledge of lore") && problemDescription.contains("ancient remedies")) {
                return "Consult ancient texts for forgotten remedies.";
            } else if (hasSkill("persuasion") && hasResource("trade goods")) {
                return "Use your trade goods to barter for medicine or help from a neighboring settlement.";
            } else {
                return "Focus on isolating the sick and searching for any known remedies or assistance.";
            }
        } else if (problemDescription.contains("attack") || problemDescription.contains("threat") || problemDescription.contains("monster")) {
            if (hasSkill("combat")) {
                return "Utilize your combat skills to defend your folks against the threat.";
            } else if (hasSkill("strategy") && availableResources.size() > 0) {
                return "Devise a strategic plan using the available resources to defend your community.";
            } else if (hasSkill("stealth") && problemDescription.contains("scout")) {
                return "Use your stealth to scout the enemy's weaknesses and plan an ambush.";
            } else {
                return "Warn the others and prepare defenses as best as you can.";
            }
        } else if (problemDescription.contains("famine") || problemDescription.contains("hunger")) {
            if (hasSkill("hunting") || hasSkill("farming")) {
                return "Focus on gathering food through hunting or cultivating the land.";
            } else if (hasResource("seeds") && hasSkill("farming")) {
                return "Plant the available seeds to ensure a future food supply.";
            } else if (hasSkill("negotiation") && hasResource("valuable items")) {
                return "Attempt to negotiate for food with neighboring communities using your valuable items.";
            } else {
                return "Organize a search party for any available food sources in the surrounding areas.";
            }
        } else if (problemDescription.contains("lost artifact") || problemDescription.contains("stolen item")) {
            if (hasSkill("tracking")) {
                return "Use your tracking skills to follow the trail of the lost or stolen item.";
            } else if (hasSkill("investigation") && hasResource("clues")) {
                return "Investigate the available clues to piece together the whereabouts of the artifact.";
            } else if (hasSkill("persuasion") && problemDescription.contains("witnesses")) {
                return "Speak with potential witnesses to gather information.";
            } else {
                return "Organize a search party and spread the word about the lost item.";
            }
        }

        return "The problem is unclear, or your skills and resources don't immediately suggest a solution. Gather more information or try a different approach.";
    }

    private boolean hasResource(String resourceName) {
        for (Resource resource : availableResources) {
            if (resource.getName().toLowerCase().contains(resourceName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSkill(String skillName) {
        for (Skill skill : protagonistSkills) {
            if (skill.getName().toLowerCase().contains(skillName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
