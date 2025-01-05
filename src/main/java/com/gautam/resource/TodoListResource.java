package com.gautam.resource;

import com.gautam.dao.TodoListEntityDAO;
import com.gautam.entity.TodoListEntity;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.validation.Validated;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/tasks")
public class TodoListResource {

    private final TodoListEntityDAO todoListEntityDAO;

    public TodoListResource(TodoListEntityDAO todoListEntityDAO) {
        this.todoListEntityDAO = todoListEntityDAO;
    }

    @GET
    @Path("/healthCheck")
    public String healthCheck() {
        return "Ping received at " + new Date();
    }

    //Get a task
    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @UnitOfWork
    public Response getTask(@PathParam("id") String id) {
        System.out.println("ID from URL: " + id);
        TodoListEntity existingTask = todoListEntityDAO.find(id);
        if (existingTask == null) {
            System.out.println("NOT FOUND");
            return Response.status(Response.Status.NOT_FOUND).entity("Task not found").build();
        }
        return Response.ok(existingTask).build();
    }

    //Save new task
    @POST
    @Path("/save")
    @UnitOfWork
    public String postReview(@Validated TodoListEntity todoListEntity) {
        return todoListEntityDAO.save(todoListEntity).getId();
    }

    //Get all tasks
    @GET
    @Path("/getAll")
    @Produces("application/json")
    @Consumes("application/json")
    @UnitOfWork
    public Response getAllTasks() {
        List<TodoListEntity> tasks = todoListEntityDAO.findAll();
        if (tasks == null || tasks.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(tasks).build();
    }

    //Delete a task
    @DELETE
    @Path("/delete/{id}")
    @UnitOfWork
    public Response deleteTask(@PathParam("id") String id) {
        TodoListEntity existingTask = todoListEntityDAO.find(id);
        if (existingTask == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Task not found").build();
        }

        todoListEntityDAO.delete(existingTask); // Call delete method in DAO
        return Response.ok("Task deleted successfully").build();
    }

    //Update a task
    @PUT
    @Path("/update/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @UnitOfWork
    public Response updateTask(@PathParam("id") String id, @Validated TodoListEntity todoListEntity) {

        //extra whitespaces were appearing in id hence we used trim()
        id=id.trim();
        // Debugging: print the id received in the URL
//        System.out.println(id+"gautam");
//        System.out.println(id+"gautam");
//        System.out.println("ID from Body: " + todoListEntity.getId());

        // Find the existing task using the id
        System.out.println(id.equals(id));


        TodoListEntity existingTask = todoListEntityDAO.find("2");
        if (existingTask == null) {
//            System.out.println("NOT FOUND");
            return Response.status(Response.Status.NOT_FOUND).entity("Task not found").build();
        }

        // Update fields
        existingTask.setTaskId(todoListEntity.getTaskId());
        existingTask.setDescription(todoListEntity.getDescription());
        existingTask.setStatus(todoListEntity.getStatus());
        existingTask.setStartDate(todoListEntity.getStartDate());
        existingTask.setTargetDate(todoListEntity.getTargetDate());

        // Save the updated task
        todoListEntityDAO.save(existingTask);

        return Response.ok(existingTask).build();
    }

}
