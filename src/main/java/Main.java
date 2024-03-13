// Main.java

import org.example.Book;
import org.example.Database;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] main){
String Archivist="";
        do {
            System.out.println("To log in as a user, enter 1, or to log in as a archivist, enter 2, and to exit, enter 3.");

            Scanner input=new Scanner(System.in);
             Archivist=input.nextLine();
            if(Archivist.equals("1")){
                System.out.println("Enter the user's ID here : ");
                String id=input.nextLine();
                if(Database.userLogin(id)) {

                    System.out.println("Having Logged in Successfully. ");
                    System.out.println("What would you like to do :");
                    System.out.println("1. Book Collection");
                    System.out.println("2. Borrow Book");
                    String loginactivity=input.nextLine();
                    if(loginactivity.equals("1")) {
                        ArrayList<Book> books=new ArrayList<>();
                        books=Database.getingBooksCollection();
                        if(books.isEmpty())
                            System.out.println("There are no books");
                        else {
                            for (Book book : books) {
                                System.out.println("The book's identifier id is: "+book.booksId);
                                System.out.println("The book's title is: "+ book.title);
                                System.out.println("The Book's writer is: "+book.writer);
                                System.out.println("The book belongs to a category.: "+book.category);
                                System.out.println("The status status of the Book is: "+(book.status));
                                System.out.println();
                            }
                        }
                    }
                    else if(loginactivity.equals("2")) {
                        System.out.println("Enter the Identifier id of the Book you want to Borrow: ");
                        String borrowerid= input.nextLine();
                        if(Database.borrowingBook(borrowerid, id))
                            System.out.println("The book has been borrowed successfully");
                        else
                            System.out.println("Error Occurred: Couldn't borrow the Book.");
                    }
                    else
                        System.out.println("Please Try again and give a valid input");

                }
                else
                    System.out.println("Wrong id");
            }
            else if(Archivist.equals("2")) {
                System.out.println("Enter Username of the archivist: ");
                System.out.println("Hint: username is `archivist`");
                String username=input.nextLine();
                if(username.equals("archivist")) {
                    System.out.println("Enter what you want to do: ");
                    System.out.println("1. Show Book Collection");
                    System.out.println("2. Add New Book");
                    System.out.println("3. Add New User");
                    System.out.println("4. return a Book");
                    System.out.println("5. search for a Book");

                    int activity=input.nextInt();
                    if(activity==1) {
                        ArrayList<Book> books=new ArrayList<>();
                        books=Database.getingBooksCollection();
                        if(books.isEmpty())
                            System.out.println("There are no books/empty");
                        else {
                            for (Book book : books) {
                                System.out.println("The identifier id of the Book is: "+book.booksId);
                                System.out.println("The Book's title is: "+ book.title);
                                System.out.println("The Book's writer is: "+book.writer);
                                System.out.println("The book belong is of the category : "+book.category);
                                System.out.println("The status of the Book is: "+book.status);
                                System.out.println();
                            }
                        }

                    }
                    else if(activity ==2) {
                        input=new Scanner(System.in);
                        System.out.println("Enter the title of the Book: ");
                        String title=input.nextLine();
                        System.out.println("Enter the writer of the Book: ");
                        String writer =input.nextLine();
                        System.out.println("Enter the category to which the book belongs Book: ");
                        String category=input.nextLine();
                        if(Database.bookAddition(title,writer,category))
                            System.out.println("Successfully added new Book");
                        else
                            System.out.println("attempt failed.");

                    }
                    else if(activity==3) {
                        input=new Scanner(System.in);
                        System.out.println("Enter the name of the user: ");
                        String name=input.nextLine();
                        System.out.println("Enter the Information of the user: ");
                        String contactInfo=input.nextLine();

                        if(Database.userAddition(name,contactInfo))
                            System.out.println("Successfully created new user");
                        else
                            System.out.println("Failed to create a user.");
                    }
                    else if(activity==4) {
                        System.out.println("Returning Books");
                        System.out.println("Enter the Book Id u want to return");
                        int b_id = input.nextInt();
                        System.out.println("Enter the User Identifier id who wants to return this book");
                        int u_id = input.nextInt();

                        if (Database.returningBook(Integer.toString(b_id), Integer.toString(u_id))) {
                            System.out.println("The user with Identifier id:" + u_id);
                            System.out.println("is returing the book with Identifier id: " + b_id);
                        }
                        else
                            System.out.println("Failed to return the Book with Identifier id: "+b_id);
                    }
                    else if(activity==5){
                        System.out.println("Search for Books");
                        System.out.println("1. By Title");
                        System.out.println("2. By writer");
                        System.out.println("3. By Id");
input=new Scanner(System.in);
                        String user_dscision=input.nextLine();

                        if(user_dscision.equals("1")) {
                            System.out.println("Enter the Book's title");
                            String title=input.nextLine();
                            ArrayList<Book> books=new ArrayList<>();

                            books=Database.searchingForBooksByTitle(title);
                            if(books.isEmpty())
                                System.out.println("There are no books");
                            else {
                                for (Book book : books) {
                                    System.out.println("The identifier id of the Book is: "+book.booksId);
                                    System.out.println("The Book's title is: "+ book.title);
                                    System.out.println("The writer of the Book is: "+book.writer);
                                    System.out.println("The book belong to the category of : "+book.category);
                                    System.out.println("The status of the Book is: "+(book.status));
                                    System.out.println();
                                }
                            }
                        }
                        else if(user_dscision.equals("2")) {
                            System.out.println("Enter the writer of the Book");
                            String writer=input.nextLine();
                            ArrayList<Book> books=new ArrayList<>();
                            books=Database.searchingForBooksBywriter(writer);
                            if(books.isEmpty())
                                System.out.println("There are no books");
                            else {
                                for (Book book : books) {
                                    System.out.println("The identifier id of the Book is: "+book.booksId);
                                    System.out.println("The Book's title is: "+ book.title);
                                    System.out.println("The writer of the Book is: "+book.writer);
                                    System.out.println("The book belong to the category of : "+book.category);
                                    System.out.println("The status of the Book is: "+(book.status));
                                    System.out.println();
                                }
                            }
                        }
                        else if(user_dscision.equals("3")) {
                            System.out.println("Enter the Id of the Book");
                            String id=input.nextLine();
                            ArrayList<Book> books=new ArrayList<>();
                            books=Database.searchForBooksBybooksid(id);
                            if(books.isEmpty())
                                System.out.println("There are no books");
                            else {
                                for (Book book : books) {
                                    System.out.println("The identifier id of the Book is: "+book.booksId);
                                    System.out.println("The Book's title is: "+ book.title);
                                    System.out.println("The writer of the Book is: "+book.writer);
                                    System.out.println("The book belong to the category of : "+book.category);
                                    System.out.println("The status of the Book is: "+(book.status));
                                    System.out.println();
                                }
                            }
                        }
                        else
                            System.out.println("Please enter a valid input");

                    }


                }
                else
                    System.out.println("Please enter the correct username: `archivist`");
            }
            else{
                System.out.println("Please give a valid input");
            }
        }while(!Archivist.equals("3"));

    }
}
