package tech.ada.web.programacao_web_2.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tech.ada.web.programacao_web_2.service.IService;


//@Secured("ROLE_USER")
@Slf4j
public abstract class BaseController<T, S extends IService<T>> {
	
	protected S service;

	public BaseController(S service) {
		
		this.service = service;
		
	}
	
	@GetMapping
	public ResponseEntity<List<T>> getAll() {
		
		return this.executeList(() -> {
			
			return ResponseEntity.ok(service.getAll());
			
		}); 
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> find(@PathVariable("id") Long id) {
		
		return this.execute(() -> {
			
			return ResponseEntity.ok(service.find(id));
			
		});		
		
	}
	
	@PostMapping
	public ResponseEntity<T> save(@RequestBody @Valid T entity) {
		
		return this.execute(() -> {
			
			return ResponseEntity.ok(service.save(entity));
			
		});
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> edit(@PathVariable("id") Long id,
								  @RequestBody @Valid T entity) {
		
		return this.execute(() -> {
			
			return ResponseEntity.ok(service.edit(id, entity));
			
		}); 
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<T> delete(@PathVariable("id") Long id) {

		return this.execute(() -> {
			
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
			
		});
					
	}

	private ResponseEntity<T> execute(Supplier<ResponseEntity<T>> action) {
		
		try {

            return action.get();

        } catch(Exception ex) {
        	
            log.error(ex.toString());
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            
        }
		
	}
	
	private ResponseEntity<List<T>> executeList(Supplier<ResponseEntity<List<T>>> action) {
		
		try {

            return action.get();

        } catch(Exception ex) {
        	
            log.error(ex.toString());
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            
        }
		
	}
	
}
