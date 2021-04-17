package world.cup.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public String getClub() {
        return club;
    }

    private String prenom;
    private String club;
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_Equipe")
    private Equipe equipe;

    public void setClub(String club) {
        this.club = club;
    }

    //constructor
    public Staff(Long id, String nom, String prenom, String role, String club,Equipe equipe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.club = club;
        this.equipe = equipe;
    }

    public Staff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", nom='" + nom  +
                ", prenom='" + prenom  +
                ", role='" + role  +
                ", equipe=" + equipe +
                '}';
    }
}
