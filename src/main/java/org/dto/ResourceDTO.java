package org.dto;

public class ResourceDTO {
    private Long id;
    private String quantity;

    public ResourceDTO(Long id, String quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ResourceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "id=" + id +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
