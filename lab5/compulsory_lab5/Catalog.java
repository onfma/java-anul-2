package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog {
    private String name;
    private List<Document> documents;

    /**
     * Class constructor
     */
    public Catalog(String name) {
        this.name = name;
        this.documents=new ArrayList<>();
    }

    /**
     * Class constructor
     */
    public Catalog(String name, List<Document> documents) {
        this.name = name;
        this.documents = documents;
    }

    /**
     * Getter for the name of the catalog
     */
    public String getName() {return name;}

    /**
     * Setter for the name of the catalog
     */
    public void setName(String name) {this.name = name;}

    /**
     * Getter for the documents of the catalog
     */
    public List<Document> getDocuments() {return documents;}

    /**
     * Setter for the documents of the catalog
     */
    public void setDocuments(List<Document> documents) {this.documents = documents;}

    /**
     * Add a document in the catalog
     */
    public void addDocument(Document document){documents.add(document);}

    /**
     * Remove a document from the catalog
     */
    public void removeDocument(Document document){documents.remove(document);}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.documents);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Catalog other = (Catalog) obj;
        if (!Objects.equals(this.name, other.name)) {return false;}
        return Objects.equals(this.documents, other.documents);
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", documents=" + documents + '}';
    }
}
