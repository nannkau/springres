package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Category;
import model.CategoryRepository;

@RestController
public class CategoryApiController {
	private CategoryRepository repository= new CategoryRepository();
	@GetMapping("category")
	public List<Category> getAll(){
		return repository.getAll();
	}
	@GetMapping("category/{id}")
	public Category findById(@PathVariable("id") int id) {
		return repository.findById(id);
	}
	@PostMapping("category")
	public int add(Category obj) {
		if(repository.add(obj)) return 1;
		return 0;
	}
	@PutMapping("category")
	public int eit(Category obj) {
		if(repository.add(obj)) return 1;
		return 0;
	}
	@DeleteMapping("category/{id}")
	public int delete(@PathVariable("id") int id) {
		if(repository.deleteById(id)) return 1;
		return 0;
	}
	
}
