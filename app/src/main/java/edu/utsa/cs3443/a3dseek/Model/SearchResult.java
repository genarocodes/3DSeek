package edu.utsa.cs3443.a3dseek.Model;

import java.util.List;

/**
 * The SearchResult class represents the outcome of a search operation.
 * It holds a list of Model objects that match the search criteria and
 * the search term used during the search.
 */
public class SearchResult {
    // List of models returned from a search query.
    private List<Model> models;
    // The search term that was used for querying models.
    private String searchTerm;

    /**
     * Constructor to initialize a SearchResult with a list of models and the search term.
     *
     * @param models     A list of Model objects resulting from the search.
     * @param searchTerm The search term used to find the models.
     */
    public SearchResult(List<Model> models, String searchTerm) {
        this.models = models;
        this.searchTerm = searchTerm;
    }


    // Getters and setters
    public List<Model> getModels() { return models; }
    public void setModels(List<Model> models) { this.models = models; }

    public String getSearchTerm() { return searchTerm; }
    public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
}