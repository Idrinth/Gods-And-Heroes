package de.idrinth.gods_and_heroes.services;

import de.idrinth.name_generator.API;

public class NameCreator {
	private static final API generator = new API();
    public static String generate() {
    	return generator.makeName();
    }
}