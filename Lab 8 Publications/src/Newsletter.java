public class Newsletter extends Publication {
    
    private String frequency, editor, owner;

    public Newsletter(String title, String publisher, String date, String subject,
            String frequency, String editor, String owner) {
        super(title, publisher, date, subject);
        this.frequency = frequency;
        this.editor = editor;
        this.owner = owner;
    }

    public Newsletter() {
        super();
        frequency = "";
        editor = "";
        owner = "";
    }

    public String getFrequency() {
        return frequency;
    }

    public String getEditor() {
        return editor;
    }

    public String getOwner() {
        return owner;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String toString() {
        return String.format("*****************Newsletter*****************\n"
                + "Title: %s\n"
                + "Editor: %s\n"
                + "Owner: %s\n"
                + "Subject: %s\n"
                + "Publisher: %s\n"
                + "Publication Date: %s\n"
                + "Publication Frequency: %s\n"
                + "--------------------------------------------", getTitle(),
                editor, owner, getSubject(), getPublisher(), getDate(), frequency);
    }

}
