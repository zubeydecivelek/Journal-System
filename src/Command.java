import java.io.*;
import java.util.*;

public class Command {
    public Command(String authorFileName, String commandFileName) throws IOException {
        BufferedWriter firstOutput = new BufferedWriter(new FileWriter("output.txt"));

        BufferedReader commandFile = new BufferedReader(new FileReader(commandFileName));
        ArrayList<String[]> commandsArrayList = new ArrayList<>();

        String line2;
        while ((line2=commandFile.readLine())!=null){
            commandsArrayList.add(line2.split(" "));
        }

        BufferedReader authorfile = new BufferedReader(new FileReader(authorFileName));
        ArrayList<String[]> authorArrayList= new ArrayList<>();

        String line ;
        while ((line=authorfile.readLine())!=null){
            authorArrayList.add(line.split(" "));
        }

        ArrayList<Author> authorsObjectsList = new ArrayList<>();
        for (String[] i : authorArrayList){
            if (i.length==2){
                Author author1 = new Author(i[1],new ArrayList<>());
                authorsObjectsList.add(author1);
            }
            else {
                ArrayList<String> articleArray = new ArrayList<>(Arrays.asList(i).subList(6, i.length));
                Author author = new Author(i[1],i[2],i[3],i[4],i[5],articleArray);
                authorsObjectsList.add(author);
            }
        }

        ArrayList<Article> articleObjectsList = new ArrayList<>();
        BufferedWriter outputFile = new BufferedWriter(new FileWriter("output.txt",true));

        for (String[] command:commandsArrayList){
            if (command[0].equals("read")){
                BufferedReader articlefile = new BufferedReader(new FileReader(command[1]));
                ArrayList<String[]> articleArrayList= new ArrayList<>();

                String line1 ;
                while ((line1=articlefile.readLine())!=null){
                    articleArrayList.add(line1.split(" "));
                }

                for (String[] i : articleArrayList){
                    Article article = new Article(i[1],i[2],i[3],i[4]);
                    articleObjectsList.add(article);
                }
            }
            else if (command[0].equals("list")){
                outputFile.write("----------------------------------------------List---------------------------------------------\n");
                for (Author author:authorsObjectsList){
                    if (author.getSize()==1){
                        outputFile.write("Author:"+author.getId()+"\n");
                    }
                    else{
                        outputFile.write("Author:" + author.getId() + "\t" + author.getName() + "\t" + author.getUniversity() +"\t" + author.getDepartment() + author.getEmail()+"\n");
                    }
                    for (String art:author.getArticles()){
                        for (Article article:articleObjectsList){
                            if (art.equals(article.getPaperID())){
                                outputFile.write("+"+article.getPaperID()+"\t" + article.getName() + "\t" + article.getPublisherName() + "\t" + article.getPublishYear()+"\n");
                            }
                        }
                    }
                    outputFile.write("\n");
                }
                outputFile.write("----------------------------------------------End----------------------------------------------\n");
            }
            else if (command[0].equals("completeAll")){
                outputFile.write("\n*************************************CompleteAll Successful*************************************\n\n");
                for (Author author:authorsObjectsList){
                    author.completeAll(articleObjectsList);
                }
            }
            else if (command[0].equals("sortedAll")){
                outputFile.write("\n*************************************SortedAll Successful*************************************\n\n");
                for (Author author:authorsObjectsList){
                    author.sortedAll();
                }
            }
            else if (command[0].equals("del")){
                outputFile.write("\n*************************************del Successful*************************************\n\n");
                authorsObjectsList.removeIf(author -> author.getId().equals(command[1]));
            }
        }
        outputFile.close();
    }
}
