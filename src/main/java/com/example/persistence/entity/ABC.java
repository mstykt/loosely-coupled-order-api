package com.example.persistence.entity;

import java.util.Objects;

public class ABC implements Comparable<ABC> {
    private int f1;
    private String f2;
    private String f3;

    public ABC() {
    }

    public ABC(int f1, String f2, String f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ABC abc = (ABC) o;
        return f1 == abc.f1 && Objects.equals(f2, abc.f2) && Objects.equals(f3, abc.f3);
    }


    @Override
    public int compareTo(ABC o) {
        return this.f1 - o.f1;
    }
}
