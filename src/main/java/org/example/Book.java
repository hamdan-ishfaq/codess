//  Book.java

package org.example;

public class Book {
    public int booksId;
    public String title,writer,category,status;

    public Book(String _title,String _writer,String _category, String _status, int _booksId){
        title=_title;
        writer=_writer;
        category=_category;
        status=_status;
        booksId=_booksId;
    }

    public String getTitle() {
        return title;
    }

    public String getwriter() {
        return writer;
    }

    public String getcategory() {
        return category;
    }

    public String getstatus() {
        return status;
    }

    public int getBooksId() {
        return booksId;
    }

}
