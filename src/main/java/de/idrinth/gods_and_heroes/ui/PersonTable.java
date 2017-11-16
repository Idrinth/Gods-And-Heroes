package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Person;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

abstract public class PersonTable<Q extends Person> extends TableView<Q> {
    public PersonTable() {
        super();
        setRowFactory(tv -> {
            TableRow<Q> row = new TableRow<>();
            return row;
        });
        setEditable(false);
        addColumn("name");
        addColumn("alignment");
    }
    public void setItems(God god) {
        super.setItems(getList(god));
    }
    protected abstract ObservableList getList(God god);
    protected final void addColumn(String name) {
        TableColumn<Q, String> column = new TableColumn<>(name);
        column.setCellValueFactory(
            new PropertyValueFactory<>(name)
        );
        column.setMinWidth(50);
        getColumns().add(column);
    }
}
