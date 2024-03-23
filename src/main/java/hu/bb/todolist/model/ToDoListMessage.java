package hu.bb.todolist.model;

public enum ToDoListMessage {

    GET_ALL_ENTITIES_SUCCESS("Get All %s was success!"),
    GET_ALL_ENTITIES_FAILED("Get All %s was fail!"),
    GET_ENTITY_SUCCESS("Get %s was success!"),
    GET_ENTITY_FAILED("Get %s was fail!"),
    POST_ENTITY_SUCCESS("Create %s was success!"),
    POST_ENTITY_FAILED("Create %s was fail!"),
    PUT_ENTITY_SUCCESS("Modify %s was success!"),
    PUT_ENTITY_FAILED("Modify %s was fail!"),
    DELETE_ENTITY_SUCCESS("Delete %s was success!"),
    DELETE_ENTITY_FAILED("Delete %s was fail!");

    private String message;

    ToDoListMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
