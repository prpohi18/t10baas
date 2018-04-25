package com.mycompany.kodutoo10;
import javax.persistence.*;

@Entity
@Table(name="autod")
public class Auto{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String mark;
    public String mudel;
    public int aasta;
}
