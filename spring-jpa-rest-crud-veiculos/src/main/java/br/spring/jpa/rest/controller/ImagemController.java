package br.spring.jpa.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.spring.jpa.rest.model.Imagem;
import br.spring.jpa.rest.model.VeiculoClass;
import br.spring.jpa.rest.service.ImagemService;
import br.spring.jpa.rest.service.VeiculoService;

@RestController
@RequestMapping("/imagem")
@CrossOrigin
public class ImagemController {

    @Autowired
    ImagemService imagemService;

    @Autowired
    VeiculoService veiculoService;
    
	@PostMapping(path= "/upload/{id}")
    Long uploadImage(@RequestParam("file") MultipartFile multipartImage, @PathVariable Integer id) throws Exception {
		VeiculoClass veiculo = veiculoService.buscarVeiculoPorId(id);
		Imagem imagem = imagemService.uploadImage(multipartImage);
		veiculo.setImagem(imagem);
		veiculoService.atualizarVeiculo(veiculo);
		return imagem.getId();
    }
	
	@GetMapping(value = "/download/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource downloadImage(@PathVariable Integer id) {
		VeiculoClass veiculo = veiculoService.buscarVeiculoPorId(id);
	   return imagemService.downloadImage(veiculo.getImagem());
	}
}	