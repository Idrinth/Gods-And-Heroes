package de.idrinth.gods_and_heroes.ui;

import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;

public class AttributeTable extends ExtTableView<AttributeItem> {
    public AttributeTable() {
        super();
        addColumn("Name", 1.5);
        addColumn("Value", 3);
        getColumns().get(0).setCellFactory(col -> { return (TableCell) new AttributeItemCell(); });
        getColumns().get(1).setCellFactory(col -> { return (TableCell) new AttributeItemCell(); });
    }
    public void setItems(AttributeList owner) {
        super.setItems(owner.getAttributes());
    }
    private class AttributeItemCell extends TableCell<AttributeItem, String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(item);
            try {
                setTooltip(new Tooltip(((AttributeItem) getTableRow().getItem()).getName()));
            } catch(NullPointerException ex) {
                //might happen if initialized before first initialized properly, not an issue
            }
        }
    }
}
