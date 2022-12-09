package org.lavanya.projects.studentjersey.models;

import java.util.Date;
import java.util.Objects;

import org.lavanya.projects.studentjersey.operations.OperationSet;

/**
 * Object representing a Prohibition.
 */
public class Prohibition {

	private int id;
    private String       name;
    private String      subject;
    private OperationSet operations;
    private Date created_at;
    private Boolean status;

    public Prohibition(int id, String name, String subject, OperationSet operations,Date created_at, Boolean status) {
        if (subject == null) {
            throw new IllegalArgumentException("Prohibition subject cannot be null");
        }

        this.name = name;
        this.subject = subject;
        this.created_at = created_at;
        this.status = status;
        this.id = id;
        if (operations == null) {
            this.operations = new OperationSet();
        } else {
            this.operations = operations;
        }
    }
    public Prohibition() {
    	super();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperationSet getOperations() {
        return operations;
    }

    public void setOperations(OperationSet operations) {
        this.operations = operations;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Prohibition)) {
            return false;
        }

        Prohibition p = (Prohibition) o;
        return this.getName().equals(p.getName());
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static class Builder {

		private int id;
	    private String       name;
	    private String      subject;
	    private OperationSet operations;
	    private Date created_at;
	    private Boolean status;

        public Builder(int id,String name, String subject, OperationSet operations,Date created_at, Boolean status) {
            this.id = id;
        	this.name = name;
            this.subject = subject;
            this.operations = operations;
            this.created_at = created_at;
            this.status = status;
        }

        public Prohibition build() {
            return new Prohibition(id, name, subject, operations, created_at, status);
        }
    }
}

