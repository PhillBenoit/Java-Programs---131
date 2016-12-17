public class Book extends Publication{
   
    private int pages, year, edition;
    private String author, isbn, lccn;
    
    public Book() {
        super();
        pages = 0;
        year = 0;
        edition = 0;
        isbn = "";
        lccn = "";
        author = "";
    }
    
    /**
     * constructor
     * @param sArgs title, publisher, date, subject, author, isbn, lccn
     * @param iArgs pages, year, edition
     */
    public Book (String title, String publisher, String date, String subject,
            String author, String isbn, String lccn, int pages, int year, int edition) {
        super(title, publisher, date, subject);
        this.author = author;
        this.isbn = isbn;
        this.lccn = lccn;
        this.pages = pages;
        this.year = year;
        this.edition = edition;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getISBN() {
        return isbn;
    }
    
    public String getLCCN() {
        return lccn;
    }
    
    public int getPages() {
        return pages;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getEdition() {
        String returnString = "";
        switch (edition % 10) {
        case 1:  returnString = "st";
                 break;
        case 2:  returnString = "nd";
                 break;
        case 3:  returnString = "rd";
                 break;
        default: returnString = "th";
        }
        if (edition % 100 == 11 || edition % 100 == 12 || edition % 100 == 13) {
            returnString = "th";
        }
        returnString = Integer.toString(edition) + returnString;
        return returnString;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    
    public void setLCCN(String lccn) {
        this.lccn = lccn;
    }
    
    public void setPages(int pages) {
        this.pages = pages;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setEdition(int edition) {
        this.edition = edition;
    }
    
    public String toString() {
        return String.format("********************Book********************\n"
                + "Title: %s\n"
                + "Author: %s\n"
                + "Copyright Year: %d\n"
                + "Subject: %s\n"
                + "%d pages    %s Edition\n"
                + "Publisher: %s\n"
                + "Publication Date: %s\n"
                + "ISBN: %s\n"
                + "LCCN: %s\n"
                + "--------------------------------------------", getTitle(),
                author, year, getSubject(), pages, getEdition(), getPublisher(),
                getDate(), isbn, lccn);
    }

}
