package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    @JsonProperty("Success")
    private boolean success;

    @JsonProperty("Error")
    private String error;

    @JsonProperty("Data")
    private CustomerData data;

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public CustomerData getData() {
        return data;
    }

    public void setData(CustomerData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}