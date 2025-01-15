package api;

public class ChallengeData extends Challenge{
        private String id;


    public ChallengeData() {
        super();
    }

    public ChallengeData(String id, String title, String description) {
        super();

        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
