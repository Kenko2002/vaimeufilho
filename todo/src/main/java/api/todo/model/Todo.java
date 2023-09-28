package api.todo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private Boolean done;
	
	@Column
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime createdDate;
	
	@Column
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime doneDate;
	
	//exemplo de método executado antes da persistência.
	//também existem métodos PósPersistência, update, etc.
	@PrePersist
	public void beforeSave() {
		setCreatedDate(LocalDateTime.now());
	}
	
	public static void main(String[] args) {
		Todo todo = new Todo();
	}
}
