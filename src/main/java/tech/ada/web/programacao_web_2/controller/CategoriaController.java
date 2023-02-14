package tech.ada.web.programacao_web_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.ada.web.programacao_web_2.model.dto.CategoriaDTO;
import tech.ada.web.programacao_web_2.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<CategoriaDTO, CategoriaService> {

	public CategoriaController(CategoriaService service) {
		super(service);
	}
	
}
