package Model;

import java.time.LocalDate;
import java.util.Objects;

public class Internship {
    private int id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate applicationEndDate;
    private int companyId;
    private int uploadedHrId;



    public Internship() {
    }

    public Internship(int id, String title, String description, LocalDate startDate, LocalDate endDate, LocalDate applicationEndDate, int companyId, int uploadedHrId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.applicationEndDate = applicationEndDate;
        this.companyId = companyId;
        this.uploadedHrId = uploadedHrId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getApplicationEndDate() {
        return this.applicationEndDate;
    }

    public void setApplicationEndDate(LocalDate applicationEndDate) {
        this.applicationEndDate = applicationEndDate;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getUploadedHrId() {
        return this.uploadedHrId;
    }

    public void setUploadedHrId(int uploadedHrId) {
        this.uploadedHrId = uploadedHrId;
    }

    public Internship id(int id) {
        setId(id);
        return this;
    }

    public Internship title(String title) {
        setTitle(title);
        return this;
    }

    public Internship description(String description) {
        setDescription(description);
        return this;
    }

    public Internship startDate(LocalDate startDate) {
        setStartDate(startDate);
        return this;
    }

    public Internship endDate(LocalDate endDate) {
        setEndDate(endDate);
        return this;
    }

    public Internship applicationEndDate(LocalDate applicationEndDate) {
        setApplicationEndDate(applicationEndDate);
        return this;
    }

    public Internship companyId(int companyId) {
        setCompanyId(companyId);
        return this;
    }

    public Internship uploadedHrId(int uploadedHrId) {
        setUploadedHrId(uploadedHrId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Internship)) {
            return false;
        }
        Internship internship = (Internship) o;
        return id == internship.id && Objects.equals(title, internship.title) && Objects.equals(description, internship.description) && Objects.equals(startDate, internship.startDate) && Objects.equals(endDate, internship.endDate) && Objects.equals(applicationEndDate, internship.applicationEndDate) && companyId == internship.companyId && uploadedHrId == internship.uploadedHrId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, startDate, endDate, applicationEndDate, companyId, uploadedHrId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", applicationEndDate='" + getApplicationEndDate() + "'" +
            ", companyId='" + getCompanyId() + "'" +
            ", uploadedHrId='" + getUploadedHrId() + "'" +
            "}";
    }
}