package com.kayamuhammet.ToDo.service;

import com.kayamuhammet.ToDo.entity.ToDo;
import com.kayamuhammet.ToDo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {


    @Autowired
    private ToDoRepository toDoRepository;



    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo updateToDo(Long id, ToDo todoDetails) {
        ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));

        todo.setText(todoDetails.getText());
        todo.setPriority(todoDetails.getPriority());
        todo.setCategory(todoDetails.getCategory());
        todo.setDueDate(todoDetails.getDueDate());
        todo.setCompleted(todoDetails.isCompleted());
        return toDoRepository.save(todo);

    }

    public void deleteToDo(Long id){
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDoRepository.delete(toDo);

    }

    public ToDo toggleToDoStatus(Long id){
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDo.setCompleted(!toDo.isCompleted());
        return toDoRepository.save(toDo);
    }
}
