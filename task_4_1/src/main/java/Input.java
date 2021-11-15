import java.util.Scanner;

public class Input extends Calculator{

    public void main(String[] args) throws Exception {
        boolean exit = true;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(calculator(input));
            if (input == "exit")
               break;
        }
    }

}
