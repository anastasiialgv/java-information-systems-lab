package classes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Category {
    private Set<Category> categories = new HashSet<>();
    private String name;
    private String description;
    private int code;
    private Set<Cosmetic> cosmetics = new HashSet<>();
    public Category(String name, int code, String description) {
        setName(name);
        setCode(code);
        setDescription(description);
        categories.add(this);
    }
    public void addCosmetic(Cosmetic cosmetic){
        if(!cosmetics.contains(cosmetic)) {
            cosmetics.add(cosmetic);
            cosmetic.setCategory(this);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (name.isEmpty()) throw new IllegalArgumentException("description cannot be empty");
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if (code < 1) throw new IllegalArgumentException("Code cannot be negative or 0");
        this.code = code;
    }

    public Set<Cosmetic> getCosmetics() {
        return Collections.unmodifiableSet(cosmetics);
    }

    @Override
    public String toString() {
        return "classes.Category{name='" + name + "', code=" + code + ", description='" + description + "'}";
    }
}

