import java.util.Random;

public class Main {

    public static void main(String[] args) {


        RedBlackTree<Integer, Double> treeID = new RedBlackTree<>();
        RedBlackTree<Double, Double> treeDD = new RedBlackTree<>();
        RedBlackTree<Integer,Integer> treeII = new RedBlackTree<>();

        addRandomValuesII(treeII,1000,5000, 7000);
        addRandomValuesDD(treeDD,2000,4500,350);
        addRandomValuesID(treeID,1500,4000,50);

        setTest(treeII);
    }

    private static void setVWithTime(RedBlackTree<Integer, Integer> tree, int n) {
        long start = System.nanoTime();
        tree.setValue(n, n);
        long nanoTime = System.nanoTime() - start;
                System.out.println(nanoTime);
    }

    private static void getVWithTime(RedBlackTree<Integer, Integer> tree, int n) {
        tree.setValue(n, n);
        long start = System.nanoTime();
        tree.getValue(n);
        long nanoTime = System.nanoTime() - start;
        System.out.println(nanoTime);
    }

    private static void setTest(RedBlackTree<Integer, Integer> tree) {

        Random generator = new Random();

        for (int i = 0; i < 1000; i++) {
            setVWithTime(tree, generator.nextInt(1000));
        }
    }

    public static void printII(RedBlackTree treeII){
        System.out.println("Drzewo czerwono-czarne o kluczach Integer, zawierające wartości Integer");
        System.out.println("_______________________________________________________________________");
        treeII.print();
    }

    public static void printDD(RedBlackTree treeDD){
        System.out.println("Drzewo czerwono-czarne o kluczach Double, zawierające wartości Double");
        System.out.println("_______________________________________________________________________");
        treeDD.print();
    }

    public static void printID(RedBlackTree treeID){
        System.out.println("Drzewo czerwono-czarne o kluczach Integer, zawierające wartości Double");
        System.out.println("_______________________________________________________________________");
        treeID.print();
    }

    public static void addRandomValuesII(RedBlackTree treeII, int howMany, int keysRange, int valuesRange){
        Random generator = new Random();

        for (int i = 0; i < howMany; i++) {
            treeII.setValue(generator.nextInt(keysRange), generator.nextInt(valuesRange));
        }
    }

    public static void addRandomValuesDD(RedBlackTree treeDD, int howMany, int keysRange, int valuesRange){
        Random generator = new Random();

        for (int i = 0; i < howMany; i++) {
            treeDD.setValue(generator.nextDouble()%keysRange, generator.nextDouble()%valuesRange);
        }
    }

    public static  void addRandomValuesID(RedBlackTree treeID, int howMany, int keysRange, int valuesRange){
        Random generator = new Random();

        for (int i = 0; i < howMany; i++) {
            treeID.setValue(generator.nextInt(keysRange), generator.nextDouble()%valuesRange);
        }
    }
}