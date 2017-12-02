package de.idrinth.gods_and_heroes.ui;

import java.math.BigInteger;

public class AttributeItem {
    private String name;
    private String value;
    private String tooltip;

    public AttributeItem(String name, BigInteger value, String tooltip) {
        this.name = name;
        this.value = value.toString();
        this.tooltip = tooltip;
    }

    public AttributeItem(String name, String value, String tooltip) {
        this.name = name;
        this.value = value;
        this.tooltip = tooltip;
    }
    public AttributeItem(String name) {
        this(name, "");
    }
    public AttributeItem(String name, String tooltip) {
        this(name, BigInteger.ZERO, tooltip);
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
    public String getTooltip() {
        return tooltip;
    }
}
