package de.idrinth.gods_and_heroes.ui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AttributeTable extends TableView<AttributeItem> {
    public AttributeTable() {
        super();
        setRowFactory(tv -> {
            TableRow<AttributeItem> row = new TableRow<>();
            return row;
        });
        setEditable(false);
        addColumn("Name");
        addColumn("Value");
    }
    public void setItems(AttributeList owner) {
        super.setItems(owner.getAttributes());
    }
    protected final void addColumn(String name) {
        TableColumn<AttributeItem, String> column = new TableColumn<>(name);
        column.setCellValueFactory(
            new PropertyValueFactory<>(name)
        );
        column.setMinWidth(100);
        getColumns().add(column);
    }
}
