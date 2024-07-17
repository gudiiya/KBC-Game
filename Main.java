import java.util.stream.Stream;
public class Main
{
public static void printMsgWithProgressBar(String message,int length,long timeinterval)
{
char incomplete='-';
char complete='#';
StringBuilder builder=new StringBuilder();
Stream.generate(()->incomplete).limit(length).forEach(builder::append);
System.out.println(message);
for(int i=0;i<length;i++)
{
builder.replace(i,i+1,String.valueOf(complete));
String progressBar="\r"+builder;
System.out.print(progressBar);
try
{
Thread.sleep(timeinterval);
}
catch(InterruptedException ignored)
{
}
}
System.out.println();
}
public static void main(String[]args)
{
printMsgWithProgressBar("Loading",25,60);
}}
