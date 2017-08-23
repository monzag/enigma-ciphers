package enigma;

import java.util.Scanner;
import java.io.*;
import app.*;
import registry.*;
import services.*;


public class TerminalTranslator{
    ServiceRepository repo = null;
    EnigmaService serviceName = null;
    String mode = null;

    public void initialize(ServiceRepository repo) {
        this.repo = repo;
    }

    public void setParameters(String serviceName, String mode){
        this.serviceName = repo.getByName(serviceName);
        this.mode = mode;
    }
    public String getName(){
        return "Terminal Translator";
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in text");
        String toCipher = scanner.nextLine();
        cipher();
    }
    public void cipher();

    String toCipher;

}
