import java.io.*;
import java.util.Random;
import java.util.stream.Stream;
class KBC 
{
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static Random r = new Random();
static int stage,amount,life, aud = 0, phn = 0, expt = 0, ddip = 0, ddip1 = 0, correct, c;
static String s1,opt;
static int a[] = {5000, 10000, 20000, 40000, 80000, 160000, 320000, 640000, 1250000, 2500000, 5000000, 10000000, 50000000};
static String s[] = {"1 : Audience poll", "2 : Phone a friend", "3 : Expert Advice", "4 : Double dip"};
static int in = 0;
static int fin = 0;
public static void printMsgWithProgressBar(String message, int length, long timeinterval) {
char incomplete = '-';
char complete = '#';
StringBuilder builder = new StringBuilder();
Stream.generate(() -> incomplete).limit(length).forEach(builder::append);
System.out.println(message);
for(int i = 0; i < length; i++) 
{
builder.replace(i, i + 1, String.valueOf(complete));
String progressBar = "\r" + builder;
System.out.print(progressBar);
try 
{
Thread.sleep(timeinterval);
} 
catch (InterruptedException ignored)
{
}
}
System.out.println();
}
public static void main(String[] args) throws IOException 
{
printMsgWithProgressBar("Loading", 100, 100);
display();
database();
}
static void display() throws IOException {
System.out.println("\n\t\tWelcome to Kaun Banega Crorepati (Computerized version 1.0)");
System.out.println("\n\t\tThis version is similar to the original game");
System.out.println("\t\tYou'll have to answer 13 questions to win 5 crore rupees\n");
for (int i = 1; i <= 13; i++)
{
System.out.println(i + " <> Rs. " + a[i - 1]);
}
System.out.println();
        stageset();
        System.out.println("\nIn addition to this, you'll have 4 lifelines to assist you\n");
        System.out.println(s[0] + " : Will help you to take audience's opinion");
        System.out.println(s[1] + " : Will enable you to call your friend for the answer");
        System.out.println(s[2] + " : Ask the experts for their advice");
        System.out.println(s[3] + " : Will allow you to give two answers for the same question");
        System.out.println("\nWarning : If you use double dip, you'll not be able to quit the game or use another lifeline");
    }

    static void stageset() throws IOException {
        System.out.print("\nPlease set a stage (Enter question number) : ");
        stage = Integer.parseInt(br.readLine());
        if (stage >= 1 && stage <= 13) {
            System.out.println("\nYou have selected : " + stage + " <> Rs. " + a[stage - 1]);
            System.out.print("\n\nAre you sure (Y/N) : ");
            String c = br.readLine();
            if (!c.equalsIgnoreCase("Y")) stageset();
        } else {
            System.out.println("\nInvalid input. Please enter again.\n");
            stageset();
        }
    }

    static void controls() throws IOException {
        System.out.println("\n\nEnter choices as A B C D");
        System.out.println("Enter 'L' to choose a life-line");
        System.out.println("Enter 'Q' to quit");
        System.out.print("\n\nEnter any key to clear the screen and continue : ");
        s1 = br.readLine();
        System.out.print("\f");
    }

    static void play() throws IOException {
        System.out.print("\n\nEnter your choice : ");
        opt = br.readLine();
        switch (opt.substring(0, 1).toUpperCase()) {
            case "A":
                c = 1;
                break;
            case "B":
                c = 2;
                break;
            case "C":
                c = 3;
                break;
            case "D":
                c = 4;
                break;
            case "L":
                lifeline();
                if (ddip1 == 0) play();
                ddip1 = 0;
                break;
            case "Q":
                quit();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                play();
                break;
        }
    }

    static void lifeline() throws IOException {
        System.out.println("\nYou have the following lifelines left : ");
        for (String lifeline : s) System.out.println(lifeline + "  ");
        System.out.print("\n\nWhich one would you like to use (Enter number) : ");
        life = Integer.parseInt(br.readLine());
        switch (life) {
            case 1:
                audience();
                break;
            case 2:
                phone();
                break;
            case 3:
                expert();
                break;
            case 4:
                dip();
                break;
            default:
                System.out.println("\nThis life line is not available");
                lifeline();
        }
    }

    static void database() throws IOException {
        int cont = 1;
        System.out.println("Stage : " + cont + " <> " + a[0] + "\n\n");
        System.out.println("A group of bits is commonly called as one byte ");
        System.out.println("\n\nA: Six bits\t\tB: Eight bits\nC: Twelve bits\t\tD: Fifteen bits");
        correct = 2;
        play();
        if (correct == c) {
            in = a[0];
            System.out.println("\nWell done. Correct answer.");
            if (stage == 1) {
                fin = in;
                System.out.println("\n\nCongratulations, you have completed your desired stage successfully");
            }
        } else {
            System.out.println("\nSorry, but this is the wrong answer");
            System.out.println("\n\nCorrect answer is B: Eight bits");
            end();
        }
        continueGame(cont, "The Third Generation computer used ",
                "A: Transistors\t\tB: Integrated Circuit\nC: Vacuum tube\t\tD: Chip", 2, a[1]);
        continueGame(cont, "Which one is the first fully supported 64-bit operating system?",
                "A: Windows Vista \t\tB: Mac\nC: Linux\t\tD: Windows XP", 3, a[2]);
        continueGame(cont, "Which of the following is an output device: ",
                "A: Keyboard\t\tB: Joy Stick \nC: Printer\t\tD: None of the above", 3, a[3]);
        continueGame(cont, "Which of the following is an input device: ",
                "A: Monitor\t\tB: Mouse\nC: Hard Disk McAleese\t\tD: Printer", 2, a[4]);
        continueGame(cont, "Which of the following is used to store data in the computer?: ",
                "A: Hard Disks \t\tB: CPU\nC: Monitor\t\tD: None of the above", 1, a[5]);
        continueGame(cont, "Which of the following is referred to as the brain of a computer? : ",
                "A: RAM\t\tB: ROM\nC: Monitor\t\tD: CPU", 4, a[6]);
        continueGame(cont, "What is the full form of the CPU? : ",
                "A: Central Program Unit\t\tB: Central Programming Unit\nC: Central Processing unit \t\tD: Centralized Processing Unit", 3, a[7]);
        continueGame(cont, "What makes the 5th generation computer different from previous generations? : ",
                "A:Object-Oriented Programming \t\tB: Scientific Code\nC: Technological Advancement\t\tD: All the Above", 3, a[8]);
        continueGame(cont, "Which of the following computer language used for artificial intelligence? : ",
                "A: PROLOG\t\tB: C.FORTRAN\nC: C\t\tD:COBOL", 1, a[9]);
        continueGame(cont, "Which of the following is referred to as volatile memory? : ",
                "A: ROM\t\tB: RAM\nC: HDs \t\tD: CDs", 2, a[10]);
        continueGame(cont, "A large computer system frequently makes use of ? : ",
                "A: Line Printers\t\tB: Ink-jet printers\nC: Dot-matrix printers\t\tD: Daisy wheel printers", 1, a[11]);
        continueGame(cont, "The characteristics of first-generation computer include? : ",
                "A: Vacuum tubes and magnetic drum \t\tB: Minicomputers\nC: Magnetic tape and transistors\t\tD: None of the above", 1, a[12]);

        System.out.print("\f");
        for (int i = 1; i <= 3; i++) {
            System.out.print(" ");
        }
        System.out.print("\n");
        for (int i = 1; i <= 80; i++) {
            System.out.print("=");
        }
        System.out.print("\n");
        System.out.print("You have won the Game\n");
        for (int i = 1; i <= 80; i++) {
            System.out.print("=");
        }
        System.out.print("\n");
    }

    static void continueGame(int cont, String question, String options, int correctAnswer, int reward) throws IOException {
        cont++;
        System.out.println("\nStage : " + cont + " <> " + reward + "\n\n");
        System.out.println(question);
        System.out.println("\n\n" + options);
        correct = correctAnswer;
        play();
        if (correct == c) {
            in = reward;
            System.out.println("\nWell done. Correct answer.");
            if (stage == cont) {
                fin = in;
                System.out.println("\n\nCongratulations, you have completed your desired stage successfully");
            }
        } else {
            System.out.println("\nSorry, but this is the wrong answer");
            end();
        }
    }

    static void end() throws IOException {
        if (fin == 0) {
            System.out.println("Sorry, you haven't won any amount of money");
        } else {
            System.out.println("You have won : Rs. " + fin);
        }
        System.out.print("Would you like to try again (Y/N) : ");
        s1 = br.readLine();
        if (s1.equalsIgnoreCase("Y")) {
            main(null);
        } else {
            System.exit(0);
        }
    }

    static void audience() throws IOException {
        if (aud == 1) {
            System.out.println("\nSorry, this lifeline has already been used");
            lifeline();
        } else {
            aud = 1;
            System.out.print("\n\nAudience poll");
            printMsgWithProgressBar("", 15, 80);
            System.out.println("A :  15%");
            System.out.println("B :  55%");
            System.out.println("C :   5%");
            System.out.println("D :  25%");
        }
    }

    static void phone() throws IOException {
        if (phn == 1) {
            System.out.println("\nSorry, this lifeline has already been used");
            lifeline();
        } else {
            phn = 1;
            System.out.print("\n\nPhone a friend");
            printMsgWithProgressBar("", 15, 80);
            System.out.println("\n\nI think the answer is option B");
        }
    }

    static void expert() throws IOException {
        if (expt == 1) {
            System.out.println("\nSorry, this lifeline has already been used");
            lifeline();
        } else {
            expt = 1;
            System.out.print("\n\nExpert advice");
            printMsgWithProgressBar("", 15, 80);
            System.out.println("\n\nMy advice is to go with option B");
        }
    }

    static void dip() throws IOException {
        if (ddip == 1) {
            System.out.println("\nSorry, this lifeline has already been used");
            lifeline();
        } else {
            ddip = 1;
            ddip1 = 1;
            System.out.print("\n\nDouble Dip");
            printMsgWithProgressBar("", 15, 80);
            System.out.println("\n\nEnter two choices consecutively");
        }
    }

    static void quit() throws IOException {
        System.out.println("\n\nDo you really want to quit(Y/N)");
        String s1 = br.readLine();
        if (s1.equalsIgnoreCase("Y")) {
            System.out.print("\f");
            end();
        }
    }
}
