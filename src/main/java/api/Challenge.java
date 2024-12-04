package api;

public class Challenge {
    String title;
    String description;

    public Challenge(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Challenge() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
