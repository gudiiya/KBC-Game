import java.io.*;
import java.util.Random;
class KBC
{
 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 static Random r=new Random();
 static int stage,amount,life,aud=0,phn=0,expt=0,ddip=0,ddip1=0,correct,in,fin,c;
 static String s1,opt;
 static int a[]={5000,10000,20000,40000,80000,160000,320000,640000,1250000,2500000,5000000,10000000,50000000};
 static String s[]={"1 : Audience poll","2 : Phone a friend","3 : Expert Advice","4 : Double dip"};
 public static void main(String [] args)throws IOException
 {
     display();
     database();
    }
    static void display()throws IOException
    {
        int i,j;
        System.out.print("\fWelcome to Kaun Banega Crorepati (Computerized version 1.0)");
        System.out.print("\n\nThis version is similar to original game");
        System.out.print("\nYou'll have to answer 10 questions to win 5 crore ruppees\n");
        for(i=1;i<=13;i++)
        {  
            System.out.print("\n"+i+" <> Rs. "+a[i-1]);
                    }
        System.out.print("\n");
        stageset();
        System.out.print("\fIn addition to this, you'll have 4 lifelines to assist you\n\n");
        System.out.print(s[0]+" : Will help you to take audience's opinion\n");
        System.out.print(s[1]+" : Will enable you to call your friend for the answer\n");
        System.out.print(s[2]+" : Ask the experts for their advice\n");
        System.out.print(s[3]+" : Will allow you to give two answers for the same question\n");
        System.out.print("\nWarning : If you use double dip, you'll not be able to quit the game or use another lifeline");
      }
    static void stageset()throws IOException
    {
        String c;
        System.out.print("\nPlease set a stage (Enter question number) : ");
        stage=Integer.parseInt(br.readLine());
        if(stage>=1 && stage<=13)
        {
            System.out.print("\nYou have selected : "+stage+" <> Rs. "+a[stage-1]);
            System.out.print("\n\nAre you sure (Y/N) : ");
            c=br.readLine();
            if(!(c.substring(0).equalsIgnoreCase("Y")))
            stageset();
        }
        else
        {
            System.out.print("\nInvalid input. Please enter again.\n");
            stageset();
        }
    }
    static void controls()throws IOException
    {
        System.out.print("\n\nEnter choices as A B C D");
        System.out.print("\nEnter 'L' to choose a life-line");
        System.out.print("\nEnter 'Q' to quit");
        System.out.print("\n\nEnter any key to clear screen and continue : ");
        s1=br.readLine();
        System.out.print("\f");
    }
    static void play()throws IOException
    {
        System.out.print("\n\nEnter your choice : ");
        opt=br.readLine();
        if(opt.substring(0,1).equalsIgnoreCase("A"))
        c=1;
        if(opt.substring(0,1).equalsIgnoreCase("B"))
        c=2;
        if(opt.substring(0,1).equalsIgnoreCase("C"))
        c=3;
        if(opt.substring(0,1).equalsIgnoreCase("D"))
        c=4;
        if(opt.substring(0,1).equalsIgnoreCase("L"))
        {
            lifeline();
            if(ddip1==0)
            play();
            ddip1=0;
        }
        if(opt.substring(0,1).equalsIgnoreCase("Q"))
        quit();
    }
    static void lifeline()throws IOException
    {
        int i;
        System.out.print("\nYou have the following lifelines left : ");
        for(i=0;i<=3;i++)
        System.out.print(s[i]+"  ");
        System.out.print("\n\nWhich one would you like to use (Enter number) : ");
        life=Integer.parseInt(br.readLine());
        switch(life)
        {
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
            System.out.print("\nThis life line is not available");
        }
    }
    static void database()throws IOException
    {
        int cont=1;
        System.out.print("Stage : "+cont+" <> "+a[0]+"\n\n");
        System.out.print("A group of is commonly called as one byte ");
        System.out.print("\n\nA: Six  bits\t\tB: Eight bits\nC: Twelve bits\t\tD: Fifteen bits");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[0];
            System.out.print("\nWell done. Correct answer.");
            if(stage==1)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B: Eight bits");
            end();//calls the method end
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[1]+"\n\n");
        System.out.print("The Third Generation computer used ");
        System.out.print("\n\nA: Transistors\t\tB: Integrated Circuit\nC: Vacuum tube\t\tD: Chip");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[1];
            System.out.print("\nWell done. Correct answer.");
            if(stage==2)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is C: Integrated Circuit");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[2]+"\n\n");
        System.out.print("Which one is the first fully supported 64-bit operating system?");
        System.out.print("\n\nA: Windows Vista \t\tB: Mac\nC: Linux\t\tD: Windows XP");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[2];
            System.out.print("\nWell done. Correct answer.");
            if(stage==3)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is C: Linux");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[3]+"\n\n");
        System.out.print("Which of the following is an output device: ");
        System.out.print("\n\nA: Keyboard\t\tB: Joy Stick \nC: Printer\t\tD: None of the above");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[3];
            System.out.print("\nWell done. Correct answer.");
            if(stage==4)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B: Joy Stick");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[4]+"\n\n");
        System.out.print("Which of the following is an input device: ");
        System.out.print("\n\nA: Monitor\t\tB: Mouse\nC: Hard Disk McAleese\t\tD: Printer");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[4];
            System.out.print("\nWell done. Correct answer.");
            if(stage==5)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A: Mouse");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[5]+"\n\n");
        System.out.print("Which of the following is uded to store data in the computer?: ");
        System.out.print("\n\nA: Hard Disks \t\tB: CPU\nC: Monitor\t\tD: None of the above");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[5];
            System.out.print("\nWell done. Correct answer.");
            if(stage==6)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B: Hard Disks");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[6]+"\n\n");
        System.out.print("Which of the following is referred to as the brain of a computer? : ");
        System.out.print("\n\nA: RAM\t\tB: ROM\nC: Monitor\t\tD: CPU");
        correct=4;
        play();
        if(correct==c)
        {
            in=a[6];
            System.out.print("\nWell done. Correct answer.");
            if(stage==7)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is D:CPU ");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[7]+"\n\n");
        System.out.print("What is the full form of the CPU? : ");
        System.out.print("\n\nA: Central Program Unit\t\tB: Central Programming Unit\nC: Central Processing unit \t\tD: Centralized Processing Unit");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[7];
            System.out.print("\nWell done. Correct answer.");
            if(stage==8)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is C:Central Processing unit ");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[8]+"\n\n");
        System.out.print("What makes the 5th generation computer different from previous generations? : ");
        System.out.print("\n\nA:Object-Oriented Programming \t\tB: Scientific Code\nC: Technological Advancement\t\tD: All the Above");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[8];
            System.out.print("\nWell done. Correct answer.");
            if(stage==9)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is c: Technological Advancement");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[9]+"\n\n");
        System.out.print("Which of the following computer language used for artificial intelligence? : ");
        System.out.print("\n\nA: PROLOG\t\tB: C.FORTRAN\nC: C\t\tD:COBOL");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[9];
            System.out.print("\nWell done. Correct answer.");
            if(stage==10)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A: PROLOG");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[10]+"\n\n");
        System.out.print("Which of the following is referred to as volatile memory? : ");
        System.out.print("\n\nA: ROM\t\tB: RAM\nC: HDs \t\tD: CDs");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[10];
            System.out.print("\nWell done. Correct answer.");
            if(stage==11)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B: RAM");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[11]+"\n\n");
        System.out.print("A large computer system frequently makes use of ? : ");
        System.out.print("\n\nA: Line Printers\t\tB: Ink-jet printers\nC: Dot-matrix printers\t\tD: Daisy wheel printers");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[11];
            System.out.print("\nWell done. Correct answer.");
            if(stage==12)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A: Line Printers");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[12]+"\n\n");
        System.out.print("The characteristics of first-generation computer include? : ");
        System.out.print("\n\nA: Vacuum tubes and magnetic drum \t\tB: Minicomputers\nC: Magnetic tape and transistors\t\tD: None of the above");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[12];
            System.out.print("\nWell done. Correct answer.");
            if(stage==13)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A:Vacuum tubes and magnetic drum ");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\f");
        for(int i=1;i<=3;i++)
        {
            System.out.print("Many ");
        }
        System.out.print("Congratulations to you.\n\nYou have completed this challenge");
        quit();
    }
    static void audience()throws IOException
    {
        aud++;
        int a[]=new int[3];
        int s1=0,i,j,c;
        s[0]="";
        for(i=0;i<=2;i++)
        {
            c=r.nextInt(15);
            a[i]=c;
        }
        s1=100-(a[0]+a[1]+a[2]);
        System.out.print("\nAwaiting reply ");
        for(i=1;i<=3;i++)
        {
            System.out.print(".");
                   }
        System.out.print("\n\n");
        if(correct==1)
        {
            System.out.print("\nA : "+s1+" %");
            System.out.print("\nB : "+a[0]+" %");
            System.out.print("\nC : "+a[1]+" %");
            System.out.print("\nD : "+a[2]+" %");
        }
        if(correct==2)
        {
            System.out.print("\nA : "+a[0]+" %");
            System.out.print("\nB : "+s1+" %");
            System.out.print("\nC : "+a[1]+" %");
            System.out.print("\nD : "+a[2]+" %");
        }
        if(correct==3)
        {
            System.out.print("\nA : "+a[1]+" %");
            System.out.print("\nB : "+a[0]+" %");
            System.out.print("\nC : "+s1+" %");
            System.out.print("\nD : "+a[2]+" %");
        }
        if(correct==4)
        {
            System.out.print("\nA : "+a[2]+" %");
            System.out.print("\nB : "+a[0]+" %");
            System.out.print("\nC : "+a[1]+" %");
            System.out.print("\nD : "+s1+" %");
        }
    }
    static void phone()
    {
        phn++;
        int c=r.nextInt(5);
        System.out.print("\n");
        s[1]="";
        if(c==1 || c==3 || c==5 || c==4)
        {
            if(correct==1)
            System.out.print("Friend says its 'A'");
            if(correct==2)
            System.out.print("Friend says its 'B'");     
            if(correct==3)
            System.out.print("Friend says its 'C'");
            if(correct==4)
            System.out.print("Friend says its 'D'");
        }
        else
        System.out.print("Friend has no idea");
    }
    static void expert()
    {
        expt++;
        int c=r.nextInt(5);
        System.out.print("\n");
        s[2]="";
        if(c==1 || c==3 || c==5 || c==4)
        {
            if(correct==1)
            System.out.print("Expert thinks it to be 'A'");
            if(correct==2)
            System.out.print("Expert thinks it to be 'B'");     
            if(correct==3)
            System.out.print("Expert thinks it to be 'C'");
            if(correct==4)
            System.out.print("Expert thinks it to be 'D'");
        }
        else
        System.out.print("Expert has no idea");
    }
    static void dip()throws IOException
    {
        s[3]="";
        ddip1=1;
        ddip++;
        System.out.print("\nFirst choice : ");
        play();
        if(correct==c)
        {
           System.out.print("\nCorrect answer");
        }
        else
        {
            System.out.print("\nWrong answer\n\nSecond choice : ");
            play();
        }
    }
    static void quit()
    {
        fin=in;
        end();
    } 
    static void end()
    {
        System.out.print("\n\nYou have won Rs. "+fin);
        System.out.print("\n\nThank you for participating in KBC version 1.0");
        System.out.print("\n\nWish you all the best\nTake care\nSee you again.");
        System.exit(0);
    }
}

