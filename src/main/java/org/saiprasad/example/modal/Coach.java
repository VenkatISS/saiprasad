package org.saiprasad.example.modal;

public class Coach {
    private String name;
    public Coach(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coach) {
            return this.name.equals(((Coach) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                '}';
    }
}
