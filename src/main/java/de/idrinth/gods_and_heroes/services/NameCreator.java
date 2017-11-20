package de.idrinth.gods_and_heroes.services;

import de.idrinth.name_generator.API;

public class NameCreator {
    private static final API GENERATOR = new API();
    public static String generate() {
        return GENERATOR.makeName(true);
    }
}