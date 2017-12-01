package de.idrinth.gods_and_heroes.ui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExtTableView<Q> extends TableView<Q> {
    public ExtTableView() {
        super();
        setRowFactory(tv -> {
            TableRow<Q> row = new TableRow<>();
            return row;
        });
        setEditable(false);
    }
    protected final void addColumn(String name) {
        addColumn(name, 1);
    }
    protected final void addColumn(String name, double factor) {
        TableColumn<Q, String> column = new TableColumn<>(name);
        column.setCellValueFactory(new PropertyValueFactory<>(name));
        column.setMinWidth((int) (60 * factor));
        getColumns().add(column);
    }
}
