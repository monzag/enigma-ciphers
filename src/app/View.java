package app;

import java.util.List;

public interface View {
    public void print(String text);
    public String input(String text);
    public boolean confirm(String text);
    public int selectItem(List list);
}