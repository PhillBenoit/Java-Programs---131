
public abstract class Publication {
    private String title, publisher, date, subject;
    
    public Publication(String title, String publisher, String date, String subject) {
        this.title = title;
        this.publisher = publisher;
        this.date = date;
        this.subject = subject;
    }
    
    public Publication() {
        title = "";
        publisher = "";
        date = "";
        subject = "";
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
