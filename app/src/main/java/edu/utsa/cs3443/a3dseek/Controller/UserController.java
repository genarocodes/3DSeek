package edu.utsa.cs3443.a3dseek.Controller;

import edu.utsa.cs3443.a3dseek.Model.User;
import edu.utsa.cs3443.a3dseek.Model.Model;

public class UserController {
    // A User object representing the current user of the application.
    private User user;

    /**
     * Constructor to initialize the UserController with a given user.
     *
     * @param user The User object representing the user to be managed by this controller.
     */
    public UserController(User user) {
        this.user = user;
    }

    /**
     * Adds a model to the user's list of favorite models.
     *
     * @param model The Model object to be added to the user's favorites.
     */
    public void addModelToFavorites(Model model) {
        user.addFavorite(model);
    }

    /**
     * Removes a model from the user's list of favorite models.
     *
     * @param model The Model object to be removed from the user's favorites.
     */
    public void removeModelFromFavorites(Model model) {
        user.removeFavorite(model);
    }

    /**
     * Adds a search query to the user's search history.
     *
     * @param query The search term to be added to the user's history.
     */
    public void addSearchQueryToHistory(String query) {
        user.addSearchHistory(query);
    }
}
