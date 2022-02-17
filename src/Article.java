public class Article {
    private String paperID;
    private String name;
    private String publisherName;
    private String publishYear;

    public Article(String paperID, String name, String publisherName, String publishYear) {
        this.paperID = paperID;
        this.name = name;
        this.publisherName = publisherName;
        this.publishYear = publishYear;
    }

    public String getPaperID() {
        return paperID;
    }

    public String getName() {
        return name;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublishYear() {
        return publishYear;
    }
}
