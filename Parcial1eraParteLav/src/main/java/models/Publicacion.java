package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publicacion {

    @Id
    @GeneratedValue
    private Integer idPublicacion;

    @NotNull(message = "Una publicacion debe tener un titulo")
    private String titulo;

    @NotNull(message = "Una publicacion debe tener una descripcion")
    private String descripcionPublicacion;

    private String foto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-YYYY")
    private LocalDate fechaPublicacion;
    private boolean liked;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuarioComentario")
    @JsonManagedReference
    private List<Comentario> comentarios;
    //ver si puedo resolver esto con un map mas tarde

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="idUsuario",referencedColumnName = "idUsuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull(message = "La publicacion debe tener especificado quien lo hizo")
    private Usuario usuarioPublicacion;




    @PrePersist
    public void addDate(){
        if (isNull(this.fechaPublicacion)){
            this.fechaPublicacion= LocalDate.now();
        }
    }

}
