public class Magazine extends Publication {

    private String frequency, editor;
    
    public Magazine() {
        super();
        frequency = "";
        editor = "";        
    }
    
    public Magazine(String title, String publisher, String date, String subject,
            String frequency, String editor) {
        super(title, publisher, date, subject);
        this.frequency = frequency;
        this.editor = editor;
    }
    
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    public void setEditor(String editor) {
        this.editor = editor;
    }
    
    public String getFrequency() {
        return frequency;
    }
    
    public String getEditor() {
        return editor;
    }
    
    public String toString() {
        return String.format("******************Magazine******************\n"
                + "Title: %s\n"
                + "Editor: %s\n"
                + "Subject: %s\n"
                + "Publisher: %s\n"
                + "Publication Date: %s\n"
                + "Publication Frequency: %s\n"
                + "--------------------------------------------", getTitle(),
                editor, getSubject(), getPublisher(), getDate(), frequency);
    }

}
