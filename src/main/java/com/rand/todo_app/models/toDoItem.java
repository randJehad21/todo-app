package com.rand.todo_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.*;

@Entity
@Table(name = "todo-item")
public class toDoItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    @Getter
    @Setter

    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;


    @Getter
    @Setter
    private Instant createdDate;


    @Getter
    @Setter
    private Instant modifiedDate;

    public toDoItem(){}

    public toDoItem(String description){
        this.description=description;
        this.complete= false;
        this.createdDate= Instant.now();
        this.modifiedDate= Instant.now();
    }

    @Override

public String toString(){
    return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
    id, description, complete, createdDate, modifiedDate);
}


}
