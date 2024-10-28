package edu.utsa.cs3443.a3dseek.Model;

/**
 * The Model class represents a 3D model object fetched from various platforms.
 * It contains information such as the model's ID, title, description, author,
 * source URL, thumbnail URL, and the platform it originated from.
 */
public class Model {
    // Unique identifier for the model (e.g., API-specific ID).
    private String id;
    // Title or name of the 3D model.
    private String title;
    // A brief description of the 3D model.
    private String description;
    // The author or creator of the model.
    private String author;
    // URL that links to the source page of the model on its platform.
    private String sourceUrl;
    // URL for the thumbnail image of the model.
    private String thumbnailUrl;
    // The platform from which the model originates (e.g., "Thingiverse", "Cults3D").
    private String platform;

    /**
     * Constructor to initialize a Model object with all its attributes.
     *
     * @param id            Unique identifier for the model.
     * @param title         Title or name of the model.
     * @param description   Brief description of the model.
     * @param author        Author or creator of the model.
     * @param sourceUrl     URL linking to the model's source page.
     * @param thumbnailUrl  URL for the model's thumbnail image.
     * @param platform      Platform name where the model is hosted.
     */
    public Model(String id, String title, String description, String author, String sourceUrl, String thumbnailUrl, String platform) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.sourceUrl = sourceUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.platform = platform;
    }

    // Getters and setters for each attribute
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }

    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
}