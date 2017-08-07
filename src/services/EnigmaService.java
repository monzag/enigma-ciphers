package services;

public interface EnigmaService {
    public String encipher(String text);
    public String decipher(String text);
    public String getName();
    public void initialize();
}
