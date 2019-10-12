package me.karthikrao.hash.map;

public class Entry {
    private String key;
    private String value;

    public Entry(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        return this.key.equals(o);
    }
}
