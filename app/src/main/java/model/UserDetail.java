package model;

import com.google.gson.annotations.SerializedName;

public class UserDetail {
    int id;
    @SerializedName("node_id")
    String nodeId;
    String name;
    @SerializedName("full_name")
    String fullName;

    public UserDetail(int id, String nodeId, String name, String fullName) {
        this.id = id;
        this.nodeId = nodeId;
        this.name = name;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
