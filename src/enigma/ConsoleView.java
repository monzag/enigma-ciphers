package enigma;

import java.util.Scanner;

import app.View;
import java.util.List;

public class ConsoleView implements View {

    public void print(String text){
        System.out.println(text);
    }
    public String input(String text) {
        print(text);
        Scanner in = new Scanner(System.in);
        String result = in.next();
        return result;
    }
    public boolean confirm(String text){
        return true;
    }
    public int selectItem(List list){
        return 0;
    }

    

}