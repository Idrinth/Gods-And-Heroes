package de.idrinth.gods_and_heroes.ui;

import java.math.BigInteger;

public class AttributeItem {
    private String name;
    private String value;

    public AttributeItem(String name, BigInteger value) {
        this.name = name;
        this.value = value.toString();
    }

    public AttributeItem(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public AttributeItem(String name) {
        this(name, BigInteger.ZERO);
    }

    public void setValue(BigInteger value) {
        this.value = value.toString();
    }
    
    public String getName() {
        return name;
    }
    public String getValue() {
        return value;
    }
}
