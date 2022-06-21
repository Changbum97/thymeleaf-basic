package hello.thymeleafbasic.StudentService.domain;

public enum Gender {
    Male("남성"), Female("여성");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
