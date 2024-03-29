package com.example.PracticaParcial.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Integer idPlayer;

    @NotNull(message = "Players MUST have a name")
    @Column(name = "name")
    private String playersName;
    @NotNull(message = "Players MUST have a surname")
    @Column(name = "surname")
    private String playersSurname;
    @NotNull(message = "Players MUST have an age")
    @Column(name = "age")
    private Integer age;
    @NotNull(message = "Players MUST have a registered date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate registeredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_team",referencedColumnName = "idTeam")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JsonBackReference
    @NotNull(message = "Players MUST have a team realeted to them") //por JSON Ignore, no se podia poner un null
    private Team team;
}
