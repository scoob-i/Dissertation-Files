import java.util.Random;

public class MyGA {

    public static final String TARGET = "Enter target string";
    public static final int POP_SIZE = 1000;
    Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int totalFitness;
    int generationCount = 0;
    double mutationRate = 0.01;


    public static void main(String[] args) throws InterruptedException {

        GUI gui = new GUI();
        Random rn = new Random();
        MyGA run = new MyGA();
        run.population.initializePopulation(POP_SIZE);
        run.population.calculateFitness();
        System.out.println("Gen: " + run.generationCount + " Fittest: " + run.population.fittest);

        int maxFitness = (int) Math.pow(TARGET.length(), 4);
        while (run.population.fittest < maxFitness) {
            ++run.generationCount;

            run.selection();
            run.crossover();
            run.mutation();
            run.population.calculateFitness();

            gui.updateGUI(run.population.fittestString, run.generationCount);

            System.out.println("Gen: " + run.generationCount + " Fittest: " + run.population.fittest + ", " + run.population.fittestString);
        }

        System.out.println("\nSolution found in generation " + run.generationCount);
        System.out.println("Fitness: "+run.population.getFittest().fitness);
        System.out.print("Genes: ");
        System.out.print(run.population.getFittest().genes);

        System.out.println("");

    }

    void getTop() {
        fittest = population.getFittest();
        secondFittest = population.getSecondFittest();

    }


    void selection() {
        Random rn = new Random();
        population.getFittest();
        totalFitness = population.totalFitness();
        Individual[] temp = new Individual[POP_SIZE];

        for (int i = 0; i < POP_SIZE; i++) {
            int goal = rn.ints(1, totalFitness + 1).findFirst().getAsInt();
            int total = 0;
            for (int j = 0; j < POP_SIZE; j++) {
                total += population.individuals[j].fitness * 2;
                if (total >= goal) {
                    temp[i] = population.individuals[j];
                    break;
                }
            }
        }

        for (int i = 0; i < POP_SIZE; i++){
            if (i % 20 == 0){
                population.individuals[i].genes = population.fittestString;
            } else {
                population.individuals[i] = temp[i];
            }

        }
    }


    void crossover() {
        for (int i = 0; i < POP_SIZE; i++){
            if (i % 2 == 0){
                String s1 = population.individuals[i].genes;
                String s2 = population.individuals[i+1].genes;
                String c1;
                String c2;

                Random rn = new Random();

                int XPoint = rn.nextInt(population.individuals[0].geneLength);

                String s1p1 = s1.substring(0, XPoint);
                String s1p2 = s1.substring(XPoint);

                String s2p1 = s2.substring(0, XPoint);
                String s2p2 = s2.substring(XPoint);


                c1 = s1p1 + s2p2 ;
                c2 = s2p1 + s1p2 ;
                population.individuals[i].genes = c1;
                population.individuals[i+1].genes = c2;
            }
        }
    }

    void mutation(){
        Random rn = new Random();

        for (int i = 0; i < POP_SIZE; i++){
            if (rn.nextDouble() < mutationRate){
                String randomLetter = rn.ints(32, 123).limit(1)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

                int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

                String temp = population.individuals[i].genes;

                String newGenes = temp.substring(0,mutationPoint)+randomLetter+temp.substring(mutationPoint+1);
                population.individuals[i].genes = newGenes;
            }
        }
    }
}

class Individual implements Cloneable{

    public static final String TARGET = "Enter target string";
    int fitness = 0;
    int geneLength = TARGET.length();
    String genes = ""; 


    public Individual() {
        Random rn = new Random();
        int leftLimit = 32; // letter 'A'
        int rightLimit = 122; // letter 'z'

        genes = rn.ints(leftLimit, rightLimit + 1)
                .limit(geneLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        fitness = 0;
    }

    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < geneLength; i++) {
            if (genes.charAt(i) == TARGET.charAt(i)) {
                ++fitness;
            }
        }
        fitness = (int) Math.pow(fitness, 4);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Individual individual = (Individual)super.clone();
        individual.genes = this.genes;
        return individual;
    }
}

class Population {

    public static final int POP_SIZE = 1000;
    Individual[] individuals = new Individual[POP_SIZE];
    int fittest  = 0;
    String fittestString = "";

    public void initializePopulation(int size){
        for (int i = 0; i < individuals.length; i++){
            individuals[i] = new Individual();
        }
    }

    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitNum = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitNum = i;
            }
        }
        fittest = individuals[maxFitNum].fitness;
        fittestString = individuals[maxFitNum].genes;
        try {
            return (Individual) individuals[maxFitNum].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Individual getSecondFittest() {
        int maxFit = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitness > individuals[maxFit].fitness) {
                maxFit2 = maxFit;
                maxFit = i;
            } else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        try {
            return (Individual) individuals[maxFit2].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void calculateFitness() {
        for (int i = 0; i< individuals.length; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
    }

    public int totalFitness(){
        int sum = 0;
        for (int i = 0; i< individuals.length; i++) {
            sum += individuals[i].fitness;
        }
        return sum;
    }

}