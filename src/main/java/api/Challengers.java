package api;

public class Challengers {

    private String id;
    private String title;
    private String link;
    private String description;
    private Double rating;
    private Integer trials;
    private Boolean active;
    private String resolution;

    public Challengers(String id, String title, String link, String description, Double rating, Integer trials, Boolean active, String resolution) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.rating = rating;
        this.trials = trials;
        this.active = active;
        this.resolution = resolution;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getTrials() {
        return trials;
    }

    public Boolean getActive() {
        return active;
    }

    public String getResolution() {
        return resolution;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setTrials(Integer trials) {
        this.trials = trials;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
