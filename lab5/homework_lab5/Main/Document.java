package Main;
import Commands.ListCommand;

import java.util.Objects;

public class Document {
    private String id;
    private String title;
    private String location;

    /**
     * Class constructor
     */
    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;

        ListCommand.AddToList(this);
    }

    /**
     * Getter for the ID of the document
     */
    public String getId() {return id;}

    /**
     * Setter for the ID of the document
     */
    public void setId(String id) {this.id = id;}

    /**
     * Getter for the title of the document
     */
    public String getTitle() {return title;}

    /**
     * Setter for the title of the document
     */
    public void setTitle(String title) {this.title = title;}

    /**
     * Getter for the location of the document
     */
    public String getLocation() {return location;}

    /**
     * Setter for the location of the document
     */
    public void setLocation(String location) {this.location = location;}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + Objects.hashCode(this.location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Document other = (Document) obj;
        if (!Objects.equals(this.id, other.id)) {return false;}
        if (!Objects.equals(this.title, other.title)) {return false;}
        return Objects.equals(this.location, other.location);
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", title=" + title + ", location=" + location + '}' + '\n';
    }
}