import java.util.ArrayList;
import java.util.Collections;

public class Author {
    private String id;
    private String name;
    private String university;
    private String department;
    private String email;
    private ArrayList<String> articles;
    private int size;

    public Author(String id, ArrayList<String> articles) {
        this.id = id;
        this.articles = articles;
        this.size = 1;
    }

    public Author(String id, String name, String university, String department, String email, ArrayList<String> articles) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.email = email;
        this.articles = articles;
    }

    public void sortedAll(){
        Collections.sort(articles);
    }

    public void completeAll(ArrayList<Article> articleArrayList){
        for (Article article:articleArrayList){
            if (articles.size()!=5 && article.getPaperID().substring(0,3).equals(id) && !(articles.contains(article.getPaperID()))){
                articles.add(article.getPaperID());
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getArticles() {
        return articles;
    }
}
