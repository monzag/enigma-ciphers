package enigma;

import java.util.Scanner;
import java.io.*;
import app.*;
import registry.*;
import services.*;


public class TerminalTranslator{
    ServiceRepository repo = null;
    EnigmaService service = null;
    String mode;
    String key;

    public void initialize(ServiceRepository repo){
        this.repo = repo;
    }

    public void setParameters(String serviceName, String mode){
        this.service = repo.getByName(serviceName);
        this.mode = mode;
        this.key = null;
    }

    public void setParameters(String serviceName, String mode, String key){
        this.service = repo.getByName(serviceName);
        this.mode = mode;
        this.key = key;
    }

    public String getName(){
        return "Terminal Translator";
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in text");
        String toCipher = scanner.nextLine();
        cipher(toCipher);
    }
    public void cipher(String toCipher){
        service.setKey(this.key);
        if (mode.equals("-e")){
            String encipheredString = service.encipher(toCipher);
            System.out.println(encipheredString);
        } else if (mode.equals("-d")){
            String decipheredString = service.decipher(toCipher);
            System.out.println(decipheredString);
        }
    }
}
