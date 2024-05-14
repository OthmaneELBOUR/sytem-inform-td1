package emi.ac.ginf.td1.domain.helper;

public class KeyGenerator {
    public static int getKey() {
        return (int) (Math.random() * 100000);
    }
}
