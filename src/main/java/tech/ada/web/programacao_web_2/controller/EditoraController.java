package tech.ada.web.programacao_web_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.ada.web.programacao_web_2.model.dto.EditoraDTO;
import tech.ada.web.programacao_web_2.service.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController extends BaseController<EditoraDTO, EditoraService> {

	public EditoraController(EditoraService service) {
		super(service);
	}

}
