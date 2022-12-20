import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) {
    char [] wordArray = wordDissection();
    looptyloop(gallows,wordArray);

    }

    public static void looptyloop(String [] gallows,char [] wordArray){
        char [] missedArray = new char[6];
        char [] convertedArray =convertTo_(wordArray);
        //Loop commence
        for (int i = 0; i<6;) {
            if (Arrays.equals(wordArray, convertedArray)) {
                printGallows(i, gallows, convertedArray);
                wordsNmisses(convertedArray, missedArray);
                System.out.println("\nYou win!");
                i=6;
                break;
            }
            printGallows(i, gallows, convertedArray);
            wordsNmisses(convertedArray, missedArray);
            char guess = currentGuess(convertedArray);
            for (int j = 0; j < wordArray.length; j++) {
                if (wordArray[j] == guess) {
                    convertedArray[j] = wordArray[j];
                    break;
                } else if (!Objects.equals(wordArray[j], guess)) {
                    if (j == wordArray.length -1) {
                        missedArray[i] = guess;
                        i++;
                        if (i == 6) {
                            printGallows(6, gallows, convertedArray);
                            wordsNmisses(convertedArray, missedArray);
                            System.out.println("\nRIP!");
                            System.out.println("The word was: '"+  new String(wordArray) +"'");
                        }
                        break;
                    }
                }
            }
        }
    }



    private static void wordsNmisses(char[] convertedArray, char[] missedArray) {
        System.out.print("Words: ");
        for (int i = 0; i < convertedArray.length; i++) {
            System.out.print(convertedArray[i] + " ");
        }
        System.out.print("\nMisses: ");
        for (int i = 0; i < 6 ; i++) {
            if (missedArray[i] != '\0') {
                System.out.print(missedArray[i] + " ");
            }

        }System.out.print("\n");
    }
    private static char currentGuess(char [] convertedArray) {
        System.out.print("Guess: ");
        char guess = input.next().charAt(0);
        System.out.println("\n");
        return Character.toLowerCase(guess);
    }

    public static char[] wordDissection(){
        String word = wordSelect(words);
        int length = word.length();
        char [] wordArray = new char[length];
        for (int i = 0; i < length ; i++) {
            wordArray[i] = word.charAt(i) ;
        }
        return wordArray;
    }

    public static char[] convertTo_(char[] wordArray){
        char[] convertedArray = new char[wordArray.length];
        for (int i = 0; i < wordArray.length ; i++) {
            convertedArray[i] = '_';
        }
        return convertedArray;
    }
    public static String wordSelect(String[] words){
        int wordNumber = rand.nextInt(64+1);
        return words[wordNumber];
    }

    public static void printGallows(int i,String[] gallows, char[] convertedArray){
        System.out.println(gallows[i]);
    }
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static String[] gallows =
            {"+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

                    "+---+\n" +
                            "|   |\n" +
                            "O   |\n" +
                            "    |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n",

                    "+---+\n" +
                            "|   |\n" +
                            "O   |\n" +
                            "|   |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|   |\n" +
                            "     |\n" +
                            "     |\n" +
                            " =========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                            "     |\n" +
                            "     |\n" +
                            " =========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +
                            "/    |\n" +
                            "     |\n" +
                            " =========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +
                            "/ \\  |\n" +
                            "     |\n" +
                            " =========\n"};
}

