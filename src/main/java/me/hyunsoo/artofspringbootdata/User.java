package me.hyunsoo.artofspringbootdata;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name="USER")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    @GeneratedValue @Id
    private Long id;

    private String name;
}
