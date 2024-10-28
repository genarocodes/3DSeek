package edu.utsa.cs3443.a3dseek.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The User class represents a user of the 3DSeek application.
 * It stores information such as the user's username, email, a list of favorite models,
 * and a search history of queries the user has made.
 */
public class User {
    private String username; // The user's chosen username
    private String email; // The user's email address
    private List<Model> favorites; // List of models that the user has marked as favorites
    private List<String> searchHistory; // List of search queries made by the user

    /**
     * Constructor to initialize a User with a username and email.
     * Initializes the favorites and search history lists.
     *
     * @param username The username of the user.
     * @param email The email address of the user.
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.favorites = new ArrayList<>();
        this.searchHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Model> getFavorites() { return favorites; }

    public void addFavorite(Model model) {
        if (!favorites.contains(model)) {
            favorites.add(model);
        }
    }

    public void removeFavorite(Model model) {
        favorites.remove(model);
    }

    public List<String> getSearchHistory() { return searchHistory; }

    public void addSearchHistory(String query) {
        searchHistory.add(query);
    }

    public void clearSearchHistory() {
        searchHistory.clear();
    }
}