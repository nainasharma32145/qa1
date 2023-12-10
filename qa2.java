import java.util.*;

public class Monster {
    private String eyeColor;
    private String featherColor;
    private String magicalAbilities;
    private int size;
    private int strength;
    private int durability;
    private String weakness;
    private int aggressionLevel;

    public Monster(String eyeColor, String featherColor, String magicalAbilities,
                   int size, int strength, int durability, String weakness,
                   int aggressionLevel) {
        this.eyeColor = eyeColor;
        this.featherColor = featherColor;
        this.magicalAbilities = magicalAbilities;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.aggressionLevel = aggressionLevel;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public String getMagicalAbilities() {
        return magicalAbilities;
    }

    public int getSize() {
        return size;
    }

    public int getStrength() {
        return strength;
    }

    public int getDurability() {
        return durability;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getAggressionLevel() {
        return aggressionLevel;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "eyeColor='" + eyeColor + '\'' +
                ", featherColor='" + featherColor + '\'' +
                ", magicalAbilities='" + magicalAbilities + '\'' +
                ", size=" + size +
                ", strength=" + strength +
                ", durability=" + durability +
                ", weakness='" + weakness + '\'' +
                ", aggressionLevel=" + aggressionLevel +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        List<Monster> monsters = new ArrayList<>();

        System.out.println("Enter the number of monsters:");
        int numMonsters = scanner.nextInt();

        for (int i = 0; i < numMonsters; i++) {
            System.out.println("Enter traits for Monster " + (i + 1) + ":");
            
            System.out.println("Eye color:");
            String eyeColor = scanner.next();

            System.out.println("Feather color:");
            String featherColor = scanner.next();

            System.out.println("Magical abilities:");
            String magicalAbilities = scanner.next();

            System.out.println("Size:");
            int size = scanner.nextInt();

            System.out.println("Strength:");
            int strength = scanner.nextInt();

            System.out.println("Durability:");
            int durability = scanner.nextInt();

            System.out.println("Weakness:");
            String weakness = scanner.next();

            System.out.println("Aggression level:");
            int aggressionLevel = scanner.nextInt();

            Monster monster = new Monster(
                    eyeColor, featherColor, magicalAbilities,
                    size, strength, durability, weakness, aggressionLevel
            );

            monsters.add(monster);
        }

        MonsterBreeder monsterBreeder = new MonsterBreeder(monsters);

        List<Monster> babyMonsters = monsterBreeder.createUniqueBabyMonsters();

        for (Monster babyMonster : babyMonsters) {
            System.out.println("Baby Monster created: " + babyMonster.toString());
        }
    }
}

class MonsterBreeder {
    private List<Monster> monsters;

    public MonsterBreeder(List<Monster> monsters) {
        this.monsters = new ArrayList<>(monsters);
    }

    public List<Monster> createUniqueBabyMonsters() {
        List<Monster> babyMonsters = new ArrayList<>();

        for (int i = 0; i < monsters.size(); i++) {
            for (int j = i + 1; j < monsters.size(); j++) {
                Monster parent1 = monsters.get(i);
                Monster parent2 = monsters.get(j);

                Monster babyMonster = createBabyMonster(parent1, parent2);

                if (!monsters.contains(babyMonster) && !babyMonsters.contains(babyMonster)) {
                    babyMonsters.add(babyMonster);
                }
            }
        }

        return babyMonsters;
    }

    private Monster createBabyMonster(Monster parent1, Monster parent2) {
        return new Monster(
                getRandomTrait(parent1.getEyeColor(), parent2.getEyeColor()),
                getRandomTrait(parent1.getFeatherColor(), parent2.getFeatherColor()),
                getRandomTrait(parent1.getMagicalAbilities(), parent2.getMagicalAbilities()),
                getRandomTrait(parent1.getSize(), parent2.getSize()),
                getRandomTrait(parent1.getStrength(), parent2.getStrength()),
                getRandomTrait(parent1.getDurability(), parent2.getDurability()),
                getRandomTrait(parent1.getWeakness(), parent2.getWeakness()),
                getRandomTrait(parent1.getAggressionLevel(), parent2.getAggressionLevel())
        );
    }

    private <T> T getRandomTrait(T trait1, T trait2) {
        Random random = new Random();
        return random.nextBoolean() ? trait1 : trait2;
    }
}
