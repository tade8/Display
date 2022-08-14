package Assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Diary {

    private String notes;
    private String title;
    private String references;
    private String date;

    Scanner input = new Scanner(System.in);
    ArrayList<Diary> pages = new ArrayList<>();

    public Diary(String title, String reference, String date, String notes){
        this.title = title;
        this.references = reference;
        this.date = date;
        this.notes= notes;
    }

    public String toString(){
        return "Date:" + date + "\n" + "Title:" + title + "\n" + "References: " + references + "\n" + "Notes: "  + notes;
    }

    public void writeThoughts(){
        String saveNote;
        String keepWriting = "yes";


        while (Objects.equals(keepWriting, "yes")){
            System.out.println("Hi, Enter a title");
            title = input.nextLine();

            System.out.println("Would you mind writing a reference?");
            references = input.nextLine();

            System.out.println("Welcome great writer, Keep Writing");
            saveNote = input.nextLine();

            LocalDateTime newDate =  LocalDateTime.now();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyy HH-mm-ss");
            String date = newDate.format(formatDate);

            pages.add(new Diary(title,references,date,saveNote));

            System.out.println("Would you like to keep writing? YES/NO ");
            keepWriting = input.nextLine();

            if (Objects.equals(keepWriting, "yes")){
                System.out.println("SAVED!");
            } else if (Objects.equals(keepWriting, "no")) {
                viewNotes();
            }
        }


    }
    public void viewNotes(){
        System.out.println("Do you want to view notes: ");
        String view_notes = input.nextLine();
        if (Objects.equals(view_notes, "yes")){
         for (Diary notes : pages){
             System.out.println(notes);
         }
        }
    }

    public static void main(String[] args) {
        Diary myDiary = new Diary(null, null, null, null);
        myDiary.writeThoughts();
    }
}
