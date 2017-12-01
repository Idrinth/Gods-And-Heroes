package de.idrinth.gods_and_heroes.ui;

public class AttributeTable extends ExtTableView<AttributeItem> {
    public AttributeTable() {
        super();
        addColumn("Name", 1.5);
        addColumn("Value", 3);
    }
    public void setItems(AttributeList owner) {
        super.setItems(owner.getAttributes());
    }
}
