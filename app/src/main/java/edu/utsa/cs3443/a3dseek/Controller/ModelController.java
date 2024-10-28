package edu.utsa.cs3443.a3dseek.Controller;

import edu.utsa.cs3443.a3dseek.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelController {
    // A list to store the models managed by this controller.
    private List<Model> modelList;

    /**
     * Constructor to initialize the ModelController.
     * Creates an empty ArrayList to hold Model objects.
     */
    public ModelController() {
        this.modelList = new ArrayList<>();
    }

    /**
     * Adds a Model object to the list.
     *
     * @param model The Model object to be added.
     */
    public void addModel(Model model) {
        modelList.add(model);
    }

    /**
     * Removes a Model object from the list.
     *
     * @param model The Model object to be removed.
     */
    public void removeModel(Model model) {
        modelList.remove(model);
    }

    /**
     * Searches the model list for models that match the given query.
     * It checks if the query is contained in either the model's title or description.
     *
     * @param query The search term used to filter the models.
     * @return A list of Model objects that match the search criteria.
     */
    public List<Model> searchModels(String query) {
        // A list to store models that match the search query.
        List<Model> result = new ArrayList<>();

        // Iterate through each model in the list.
        for (Model model : modelList) {
            // Check if the query matches the title or description of the model.
            if (model.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    model.getDescription().toLowerCase().contains(query.toLowerCase())) {

                // If a match is found, add the model to the result list.
                result.add(model);
            }
        }

        // Return the list of models that match the search query.
        return result;
    }
}
